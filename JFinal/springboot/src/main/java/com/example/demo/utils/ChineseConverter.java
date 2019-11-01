package com.example.demo.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.nlpcn.commons.lang.jianfan.JianFan;
import org.nlpcn.commons.lang.pinyin.Pinyin;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/11/1/001 17:28
 * @Version 1.0
 */
public class ChineseConverter implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 5460286608533749397L;
    private JSONObject HK_PINYIN = null;
    private JSONObject SIMPLE_TRADITIONAL = null;


    public List<String> convertChineseToPinYin(String source) {

        if(source.length()>6)
            return null;
        String name_zh = JianFan.f2j(source);
        List<JSONArray> pinyin_array_list = new LinkedList<>();
        // int name_count = 0;
        for (int i = 0; i < name_zh.length(); i++) {
            char c = name_zh.charAt(i);
            JSONArray values = HK_PINYIN.getJSONArray(c + "");
            if (values != null && values.size() > 0) {
                pinyin_array_list.add(values);
            } else {
                System.out.println(c + " no matching words!!!!");
                values = new JSONArray();
                List<String> pinyin_list = Pinyin.pinyin(c + "");
                for (String ele : pinyin_list) {
                    if (ele != null) {
                        values.add(ele.toUpperCase());
                    } else {
                        values.add((c + "").toUpperCase());
                    }
                }

                // System.out.println("Pinyin "+pinyin_list);
                pinyin_array_list.add(values);
            }
            // if (i == 0) {
            // if (values != null)
            // name_count = values.size();
            // else
            // return null;
            // } else {
            // if (values != null)
            // name_count *= values.size();
            // else
            // return null;
            // }
        }

        List<String> name_list = new LinkedList<>();
        name_list = joinName(pinyin_array_list, name_list, 0,true);

        return name_list;
    }

    private List<String> joinName(List<JSONArray> pinyin_array_list, List<String> result, int cursor,boolean is_pinyin) {
        if (cursor >= pinyin_array_list.size())
            return result;

        JSONArray ele = pinyin_array_list.get(cursor);
        int total = ele.size() * result.size();
        if (total == 0)
            total = ele.size();

        List<String> final_result = new LinkedList<>();
        for (int i = 0; i < (result.size() == 0 ? 1 : result.size()); i++) {
            for (int m = 0; m < ele.size(); m++) {
                String name = ((result.size() == 0) ? "" : result.get(i)) + ele.getString(m) + (is_pinyin?" ":"");
                final_result.add(name);
            }
        }
        result = joinName(pinyin_array_list, final_result, ++cursor,is_pinyin);

        return result;
    }

    public String convertFanToJian(String source) {
        String result="";
        if(source!=null) {
            char[] re_arr=source.toCharArray();
            for(int i=0;i<re_arr.length;i++) {
                result+=re_arr[i];
                for (String key : SIMPLE_TRADITIONAL.keySet()) {
                    JSONArray trad = SIMPLE_TRADITIONAL.getJSONArray(key);
                    for(Object o:trad) {
                        if(o.toString().equals(re_arr[i]+""))
                            result=result.replace(re_arr[i]+"", key);
                    }
                }
            }
        }
        result=JianFan.f2j(result);
        return result;
    }

    public List<String> convertJianToFan(String source) {

        List<JSONArray> fan_array_list = new LinkedList<>();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            JSONArray values =null;
            if(SIMPLE_TRADITIONAL.containsKey(c+"")) {
                values=SIMPLE_TRADITIONAL.getJSONArray(c+"");
            }else {
                values=new JSONArray();
                values.add(JianFan.j2f(c+""));
            }
            fan_array_list.add(values);
        }

        List<String> name_list = new LinkedList<>();
        name_list = joinName(fan_array_list, name_list, 0,false);

        return name_list;
    }

    public List<String> convertJianToFanOnlyMoreTraditional(String source) {

        List<JSONArray> fan_array_list = new LinkedList<>();
        for (int i = 0; i < source.length(); i++) {
            char c =convertFanToJian(source.charAt(i)+"").charAt(0);
            JSONArray values =null;
            if(SIMPLE_TRADITIONAL.containsKey(c+"")) {
                values=SIMPLE_TRADITIONAL.getJSONArray(c+"");
            }else {
                values=new JSONArray();
                values.add(c+"");
            }
            fan_array_list.add(values);
        }

        List<String> name_list = new LinkedList<>();
        name_list = joinName(fan_array_list, name_list, 0,false);

        return name_list;
    }

}
