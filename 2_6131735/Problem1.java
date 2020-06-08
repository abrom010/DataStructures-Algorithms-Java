/**************************************************************
 Purpose/Description: This program calculates the difference of two lists
                        using only the basic list operators (next(), hasNext(),
                        compareTo()) and one loop with several checks in it.
 Author’s Panther ID: 6131735
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 **************************************************************/

package assignment2;
import java.util.*;

public class Problem1 {
    public static <AnyType extends Comparable<? super AnyType>>
    void difference(List<AnyType> L1, List<AnyType> L2, List<AnyType> Difference) {
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();

        @SuppressWarnings("unchecked")
        AnyType itemL1 = (AnyType) Integer.valueOf(0);
        @SuppressWarnings("unchecked")
        AnyType itemL2 = (AnyType) Integer.valueOf(0);

        boolean rest = false;
        int comparison = 0;

        if (iterL1.hasNext() && iterL2.hasNext()) {
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
        } else {
            rest = true;
        }

        comparison = itemL1.compareTo(itemL2);

        while(true){
            if(rest) {
                if(iterL1.hasNext()) {
                    itemL1 = iterL1.next();
                    Difference.add(itemL1);
                } else break;
            }

            if(comparison==0) {
                if(iterL1.hasNext()) {
                    itemL1 = iterL1.next();
                    if(iterL2.hasNext()) {
                        itemL2 = iterL2.next();
                    } else {
                        Difference.add(itemL1);
                        rest = true;
                    }
                } else break;

            }

            if(comparison<0) {
                Difference.add(itemL1);
                if (iterL1.hasNext()) {
                    itemL1 = iterL1.next();
                } else break;
            }

            if(comparison>0) {
                if (iterL2.hasNext()) {
                    itemL2 = iterL2.next();
                } else {
                    rest = true;
                    continue;
                }
            }

            comparison = itemL1.compareTo(itemL2);

        }

    }

    public static void main(String[] args) {
        LinkedList<Integer> L1 = new LinkedList<>(Arrays.asList(1,2,3,4,5,5,5,6,7,8,9));
        LinkedList<Integer> L2 = new LinkedList<>(Arrays.asList(1,3,3,5,7,9));
        LinkedList<Integer> Difference = new LinkedList<>();

        difference(L1,L2,Difference);
        System.out.println(Difference);
    }

}
