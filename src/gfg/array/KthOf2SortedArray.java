package gfg.array;

import java.util.Scanner;

public class KthOf2SortedArray {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t > 0)
        {
            int a = sc.nextInt();
            
            int b = sc.nextInt();
            
            int k = sc.nextInt();
            
            int[] arr1 = new int[a];
            int[] arr2 = new int[b];
            
            for (int i = 0; i < a; i++){
                arr1[i] = sc.nextInt();
            }
            
            for (int i = 0; i < b; i++){
                arr2[i] = sc.nextInt();
            }
            System.out.println(kthOf2SortedArrays(arr1,arr2,k));
            t--;
        }
	}
	
	static int kthOf2SortedArrays(int[] input1, int[] input2, int k) {
		int i = 0;
		int j = 0;
		int number = 0;
		
		while (k > 0) {
		    
		    if( i >= input1.length){
		        number = input2[j];
		        j++;
		    }
		    else if(j >= input2.length){
		        number = input1[i];
		        i++;
		    }
			else if (input1[i] > input2[j]) {
				number = input2[j];
				j++;

			} else if (input1[i] == input2[j]) {
				number = input1[i];
				k--;
				i++;
				j++;

			} else {
				number = input1[i];
				i++;
			}
			k--;
		}
		return number;
	}

}