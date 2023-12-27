package org.BookStore.Services;

import org.BookStore.users.currentuser;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private BufferedReader MessageReader;
    private BufferedWriter MessageWriter;
    private String Username = currentuser.getInstance().getName();

    public Client(Socket socket,String username){
        try{
            this.socket=socket;
            MessageReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            MessageWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.Username = username;
        }catch (IOException ex)
        {
            CloseAll(socket,MessageReader,MessageWriter);
        }
    }
    public void SendMessage(String Message,boolean FirstConn){
        try{
            if(FirstConn) {
                MessageWriter.write(Username + "\n");
                MessageWriter.flush();
            }
            else {
                if (socket.isConnected()) {
                    MessageWriter.write(Username + ": " + Message + "\n");
                    MessageWriter.flush();
                }
            }
        }
        catch (IOException ex){
            CloseAll(socket,MessageReader,MessageWriter);
        }
    }

    public void CloseAll(Socket soc,BufferedReader sc,BufferedWriter bw){
        try{
            if(bw!=null)
            {
                bw.close();
            }
            if(sc != null)
            {
                sc.close();
            }
            if(soc!= null)
            {
                soc.close();
            }

        }catch (IOException ex){
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
        }
    }
    public void Listener(){
         new Thread(new Runnable() {
             @Override
             public void run() {
                String Message;
                while(socket.isConnected())
                {
                    try {
                        Message = MessageReader.readLine();
                        System.out.println(Message);
                    }
                    catch (IOException ex){
                        CloseAll(socket,MessageReader,MessageWriter);
                    }
                }
             }
         }).start();
    }
}
