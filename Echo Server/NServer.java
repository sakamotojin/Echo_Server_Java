import java.net.*;
import java.io.*;

class NServer implements Runnable
{
 ServerSocket port;
 Thread connThread;
 boolean flag;

 NServer(int pNo) throws Exception
 {

   port = new ServerSocket(pNo);

   flag = true;
   connThread = new Thread(this);
   connThread.start();
   
 }

 public void run()
 {
  while(flag)
  {
   acceptConnection();
  }
  
  try
  {
    port.close();
  }
  catch(Exception ex)
  {
    System.out.println(ex);
  }

 }

 void acceptConnection()
 {
  try
  {
    System.out.println("Waiting for a client connection ...");
    

    Socket s = port.accept();  
    System.out.println("...Got a client connection");
    System.out.println(s);
    new ClientProcessor(s);   
 
  }
  catch(Exception ex)
  {
    System.out.println(ex);
  }
 }

 public static void main(String args[])
 {
   try
   {
     new NServer(8000);
   }
   catch(Exception ex)
   {
    System.out.println(ex);
   }
 }

}

class ClientProcessor extends Thread
{
  Socket clnt;

  ClientProcessor(Socket s)
  {
    clnt = s;
    start();
  }

  public void run()
  {
   try
   { 
    
    InputStream in = clnt.getInputStream();
    OutputStream out = clnt.getOutputStream();

    
	byte arr[] = new byte[60];
    while(in.read(arr)!=-1)
    {
    	System.out.println("-----------------------");
    	System.out.println(clnt);
  	out.write(arr);
  	System.out.write(arr);
  	System.out.println("-----------------------");
    }

  
   }
   catch(Exception ex)
   {
     System.out.println(ex);
    
   }
  }
}



