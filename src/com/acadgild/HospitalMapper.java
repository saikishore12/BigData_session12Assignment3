package com.acadgild;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



public class HospitalMapper extends
Mapper<LongWritable, Text, Text, IntWritable> {
	private Text Question = new Text();
	
@Override
public void map(LongWritable key, Text value, Context context)
  throws IOException, InterruptedException {

	String line = value.toString();
	String hospital_data[] = line.split(",");

	if (hospital_data.length > 4) {
		Question.set(hospital_data[1]);
		
	}

	context.write(Question, new IntWritable(1));
  }
}
