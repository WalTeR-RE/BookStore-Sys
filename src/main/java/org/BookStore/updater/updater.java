package org.BookStore.updater;

import com.sun.tools.javac.Main;
import org.BookStore.updater.webfetcher;
import javax.swing.*;
import java.io.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import org.BookStore.Cryptography.*;

public class updater {
    private String currentVersion;
    private String LatestVersion;
    private Boolean NewversionAva =false;
    private Boolean IsNewUpdate = false;
    private Boolean ForceUpdate = true;
    public static Boolean NewversionAvailable=false;
    public static Boolean CheckDone = false;

    public  void setCurrentVersion(String s){
        this.currentVersion=s;
    }
    public  void setLatestVersion(String s) {
        this.LatestVersion = s;
    }
    public void setNewversionAva(Boolean status){
        this.NewversionAva=status;
    }
    public void setForceUpdate(Boolean forceUpdate){this.ForceUpdate=forceUpdate;}
    public String getLatestVersion(){
        return this.LatestVersion;
    }
    public String getCurrentversion(){
        return this.currentVersion;
    }
    public boolean getForceUpdate(){return this.ForceUpdate;}
    public boolean NewversionAv(){
        return this.NewversionAva;
    }
    public boolean IsNewUpdate(){
        return this.IsNewUpdate;
    }

    public updater(){
       CheckUpdate();
    }
    private void CheckUpdate(){
        try {

            webfetcher wb = new webfetcher();
            Crypto cr = new Crypto();
            URL resourceURL = updater.class.getResource("/files/file.dat"); //Read File From Disk
            Path path = Paths.get(URI.create(resourceURL.toString()));
            List<String> lines = Files.readAllLines(path);
            List<String> DecryptedData = new ArrayList<>();



            for (String line : lines) {
                String plain = cr.decrypt(line);
                DecryptedData.add(plain);
            }


            String Lastest = wb.fetchLatestData(System.getenv("UPDATE_URL"));

            // Read Data From Server
            String curVersion = Lastest.split("= ")[1].split("\r")[0];
            Boolean ForceUpd = Boolean.parseBoolean(Lastest.split("= ")[2].split("\r")[0]);

            // Read Data From .dat File
            this.currentVersion=DecryptedData.get(0).split(": ")[1].split("\n")[0];
            this.IsNewUpdate = Boolean.parseBoolean(DecryptedData.get(0).split(": ")[2]);


            //Set Variables
            this.LatestVersion=curVersion;
            this.ForceUpdate=ForceUpd;



            if(this.currentVersion.equals(this.LatestVersion))
                JOptionPane.showMessageDialog(null,"Yaay!\nApplication is up-to-date");
            else
            {
                this.NewversionAva = true;
                NewversionAvailable=true;
                if (ForceUpdate) {

                    JOptionPane.showMessageDialog(null,
                            "A New Update Is Availabe\nAnd You Have To Update The System To Login"
                            ,"BookStore-Updating-System",
                            JOptionPane.OK_OPTION
                    );


                    String Updateurl = Lastest.split("= ")[3].split("\r")[0];
                    String Updatedata = Lastest.split("=")[4].replace("\r", "");





                    Update(this.currentVersion, this.LatestVersion, Updateurl, Updatedata);
                }
                else {

                    int choice = JOptionPane.showConfirmDialog(
                            null,
                            "A New Version Is Available Do you Want to update the application Now?",
                            "BookStore-Updating-System",
                            JOptionPane.YES_NO_OPTION
                    );

                    if(choice == JOptionPane.YES_OPTION)
                    {
                        String Updateurl = Lastest.split("= ")[3].split("\r")[0];
                        String Updatedata = Lastest.split("=")[4].replace("\r", "");
                        this.NewversionAva = true;
                        Update(this.currentVersion, this.LatestVersion, Updateurl, Updatedata);
                    }

                    else{
                        JOptionPane.showMessageDialog(null,
                                "You May Be Vulnerable In This Version"
                                ,"BookStore-Updating-System",
                                JOptionPane.OK_OPTION
                        );
                        this.NewversionAva= false;
                        NewversionAvailable = false;
                    }
                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public void Update(String CurrentVer,String LatestVer,String Updateurl,String Updateinfo) {

        System.out.println(String.format("There A New Version!\nCurrent: %s\nNew: %s\nUpdates: %s",CurrentVer,LatestVer,Updateinfo));

        System.out.println("Update Url: "+Updateurl);

        String DownloadDir = System.getProperty("user.dir");
        System.out.println(String.format("%s/BookStoreV%s.jar",DownloadDir,LatestVer));
       try{

            URL url = new URL(Updateurl);
            // Open Download Channel

            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            // Create OutPut File

            FileOutputStream fileOutputStream = new FileOutputStream(String.format("%s/BookStoreV%s.jar",DownloadDir,LatestVer));

            fileOutputStream.getChannel().transferFrom(rbc,0,Long.MAX_VALUE); // Download The Latest Version

            // Close Channel , OUTPUT File
            fileOutputStream.close();
            rbc.close();

            // Apply Updates

            restartApplication(String.format("BookStoreV%s.jar",LatestVer));
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
        }

    }


    // TODO: Update this method after completing the development of the application.
    private void restartApplication(String AppName) {
        try {
            
            String java = System.getProperty("java.home") + "/bin/java"; //GET OUR JAVA Process Location

            String currentdir = System.getProperty("user.dir");
            String path2open = currentdir+"/"+AppName.replace(".jar",".pdf");

            String[] command = {"cmd.exe","/C","start","\"\"", path2open};
            // Final Command Will Be java , "-jar" , AppName for .jar file /
            // java , Appname for .java file
            // / cmd.exe, /c, start ,\"\", AppName for .exe file
            Runtime.getRuntime().exec(command);

            System.exit(0);


        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
        }
    }


}
