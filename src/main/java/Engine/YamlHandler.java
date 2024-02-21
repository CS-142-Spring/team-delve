package main.java.Engine;

import java.util.Map;
import java.io.InputStream;
import org.yaml.snakeyaml.*;

public class YamlHandler {

    Yaml yaml;

    public YamlHandler() {

        yaml = new Yaml();
    }
    
    public void load(String path) {

        InputStream inputStream = this.getClass()
            .getClassLoader()
            .getResourceAsStream("path");

        Map<String, Object> obj = yaml.load(inputStream);
        System.out.println(obj);
    }
}
