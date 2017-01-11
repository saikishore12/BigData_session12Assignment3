package com.acadgild.extend;

//import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;
//import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class DescendingIntComparator extends WritableComparator {

	public DescendingIntComparator() {
		super(IntWritable.class,true);
		// TODO Auto-generated constructor stub
	}

	public int compare(@SuppressWarnings("rawtypes") WritableComparable w1,@SuppressWarnings("rawtypes") WritableComparable w2){
		IntWritable key1=(IntWritable) w1;
		IntWritable key2=(IntWritable) w2;
		return -1* key1.compareTo(key2);
		
	}
	
	

}
