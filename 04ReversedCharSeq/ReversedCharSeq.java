public class ReversedCharSeq{
    private String seq;
    
    public ReversedCharSeq(String s){
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

    public String subSequence(int start, int end){
	return seq.substring(start, end);
    }
    
    public String toString(){
	return seq;
    }

    public static void main(String[] args){
	ReversedCharSeq a = new ReversedCharSeq("ABCDEF");
	for (int x = 0; x < a.length(); x++){
	    System.out.println(a.charAt(x));
	}
			       
	System.out.println(a.subSequence(0,4));
	System.out.println(a);
	System.out.println(a.subSequence(0,6));
	
    }
}
