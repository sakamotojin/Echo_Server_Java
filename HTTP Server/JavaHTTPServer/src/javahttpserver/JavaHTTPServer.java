/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahttpserver;

/**
 *
 * @author Sakamoto Jin
 */
public class JavaHTTPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            MyServer HTTPServer = new MyServer(80);
            HTTPServer.initialize();
            HTTPServer.start();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
