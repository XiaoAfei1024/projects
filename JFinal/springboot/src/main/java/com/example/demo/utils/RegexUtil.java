package com.example.demo.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/11/1/001 17:26
 * @Version 1.0
 */
public class RegexUtil {
    /**
     * @param source
     * @return
     * only remain Chinese character and English character
     */
    public static String removeSpecialChar(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "[0-9\\s~·`!！@#￥$%^……&*（()）\\-——\\-_=+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            return m.replaceAll("");
        }
        return source;
    }
    public static String removeSpecialCharRemainNum(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "[\\s~·`!！@#￥$%^……&*（()）\\-——\\-_=+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            return m.replaceAll("");
        }
        return source;
    }
    public static String removeSpecialCharRemainSpace(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "[~·`!！@#￥$%^……&*（()）\\-——\\-_=+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            return m.replaceAll("");
        }
        return source;
    }
    public static String removeSpace(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "[\\s]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            return m.replaceAll("");
        }
        return source;
    }
    public static String removeTailNum(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "(\\d+)$";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            return  m.replaceAll("");
        }
        return source;

    }

    public static String removeHeadEnCharAndNum(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "^([a-zA-Z0-9]+)";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            return  m.replaceAll("");
        }
        return source;
    }

    public static String removeTailEnCharAndNum(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "([a-zA-Z0-9]+)$";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            return  m.replaceAll("");
        }
        return source;
    }

    public static boolean isWholeNum(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "^[0-9]*$";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            return m.find();
        }
        return false;
    }

    public static String[] splitByNum(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "[0-9]";

            return source.split(regEx);
        }
        return null;
    }
    public static String[] splitByEnglishChar(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "[a-zA-Z]";

            return source.split(regEx);
        }
        return null;
    }
    public static String[] splitByEnglishSingleChar(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = " [a-zA-Z] ";

            return source.split(regEx);
        }
        return null;
    }
    public static boolean isContainEnglishSingleChar(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = " [a-zA-Z] ";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            return m.find();
        }
        return false;
    }
    public static boolean isContainNum(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "[0-9]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            return m.find();
        }
        return false;
    }

    public static String getNum(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "[^\\d]*";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            return m.replaceAll("");
        }
        return null;
    }

    public static String removeNotNumAndEnglisChar(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "[^a-zA-Z0-9]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            return  m.replaceAll("");
        }
        return source;
    }
    public static String removeNotNum(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "\\D";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            return  m.replaceAll("");
        }
        return source;
    }


    public static boolean isChinese(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "^[\u4e00-\u9fa5]*$";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            return m.find();
        }
        return false;
    }

    public static boolean isContainChinese(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "[\u4e00-\u9fa5]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            return m.find();
        }
        return false;
    }

    public static JSONObject getChinesePosition(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "[\u4e00-\u9fa5]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            if(m.find()) {
                JSONObject result=new JSONObject();
                result.put("start", m.start());
                result.put("end", m.end());
                return result;
            }
        }
        return null;
    }

    public static boolean isContainEnglish(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "[A-Za-z]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            return m.find();
        }
        return false;
    }
    /**
     * @param source
     * @return start index,end index
     */
    public static JSONObject getEnglishPosition(String source) {

        if (source != null && !source.trim().isEmpty()) {
            String regEx = "[A-Za-z]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            if(m.find()) {
                JSONObject result=new JSONObject();
                result.put("start", m.start());
                result.put("end", m.end());
                return result;
            }
        }
        return null;
    }

    public static int getFloorStartPosition(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "[0-9一二三四五六七八九十０-９a-zA-Z]{1,}(F|/F|樓|字樓|楼|層|层|室)(?!(號|号))";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            if(m.find()) {
                return m.start();
            }
        }
        return -1;
    }
    public static int getFloorEndPosition(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "[0-9]{1,}(F|/F)";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            if(m.find()&&m.end()>=0) {
                return m.end();
            }

            regEx = "FLAT\\s[0-9]{1,}";
            p = Pattern.compile(regEx);
            m = p.matcher(source);
            if(m.find()) {
                return m.end();
            }
        }
        return -1;
    }

    public static String getFirstSpecialChar(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "[~·`!！@#￥$%^……&*（\\()）\\-——\\-_=+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            if(m.find()) {
                return source.substring(m.start(),m.start()+1);
            }
        }
        return null;
    }
    public static String getFirstSpecialCharContainSpace(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "[\\s~·`!！@#￥$%^……&*（\\()）\\-——\\-_=+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            if(m.find()) {
                return source.substring(m.start(),m.start()+1);
            }
        }
        return null;
    }
    public static List<String> getSpecialChar(String source) {
        if (source != null && !source.trim().isEmpty()) {
            String regEx = "[~·`!！@#￥$%^……&*（()）\\-——\\-_=+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(source);
            if(m.find()) {
                List<String> result=new ArrayList<>();
                for(int i=0;i<m.groupCount();i++) {
                    String special_char=source.substring(m.start(i),1);
                    if(!result.contains(special_char)) {
                        result.add(special_char);
                    }
                }
                return result;
            }
        }
        return null;
    }
}
