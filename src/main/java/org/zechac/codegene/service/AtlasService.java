package org.zechac.codegene.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zechac.codegene.utils.PropertyUtils;

import java.util.Properties;

/**
 *
 */
@Component
public class AtlasService {

    private final String projName="atlas-backend";
    @Autowired
    private VelocityTplService velocityTplService;
    @Autowired
    private PropertyService propertyService;

    /**
     * 生成后台模板
     */
    public void geneBackendTpl(Properties properties){
        Properties properties1=propertyService.loadProperties(projName);
        Properties pl= PropertyUtils.margeProperties(properties1,properties);
    }
}
