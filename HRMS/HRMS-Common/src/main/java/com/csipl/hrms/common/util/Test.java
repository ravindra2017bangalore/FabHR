package com.csipl.hrms.common.util;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String args[]) {
		int array[] = { 1, 4, 7, 6, 8, 9, 10, 11, 13, 16, 2, 9, 1, 3, 5, 6, 8 };

		int previousValue = 0;
		int nextValue = 0;
		List arrayList = new ArrayList();

		for (int i = 0; i < array.length; i++) {
			
			for (int j = i + 1; j < array.length; j++) {
				List tempList = new ArrayList();
				previousValue = array[j - 1];
				nextValue = array[j];
				tempList.add( previousValue );

				System.out.println("nextValue === " + previousValue + "       " + nextValue);

				if ( previousValue > nextValue ) {
					System.out.println(" =======   ");
					break;

				}
				i = j;
				arrayList.addAll(tempList);
			}
			

		}

		System.out.println(arrayList.size());
		for (int index = 0; index < arrayList.size(); index++) {
			System.out.println(arrayList.get(index));
		}

	}

}
