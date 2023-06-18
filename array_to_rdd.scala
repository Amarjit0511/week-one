import org.apache.spark.{SparkConf, SparkContext}

object rddd {
  def main(args: Array[String]): Unit = {
    // Create a SparkConf object
    val conf = new SparkConf().setAppName("rddd").setMaster("local[*]")

    // Create a SparkContext object
    val sc = new SparkContext(conf)

    // Create an RDD by parallelizing an existing collection
    val data = Array(1, 2, 3, 4, 5)
    val rdd = sc.parallelize(data)

    // Perform transformations and actions on the RDD
    val squaredRDD = rdd.map(x => x * x)
    val result = squaredRDD.collect()

    // Print the result
    result.foreach(println)

    // Stop the SparkContext
    sc.stop()
  }
}
