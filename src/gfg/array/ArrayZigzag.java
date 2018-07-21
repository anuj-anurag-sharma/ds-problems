package gfg.array;


import java.util.Scanner;

public class ArrayZigzag {
	public static void main (String[] args) {
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
		    int len = sc.nextInt();
		    int[] input = new int[len];
		    for(int i = 0; i < len ; i++){
		        input[i] = sc.nextInt();
		    }
		    arrangeInZigzag(input);
		    print(input);
		    t--;
		}
	}
	
	static void arrangeInZigzag(int[] input){
	    int len = input.length;
	    
	    for(int i = 1; i<len;i++){
	        if(i%2 == 1){
	            if(input[i] < input[i-1]){
	                int tmp = input[i];
	                input[i] = input[i-1];
	                input[i-1] = tmp;
	            }
	        }
	        else {
	            if(input[i] > input[i-1]){
	                int tmp = input[i];
	                input[i] = input[i-1];
	                input[i-1] = tmp;
	            }
	        }
	    }
	}
	
	static void print(int[] input){
	    for(int i = 0; i< input.length ; i++){
	        System.out.print(input[i]+" ");
	    }
	    System.out.println();
	}
}