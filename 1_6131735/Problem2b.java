/**************************************************************
 Purpose/Description: This program reveals if a 2d matrix of certain
                        properties specified in the problem statement
                        contains a given integer, in linear time.
                        The search begins at the top left of the matrix,
                        scrolling down one at a time until it finds the
                        row that would possibly contain the integer.
                        Then, it searches that row 1 by 1. Even though
                        a binary search could be applied here, this
                        is sufficient for linear time, as the worst case
                        would iterate 2N times in an N x N matrix.
 Author’s Panther ID: 6131735
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 **************************************************************/
public class Problem2b {

    static boolean search(int[][] array2d, int key) {
        int x = 1;
        int y = 0;

        if(array2d[0][0]<key) return false;

        while(y<array2d.length) {
            int number = array2d[y][0];
            if(number==key) return true;
            if(y==array2d.length-1) break;

            if(number>key)
                if(array2d[y+1][0]<key)
                    break;
            y++;
        }

        while(x<array2d.length) {
            int number = array2d[y][x];
            if(number==key) return true;
            if(x==array2d[0].length-1) break;

            if(number>key)
                if(array2d[0][x+1]<key)
                    break;
            x++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array2d = {{26,22,17,10},{19,16,12,7},{12,10,7,4},{5,4,2,1}};
        int key = 7;

        boolean contains = search(array2d,key);
        System.out.println(contains);
    }
}
