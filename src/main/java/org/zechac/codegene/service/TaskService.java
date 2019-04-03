package org.zechac.codegene.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zechac.codegene.utils.Constants;
import org.zechac.codegene.utils.PathUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.Map;

@Component
public class TaskService {

    @Autowired
    private VelocityTplService velocityTplService;

    public void doTask(Map task,Map res){
        if(task.containsKey(Constants.Data)){
            res.put("data",task.get("data"));
        }
        String tplName=task.get(Constants.Tpl).toString();
        StringWriter stringWriter= velocityTplService.randerTpl(tplName,res);
        String outPath=task.get(Constants.OutPath).toString();
        outPath= PathUtils.buildPath(outPath,res);
        File file=new File(outPath);
        file.mkdirs();
        String fileName=task.get(Constants.FileName).toString();
        fileName=PathUtils.buildPath(fileName,res);
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(new File(file,fileName));
            fileOutputStream.write(stringWriter.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
