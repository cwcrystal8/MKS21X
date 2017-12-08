import java.util.Arrays;
import java.util.*;

public class Sorts{

    /**EDIT THIS METHOD TO MATCH YOUR NAME 
     */
    public static String name(){
	return "01.Wang.Crystal"; 
    }

    /**Selection sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void selectionSort(int[] data){
	for (int x = 0; x < data.length; x++){
	    int min = data[x];
	    int ind = x;
	    for (int y = x; y < data.length; y++){
		if (data[y] < min){
		    min = data[y];
		    ind = y;
		}
	    }
	    data[ind] = data[x];
	    data[x] = min;
	}
    }

    public static void insertionSort(int[] data){
	ArrayList<Integer> ans = new ArrayList<Integer>(data.length);
	for(int x : data){
	    int n = findPlace(x,ans);
	    if (n == -1){
		ans.add(x);
	    }else{
		ans.add(n,x);
	    }
	}
	for(int x = 0; x < ans.size(); x++){
	    data[x] = ans.get(x);
	}
    }

    private static int findPlace(int n, ArrayList<Integer> ans){
	if (ans.size() == 0){
	    return 0;
	}
	for (int x = 0; x < ans.size(); x++){
	    if (ans.get(x) > n){
		return x;
	    }
	}
	return -1;
    }

    public static void main(String[] args){
	int[] data1 = {8,6,3,4,5,9,1,0,2,2,5,3,9,8,7},
	    data2 = {0,1,2,3,4,5},
	    data3 = {},
	    data4 = {9,8,7,6,5,4,3,2,1,0},
	    data5 = {-1,-2,-3,-2,-5,6,8,5};
	//	Sorts.selectionSort(data1);
	//      Sorts.selectionSort(data2);
	//	Sorts.selectionSort(data3);
	//	Sorts.selectionSort(data4);
	//	Sorts.selectionSort(data5);

	Sorts.insertionSort(data1);
	Sorts.insertionSort(data2);
	Sorts.insertionSort(data3);
	Sorts.insertionSort(data4);
	Sorts.insertionSort(data5);
	
	System.out.println(Arrays.toString(data1)); // [0,1,2,2,3,3,4,5,5,6,7,8,8,9,9]
	/*(	System.out.println(Arrays.toString(data2)); // [0,1,2,3,4,5]
	System.out.println(Arrays.toString(data3)); // []
	System.out.println(Arrays.toString(data4)); // [0,1,2,3,4,5,6,7,8,9]
	System.out.println(Arrays.toString(data5)); // [-5,-3,-2,-2,-1,5,6,8]
		*/
	}

}
