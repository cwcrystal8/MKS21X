public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String aut, String name, String isbn, String callNum){
	super(aut,name,isbn);
	callNumber = callNum;
    }

    public String getCallNumber(){return callNumber;}

    public abstract void checkout(String patron, String due);
    public abstract void returned();
    public abstract String circulationStatus();

    public int compareTo(LibraryBook other){
	return callNumber.compareTo(other.getCallNumber());
    }

    public String toString(){
	return super.toString() + circulationStatus() + " " + callNumber;
    }
}
