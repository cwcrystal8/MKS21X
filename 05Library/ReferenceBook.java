public class ReferenceBook extends LibraryBook{
    private String collection;

    public ReferenceBook(String aut, String name, String isbn, String callNum, String collec){
	super(aut, name, isbn, callNum);
	collection = collec;
    }

    public String getCollection(){return collection;}

    public void checkout(String patron, String due){
	System.out.println("Cannot check out a reference book");
    }
    public void returned(){
	System.out.println("Reference book could not have been checked out -- return impossible");
    }
    public String circulationStatus(){
	return "non-circulating reference book";
    }
    public String toString(){
	return super.toString() + " " + collection;
    }

    /*    public static void main(String[] args){
	ReferenceBook a = new ReferenceBook("Lucy Wang","XD","1234", "0987", "Encyclopedia");
	System.out.println(a.circulationStatus());
	a.returned();
	a.checkout("Girl", "5.00");
	
	System.out.println(a.getAuthor());
	System.out.println(a.getTitle());
	System.out.println(a.getISBN());
	System.out.println(a.getCallNumber());
	System.out.println(a.getCollection());

	System.out.println(a);
	}*/
}
