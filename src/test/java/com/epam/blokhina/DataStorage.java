package java.com.epam.blokhina;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by yevheniia on 24.05.2015.
 */
public class DataStorage {
    private Map<String, Properties> propertiesMap;
    private DataStorage() {
        this.propertiesMap = new HashMap<String, Properties>();
    }
    public static DataStorage getInstance() {
        return new DataStorage();
    }
    public void setProperty(String key, Properties properties) {
        propertiesMap.put(key, properties);
    }
    public Properties getProperty(String key) {
        return propertiesMap.get(key);
    }
    public boolean exists(String key) {
        return propertiesMap.get(key) != null;
    }
}
