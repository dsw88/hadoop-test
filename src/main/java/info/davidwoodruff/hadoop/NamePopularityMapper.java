
package info.davidwoodruff.hadoop;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Mapper class for NamePopularity MapReduce program
 */
public class NamePopularityMapper
    extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws InterruptedException, IOException {

        String[] nameData = value.toString().split(",");
        String name = nameData[1];
        int count = Integer.parseInt(nameData[4]);
        context.write(new Text(name), new IntWritable(count));
    }

}
