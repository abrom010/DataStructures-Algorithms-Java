/**************************************************************
 Purpose/Description: This program finds the stability indices of a sequence of integers
                        in linear time. By keeping left and right sum variables, we can
                        avoid using a nested loop as we iterate through each integer in
                        the sequence.
 Author’s Panther ID: 6131735
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 **************************************************************/
import java.util.ArrayList;

public class Problem1 {

        static ArrayList<Integer> stabilityIndex(int arr[], int n) {
            ArrayList<Integer> out = new ArrayList<>();

            int rightSum = 0;
            for(int i=1; i<n; i++)
                rightSum += arr[i];

            int leftSum = 0;
            for(int i=0; i<n; i++) {
                if(i!=0) {
                    leftSum += arr[i-1];
                    rightSum -= arr[i];
                }

                if(leftSum == rightSum)
                    out.add(i);
            }

            return out;
        }

        public static void main(String[] args) {
            int[] array = {4, 6, -4, 6, 2, 0};
            int n = array.length;

            ArrayList<Integer> si = stabilityIndex(array,n);
            System.out.println(si);
    }
}
