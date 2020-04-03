package org.zechac.codegene.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zechac.codegene.utils.PropertyUtils;
import org.zechac.codegene.utils.TaskUtils;

import java.util.List;
import java.util.Map;
import java.util.Properties;
@Component
public class TaskCommandService {

    @Autowired
    private VelocityTplService velocityTplService;
    @Autowired
    private ProjService projService;
    @Autowired
    private TaskService taskService;

    /**
     * 根据task配置生成模板
     * @param task
     * @param properties
     */
    public void doTask(String taskName, Properties properties) {
        Map properties1= projService.loadProperties(taskName);
        Map res= PropertyUtils.margeProperties(properties1,properties);
        Map taskRes= TaskUtils.loadTask("task/"+taskName+".yml");
        List<Map> task=(List) taskRes.get("task");
        taskRes.remove("task");
        res=PropertyUtils.margeProperties(res,taskRes);
        velocityTplService.initEngine(res);
        for (Map map : task) {
            taskService.doTask(map,res);
        }
    }

}
