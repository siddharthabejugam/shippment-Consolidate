package shippment.Consolidate1.service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author siddharthabejugam
 * class which will consolidate the zipcodes and produces the output
 */
public class ConsolidateService {

	
	/**
	 * iterate the list by intializing backward inside the forward loop and check based on
	 * the range of zipcode, if they fall within the specific range of each other,they are
	 * being merged.
	 */
	private static List<int[]> mergezipcodes(List<int[]> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > 1; --j) {
				boolean ismerged = false;
				int[] enlist1 = new int[2];
				if (list.get(i)[0] <= list.get(j)[0]) {
					if ((list.get(i)[1] >= list.get(j)[0] && list.get(i)[1] <= list
							.get(j)[1])) {
						enlist1[0] = list.get(i)[0];
						enlist1[1] = list.get(j)[1];
						ismerged = true;
					} else if (list.get(i)[1] >= list.get(j)[0]
							&& list.get(i)[1] >= list.get(j)[1]) {
						enlist1[0] = list.get(i)[0];
						enlist1[1] = list.get(i)[1];
						ismerged = true;
					}
				} else if (list.get(i)[0] > list.get(j)[0]) {
					if ((list.get(j)[1] >= list.get(i)[0] && list.get(j)[1] <= list
							.get(i)[1])) {
						enlist1[0] = list.get(j)[0];
						enlist1[1] = list.get(i)[1];
						ismerged = true;
					} else if (list.get(j)[1] >= list.get(i)[0]
							&& list.get(j)[1] >= list.get(i)[1]) {
						enlist1[0] = list.get(j)[0];
						enlist1[1] = list.get(j)[1];
						ismerged = true;
					}
				}
				if (ismerged) {
					list.remove(i);
					list.remove(j - 1);
					list.add(enlist1);
					i = 0;
				}
			}
		}
		return list;
	}
	
	public void runZipcodeConsodilation (List<int[]> list){
		
		list = mergezipcodes((LinkedList<int[]>) list);
		for(int[] inte : list)
			System.out.println("["+inte[0]+" " +inte[1]+"]");
		
	}

}
