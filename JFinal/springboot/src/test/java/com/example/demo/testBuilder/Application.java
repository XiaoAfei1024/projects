package com.example.demo.testBuilder;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/12/18/018 10:48
 * @Version 1.0
 */
public class Application {
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240,8)
                .calories(100).sodium(35).carbohydrate(27).build();
    }
}
