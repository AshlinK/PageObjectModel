package rough;

import utilities.Property;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

    private static Properties properties = null;
    private static InputStream input = null;
    private static String value = null;

    public static String get(Property name) {
        properties = new Properties();
        try {
            input = new FileInputStream("src/main/resources/properties/config.properties");

            //Load the properties file
            properties.load(input);
            value = properties.getProperty(name.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;

    }
}
