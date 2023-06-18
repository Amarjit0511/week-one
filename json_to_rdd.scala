import org.apache.spark.{SparkConf, SparkContext}
object jsonRDD {
  def main(args: Array[String]): Unit={

    //Creating a Configuration object for the application
    val conf=new SparkConf()
      .setAppName("jsonRDD")
      .setMaster("local[*]")

    //Creating a SparkContext object
    val sc=new SparkContext(conf)

    //Reading the data
    val rdd=sc.textFile("C:\\Datasets\\dwsample2-json.json")

    //Printing the sample data
    val sample=rdd.take(5)
    sample.foreach(println)

    sc.stop()
  }

}
