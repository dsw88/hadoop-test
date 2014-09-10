
package info.davidwoodruff.hadoop;

//import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Reducer class for NamePopularity MapReduce program
 */
public class NamePopularityReducer
    extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws InterruptedException, IOException {

        int totalCount = 0;
        for (IntWritable value : values) {
            totalCount += value.get();
        }
        context.write(key, new IntWritable(totalCount));
    }
}
