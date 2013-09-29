package com.lambda.plugin.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IPath;

import com.lambda.plugin.YPlugin;
import com.lambda.plugin.utils.StringUtils;

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
            evaluate(properties);
            return properties;
        } catch (FileNotFoundException e) {
            YPlugin.logError(e);
            return null;
        } catch (IOException e) {
            YPlugin.logError(e);
            return null;
        }
    }

    private void evaluate(Properties properties) {
        Set<Entry<Object, Object>> entrySet = properties.entrySet();
        for (Entry<Object, Object> entry : entrySet) {
            evaluate(properties, entry);
        }
    }

    private void evaluate(Properties properties, Entry<Object, Object> entry) {
        Pattern p = Pattern.compile("\\$\\{([a-zA-Z0-9\\._]+)\\}");
        String value = (String) entry.getValue();

        Matcher m = p.matcher(value);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String propertyRef = m.group(1);
            String property = properties.getProperty(propertyRef);
            if (StringUtils.isNotEmpty(property)) {
                m.appendReplacement(sb, property);
            }
        }

        if (sb.length() > 0) {
            m.appendTail(sb);
            entry.setValue(sb.toString());
            evaluate(properties, entry);
        }
    }

}
