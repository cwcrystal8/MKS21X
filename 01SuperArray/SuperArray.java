import java.util.*;
import java.io.*;

public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;

    public SuperArray(){
	data = new String[10];
	size = 0;
    }

    public SuperArray(int startingCapacity){
	data = new String[startingCapacity];
	size = 0;
    }
    
    public void clear(){
	data = new String[data.length];
	size = 0;
    }

    public int size(){
	return size;
    }

    public boolean isEmpty(){
	return size == 0;
    }


    private void resize(){
	String[] ans = new String[size * 2 + 1];
	for (int x = 0; x < size; x++){
	    ans[x] = data[x];
	}
	data = ans;
    }
    
    public boolean add(String element){
	if (size == data.length){
	    resize();
	}
	data[size] = element;
	size++;
	return true;
    }

    public String get(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	else {
	    return data[index];
	}
    }

    public String set(int index, String element){
	String ans;
       	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	else {
	    ans = data[index];
	    data[index] = element;
	    if (index >= size){
		size++;
	    }
	    return ans;
	    	}
    }

    public String toString(){
	String ans = "[";
	for (int x = 0; x < data.length; x++){
	    ans += data[x] + ", ";
	}
	return ans.substring(0, ans.length() - 2) + "]";
    }

    public boolean contains(String element){
	for (int x = 0; x < size; x++){
	    if (data[x].equals(element)){
		return true;
	    }
	}
	return false;
    }

    public void add(int index, String element){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	if (index == size){
	    add(element);
	}
	else if (index < size){
	    resize();
	    size++;
	    for (int x = size - 1; x > index; x--){
		data[x] = data[x-1];
	    }
	    data[index] = element;
	}
    }




    public int indexOf(String element){
	for (int x = 0; x < size; x++){
	    if (data[x].equals(element)){
		return x;
	    }
	}
	return -1;
    }
    

    public int lastIndexOf(String element){
	for (int x = size - 1; x >= 0; x--){
	    if (data[x].equals(element)){
		return x;
	    }
	}
	return -1;
    }

    public String remove(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	String ans = data[index];
	String[] a = new String[size - 1];
	for (int x = 0; x < index; x++){
	    a[x] = data[x];
	}
	size--;
	for (int x = index; x < size; x++){
	    a[x] = data[x+1];
	}
	data = a;
	return ans;
    }

    public boolean remove(String element){
	if (contains(element)){
	    remove(indexOf(element));
	    return true;
	}
	return false;
    }


    public Iterator<String> iterator(){
	return new ArrayIter(this);
    }

    private class ArrayIter implements Iterator<String>{
	private int index;
	private SuperArray arr;
	
	public ArrayIter(SuperArray a){
	    index = 0;
	    arr = new SuperArray(a.size());
	    for (int x = 0; x < a.size(); x++){
		arr.add(a.get(x));
	    }
	}

	public boolean hasNext(){
	    return arr.size() != 0;
	}

	public String next(){
	    index++;
	    return arr.remove(0);
	}
    }




    
    public static void main(String[] args){
	SuperArray a = new SuperArray();
	a.add("a");
	a.add("ab");
	a.add("ba");
	a.add("bca");
	a.add("da");
	a.add("ea");
	a.add("fa");
	
	System.out.println("Before iteration: " + a);
	System.out.println("Iterating through a: ");
	for (String x: a){
	    System.out.println(x);
	}
	System.out.println("After iteration: " + a);
    }
}
