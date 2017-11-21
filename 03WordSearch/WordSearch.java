import java.util.*;
import java.io.*;

public class WordSearch{
    private char[][]data;
    private Random randgen;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;
    private int seedn;
    private char[][] solution;

    /**Initialize the grid to the size specified 
     *fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    public WordSearch(int rows,int cols,String filename){
	this(rows, cols, filename, new Random().nextInt());
    }


    public WordSearch(int rows,int cols,String filename, int seed){
 	data = new char[rows][cols];
	randgen = new Random((long)seed);
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
	seedn = seed;
	solution = new char[rows][cols];
	clear();
	try{
	    Scanner in = new Scanner(new File(filename));
	    while(in.hasNext()){
		wordsToAdd.add(in.next());
	    }
	} catch (FileNotFoundException e){
    	    System.out.println("File not found: " + filename);
	}
	addAllWords(filename);
	for (int x = 0; x <data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		solution[x][y] = data[x][y];
	    }
	}

    }

    public int getSeed(){
	return seedn;
    }

    public String getSolution(){
	String ans = "";
	for (int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		ans += solution[x][y] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }


    
    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
	for (int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		data[x][y] = '_';
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
	String ans = "";
	for (int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		ans += data[x][y] + " ";
	    }
	    ans += "\n";
	}
	ans += "Words To Find: " + (wordsAdded.toString()).substring(1,(wordsAdded.toString()).length() - 1);
	ans += "\nSeed: " + getSeed();
	return ans;
    }


    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned 
     * and the board is NOT modified.
     */
    public boolean addWordHorizontal(String word,int row, int col){
	try{
	    for (int x = 0; x < word.length(); x++){
		if ((data[row][col + x] != word.charAt(x)) && (data[row][col + x] != '_')){
		    return false;
		}
	    }
	    for (int x = 0; x < word.length(); x++){
		data[row][col + x] = word.charAt(x);
	    }
	    return true;
	} catch (IndexOutOfBoundsException a){
	return false;
	}
    }

   /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.
     */
    public boolean addWordVertical(String word,int row, int col){
	try{
	    for (int x = 0; x < word.length(); x++){
		if ((data[row + x][col] != word.charAt(x)) && (data[row + x][col] != '_')){
		    return false;
		}
	    }
	    for (int x = 0; x < word.length(); x++){
		data[row + x][col] = word.charAt(x);
	    }
	    return true;
	} catch(IndexOutOfBoundsException a){
	return false;
	}
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top left to bottom right, must fit on the WordGrid,
     *and must have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordDiagonal(String word,int row, int col){
	try{
	    for (int x = 0; x < word.length(); x++){
		if ((data[row + x][col + x] != word.charAt(x)) && (data[row + x][col + x] != '_')){
		    return false;
		}
	    }
	    for (int x = 0; x < word.length(); x++){
		data[row + x][col + x] = word.charAt(x);
	    }
	    return true;
	} catch(IndexOutOfBoundsException a){
	    return false;
	}
    }

    private boolean addWord(int row, int col, String word,  int xcor, int ycor){
	word = word.toUpperCase();
	if (xcor == 0 && ycor == 0){
	    return false;
	}
        try{
	    for (int x = 0; x < word.length(); x++){
		if ((data[row - x * ycor][col + x * xcor] != word.charAt(x)) && (data[row - x * ycor][col + x * xcor] != '_')){
		    return false;
		}
	    }
	    for (int x = 0; x < word.length(); x++){
		data[row - x * ycor][col + x * xcor] = word.charAt(x);
	    }
	    wordsAdded.add(word);
	    wordsToAdd.remove(word);
	    return true;
	} catch(ArrayIndexOutOfBoundsException a){
	    return false;
	
	}
    }

    public boolean randomize(){
	for (int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		if (data[x][y] == '_'){
		    int num = randgen.nextInt(26) + 65;
		    data[x][y] = (char)(num);
		}
	    }
	}
	return true;
    }
   
        
    private boolean addAllWords(String filename){
	int len = wordsToAdd.size() * 900;
	for (int i = 0; i < len; i++){	
	    if (wordsToAdd.size() == 0){
		return true;
	    }
	    int x = randgen.nextInt(3) - 1,
		y = randgen.nextInt(3) - 1,
		num = randgen.nextInt(wordsToAdd.size()),
		row = randgen.nextInt(data.length),
		col = randgen.nextInt(data[0].length);
	    String wor = wordsToAdd.get(num);
	    addWord(row, col, wor, x, y);
	    wordsToAdd.remove(wor);
	}
	return true;
    }

    public static void main(String[] args){
	try {
	    int row = Integer.parseInt(args[0]),
		col = Integer.parseInt(args[1]);
	    if (row == 0 || col == 0 || !(args[2].substring(args[2].length() - 4).equals(".txt"))){
		throw new ArrayIndexOutOfBoundsException();
	    }
	    if (args.length > 3){
		int seed = Integer.parseInt(args[3]);
		WordSearch ws = new WordSearch(row, col, args[2], seed);
		if (args.length == 5 && args[4].equals("key")){
		    System.out.println(ws);
		}
		else{
		    ws.randomize();
		    System.out.println(ws);
		}
	    }
	    else{
		WordSearch ws = new WordSearch(row, col, args[2]);
		ws.randomize();
		System.out.println(ws);
	    }
	    /*	    System.out.println(ws.getSeed());
	    System.out.println(ws.getSolution());
	    System.out.println(); */
	} catch(ArrayIndexOutOfBoundsException e){
	    System.out.println("Please enter in the specifications for the word search in the following format: \n java WordSearch <row> <col> <filename> <seed> <answers>");
	    System.out.println("<row>: the number of rows");
	    System.out.println("<col>: the number of columns");
    	    System.out.println("<filename>: the name of the file containing the words");
	    System.out.println("<seed>: the seed (optional)");
	    System.out.println("<answer>: type key to receive the solution (optional)");
	}
    }

}
