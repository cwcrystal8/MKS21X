public class Barcode implements Comparable<Barcode>{
    private String zipcode;
    
    public Barcode(String zip){
	zipcode = zip;
    }

    public String getZip(){
	return zipcode;
    }
    public String getCode(){
	String ans = "|";
	for (int x = 0; x < zipcode.length(); x++){
	    ans += findBarChar(Integer.parseInt(zipcode.substring(x,x+1)));
	}
	return ans + "|";
    }
    public String toString(){
	return getCode() + "\n" + zipcode;
    }
    public int compareTo(Barcode b){
	return zipToInt() - b.zipToInt();
    }
    public boolean equals(Barcode b){
	return zipToInt() == b.zipToInt();
    }

    private int zipToInt(){
	return Integer.parseInt(zipcode);
    }
    private String findBarChar(int x){
	String[] temp = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:", "|:|::"};
	return temp[x];
    }
    private boolean checksum(){
	return true; //FILLER, WRITE METHOD LATER
    }

    public static void main(String[] args){
	Barcode a = new Barcode("11245");
	Barcode b = new Barcode("38760");
	Barcode c = new Barcode("11245");
	Barcode d = new Barcode("00294");

	System.out.println(a.getZip());//11245
	System.out.println(d.getZip());//00234
	System.out.println(a.getCode());// |:::||:::||::|:|:|::|:|:|:::||:|
	System.out.println(a.toString());// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
	System.out.println(b);// |::||:|::|:|:::|:||::||::::|::|| (38760)
	System.out.println(c);// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
	System.out.println(d);// |||:::||:::::|:||:|:::|::|:|:|:| (00294)
	System.out.println(a.compareTo(b));// negative
	System.out.println(a.compareTo(c));// 0
	System.out.println(a.compareTo(d));// positive
	System.out.println(a.equals(b));// false
	System.out.println(a.equals(c));// true
	System.out.println(a.equals(d));// false
    }
    
}
