/**************************************************************
        Purpose/Description: This is an implementation of radix sort, with an added feature
                                of aborting if any number contains an odd digit. For each digit,
                                10 buckets are filled then emptied into the array, corresponding
                                with the sorting method used in radix sort (starts at 1's place,
                                fills buckets with the number according to the current digit).
        Author’s Panther ID: 6131735
        Certification:
        I hereby certify that this work is my own and none of it is the work of
        any other person.
        **************************************************************/

package assignment4;
import java.util.*;

/*
    b) The running time complexity of this radixSort method is at least O(kn). The program will always
        iterate through each number in the array (n), k times (k being the amount of digits in
        the max number).
 */

public class Problem2 {
    static void radixSort(int[] arr) {
        int max = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]>max) max=arr[i];
        }

        int maxLength = 1;
        while(max/(Math.pow(10,maxLength))>1) {
            maxLength++;
        } maxLength++;

        List<List<Integer>> buckets = new ArrayList<>(10);
        for(int i=0; i<10; i++) {
            buckets.add(new ArrayList<>());
        }

        //for each digit
        for(int j=1; j<=maxLength; j++) {
            //fill buckets
            for(int i=0; i<arr.length; i++) {
                int digit;
                int number = arr[i];
                if(number/10<=1){
                    if(j==1) {
                        digit = number%10;
                    } else {
                        digit = 0;
                    }
                } else {
                    int count = 1;
                    while(number/10>=1 && count<j) {
                        number/=10;
                        count++;
                    }
                    if(!(count==j)) {
                        digit = 0;
                    }
                    else digit = number%10;
                }
                if(digit%2!=0) {
                    System.out.println("*** Abort *** the input has at least one key with odd digits");
                    return;
                }
                List<Integer> bucket = buckets.get(digit);
                bucket.add(arr[i]);
            }

            //empty buckets
            int count = 0;
            for(List<Integer> bucket: buckets) {
                while(!bucket.isEmpty()) {
                    int number = bucket.remove(0);
                    arr[count] = number;
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int[] array = {24, 2, 4, 466, 48, 66, 8, 44};
        radixSort(array);
    }
}
