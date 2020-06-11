package co.unicauca.parqueadero.servidor.servidor;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import co.unicauca.parqueadero.servidor.negocio.*;
import co.unicauca.parqueadero.servidor.negocio.GestorParqueadero;
import co.unicauca.parqueadero.servidor.negocio.clsGestorParqueo;
import co.unicauca.parqueadero.servidor.negocio.clsRegistroParqueo;
import co.unicauca.parqueadero.servidor.transversal.*;

import java.util.List;

/**
 * Servidor Socket que está escuchando permanentemente solicitudes de los
 * clientes. Cada solicitud la atiende en un hilo de ejecución
 *
 * @author Libardo
 */
public class ParqueaderoServer implements Runnable {

    private final GestorParqueadero gestor;
    private clsGestorParqueo atrGestorParqueo;
    private clsGestorUsuarios atrGestorUsuarios;
    private static ServerSocket ssock;
    private static Socket socket;

    private Scanner entradaDecorada;
    private PrintStream salidaDecorada;
    private static final int PUERTO = 5000;
    private JSONServices atrParse = JSONServices.getInstancia();

    /**
     * Constructor
     */
    public ParqueaderoServer() {
        gestor = new GestorParqueadero();
        atrGestorParqueo = new clsGestorParqueo();
        atrGestorUsuarios = new clsGestorUsuarios();
    }

    /**
     * Logica completa del servidor
     */
    public void iniciar() {
        abrirPuerto();

        while (true) {
            esperarAlCliente();
            lanzarHilo();
        }
    }

    /**
     * Lanza el hilo
     */
    private static void lanzarHilo() {
        new Thread(new ParqueaderoServer()).start();
    }

    private static void abrirPuerto() {
        try {
            ssock = new ServerSocket(PUERTO);
            System.out.println("Escuchando por el puerto " + PUERTO);
        } catch (IOException ex) {
            Logger.getLogger(ParqueaderoServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Espera que el cliente se conecta y le devuelve un socket
     */
    private static void esperarAlCliente() {
        try {
            socket = ssock.accept();
            System.out.println("Cliente conectado");
        } catch (IOException ex) {
            Logger.getLogger(ParqueaderoServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cuerpo del hilo
     */
    @Override
    public void run() {
        try {
            crearFlujos();
            leerFlujos();
            cerrarFlujos();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Crea los flujos con el socket
     *
     * @throws IOException
     */
    private void crearFlujos() throws IOException {
        salidaDecorada = new PrintStream(socket.getOutputStream());
        entradaDecorada = new Scanner(socket.getInputStream());
    }

    /**
     * Lee los flujos del socket
     */
    private void leerFlujos() {
        if (entradaDecorada.hasNextLine()) {
            // Extrae el flujo que envía el cliente
            String peticion = entradaDecorada.nextLine();
            decodificarPeticion(peticion);

        } else {
            salidaDecorada.flush();
            salidaDecorada.println("NO_ENCONTRADO");
        }
    }

    /**
     * Decodifica la petición, extrayeno la acción y los parámetros
     *
     * @param peticion petición completa Tiene la siguiente forma
     * "consultarCliente,983932814" Prmero la accion y los parámetros separados
     * por coma
     */
    private void decodificarPeticion(String peticion) {
        StringTokenizer tokens = new StringTokenizer(peticion, "|");
        String parametros[] = new String[10];

        int i = 0;
        while (tokens.hasMoreTokens()) {
            parametros[i++] = tokens.nextToken();
        }
        String accion = parametros[0];
        procesarAccion(accion, parametros);

    }

    /**
     * Según el protocolo decide qué accion invocar
     *
     * @param accion acción a procesar
     * @param parametros parámetros de la acción
     */
    private void procesarAccion(String accion, String parametros[]) {
        switch (accion) {
            case "getParqueaderos":
                List<Parqueadero> par = gestor.getParqueaderos();
                if (par.size() == 0) {
                    salidaDecorada.println("NO_ENCONTRADO");
                } else {
                    salidaDecorada.println(atrParse.parseToJSON(par));
                }
                break;
            case "consultarParqueadero":
                String id = parametros[1];
                Parqueadero objpar = gestor.find(id);
                if (objpar == null) {
                    salidaDecorada.println("NO_ENCONTRADO");
                } else {
                    salidaDecorada.println(atrParse.parseToJSON(objpar));
                }
                break;
            case "login":
                String login = parametros[1];
                String password = parametros[2];
                clsSeguridad objLogin = new clsSeguridad();
                if (objLogin.login(login, password)) {
                    salidaDecorada.println("TRUE");
                } else {
                    salidaDecorada.println("FALSE");
                }
                break;
            case "registrarEntrada":
                clsRegistroParqueo objRegistro = atrParse.parseToRegistroParqueo(parametros[1]);
                if (atrGestorParqueo.registrarEntrada(objRegistro)) {
                    salidaDecorada.println("TRUE");
                } else {
                    salidaDecorada.println("FALSE");
                }
                break;
            case "findUser":
                clsUsuario objUser = atrGestorUsuarios.find(parametros[1]);
                if (objUser != null) {
                    salidaDecorada.println(atrParse.parseToJSON(objUser));
                } else {
                    salidaDecorada.println("NO_ENCONTRADO");
                }
                break;
            case "buscarXplaca":
                objRegistro = atrGestorParqueo.buscarXplaca(parametros[1]);
                if (objRegistro!=null) {
                    salidaDecorada.println(atrParse.parseToJson(objRegistro));
                } else {
                    salidaDecorada.println("NO_ENCONTRADO");
                }
                break;
            case "buscarXcodigo":
                objRegistro = atrGestorParqueo.buscarXcodigo(parametros[1]);
                if (objRegistro!=null) {
                    salidaDecorada.println(atrParse.parseToJson(objRegistro));
                } else {
                    salidaDecorada.println("NO_ENCONTRADO");
                }
                break;
        }
    }

    /**
     * Cierra los flujos de entrada y salida
     *
     * @throws IOException
     */
    private void cerrarFlujos() throws IOException {
        salidaDecorada.close();
        entradaDecorada.close();
        socket.close();
    }

}
