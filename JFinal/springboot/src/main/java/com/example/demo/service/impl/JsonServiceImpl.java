package com.example.demo.service.impl;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/7/4/004 18:11
 * @Version 1.0
 */
public class JsonServiceImpl {

    public static void main(String args[]){
        JsonParser parse =new JsonParser();  //创建json解析器
        try {

            JsonObject json =(JsonObject) parse.parse(new FileReader("D:\\JAVA\\IdeaProjects\\projects\\JFinal\\springboot\\src\\main\\java\\com\\example\\demo\\service\\impl\\test.json"));  //创建jsonObject对象
            JsonObject result=json.get("features").getAsJsonObject();
            JsonObject today = result.get("today").getAsJsonObject();



        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
