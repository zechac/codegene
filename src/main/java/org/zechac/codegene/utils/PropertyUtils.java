package org.zechac.codegene.utils;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtils {
    /**
     * 加载配置文件
     * @param location
     */
    public static Map loadProperty(String location){
        Resource resource=null;
        if(location.startsWith("classpath:")){
            location=location.replace("classpath:","");
            resource=new ClassPathResource(location);
        }
        if(location.startsWith("file:")){
            location=location.replace("file:","");
            resource=new FileSystemResource(location);
        }

        Yaml yaml = new Yaml();
        try {
            return yaml.loadAs(resource.getInputStream(), HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Properties margeProperties(Properties properties1, Properties properties) {
       properties.forEach((k,v)->{
           //properties1.setProperty(k,v);
        });
       return null;
    }

    public static Map margeProperties(Map properties1, Map properties) {
        properties.forEach((k,v)->{
            properties1.put(k,v);
        });
        return properties1;
    }

    public static boolean exists(String location) {
        Resource resource=null;
        if(location.startsWith("classpath:")){
            location=location.replace("classpath:","");
            resource=new ClassPathResource(location);
            return resource.exists();
        }
        if(location.startsWith("file:")){
            location=location.replace("file:","");
            resource=new FileSystemResource(location);
            return resource.exists();
        }
        return false;
    }
}
