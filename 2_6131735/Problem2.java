/**************************************************************
 Purpose/Description: This program finds a leader element in an array
                        of numbers and returns the index, using only
                        one stack. It does this by iterating through
                        the array once, performing checks and
                        manipulating the stack along the way.
 Author’s Panther ID: 6131735
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 **************************************************************/

package assignment2;
import java.util.*;
public class Problem2 {
    static int leader(int[] A) {
        LinkedList<Integer> stack = new LinkedList<>();
        int leader = 0;

        for (int i=0; i<A.length; i++) {
            int current = A[i];
            if (stack.isEmpty()) {
                stack.push(current);
                leader = i;
            } else {
                if (stack.getLast() == current) {
                    stack.push(current);
                } else {
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty()) {
            return -1;
        } else {
            return leader;
        }
    }

    public static void main(String[] args) {
        int i = leader(new int[]{1,1,1,2,2,2,2,2,3,4,2});
        System.out.println(i);
    }
}
