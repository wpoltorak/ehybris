package com.lambda.plugin.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.core.runtime.IPath;

import com.lambda.plugin.YPlugin;

public class PropertiesLoader {

    Properties loadProperties(Properties baseProperties, IPath propertiesLocation) {
        try {
            Properties properties = new Properties(baseProperties);
            FileInputStream in = null;
            try {
                in = new FileInputStream(propertiesLocation.toFile());
                properties.load(in);
            } finally {
                if (in != null) {
                    in.close();
                }
            }
            PropertiesSubstitution.evaluate(properties);
            return properties;
        } catch (FileNotFoundException e) {
            YPlugin.logWarning("Unable to find Platform properties.", e);
            return null;
        } catch (IOException e) {
            YPlugin.logError(e);
            return null;
        }
    }

}
