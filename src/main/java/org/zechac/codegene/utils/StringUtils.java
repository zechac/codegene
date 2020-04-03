package org.zechac.codegene.utils;

public class StringUtils {

    public String firstUpper(String s){
        String first=s.substring(0,1)+"";
        first=first.toUpperCase();
        s=first+s.substring(1,s.length()-1);
        return s;
    }

    public String firstLower(String s){
        String first=s.substring(0,1)+"";
        first=first.toLowerCase();
        s=first+s.substring(1,s.length()-1);
        return s;
    }

    public String toLower(String s){
       s=s.toLowerCase();
        return s;
    }
}
