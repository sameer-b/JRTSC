import java.io.*;
import server.*;


class serverMain  extends Thread{

	public static void main(String[] args) throws IOException {
		
		final int port=5005;
		server s=new server(port);
		Thread t=new Thread(s);
		t.start();

		
	}
}
