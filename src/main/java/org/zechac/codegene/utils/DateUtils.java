package org.zechac.codegene.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

public class DateUtils {
    public String format(Date date,String pattern){
        return DateFormatUtils.format(date,pattern);
    }
}
