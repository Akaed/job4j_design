package io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                             out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                             String readline = in.readLine();
                    if (readline.contains("Hello")) {
                        out.write("Hello".getBytes());
                    } else if (readline.contains("Exit")) {
                        server.close();
                    } else if (readline.contains("Any")) {
                        out.write("What".getBytes());
                    }
                    out.flush();
            }
        }
    }
  }
}
