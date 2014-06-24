package com.example

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object App {
  
  def main(args : Array[String]) {
    println( "Hello World!" )
    val logFile="/home/dc/TestScalaMaven/src/main/resources/README.md"    
    val sc = new SparkContext("local","App","/usr/lib/spark",List("/home/dc/TestScalaMaven/target/TestScalaMaven-0.1.jar")) 
    val logData=sc.textFile(logFile,2).cache()
    val numAs = logData.filter(line=>line.contains("a")).count()
    println("numAs:"+numAs);    
  }

}
