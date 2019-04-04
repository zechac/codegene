package org.zechac.codegene.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent("基于任务的模板生成")
public class TaskCmd {

    @ShellMethod(value = "基于任务的模板生成",key = "task",prefix = "-")
    public String backendGene(
            @ShellOption(value = {"-t","-task"},help = "任务名称") String task,
            @ShellOption(value = {"-d","-data"},help = "自定义参数,逗号隔开，例: a=a,b=b",defaultValue = "")String data){

        return "gene success";
    }
}
