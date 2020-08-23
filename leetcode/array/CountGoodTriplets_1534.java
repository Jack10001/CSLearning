package array;

public class CountGoodTriplets_1534 {
	  public int countGoodTriplets(int[] arr, int a, int b, int c) {
		  
	    }
	  }


//shave off a few milliseconds by creating your own Math.abs, or just
//play with the math a little to find a slightly quicker calculation.
class Solution_1534 {
 public int countGoodTriplets(int[] arr, int a, int b, int c) {

     int answer = 0;
     int cond_i, cond_j;

     for (int i = 0; i < arr.length - 2; i++) {
         cond_i = a + arr[i];
         
         // right when you get into the j-loop, you should check
         // the i vs j condition, otherwise you'll be
         // checking it k times.
         for (int j = i + 1; j < arr.length - 1; j++) {
             if (cond_i >= arr[j] && 
                 arr[j] >= arr[i] - a) { // |arr[i] - arr[j]| <= a
                 cond_j = b + arr[j];
                 
                 for (int k = j + 1; k < arr.length; k++) {
                     if (cond_j >= arr[k] && 
                         arr[k] >= arr[j] - b && // |arr[j] - arr[k]| <= b
                         -c <= arr[i] - arr[k] && 
                         arr[i] - arr[k] <= c) { // |arr[i] - arr[k]| <= c
                         answer++;
                             }
                 }
             }
         }
     }
     return answer;
 }
}