package org.cognito.corelayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Settings {

    private static Properties prop = readFromPropertyFile();
    /*    Singleton pattern to get only one instance of property file throughout the execution
     */
    private Settings(){ }
    private static Settings settings = new Settings();
    public static Properties getInstance(){
        return prop;
    }

    /*    Function to rad value from Global Settings property file
     */
    private static Properties readFromPropertyFile(){
        Properties properties = new Properties();
        String relativePath = new File(System.getProperty("user.dir")).getAbsolutePath()+
                System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "test"
                + System.getProperty("file.separator")+ "resources";
        try {
            properties.load(new FileInputStream(relativePath + System.getProperty("file.separator") +
                    "GlobalSettings.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
