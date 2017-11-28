public class Book{
    private String author, title, ISBN;

    public Book(){}

    public Book(String aut, String name, String isbn){
	author = aut;
	title = name;
	ISBN = isbn;
    }

    public String getAuthor(){return author;}
    public String getTitle(){return title;}
    public String getISBN(){return ISBN;}

    public String toString(){
	return title + " " + author + " " + ISBN;
    }

    /*    public static void main(String[] args){
	Book a = new Book("Lois Schmul", "XDXD", "1234567890");
	System.out.println("Title: " + a.getTitle());
	System.out.println("Author: " + a.getAuthor());
	System.out.println("ISBN: " + a.getISBN());

	System.out.println(a);
	} */
}
