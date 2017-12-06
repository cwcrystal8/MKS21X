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

    /*    public static String ts(int[] data){
	if (data.length == 0){
	    return "[]";
	}
	String ans = "[";
	for (int x : data){
	    ans += x + ",";
	}
	return ans.substring(0,ans.length() - 1) + "]";
    }
    
    public static void main(String[] args){
	int[] data1 = {8,6,3,4,5,9,1,0,2,2,5,3,9,8,7},
	    data2 = {0,1,2,3,4,5},
	    data3 = {},
	    data4 = {9,8,7,6,5,4,3,2,1,0},
	    data5 = {-1,-2,-3,-2,-5,6,8,5};
	Sorts.selectionSort(data1);
	Sorts.selectionSort(data2);
	Sorts.selectionSort(data3);
	Sorts.selectionSort(data4);
	Sorts.selectionSort(data5);

	System.out.println(Sorts.ts(data1)); // [0,1,2,2,3,3,4,5,5,6,7,8,8,9,9]
	System.out.println(Sorts.ts(data2)); // [0,1,2,3,4,5]
	System.out.println(Sorts.ts(data3)); // []
	System.out.println(Sorts.ts(data4)); // [0,1,2,3,4,5,6,7,8,9]
	System.out.println(Sorts.ts(data5)); // [-5,-3,-2,-2,-1,5,6,8]
	}*/

}
