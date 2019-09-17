import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Socket {
	private static ServerSocket server;

	public static void main(String[] args) {
		try {
			server = new ServerSocket(5560);

			while (true) {
				java.net.Socket socket = server.accept();

				DataInputStream dIn = new DataInputStream(socket.getInputStream());
				DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

				System.out.println(dIn.readUTF());

				
				
//				Scanner scan = new Scanner(System.in);
//				
//				System.out.println("Digite a mensagem");
//				String msg = scan.next();
				
				dOut.writeUTF("ok");

				dOut.flush();
				dOut.close();
				dIn.close();
				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}