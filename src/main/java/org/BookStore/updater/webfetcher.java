package org.BookStore.updater;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringJoiner;


public class webfetcher {
    public String fetchLatestData(String uri) {
        try {
            URL InfobasedURL = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) InfobasedURL.openConnection();
            connection.setConnectTimeout(5000);
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringJoiner InfoBuffer = new StringJoiner(System.lineSeparator());
                String line;
                while((line=reader.readLine())!=null){
                    InfoBuffer.add(line);
                }
                reader.close();
                return InfoBuffer.toString();
            } else {
                System.out.println("Version check failed with response code: " + responseCode);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
        }
        return null;
    }

}
