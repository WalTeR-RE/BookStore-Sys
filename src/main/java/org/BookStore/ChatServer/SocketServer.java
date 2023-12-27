package org.BookStore.ChatServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    private ServerSocket server;
    private Socket soc;


    public SocketServer(ServerSocket socket) {
        server = socket;
    }
    public void closeServer(){
        try {
            if(server!=null)
                server.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    public static void SendDCMessage(String Name){
        System.out.println(String.format("User: %s Has Disconnected!",Name));
    }
    public void start(){
        try{
            while(!server.isClosed())
            {
                soc = server.accept();
                ClientSideHandler client = new ClientSideHandler(soc);
                System.out.println(String.format("User: \" %s \" With Ip: %s Has Connected!",client.getUsername(),soc.getInetAddress().toString().replace("/","")));
                Thread thr = new Thread(client);
                thr.start();

            }
        }
        catch (IOException ex){
            closeServer();
        }
    }

    public static void main(String[] args)
    {
        try {
            int Port = 1280;
            System.out.println("Server Is Starting....");
            ServerSocket ssocket = new ServerSocket(Port);
            SocketServer server = new SocketServer(ssocket);
            System.out.println("Server Is Listening On Port: "+Port);
            server.start();

        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }


}
