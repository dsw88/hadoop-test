# hadoop-test
First MapReduce program using Hadoop.

This is my first MapReduce program, following the information given in Chapter 2 of *Hadoop: The Definitive Guide*

# Instructions
To run my first MapReduce job, do the following:
1. Install Hadoop on your local machine. Recommended to use in standalone mode, as it simplifies configuration
2. Build Jar:
```
mvn clean install
```
3. Set JAR in Hadoop Classpath:
```
export HADOOP_CLASSPATH=path/to/hadoop-test.jar # Replace with real path of JAR
```
4. Run Hadoop job on main class:
```
hadoop NamePopularity Baby_Names__Beginning_2007.csv output
```

The resulting output will be in the *output* directory.
