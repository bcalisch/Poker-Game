

/**
 * Checks to see if the array is a flush.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FlushCheck {
    public static void main(String[] args) {
        List<String>  P1 = new ArrayList(Arrays.asList("1S", "2S", "TS", "4S", "5S"));
        char suit1  = P1.get(0).charAt(1);
        char suit2;
        boolean flush = true;
//        String temp;
//


        for (int i = 0; i < P1.size(); i++) {
            suit2 = P1.get(i).charAt(1);
            if (suit1 == suit2){
                flush = true;
            }
            else {
                flush = false;
                break;
            }
//            temp = P1.get(i);
//          //  System.out.println("temp = " + temp);
//            temp = temp.substring(0,1);
//           // System.out.println("temp = " + temp);
//            //String replace = temp.replace(temp.charAt(1), "");
//           P1.remove(i);
//            P1.add(i, temp);
////            System.out.println("P1.get(" + i+") = " + P1.get(i));
////            System.out.println(P1.get(i).charAt(1));

        }
        if(flush){
            System.out.println("We have a flush!!!");
        }
        else{
            System.out.println("No flush today!");
        }
        System.out.println("P1 = " + P1);
    }
}
