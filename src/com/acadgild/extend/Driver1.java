package com.acadgild.extend;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
//import org.apache.hadoop.mapred.TextOutputFormat;
//import org.apache.hadoop.io.LongWritable;
//import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
//import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.mapreduce.Job;

import com.acadgild.HospitalMapper;
import com.acadgild.HospitalReducer;


public class Driver1 {

	@SuppressWarnings({ "deprecation" })
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		Job job1 = Job.getInstance(conf, "driver");		
		job1.setJarByClass(Driver1.class);
		job1.setMapperClass(HospitalMapper.class);
		job1.setReducerClass(HospitalReducer.class);
		job1.setMapOutputKeyClass(Text.class);
		job1.setMapOutputValueClass(IntWritable.class);
		job1.setOutputKeyClass(IntWritable.class);
		job1.setOutputValueClass(Text.class);
		job1.setInputFormatClass(TextInputFormat.class);
		job1.setOutputFormatClass(SequenceFileOutputFormat.class);
		FileInputFormat.addInputPath(job1, new Path(args[0]));
		Path outputPath=new Path("mapreduce1output");
		FileOutputFormat.setOutputPath(job1,outputPath);
		outputPath.getFileSystem(conf).delete(outputPath);
		job1.waitForCompletion(true);
	
		Configuration conf2 = new Configuration();
		
		Job job2 = Job.getInstance(conf2, "driver1");		
		job2.setJarByClass(Driver1.class);	
		job2.setMapperClass(HospitalMapper1.class);
		job2.setSortComparatorClass(DescendingIntComparator.class);
		//job2.setReducerClass(MyReducer.class);
		job2.setMapOutputKeyClass(IntWritable.class);
		job2.setMapOutputValueClass(Text.class);
		job2.setInputFormatClass(SequenceFileInputFormat.class);
		//job2.setOutputFormatClass(TextOutputFormat.class);
		FileInputFormat.addInputPath(job2, outputPath);
		FileOutputFormat.setOutputPath(job2,new Path(args[1]));
		//outputPath.getFileSystem(conf).delete(outputPath);
		job2.waitForCompletion(true);
		

	}

}
