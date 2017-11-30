public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String aut, String name, String isbn, String callNum){
	super(aut, name, isbn, callNum);
	returned();
    }

    public String getCurrentHolder(){return currentHolder;}
    public String getDueDate(){return dueDate;}

    public void checkout(String patron, String due){
	currentHolder = patron;
	dueDate = due;
    }

    public void returned(){
	currentHolder = null;
	dueDate = null;
    }

    public String circulationStatus(){
	if (currentHolder != null){
	    return currentHolder + " " + dueDate;
	}
	return "book available on shelves";
    }

    public String toString(){
	if (currentHolder != null){
	    return super.toString() + " " + currentHolder + " " + dueDate;
	}
	return super.toString();
    }
}
