package org.zechac.codegene.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zechac.codegene.utils.PropertyUtils;
import org.zechac.codegene.utils.TaskUtils;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 *
 */
@Component
public class AtlasService {

    private final String projName="atlas-backend";
    private final String bTask="classpath:task/atlas-backend-task.yml";
    @Autowired
    private VelocityTplService velocityTplService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private TaskService taskService;

    /**
     * 生成后台模板
     */
    public void geneBackendTpl(Properties properties){
        Map properties1=propertyService.loadProperties(projName);
        Map res= PropertyUtils.margeProperties(properties1,properties);
        Map taskRes= TaskUtils.loadTask(bTask);
        List<Map> task=(List) taskRes.get("task");
        taskRes.remove("task");
        res=PropertyUtils.margeProperties(res,taskRes);
        velocityTplService.initEngine(res);
        for (Map map : task) {
            taskService.doTask(map,res);
        }
    }
}
