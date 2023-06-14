/* Name: Paul Helske
 * Date: 06/13/2023
 */

import java.util.ArrayList;

public class Ex19_3 {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(14);
		list.add(24);
		list.add(14);
		list.add(42);
		list.add(25);

		ArrayList<Integer> newList = removeDuplicates(list);
		System.out.print(newList);
	}

	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		
		ArrayList<E> list2 = new ArrayList<E>();
		
		for (int i = 0; i < list.size(); i++) {
			
			if (list2.contains(list.get(i)) == false) {
				list2.add(list.get(i));
			}
		}	
		return list2;
	}
}