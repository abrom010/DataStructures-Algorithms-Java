/**************************************************************
 Purpose/Description: This program moves all of the negative ones of an array to the end.
                        It has two pointers, one starting at the beginning, one at the end,
                        and checks each item in the array once.
 Author’s Panther ID: 6131735
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 **************************************************************/

package assignment4;

import java.util.Arrays;

public class Problem1 {
    static void moveAllNegativeOne(int[] array) {
        int N = array.length;
        int j = N-1;
        for(int i=0; i<N-1; i++) {
            if(array[i]==-1) {
                while(array[j]==-1) {
                    if(!(j>0)||j==i) return;
                    j--;
                }
                array[i]=array[j];
                array[j]=-1;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{6, -1, 8, 2, 3, -1, 4, -1, 1};
        moveAllNegativeOne(a);
        System.out.println(Arrays.toString(a));
    }
}
