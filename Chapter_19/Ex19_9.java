/* Name: Paul Helske
 * Date: 06/15/23
 */
import java.util.*;

public class Ex19_9 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(14);
		list.add(24);
		list.add(4);
		list.add(42);
		list.add(5);
		Ex19_9.<Integer>sort(list);

		System.out.print(list);
	}
	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		Collections.sort(list);
		
	}
}
