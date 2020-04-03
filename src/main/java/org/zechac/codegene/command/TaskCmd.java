package org.zechac.codegene.command;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.zechac.codegene.service.TaskCommandService;
import org.zechac.codegene.service.TaskService;

import java.util.Properties;

@ShellComponent("基于任务的模板生成")
public class TaskCmd {

    @Autowired
    private TaskCommandService taskCommandService;

    @ShellMethod(value = "基于任务的模板生成,例：生成task为b-jpa的模板文件 g -t b-jpa -d className=Ex1",key = {"gene","g"})
    public String gene(
            @ShellOption(value = {"-t","-task"},help = "任务名称") String task,
            @ShellOption(value = {"-d","-data"},help = "自定义参数,逗号隔开，例: a=a,b=b",defaultValue = "")String data){
        Properties properties=new Properties();
        if(StringUtils.isNoneBlank(data)){
            String[]  d1=data.split(",");
            for(int i=0;i<d1.length;i++){
                String[] d2=d1[i].split("=");
                properties.setProperty(d2[0],d2[1]);
            }
        }
        taskCommandService.doTask(task,properties);
        return "生成成功";
    }
}
