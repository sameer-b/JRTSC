import client.*;
import java.io.*;

class clientMain extends Thread {
	public static void main(String[] args) throws IOException {
		final int port=6000;
		client c=new client(port);
		Thread t1=new Thread(c);
		t1.start();
		//clientKeyboard kb=new clientKeyboard(5000);
		//Thread t2=new Thread(kb);
		//t2.start();
		

	}
}