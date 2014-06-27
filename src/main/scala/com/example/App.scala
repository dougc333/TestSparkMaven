package com.example

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.streaming._

object App {
  
  def main(args : Array[String]) {
    println( "Hello World!" )
    val logFile="/usr/lib/spark/README.md"    
    val sc = new SparkContext("local","App","/usr/lib/spark",List("/home/dc/TestScalaMaven/target/TestScalaMaven-0.1.jar")) 
    val logData=sc.textFile(logFile,2).cache()
    val numAs = logData.filter(line=>line.contains("a")).count()
    println("numAs:"+numAs);    
    
    //create a streaming context
       System.setProperty("twitter4j.oauth.consumerKey", "eFIaiOuxsny01VVQ2QWISK1Mw")
       System.setProperty("twitter4j.oauth.consumerSecret", "gDQI5EiCMJJaaNI8XVNhfZXwuCOYfeJ3XsOUNHvsXqgq0Hoj9T")
       System.setProperty("twitter4j.oauth.accessToken", "76976448-Otz8w4yMKx6yCEWTH3dNTfuF8LYeLgqdoDrcl0oBK")
       System.setProperty("twitter4j.oauth.accessTokenSecret", "NFPFe2EzuKWuzRKmY1RENUBfQzGeGbAS1JzjX3Eu3GwDE")
       //scaladocs not accurate, follow holden's exampple
       //spark://192.168.171.1:7077
//	   val stream = new StreamingContext("local","TestStuff", new Duration(1000))
//       val tweets= TwitterUtils.createStream(stream,None)
//	   tweets.print()
//	   stream.start()
//	   println("+++++++++++++++++++++++++++++");
//	   stream.stop(true)
       sc.stop()
  }

}
