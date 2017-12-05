package com.test;

public class FindTheWInner {

	public static void main(String[] args) {
		System.out.println(winner(new int[] { 1, 2, 3 }, new int[] { 2, 1, 3 },
				"even"));
		System.out.println(winner(new int[] { 1, 2, 3 }, new int[] { 2, 1, 3 },
				"Odd"));
	}

	static String winner(int[] andrea, int[] maria, String str) {
		int andreaPoints = 0;
		int mariaPoints = 0;
		int i = 0;
		if ("odd".equalsIgnoreCase(str)) {
			i = 1;
		}

		while (i < andrea.length) {
			int points = andrea[i] - maria[i];
			andreaPoints = andreaPoints + points;
			mariaPoints = mariaPoints - points;
			i += 2;
		}

		if (andreaPoints > mariaPoints) {
			return "Andrea";
		} else if (mariaPoints > andreaPoints) {
			return "Maria";
		}

		return "Tie";
	}
}
