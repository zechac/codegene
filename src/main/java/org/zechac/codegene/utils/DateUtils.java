package org.zechac.codegene.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    public String format(Date date,String pattern){
        return DateFormatUtils.format(date,pattern);
    }

    /**
     * 获取当前时间
     * @return
     */
    public String now(){
        return simpleDateFormat.format(new Date());
    }
}
