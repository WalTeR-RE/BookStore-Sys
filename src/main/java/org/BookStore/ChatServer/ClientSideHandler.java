package org.BookStore.ChatServer;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ClientSideHandler implements Runnable {

    private Socket soc;
    private BufferedReader MessageReader;
    private BufferedWriter MessageSender;
    private String Username;

    public String getUsername() {
        return Username;
    }

    public Socket getSoc() {
        return soc;
    }

    public static List<ClientSideHandler> clientSideList = new ArrayList<>();

    public ClientSideHandler(Socket socket){
        try{
            soc = socket;
            MessageReader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            MessageSender = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
            clientSideList.add(this);
            Username = MessageReader.readLine();
            SendGlobalMessage(String.format("%s Now Is Online!",Username));
        }
        catch (IOException ex)
        {
            CloseAll(soc,MessageReader,MessageSender);
        }
    }
    public void SendGlobalMessage(String Msg)
    {
        for (ClientSideHandler client : clientSideList){
            try{
                if(client.Username.equals(Username)&&Msg.contains("Now Is Online!"))
                {
                    client.MessageSender.write("You Are Online!" + "\n");
                    client.MessageSender.flush();
                }
                else {
                    client.MessageSender.write(Msg + "\n");
                    client.MessageSender.flush();
                }
            }
            catch (IOException ex){
                CloseAll(soc,MessageReader,MessageSender);
            }
        }
    }
    public void RemoveClient(){
        clientSideList.remove(this);
        SocketServer.SendDCMessage(Username);
        SendGlobalMessage(String.format("%s Is Now Offline!",Username));
    }

    public void CloseAll(Socket socket,BufferedReader scanner,BufferedWriter bw){
        RemoveClient();
        try{
            if(bw!=null)
            {
                bw.close();
            }
            if(scanner != null)
            {
                scanner.close();
            }
            if(socket!= null)
            {
                socket.close();
            }

        }catch (IOException ex){
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
        }
    }
    @Override
    public void run() {

        String Message;
        while(soc.isConnected())
        {
            try {
                Message = MessageReader.readLine();
                SendGlobalMessage(Message);
            }
            catch (IOException ex)
            {
                CloseAll(soc,MessageReader,MessageSender);
                break;
            }
        }
    }
}
