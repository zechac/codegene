package org.zechac.codegene.service;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zechac.codegene.utils.Constants;
import org.zechac.codegene.utils.DateUtils;
import org.zechac.codegene.utils.ValueUtils;

import java.io.StringWriter;
import java.util.Map;

@Component
public class VelocityTplService {

    private String tplPath="";

    @Autowired
    private VelocityEngine velocityEngine;

    /**
     * 测试 渲染模板
     * @param tplName
     * @param data
     * @return
     */
    public StringWriter randerTpl(String tplName,Map data){
        Template t = velocityEngine.getTemplate(tplPath+tplName);
        VelocityContext ctx = new VelocityContext();
        ctx.put("dateutils",new DateUtils());
        data.forEach((k,v)->{
            v= ValueUtils.build(v,data);
            ctx.put(k.toString(),v);
        });
        StringWriter sw = new StringWriter();
        t.merge(ctx, sw);
        return sw;
    }

    public void initEngine(Map res) {
        velocityEngine.reset();
        if(res.containsKey(Constants.TplRes)){
            String tplRes=res.get(Constants.TplRes).toString();
            if(tplRes.startsWith("classpath:")) {
                this.tplPath=tplRes.replace("classpath:","");
                velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADERS, "classpath");
                velocityEngine.setProperty("resource.loader.classpath.class", ClasspathResourceLoader.class.getName());
            }
        }else{
            velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADERS, "classpath");
            velocityEngine.setProperty("resource.loader.classpath.class", ClasspathResourceLoader.class.getName());
        }
        velocityEngine.init();
    }
}
