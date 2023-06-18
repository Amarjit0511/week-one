import org.apache.spark.{SparkConf, SparkContext}
object parquetRDD {
  def main(args: Array[String]): Unit={

    // Creating a configuration object for the application
    val conf=new SparkConf()
      .setAppName("parquetRDD")
      .setMaster("local[*]")

    //Creating a SparkContext object
    val sc=new SparkContext(conf)

    //Reading the data
    val rdd=sc.textFile("C:\\Datasets\\predictions.parquet")

    //Printing the sample data
    val sample=rdd.take(10)
    sample.foreach(println)

  }

}
