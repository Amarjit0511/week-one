import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.storage.StorageLevel

object csvRDD {
    def main(args: Array[String]): Unit={
        
        // Creating a configuration object for the spark app
        val conf=new SparkConf()
          .setAppName("csvRDD")
          .setMaster("local[*]")
          
        // Creating an SparkContext 
        val sc=new SparkContext(conf)
        
        // Reading the data
        val df=sc.read.textFile("file location")
        
        // Persisting the data
        df.persist(STORAGELEVEL.MEMORY_ONLY)

        // Creating temporary table for persisted data
        df.createTempView("my_table")

        // Displaying the result
        val result = spark.sql("SELECT * FROM temp_table")
        result.show()

        // Unpersisting the data
        df.unpersist()

        // Stopping the spark session
        sc.stop()
    }
}
