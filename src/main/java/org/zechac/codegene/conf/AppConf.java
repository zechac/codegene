package org.zechac.codegene.conf;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;

import javax.annotation.Resource;

@Configuration
public class AppConf {

    @Bean(name = "defaultConversionService")
    public GenericConversionService genericConversionService(){
        GenericConversionService genericConversionService1=new GenericConversionService();
        return genericConversionService1;
    }

    /**
     *
     * @return
     */
    @Bean
    public VelocityEngine velocityEngine(){
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADERS, "classpath");
        ve.setProperty("resource.loader.classpath.class", ClasspathResourceLoader.class.getName());
        ve.init();
        return ve;
    }

}
