import java.util.Arrays;
import java.util.*;

public class Sorts{

    /**EDIT THIS METHOD TO MATCH YOUR NAME 
     */
    public static String name(){
	return "10,Wang,Crystal"; 
    }


    public static boolean isSorted(int[] data){
	for(int x = 0; x < data.length - 1; x++){
	    if (data[x] > data[x+1]){
		return false;
	    }
	}
	return true;
    }

    public static boolean equals(int[] a, int[] b){
	for(int x = 0; x < a.length; x++){
	    if (a[x] != b[x]){
		return false;
	    }
	}
	return a.length == b.length;
    }

    
    public static int[] copyOf(int[] data){
	int[] ans = new int[data.length];
	for (int x = 0; x < data.length; x++){
	    ans[x] = data[x];
	}
	return ans;
    }



    public static void selectionSort(int[] data){
	if (!(isSorted(data))){
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
    }

    public static void insertionSort(int[] data){
	if (!(isSorted(data))){
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
    }

    public static void bubbleSort(int[] data){
	if (!(isSorted(data))){
	    boolean needsToIterAgain = true;
	    int len = data.length;
	    while(needsToIterAgain){
		needsToIterAgain = false;
		for (int x = 0; x < len - 1; x++){
		    if (data[x] > data[x+1]){
			swap(data,x,x+1);
			needsToIterAgain = true;
		    }
		}
		len--;
	    }
	}
    }

    private static void swap(int[] data, int x, int y){
	int temp = data[x];
	data[x] = data[y];
	data[y] = temp;
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
	    data5 = {-1,-2,-3,-2,-5,6,8,5},
	    data6 = new int[20];
	for (int x = 0; x < 20; x++){
	    data6[x] = (int)(Math.random() * 1000);
	}

	int[] data6Copy = copyOf(data6);
	
	/*System.out.println(Arrays.toString(data6));
	int[] data6Copy = copyOf(data6);

	Arrays.sort(data6);
	System.out.println(Arrays.toString(data6));

	selectionSort(data6Copy);
	System.out.println(Arrays.toString(data6Copy));

	System.out.println(equals(data6, data6Copy));*/
	
	
	int choice = -1;
	try{
	    choice = Integer.parseInt(args[0]);
	}catch(Exception e){
	    System.exit(1);
	}

	if (choice == 0){
	Sorts.selectionSort(data1);
	Sorts.selectionSort(data2);
	Sorts.selectionSort(data3);
	Sorts.selectionSort(data4);
	Sorts.selectionSort(data5);
	Sorts.selectionSort(data6);
	System.out.println("Selection Sort");
	}
	else if(choice == 1){
	Sorts.insertionSort(data1);
	Sorts.insertionSort(data2);
	Sorts.insertionSort(data3);
	Sorts.insertionSort(data4);
	Sorts.insertionSort(data5);
	Sorts.insertionSort(data6);
	System.out.println("Insertion Sort");
	}
	else if(choice == 2){
	Sorts.bubbleSort(data1);
	Sorts.bubbleSort(data2);
	Sorts.bubbleSort(data3);
	Sorts.bubbleSort(data4);
	Sorts.bubbleSort(data5);
	Sorts.bubbleSort(data6);
	System.out.println("Bubble Sort");
	}
	System.out.println(Arrays.toString(data1));
	System.out.println("[0, 1, 2, 2, 3, 3, 4, 5, 5, 6, 7, 8, 8, 9, 9]");
	System.out.println(Arrays.toString(data2));
	System.out.println("[0, 1, 2, 3, 4, 5]");
	System.out.println(Arrays.toString(data3));
	System.out.println("[]");
	System.out.println(Arrays.toString(data4));
	System.out.println("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
	System.out.println(Arrays.toString(data5));
	System.out.println("[-5, -3, -2, -2, -1, 5, 6, 8]");
	System.out.println(Arrays.toString(data6));

	Arrays.sort(data6Copy);
	System.out.println(Arrays.toString(data6Copy));
		



	/*	long start = System.currentTimeMillis();
	insertionSort(r);
	long end = System.currentTimeMillis();

	System.out.println(end - start);*/
	}

}
