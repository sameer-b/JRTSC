package server;
import java.io.*;
import java.net.*;
import java.awt.Robot;


public class serverKeyboard extends Thread 
{

	BufferedReader keyboardBuffer,socketReader;
	PrintWriter socketWriter;
	String st1,st2;
	ServerSocket server;
	Socket connection;

	public serverKeyboard(int port)
	{
    try 
    	{
        
        server=new ServerSocket(port);
       	connection=server.accept();
        socketReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
      
    	}

    catch(Exception ee)
    	{
        System.out.println(ee);
    	}
	}

	
	
	void controlKeyboard() throws IOException
	{

		try 
		{
        
		Robot robot = new Robot();
        // Simulate a key press
        String key=socketReader.readLine();
        
        if(key!=null)
        {
        	String keyCode=key.replaceAll("\\D","");
        	System.out.println("Key received is: "+key);


        if(key.contains("KP"))
        	{
        		System.out.println("I will perform key press"+keyCode);
          		robot.keyPress(Integer.parseInt(keyCode));

        	}
       	if(key.contains("KR"))
       		{
       			System.out.println("I will perform key release"+keyCode);
      	  		robot.keyRelease(Integer.parseInt(keyCode));
       		}
        
        }

        
        
        }

        

		 
		catch (Exception e) 
		{
        	e.printStackTrace();
		}

	}

	public void run() 
	{

		while(true)
		{
			
			try 
			{
				controlKeyboard();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}


}