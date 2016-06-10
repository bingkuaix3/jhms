package com.jhms.utils;

import java.text.DecimalFormat;

public class RateUtil {

	public double getRate(int val,int sum){
		if(sum == 0){
			return 0.0;
		}
		else{
			DecimalFormat    df   = new DecimalFormat("######0.00");   
			double res = (val / (sum * 1.0));
			df.format(res); 
			return res;
		}
	}
}
