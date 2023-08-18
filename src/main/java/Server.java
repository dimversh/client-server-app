import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) throws IOException {
        int port = 8089;


        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started");
            while(true) {
                try(Socket clientSocket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    System.out.printf("New connetction accepted! Port: %d\n", clientSocket.getPort());
                    final String name = in.readLine();

                    out.println(String.format("Hello %s! Your port is %d", name, clientSocket.getPort()));
                }
            }

        }

    }
}
