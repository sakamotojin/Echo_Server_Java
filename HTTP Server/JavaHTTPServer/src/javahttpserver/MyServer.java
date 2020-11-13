/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahttpserver;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/**
 *
 * @author Sakamoto Jin
 */
public class MyServer {
    private int port ;
    private HttpServer server ;
    ThreadPoolExecutor threadPoolExecutor;
    
    MyServer(int port  ) throws Exception{
        if(port <= 0 ) throw new Exception("Enter Valid Port Number");
        this.port = port;
        server = HttpServer.create(new InetSocketAddress(port), 0);
        threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
    }
    public void initialize(){
         server.createContext("/", new IndexHandler());
         server.createContext("/register" , new RegisterPageHandler());
    }
    public void start(){
        server.setExecutor(threadPoolExecutor);
        server.start();
    }
}


