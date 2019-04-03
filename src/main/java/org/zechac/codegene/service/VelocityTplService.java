package org.zechac.codegene.service;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class VelocityTplService {

    private String tplPath="templates/";

    @Autowired
    private VelocityEngine velocityEngine;

    /**
     * 测试 渲染模板
     * @param tplName
     * @param data
     * @return
     */
    public StringWriter randerTpl(String tplName,Object data){
        Template t = velocityEngine.getTemplate(tplPath+"hellovelocity.vm");
        VelocityContext ctx = new VelocityContext();

        ctx.put("name", "velocity");
        ctx.put("date", (new Date()).toString());

        List temp = new ArrayList();
        temp.add("1");
        temp.add("2");
        ctx.put( "list", temp);

        StringWriter sw = new StringWriter();

        t.merge(ctx, sw);
        return sw;
    }
}
