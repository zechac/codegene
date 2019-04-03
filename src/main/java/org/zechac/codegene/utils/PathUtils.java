package org.zechac.codegene.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PathUtils {
    public static String buildPath(String pathTpl,Map res){
        List<String> ls=new ArrayList<String>();
        Pattern pattern = Pattern.compile("(?<=\\{)(.+?)(?=\\})");
        Matcher matcher = pattern.matcher(pathTpl);
        while(matcher.find()) {
            ls.add(matcher.group());
        }
        for(String s :ls){
            pathTpl=pathTpl.replace("{"+s+"}",res.get(s).toString());
        }
        return pathTpl;
    }
}
