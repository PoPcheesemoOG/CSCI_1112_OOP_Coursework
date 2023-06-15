/* Name: Paul Helske
 * Date: 06/14/23
 */
public class Ex19_5 {
  public static void main(String[] args) {
    Integer[] numbers = {1, 2, 3};
    System.out.println(max(numbers));
    
    String[] words = {"red", "green", "blue"};
    System.out.println(max(words));
    
    Circle[] circles = {new Circle(3), new Circle(2.9), new Circle(5.9)};
    System.out.println(max(circles));
  }
  
  static class Circle implements Comparable<Circle> {
    double radius;
    
    public Circle(double radius) {
      this.radius = radius;
    }
    
    @Override
    public int compareTo(Circle c) {
      if (radius < c.radius) 
        return -1;
      else if (radius == c.radius)
        return 0;
      else
        return 1;
    }
    
    @Override
    public String toString() {
      return "Circle radius: " + radius;
    }

  }
  public static <E extends Comparable<E>> E max(E[] list) {
  	// declare max as first index
  	E max = list[0];
  	//go through list, replace max if greater
  	for (int i = 0; i < list.length; i++) {
  		if (max.compareTo(list[i]) < 0) {
  			max = list[i];
  		}
  	}
  	return max;
  }
}