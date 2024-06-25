package org.desafio_web.framework.utils;

import java.io.File;
import java.util.Properties;

import static org.desafio_web.framework.utils.FileOperationsProperties.getProperties;

public class ObjectsUtils {

    public static String getPropertiesData(String fileName, String property){
        try {
            Properties properties = getProperties("Properties"+ File.separator + fileName +".properties");
            return properties.getProperty(property);
        } catch(Exception e){
            System.out.println("Não foi possível ler o arquivo"+e.getMessage());
            return null;
        }
    }

    public static void setPropertiesData(String fileName,String propKey,String propValue){
        try {
            FileOperationsProperties.setProperties("properties"+ File.separator + fileName + ".properties",propKey,propValue);
        } catch(Exception e){
            System.out.println("Não foi possível ler o arquivo "+e.getMessage());
        }
    }
}
