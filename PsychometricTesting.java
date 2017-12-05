package com.test;

public class PsychometricTesting {

	public static void main(String[] args) {

		print(jobOffers(new int[] { 4, 8, 7 }, new int[] { 2, 4 }, new int[] {
				8, 4 }));

	}

	static void print(int[] jobOffers) {
		for (int i = 0; i < jobOffers.length; i++) {
			System.out.print(jobOffers[i] + " ");
		}
	}

	static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {

		int[] jobOffers = new int[lowerLimits.length];

		for (int i = 0; i < lowerLimits.length; i++) {
			int candidateCount = 0;
			for (int j = 0; j < scores.length; j++) {
				if (scores[j] >= lowerLimits[i] && scores[j] <= upperLimits[i]) {
					++candidateCount;
				}
			}

			jobOffers[i] = candidateCount;
		}

		return jobOffers;
	}
}
