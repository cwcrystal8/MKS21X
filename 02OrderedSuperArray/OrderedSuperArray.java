public class OrderedSuperArray extends SuperArray{

    public OrderedSuperArray(){
	super();
    }

    public OrderedSuperArray(int startingCapacity){
	super(startingCapacity);
    }

    public OrderedSuperArray(String[] ary){
	super(ary.length);
	for (int x = 0; x < ary.length; x++){
	    add(ary[x]);
	}
    }


    public void add(int index, String value){
	add(value);
    }

    public boolean add(String value){
	int x = findIndexBinary(value);
	if (x >= size()){
	    super.add(value);
	}
	else {
	    super.add(x, value);
	}
	return true;
    }
    private int findIndex(String val){
	for (int x = 0; x < size(); x++){
	    if (get(x).compareTo(val) > 0 ){
		return x;
	    }
	}
	return size();
    }

    private int findIndexBinary(String val){
	int start = 0, end = size();
	while (start != end){
	    if (get((start + end)/2).compareTo(val) > 0){
		end = (start + end) / 2;
	    }
	    else {
		start = (start + end) / 2 + 1;
	    }
	}
	return start;
    }

    public String set(int index, String element){
	throw new UnsupportedOperationException();
    }

    public int indexOfBinary(String element){
       	int start = 0, end = size();
	while (start != end){
	    if (get((start + end)/2).compareTo(element) > 0){
		end = (start + end) / 2;
	    }
	    else if (get((start + end)/2).equals(element)){
		if (start == 0 || !(get((start + end) / 2 - 1).equals(element))){
		    return (start + end) / 2;
		}
		end = (start + end) / 2;
		start = (start + end) / 2 - 1; 
	    }
	    else {
		start = (start + end) / 2 + 1;
	    }
	}
	if (get(start) != element){
	    return -1;
	}
	return start;
    }

    public int lastIndexOfBinary(String element){
	int start = indexOfBinary(element), end = size();
	while (start != end){
	    if (get((start + end)/2).compareTo(element) > 0){
		end = (start + end) / 2;
	    }
	    else if (get((start + end)/2).equals(element)){
		if (start == size() - 1 || !(get((start + end) / 2 + 1).equals(element))){
		    return (start + end) / 2;
		}
		end = (start + end) / 2;
		start = (start + end) / 2 - 1; 
	    }
	    else {
		start = (start + end) / 2 + 1;
	    }
	}
	if (get(start) != element){
	    return -1;
	}
	return start;
    }


    
    public static  void main(String[] args){
	OrderedSuperArray a = new OrderedSuperArray();
	a.add("elephant");
	a.add("zebra");
	a.add("alphabet");
	a.add("b");
	a.add("ba");
	a.add("mArY dId yOu KnOw");
	a.add("mary did you know");
	a.add("kielbasa");
	a.add("harry potter");
	a.add("pumpernickel");
	a.add("holy ghost");
	a.add("rumpelstilskin");

	String[] arr = {"elephant", "zebra", "alphabet", "b", "ba", "mArY dId yOu KnOw", "mary did you know", "kielbasa", "harry potter", "pumpernickel", "holy ghost", "rumpelstilskin"};
      	OrderedSuperArray b = new OrderedSuperArray(arr);

	System.out.println("expected: [alphabet, b, ba, elephant, harry potter, holy ghost, kielbasa, mArY dId yOu KnOw, mary did you know, pumpernickel, rumpelstilskin, zebra, null, null, null, null, null, null, null, null, null, null, null]");
	System.out.println("actual a: " + a);
	System.out.println("actual b: " + b);

	for (int x = 0; x < a.size(); x++){
	    System.out.println(a.lastIndexOf(a.get(x)) == a.lastIndexOfBinary(a.get(x)));
	}

	for (int x = 0; x < a.size(); x++){
	    System.out.println(a.findIndex(a.get(x)) == a.findIndexBinary(a.get(x)));
	}

       
	for (int x = 0; x < a.size(); x++){
	    System.out.println(a.indexOf(a.get(x)) == a.indexOfBinary(a.get(x)));
	}
    }

    
}
