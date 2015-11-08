/*
 * testarray is a driver program testing all the methods constructed in Arraylist.java
 */

public class testarray {

	public static void main(String[] args) {
		//Method 1 Arraylist()
		Arraylist a = new Arraylist();
		System.out.println("Default Arraylist Constructed");
		
		//Method 2 Arraylist(n)
		Arraylist b = new Arraylist(5);
		System.out.println("Arraylist Constructed with 5 Elements");
		
		//Method 7 isEmpty()
		System.out.println("The default Arraylist is not populated: " + a.isEmpty());
		
		//Method 3 add()
		for(int i = 0; i < 15; i++){
			a.add(i);
		}
		System.out.println(a.toString() + "The add method is successful");
		System.out.println("The default array is not populated: " + a.isEmpty());
		
		//Method 4 add( , )
		a.add(5, "FIVE!");
		a.add(8, "Eight");
		System.out.println(a.toString() + "This add method(index, x) is also successful");
		
		//Method 5 get()
		System.out.println("The get() method clearly works--Index 5: " + a.get(5));
		
		//Method 6 size()
		System.out.println("The size() method works as well--Size of b: " + b.size());
		for(int i = 0; i < 8; i++){
			b.add(i);
		}
		System.out.println("The size( method now surely works--Size of b: " + b.size());
		
		//Method 8 isIn()
		System.out.println("The isIn() method works--is the String HI in b? " +  b.isIn("HI"));
		b.add("HI");
		System.out.println("Now is the String HI in b? " + b.isIn("HI"));
		
		//Method 9 find()
		System.out.println("At what index is String FIVE! in Arraylist a? " + a.find("FIVE!"));
		
		//Method 10 remove()
		a.remove("FIVE!");
		System.out.println("String FIVE! has been removed from Object a: " + a.toString() );
	}
}
