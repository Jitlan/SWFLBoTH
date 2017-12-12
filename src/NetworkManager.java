import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkManager
{
  private String HOST;
  private int PORT_NUM;

  public NetworkManager(String HOST, int PORT_NUM)
  {
    this.HOST = HOST;
    this.PORT_NUM = PORT_NUM;
  }

  public void connectTo()
  {
    ServerSocket serverSocket = null;
       try {
            serverSocket = new ServerSocket(PORT_NUM);
        }
        catch (IOException e) {
            System.err.println("Could not listen on port: " + PORT_NUM);
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        }
        catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Echo server started");

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("echoing: " + inputLine);
            out.println(inputLine);
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
  }

  public String getHost()
  {
    return HOST;
  }

  public void setHost(String HOST)
  {
    this.HOST = HOST;
  }

  public int getPortNum()
  {
    return PORT_NUM;
  }

  public void setPortNum(int PORT_NUM)
  {
    this.PORT_NUM = PORT_NUM;
  }
}
