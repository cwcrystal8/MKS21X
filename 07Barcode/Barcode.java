import java.util.*;
import java.io.*;

public class Barcode implements Comparable<Barcode>{
    private String zip;
    
    public Barcode(String zip){
	for (int x = 0; x < zip.length(); x++){
	    if ("0123456789".indexOf(zip.substring(x,x+1)) == -1){
		throw new IllegalArgumentException();
	    }
	}
	if (zip.length() != 5){
	    throw new IllegalArgumentException();
	}
	this.zip = zip;
    }

    public String getZip(){
	return zip;
    }

    public String getCode(){
	String ans = "|";
	int total = 0;
	for (int x = 0; x < zip.length(); x++){
	    total += Integer.parseInt(zip.substring(x,x+1));
	    ans += findBarChar(Integer.parseInt(zip.substring(x,x+1)));
	}
	ans += findBarChar(total % 10);
	return ans + "|";
    }

    public String toString(){
	return getCode() + " (" + zip + ")";
    }

    public int compareTo(Barcode b){
	return zipToInt() - b.zipToInt();
    }

    public boolean equals(Barcode b){
	return zipToInt() == b.zipToInt();
    }

    public static String toCode(String zip){
	Barcode b = new Barcode(zip);
	return b.getCode();
    }

    public static String toZip(String code){
	if (code.length() != 32 || code.charAt(0) != '|' || code.charAt(code.length() - 1) != '|'){
	    throw new IllegalArgumentException();
	}
	code = code.substring(1, 31);
	String ans = "";
	int total = 0;
	String[] tem = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:", "|:|::"};
	ArrayList<String> a = new ArrayList<String>();
	for (int x = 0; x < 10; x++){
	    a.add(tem[x]);
	}
	for (int x = 0; x < 25; x++){
	    int  n = a.indexOf(code.substring(x, x + 5));
	    if (n == -1){
		throw new IllegalArgumentException();
	    }
	    total += n;
	    ans += n;
	    x += 4;
	}
	if (!(code.substring(25,30).equals(findBarChar(total % 10)))){
	    throw new IllegalArgumentException();
	}
	return ans;
    }
    
    private int zipToInt(){
	return Integer.parseInt(zip);
    }

    private static String findBarChar(int x){
	String[] temp = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:", "|:|::"};
	return temp[x];
    }

    
    public static void main(String[] args){
	Barcode a = new Barcode("11245");
	Barcode b = new Barcode("38760");
	Barcode c = new Barcode("11245");
	Barcode d = new Barcode("00294");

	System.out.println(a.getZip());//11245
	System.out.println(d.getZip());//00294
	System.out.println(a.getCode());// | :::|| :::|| ::|:| :|::| :|:|: ::||: |

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

	//	Barcode e = new Barcode("asdfd"); //Contains non-barcode characters, should throw IllegalArgumentException
	//	Barcode f = new Barcode("1234"); //Invalid length, should throw IllegalArgumentException

	//      System.out.println(Barcode.toCode("00294")); // |||:::||:::::|:||:|:::|::|:|:|:|
	//	System.out.println(Barcode.toCode("asdfd")); //Contains non-barcode characters, should throw IllegalArgumentException
	//	System.out.println(Barcode.toCode("1234")); //Invalid length, should throw IllegalArgumentException

	//	System.out.println(Barcode.toZip("|||:::||:::::|:||:|:::|::|:|:|:|")); //Should return 00294
	//	System.out.println(Barcode.toZip("|:::||:::||::|:|:|::|:|:|:::||:")); //Invalid length, should throw IllegalArgumentException
	//	System.out.println(Barcode.toZip("|:::||:::||::|:|:|::|:|:|:::||||")); //Incorrect checksum, should throw IllegalArgumentException
	//	System.out.println(Barcode.toZip("|a::||:::||::|:|:|::|:|:|:::||:|")); //Contains non-barcode characters, should throw IllegalArgumentException
	//	System.out.println(Barcode.toZip("::::||:::||::|:|:|::|:|:|:::||:|")); //First character is not '|', should throw IllegalArgumentException
	//	System.out.println(Barcode.toZip("|:::||:::||::|:|:|::|:|:|:::||::")); //Last character is not '|', should throw IllegalArgumentException
	//	System.out.println(Barcode.toZip("|::::::::||::|:|:|::|:|:|:::||:|")); //Invalid character sequence, should throw IllegalArgumentException
    }
    
}
