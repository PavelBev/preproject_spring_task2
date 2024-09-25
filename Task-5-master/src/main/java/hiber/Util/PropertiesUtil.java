package hiber.Util;

import lombok.var;

import java.util.Properties;

public final class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();
    static {
        loadProperties();
    }
    private PropertiesUtil() {}

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
    private static void loadProperties() {
        try (var inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("db.properties")){
            PROPERTIES.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
