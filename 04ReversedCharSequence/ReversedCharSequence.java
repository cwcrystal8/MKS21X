public class ReversedCharSequence implements CharSequence{ 
    private String seq;
    
    public ReversedCharSequence(String s){
	seq = "";
	for (int x = s.length() - 1; x >= 0; x--){
	    seq += s.substring(x, x + 1);
	}
    }

    public char charAt(int index){
	return seq.charAt(index);
    }

    public int length(){
	return seq.length();
    }

    public CharSequence subSequence(int start, int end){
	String s = seq.substring(start, end);
	ReversedCharSequence temp = new ReversedCharSequence(s);
	ReversedCharSequence ans = new ReversedCharSequence(temp.toString());
	return ans;
    }
    
    public String toString(){
	return seq;
    }

    public static void main(String[] args){
	ReversedCharSequence a = new ReversedCharSequence("ABCDEF");
	for (int x = 0; x < a.length(); x++){
	    System.out.println(a.charAt(x));
	}
			       
	System.out.println(a.subSequence(0,4));
	System.out.println(a);
	System.out.println(a.subSequence(0,6));
	
    }
}
