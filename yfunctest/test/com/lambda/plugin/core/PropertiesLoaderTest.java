package com.lambda.plugin.core;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PropertiesLoaderTest {

    private static final IPath temp = new Path(System.getProperty("java.io.tmpdir"));
    private static final IPath propertiesFile = temp.append("ytest.properties");

    private PropertiesLoader loader;

    @Before
    public void init() {
        loader = new PropertiesLoader();

    }

    @BeforeClass
    public static void createPropertyFile() throws FileNotFoundException, IOException {
        File file = propertiesFile.toFile();
        file.createNewFile();
        Properties properties = new Properties();
        properties.put("test", "${platformhome} is OK ${platformhome}");
        properties.put("test1", "1");
        properties.put("test11", "${test1}${test1}");
        properties.put("test2", "${test${test1}} 2");
        properties.put("test3", "${test4.is_not_ok} 2");
        properties.put("test4", "aaa ${not.existing} sss ${test1} zzz ${ ${not.exist} dd");
        FileOutputStream out = new FileOutputStream(file);
        try {
            properties.store(out, null);
        } finally {
            out.close();
        }
    }

    @AfterClass
    public static void deletePropertyFile() {
        propertiesFile.toFile().delete();
    }

    @Test
    public void testLoading() {
        Properties base = new Properties();
        String platformhome = "home";
        base.put("platformhome", platformhome);

        Properties properties = loader.loadProperties(base, propertiesFile);

        assertEquals(platformhome, properties.getProperty("platformhome"));
        assertEquals(platformhome + " is OK " + platformhome, properties.getProperty("test"));
        assertEquals("1", properties.getProperty("test1"));
        assertEquals("11", properties.getProperty("test11"));
        assertEquals("1 2", properties.getProperty("test2"));
        assertEquals("${test4.is_not_ok} 2", properties.getProperty("test3"));
        assertEquals("aaa ${not.existing} sss 1 zzz ${ ${not.exist} dd", properties.getProperty("test4"));
    }
}
