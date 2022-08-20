import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket serverSocket = null;

        try{
            serverSocket = new ServerSocket(5001);
            socket = serverSocket.accept();
            DataInputStream recebido = new DataInputStream(socket.getInputStream());
            DataOutputStream enviado = new DataOutputStream(socket.getOutputStream());
            System.out.println("(cliente): " + recebido.readUTF());
            enviado.writeUTF("O servidor recebeu sua mensagem.");
        }catch (IOException e){
            System.err.println("Falha na conexão");
        }finally {
            try{
                socket.close();
                serverSocket.close();
            }catch (IOException e){
                System.err.println("Falha ao encerrar a conexão");
            }
        }
    }
}
