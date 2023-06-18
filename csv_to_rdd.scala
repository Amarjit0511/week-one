import org.apache.spark.{SparkConf, SparkContext}
object csvRDD {
  def main(args: Array[String]): Unit={

    // Creating an object for Spark Configuration
    val conf=new SparkConf()
      .setAppName("csvRDD")
      .setMaster("local[*]")

    // Creating an object for SparkContext
    val sc =new SparkContext(conf)

    // Reading the file
    val rdd=sc.textFile("C:\\Datasets\\Supercharge_Locations.csv")

    // Printing the file
    val sample=rdd.take(10)
    sample.foreach(println)
  }

}
