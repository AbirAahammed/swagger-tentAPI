package io.swagger.propertyLoader;

import io.swagger.api.CompanyApiController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
    private static final Logger log = LoggerFactory.getLogger(CompanyApiController.class);

    public static Properties loadProperties(String propertyFileName) {
       try {
           InputStream input = new FileInputStream(String.format("./src/main/resources/%s.properties", propertyFileName));
           Properties prop = new Properties();
           prop.load(input);
           return prop;
       } catch (IOException e) {
           log.error(e.getMessage());
           return null;
       }
    }
}
