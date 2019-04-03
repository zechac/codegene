package org.zechac.codegene.service;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;
import org.zechac.codegene.utils.Constants;
import org.zechac.codegene.utils.PropertyUtils;

import java.io.File;
import java.util.Map;
import java.util.Properties;

@Component
public class PropertyService {

    private String g1="classpath:project.yml";
    private String g2="file:project.yml";

    public Map loadProperties(String projName){
        //global
        Map p1= PropertyUtils.loadProperty(g1);
        if(PropertyUtils.exists(g2)){
            Map p2=PropertyUtils.loadProperty(g2);
            p1=PropertyUtils.margeProperties(p1,p2);
        }

        //proj
        /*
        if(env.containsProperty(projName)){
            Object object=env.getProperty(projName,Object.class);
        }
        */
        return p1;
    }
}
