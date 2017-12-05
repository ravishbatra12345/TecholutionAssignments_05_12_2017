package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConsecutiveSum {

	public static void main(String[] args) {
		consecutive(1000000000);
		consecutive(15);
		consecutive(2);
		consecutive(10);
		consecutive(600);
		consecutive(300000000);
		consecutive(500000000);
		consecutive(704400000);
		consecutive(999999999);
		consecutive(10000000);
	}

	static int consecutive(long n) {

		Map<Integer, Integer> primeFactMap = new HashMap<Integer, Integer>();
		long num = n;
		long halfOfNum = n/2;
		for (int i = 2; i <= halfOfNum; i += 1) {
			if(n == 1) {
				break;
			}
		
			int divCount = 0;
			
			while (n % i == 0) {
				n /= i;
				++divCount;
			}
			
			if(i%2 != 0 && divCount > 0) {
					primeFactMap.put(i, divCount);
			}
		}

		// System.out.println(primeFactMap);
		Set<Integer> keys = primeFactMap.keySet();

		int product = 1;

		for (Integer key : keys) {
			product = product * (primeFactMap.get(key).intValue() + 1);
		}

		System.out.println("No Of Ways For "+ num +" : " + (product - 1));

		return product;
	}
}
