import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 5001);
            DataInputStream recebido = new DataInputStream(socket.getInputStream());
            DataOutputStream enviado = new DataOutputStream(socket.getOutputStream());

            enviado.writeUTF("Aqui é um cliente falando");
            System.out.println("(servidor): " + recebido.readUTF());
        } catch (IOException e) {
            System.err.println("Falha ao inicializar server");
        } finally {
            try{
                socket.close();
            }catch (IOException e){
                System.err.println("Falha ao encerrar conexão");
            }
        }
    }
}
