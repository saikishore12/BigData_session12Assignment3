package com.acadgild.extend;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



public class HospitalMapper1 extends
Mapper<IntWritable,Text, IntWritable,Text> {
	
	
@Override
public void map(IntWritable key, Text value, Context context)
  throws IOException, InterruptedException {
context.write(key, value);
  }
}
