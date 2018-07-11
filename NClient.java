import java.net.*;
import java.io.*;


class NClient
{
 Socket svr;
 NClient(String ip, int port) throws Exception
 {
  svr = new Socket(ip, port);	
  
 } 

 


 void communicate() throws Exception
 {
   InputStream in = svr.getInputStream();
   OutputStream out = svr.getOutputStream();

   

  while(true)
  {
  	 byte arr[] = new byte[60];
  	 byte arr2[] = new byte[60];
  	int n=System.in.read(arr);
  	out.write(arr);
  	int n1 = in.read(arr2);
  	System.out.write(arr2);
    	
  
  }
  }

 void close() throws Exception
 {
   svr.close();   
 }
 
 public static void main(String args[])
 {
  try
  {
    String sip= "192.168.116.52";
    int sport = 9876;

    NClient nc = new NClient(sip, sport);
    nc.communicate();
    nc.close(); 
  }
  catch(Exception ex)
  {
   System.out.println(ex);
  }
 }
}
