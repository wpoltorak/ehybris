package com.lambda.plugin.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.core.runtime.IPath;

import com.lambda.plugin.YPlugin;

public class PropertiesLoader {

    Properties loadProperties(Properties baseProperties, IPath propertiesLocation) {
        FileInputStream in = null;
        try {
            Properties properties = new Properties(baseProperties);
            File file = propertiesLocation.toFile();
            if (!file.exists()) {
                return null;
            }
            in = new FileInputStream(file);
            properties.load(in);
            PropertiesSubstitution.evaluate(properties);
            return properties;
        } catch (FileNotFoundException e) {
            YPlugin.logWarning("Unable to find Platform properties.", e);
            return null;
        } catch (IOException e) {
            YPlugin.logError(e);
            return null;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioe) {
                // ignore
            }
        }
    }

}
