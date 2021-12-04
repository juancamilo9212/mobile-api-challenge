package co.com.koombea.qa.precise_conversion.utils;

import java.io.*;
import java.util.Properties;

public class PropertyLoader {

    public String getConfigValue(String attribute) throws IOException {
        String keyValue = "";
        Properties properties= new Properties();
        try {
            properties.load(new FileInputStream(new File("params.properties")));
           keyValue= (String) properties.get(attribute);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return keyValue;
    }

}
