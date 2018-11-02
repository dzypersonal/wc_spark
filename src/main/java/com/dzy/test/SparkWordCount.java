package com.dzy.test;


import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.SparkSession;


public class SparkWordCount {
    public static void main(String[] args){
        SparkSession spark = SparkSession.builder().appName("Simple Application").getOrCreate();
        SparkContext sc = spark.sparkContext();
        RDD<String> rdd = sc.textFile("hdfs://ns2/user/ruban/test/wc/input", 20);
        JavaRDD<String> javaRDD = rdd.toJavaRDD();
        javaRDD.foreach(new VoidFunction<String>() {
            @Override
            public void call(String s) throws Exception {
                System.out.println(s);
            }
        });

        spark.stop();
    }
}