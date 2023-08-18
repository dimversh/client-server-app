import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {



    public static void main(String[] args) throws IOException {

        int port = 8089;
        String host = "localhost";


        try(Socket clientSocket = new Socket(host, port);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket
                    .getInputStream()))
        ) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Input your name: ");
            String name = scanner.nextLine();
            out.println(name);

            String resp = in.readLine();
            System.out.println(resp);
        }

    }
}
