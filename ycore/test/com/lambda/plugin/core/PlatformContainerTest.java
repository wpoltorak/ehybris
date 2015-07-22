package com.lambda.plugin.core;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.Properties;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PlatformContainerTest {

    private PlatformContainer container;
    PropertiesLoader loader;

    @Before
    public void init() {
        loader = Mockito.mock(PropertiesLoader.class);

        container = new PlatformContainer();
        container.setPropertiesLoader(loader);
    }

    @Test
    public void testCreatePlatform() {
        Properties properties = new Properties();
        properties.put("test", "${platformhome} is OK ${platformhome}");
        properties.put("test1", "1");
        properties.put("test11", "11");
        properties.put("test2", "${test${test1}} 2");
        properties.put("test3", "${test4.is_not_ok} 2");

        doReturn(properties).when(loader).loadProperties(any(Properties.class), any(IPath.class));

        long id = System.currentTimeMillis();
        String name = "test platform";
        String description = "test e-commerce platform";
        String version = "0.1";
        IPath path = new Path(System.getProperty("java.io.tmpdir"));

        StandardPlatformType platform = container.createPlatform(name, id, description, version, path.toOSString());
        assertEquals(description, platform.getDescription());
        assertEquals(id, platform.getId());
        assertEquals(name, platform.getName());
        assertEquals(version, platform.getVersion());
        assertEquals(description, platform.getDescription());
        assertEquals(platform.getProperties(), properties);
        assertEquals(path, platform.getRootLocation());
        assertEquals(path.append("bin").append("platform"), platform.getPlatformLocation());
        assertEquals(path.append("bin").append("custom"), platform.getCustomExtensionLocation());
        assertEquals(path.append("config"), platform.getConfigLocation());
        assertEquals(path.append("temp"), platform.getTempLocation());
        assertEquals(path.append("data"), platform.getDataLocation());

    }
}
