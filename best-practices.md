# Scala Style guide
### Line Wrapping
### Methods with numerous arguments
It is a good practice to wrap methods with numerous arguments 

### Naming convention
Class name: Upper camel case <br/>
Function name: Lower Camel case <br/>
Value and Variabe name: Lower Camel case <br/>
Constant names: Upper camel case <br/>
Arguments: Camel case <br/>
Type Parameters: Single Capital letter <br/>
Type Parameters: If the parameter has a specific name : the Firts letter with Caps and rest all small <br/>
Annotations: lower camel case

Object name: Upper camel case ***Exception***  When mimicking a package or function.
Example of exception:
```
object ast {
    sealed trait Expr
    case class Plus(e1: Expr, e2: Expr) extends Expr 
    ...
}
object inc {
    def apply(x: Int): Int = x+1
}
```

***Packages***
The naming convention of package in scala is same as that of java.

***Usage of _root_ while importing libraries***
_root_ is not required in most cases. It is sparingly used when there is specific need to disambiguate package names and avoid naming conflicts.


 




# Best Practices
### 1. Use strong typing: to catch erros at compile time itself.

### 2. Avoid using wildcards:
Wildcards or patter matching in scala: This will import all the classes and packages within a namespace
Ex. 
```
import org.apache.spark.sql._
```
The above command will import all the classes and packages within the ***org.apache.spark.sql*** namespace

#### Hence only import the required classes and packages

### 3. Minimize Data Shuffling:
Data Shuffling is an expensive operation as it causes Network Overhead due. Ex. ***repartitioning causes data shuffling***
Try using operations that don't require data shuffling ex. ***map***, ***filter***, ***flatMap***.

Operations like ***groupBy*** and ***join*** can aslo trigger data shuffling

### 4. Use broadcast variables
In spark, broadcast variables are used to share the read only data across all the worker nodes in a cluster.

This broadcast variables comes in handy when we have large read only data that needs to be accesses by multiple tasks or operations on different worker nodes.

Create the data that you want to broadcast
```
val data = Seq(1, 2, 3, 4, 5)
```

Broadcast the data across spark cluster
```
val broadcastData: Broadcast[Seq[Int]] = sc.broadcast(data)
```

Performing operations using broadcast variable
```
val result=sc.parallelize(Seq(1,2,3,4,5)).map(num => num*broadcastData.value.sum).collect()
```

Displaying the result
```
result.foreach(println)
```

### 5. Handle Missing or Corrupted Data

### 6. Caching or persisting
When we have to use immediate results multiple times iteratively, we should use persistene/Caching
Also depending upon the size of the data, persistence level can be chosen appropriately.

### 7. Proper partitioning of data
Partitioning on frequently used data can improve the performance.

### 8. Leverage DataFrame and DataSet API:
Avoid using RDD API whenever possible. The DataFrame and DataSet APIs provide a higher level of optimisation and performance enhancements.

### 9. Write unit tests
Write unit test cases using frameworks like ScalaTest or JUnit.

### 10. Follow Scala style guide and properly document the code 



