/**************************************************************
 Purpose/Description: This program reveals if there exists a given integer in
                        a given monotonically increasing then monotonically
                        decreasing sequence of integers, in sub-linear time.
                        First, we find the peak of the sequence using a
                        peak-finding algorithm that runs in sub-linear time.
                        Then, we run a binary search on the numbers to the
                        left and right sides of the peak (also sub-linear).
 Author’s Panther ID: 6131735
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 **************************************************************/
public class Problem2a {

    static boolean binarySearch(int[] array, int a, int b, int key, boolean increasing) {
        int length = b-a;
        if(length==0) return false;

        int middle = (length/2)+a;
        if(array[middle]==key) return true;

        if(increasing) {
            int min = array[a];
            int max = array[b-1];

            if(key<min || key>max) return false;

            if(array[middle]<key) return binarySearch(array,middle,b,key,true);
            else return binarySearch(array,a,middle,key,true);
        } else {
            int min = array[b-1];
            int max = array[a];

            if(key<min || key>max) return false;

            if(array[middle]>key) return binarySearch(array,middle,b,key,true);
            else return binarySearch(array,a,middle,key,true);
        }
    }

    static int findPeak(int[] array, int a, int b) {
        if(b-a<=5) {
            for(int i=a+1; i<b; i++) {
                int middle = array[i];
                int right = array[i+1];
                int left = array[i-1];
                if(middle>right && middle>left) return i;
            }
        }

        int index = ((b-a)/2)+a;
        int middle = array[index];
        int right = array[index+1];
        int left = array[index-1];

        if(middle>left && middle>right) return index;

        if(middle>left)
            return findPeak(array,index,b);
        else
            return findPeak(array,a,index);
    }

    public static void main(String[] args) {
        int[] array =  {1, 3, 4, 5, 7, 14, 11, 2, -4, -8};
        int key = 11;

        int peak = findPeak(array,0,array.length);
        boolean contains = binarySearch(array,0, peak, key, true)
                || binarySearch(array, peak, array.length, key, false);

        System.out.println(contains);
    }
}
