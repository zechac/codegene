package org.zechac.codegene.utils;

import java.util.Date;
import java.util.Map;

public class ValueUtils {
    public static Object build(Object val,Map res){
        if(val instanceof String) {
            String s=(String) val;
            if (s.startsWith("#")) {
                if (s.equals("#now")) {
                    return new Date();
                }
            }
        }
        return val;
    }
}
