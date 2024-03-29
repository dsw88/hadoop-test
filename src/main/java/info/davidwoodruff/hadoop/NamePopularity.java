
package info.davidwoodruff.hadoop;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


/**
 * Main class for NamePopularity MapReduce program
 */
public class NamePopularity {

    public static void main(String[] args) throws Exception {
        if(args.length != 2) {
            System.err.println("Usage: NamePopularity <input path> <output path>");
            System.exit(1);
        }

        Job job = new Job();
        job.setJarByClass(NamePopularity.class);
        job.setJobName("Name popularity");

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(NamePopularityMapper.class);
        job.setReducerClass(NamePopularityReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        System.exit(job.waitForCompletion(true) ? 0 : 1);

    }

}
