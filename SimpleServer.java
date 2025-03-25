import java.io.*;
import java.net.*;

public class SimpleServer {
    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor iniciado en el puerto " + port);
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     OutputStream output = clientSocket.getOutputStream();
                     PrintWriter writer = new PrintWriter(output, true)) {
                    writer.println("HTTP/1.1 200 OK");
                    writer.println("Content-Type: text/plain; charset=UTF-8");
                    writer.println();
                    writer.println("¡Hola, este es un servidor HTTP simple en Java!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
