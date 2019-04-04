package org.zechac.codegene.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.zechac.codegene.service.AtlasService;
import org.zechac.codegene.service.VelocityTplService;
import org.zechac.codegene.utils.Constants;

import java.util.Properties;

@ShellComponent("atlas 模板生成")
public class AtlasProjGene {

    @Autowired
    private AtlasService atlasService;

    @ShellMethod(value = "后台代码生成",key = "ab")
    public String backendGene(
            @ShellOption(value = {"-m","-module"},help = "模块名称") String module,
            @ShellOption(value = {"-md","--module-desc"},help = "模块描述",defaultValue = "")String moduleDesc){
        Properties properties=new Properties();
        properties.setProperty(Constants.ModuleName,module);
        properties.setProperty(Constants.ModuleDesc,moduleDesc);
        atlasService.geneBackendTpl(properties);
        return "gene success";
    }
}
