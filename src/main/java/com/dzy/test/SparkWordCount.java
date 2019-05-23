package com.dzy.test;


import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.SparkSession;


public class SparkWordCount {
    public static void main(String[] args){
        SparkSession spark = SparkSession.builder().appName("Simple Application").getOrCreate();
        String config1 = PropertyUtil.getString("config.key1", "");
        String config2 = PropertyUtil.getString("config.key2", "");
        String set1 = SetUtil.getString("set.key1", "");
        String set2 = SetUtil.getString("set.key2", "");
        String string = String.format("config.key1=%s, config.key2=%s, set.key1=%s, set.key2=%s ===>>> ",
                config1, config2, set1, set2);
        SparkContext sc = spark.sparkContext();
        JavaSparkContext jsc = JavaSparkContext.fromSparkContext(sc);
        Broadcast<String> broadcast = jsc.broadcast(string);
        JavaRDD<String> stringJavaRDD = jsc.textFile(args[0], 20);
        stringJavaRDD.foreach(x -> System.out.println(broadcast.value() + x));

        spark.stop();
    }
}