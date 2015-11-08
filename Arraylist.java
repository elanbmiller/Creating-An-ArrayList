public class Arraylist {

	private int capacity;
	private Object[] objectList;
	private int size;

	//Default constructor with size 10
	public Arraylist() {
		this(10);
	}
	//-----------------------------------------------------------------------------
	//Constructs and Arraylist of size n
	//Precondition: n must be great than zero
	//Postcondition: method sets capacity = n and objectList[capacity]
	//-----------------------------------------------------------------------------
	public Arraylist(int n){
		this.capacity = n;
		this.objectList = new Object[capacity];
	}
	//returns Arraylist as a String value
	public String toString(){
		String list = "";
		for(int i = 0; i < size; i++){
			list+= objectList[i].toString() + " ";
		}
		return list;
	}

	//returns int size of Arraylist, which is equivalent to the index of where the next object will be added
	//in the add method
	public int lastObjIndex(){
		return size;
	}
	//creates new Array of size 10> objectList.length to be returned and it copies the Objects from objectList
	//and it's used in conjunction with the add method to increase size
	public Object addHelper(){
		Object[] newObjectList = new Object[objectList.length+10];
		for(int i = 0; i < objectList.length;i++){
			newObjectList[i] = objectList[i];
		}
		return newObjectList;
	}
	//-----------------------------------------------------------------------------
	//adds inputted Object x to the end of Arraylist.
	//Precondition: method must receive Object x
	//Postcondition: Adds to the array if isFull() through use of the addHelper() and then
	//adds x to the end of array and increases size
	//-----------------------------------------------------------------------------
	public void add(Object x){
		if (isFull()){
			Object temp = addHelper();
			objectList = (Object[]) temp;
		}
		int lastIndex = lastObjIndex();
		objectList[lastIndex] = x;
		size++;
	}
	//tests to see if there is space in array (to add an element)
	public boolean isFull(){
		return size >= capacity;
	}
	//-----------------------------------------------------------------------------
	//Adds given Object x into Arraylist at given int index
	//Precondition: method is given an index and x
	//Postcondition: tests if Arraylist is full or not and adds length depending
	//then for loop shifts items to the right of the index to the right and then
	//x is inserted at the index
	//-----------------------------------------------------------------------------
	public void add(int index, Object x){
		if(isFull()){
			addHelper();
		}
		for(int i = size; i > index; i--){
			objectList[i] = objectList[i-1];
		}
		objectList[index] = x ;
		size++;
	}

	//-----------------------------------------------------------------------------
	//Returns object at given index
	//Precondition: method is given int index
	//Postcondition: if index is out of bounds, null is returned, otherwise the object
	//at the index is returned
	//-----------------------------------------------------------------------------
	public Object get(int index){
		if(index >= size)
			return null;

		return objectList[index];
	}

	//retrieves size of the Arraylist
	public int size(){
		return this.size;
	}
	//returns true if Arraylist is empty and false otherwise
	public boolean isEmpty(){
		return size == 0;
	}

	//-----------------------------------------------------------------------------
	//Test if an Object ob is in the Arraylist
	//Precondition: Method is given Object ob
	//Postcondition: the method loops through the objectList array testing each item for
	//equality and if it finds equality it returns true, false otherwise
	//-----------------------------------------------------------------------------
	public boolean isIn(Object ob){
		for(int i = 0; i < size; i ++){
			if(objectList[i].equals(ob)){
				return true;
			}
		}
		return false;
	}

	//-----------------------------------------------------------------------------
	//Returns index of Object n
	//Precondition: Method is given Object n
	//Postcondition: the method again loops through the objectList array testing each 
	//item for equality and if it finds equality it returns the index of the equal object
	//and if it doesn't, it returns -1
	//-----------------------------------------------------------------------------
	public int find(Object n){
		for(int i =0; i < size; i++){
			if(objectList[i].equals(n)){
				return i;
			}
		}
		return -1;
	}

	//-----------------------------------------------------------------------------
	//Removes a given Object n
	//Precondition: method is given Object n
	//Postcondition: New Array is created.  If statement tests if n is in array using
	//isIn method.  Then finds locations using find() method.  Then copies everything 
	//from objectList to new Array (newList) until the location of the given object
	//then adds everything beyond that, in the next loop, to the rest of the array, leaving
	//out n. The third for loop empties objectList and then, in the last for loop, everything
	//from newList is copied back to objectList.  Of course size is decreased
	//-----------------------------------------------------------------------------
	public void remove(Object n){
		Object[] newList = new Object[size - 1]; 

		if(isIn(n)){
			int location = find(n);
			for(int i = 0; i < location; i++){
				newList[i] = objectList[i];
			}
			for(int j = location + 1; j < size; j++){
				newList[j-1] = objectList[j];
			}

			for(int l = 0; l < objectList.length; l++){
				objectList[l] = "";
			}

			for(int k = 0; k < newList.length; k++){
				objectList[k] = newList[k];
			}
			size--;
		}
	}
}
