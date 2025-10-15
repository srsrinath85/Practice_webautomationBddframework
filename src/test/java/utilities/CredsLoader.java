package utilities;

import java.util.Properties;

public class CredsLoader {
    private final Properties properties;

    public CredsLoader() {
        properties = PropertyUtils.propertyLoader(System.getProperty("credsFilePath",
                System.getProperty("src/test/resources/devconfiguration.properties")));

    }

    public String getProperty(String property) {
        String prop = properties.getProperty(property);
        if (prop != null)
            return prop;
        else
            throw new RuntimeException("Property " + property + " is not specified in the creds file");
    }

}
