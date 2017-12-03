import java.util.*;
import java.io.*;

public class SuperArrayIterator implements Iterator<String>{
    private int index;
    private SuperArray arr;
	
    public SuperArrayIterator(SuperArray a){
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
	try{
	    index++;
	    return arr.remove(0);
	}catch(NoSuchElementException e){
	    throw e;
	}
    }
    
    public void remove(){
	throw new UnsupportedOperationException();
    }
 }
