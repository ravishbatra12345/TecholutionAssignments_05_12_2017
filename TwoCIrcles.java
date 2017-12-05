package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TwoCIrcles {

	public static void main(String[] args) {
		circles(new String[] { "12 0 21 14 0 23", "0 45 8 0 94 9",
				"35 0 13 10 0 38", "0 26 8 0 9 25", "0 5 9 0 9 7",
				"0 15 11 0 20 16", "26 0 10 39 0 23", "37 0 5 30 0 11",
				"41 0 0 28 0 13" });

	}

	public static String[] circles(String[] info) {

		int infoLen = info.length;
		String[] relations = new String[infoLen];

		for (int i = 0; i < infoLen; i++) {
			List<CircleCoordinates> cCords = getDiscriptors(info[i]);
			relations[i] = relate(cCords);
		}
		return relations;
	}

	private static List<CircleCoordinates> getDiscriptors(String circlesStr) {

		List<CircleCoordinates> cirCords = new ArrayList<>();

		CircleCoordinates circleA = new CircleCoordinates();
		CircleCoordinates circleB = new CircleCoordinates();

		StringTokenizer st = new StringTokenizer(circlesStr, " ");

		int[] circleArr = new int[6];

		int i = 0;
		while (st.hasMoreTokens()) {
			circleArr[i] = Integer.valueOf(st.nextToken());
			i++;
		}
		if (circleArr[0] == 0 && circleArr[3] == 0) {
			circleA.point = circleArr[1];
			circleB.point = circleArr[4];
		} else {
			circleA.point = circleArr[0];
			circleB.point = circleArr[3];
		}
		circleA.radius = circleArr[2];
		circleB.radius = circleArr[5];

		cirCords.add(circleA);
		cirCords.add(circleB);
		return cirCords;
	}

	private static String relate(List<CircleCoordinates> cCords) {
		CircleCoordinates circleA = cCords.get(0);
		CircleCoordinates circleB = cCords.get(1);

		int extremeA1 = circleA.point + circleA.radius;
		int extremeA2 = circleA.point - circleA.radius;
		int extremeB1 = circleB.point + circleB.radius;
		int extremeB2 = circleB.point - circleB.radius;

		int distanceBtwCentres = Math.abs(circleA.point - circleB.point);
		int sumOfRadius = circleA.radius + circleB.radius;
		int distBtwFarEnds = Math.abs(extremeA1 - extremeB2);

		if (distanceBtwCentres == 0) {
			System.out.println("Concentric");
			return "Concentric";
		} else if (distanceBtwCentres == sumOfRadius
				|| distBtwFarEnds == 2 * circleA.radius
				|| distBtwFarEnds == 2 * circleB.radius) {
			System.out.println("Touching");
			return "Touching";
		} else if (distanceBtwCentres > sumOfRadius) {
			System.out.println("Disjoint-Outside");
			return "Disjoint-Outside";
		} else if (distanceBtwCentres < sumOfRadius) {
			if ((extremeA1 < extremeB1 && extremeA2 > extremeB2)
					|| (extremeA1 > extremeB1 && extremeA2 < extremeB2)) {
				System.out.println("Disjoint-Inside");
				return "Disjoint-Inside";
			} else {
				System.out.println("Intersecting");
				return "Intersecting";
			}
		}
		return null;
	}
}

class CircleCoordinates {
	Integer point;
	Integer radius;
}