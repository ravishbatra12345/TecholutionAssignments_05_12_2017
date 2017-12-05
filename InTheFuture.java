package com.test;

public class InTheFuture {

	public static void main(String[] args) {

		minNum(3, 5, 1);
		minNum(4, 5, 1);
		minNum(30, 35, 99);
		minNum(2, 6, 3);
		minNum(2, 5, 1);
		minNum(3, 6, 3);
		minNum(2, 3, 5);
		minNum(5, 2, 3);
	}
	
	static int minNum(int a, int k, int p) {
		
		boolean aNotInLimit = a<=0 || a>100;
		boolean kNotInLimit = k<=0 || k>100;
		boolean pNotInLimit = p<0 || p>100;
		
		if(aNotInLimit || kNotInLimit || pNotInLimit || a>k) {
			System.out.println("Result For ("+a+","+k+","+p+") : never");
			return -1;
		}
		
		if(a==p && p==0) {
			return 0;
		}
		
		double minDays = (double)p/(k-a);
		double minDaysCeil = Math.ceil(minDays);
		
		
		int result = new Double(minDaysCeil).intValue();
		
		if(minDays == Math.floor(minDays)) {
			result = result + 1;
		}
		System.out.println("Result For ("+a+","+k+","+p+") : " + result);
		return result;
	}

}
