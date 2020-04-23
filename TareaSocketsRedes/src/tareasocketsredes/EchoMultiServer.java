/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareasocketsredes;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EchoMultiServer {

    private ServerSocket serverSocket;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            new EchoClientHandler(serverSocket.accept()).start();
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    private static class EchoClientHandler extends Thread {

        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public EchoClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException ex) {
                Logger.getLogger(EchoMultiServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException ex) {
                Logger.getLogger(EchoMultiServer.class.getName()).log(Level.SEVERE, null, ex);
            }

            String inputLine;
            try {
                while ((inputLine = in.readLine()) != null) {
                    if (".".equals(inputLine)) {
                        out.println("bye");
                        break;
                    }
                    out.println(inputLine);
                }
            } catch (IOException ex) {
                Logger.getLogger(EchoMultiServer.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(EchoMultiServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.close();
            try {
                clientSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(EchoMultiServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        EchoMultiServer server=new EchoMultiServer();
        server.start(5555);
    }
}
