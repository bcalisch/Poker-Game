package com.pokerGame; /**
 * TODO:
 * Make the following Classes
 * CheckPair-Mike
 * Check2Pair-Benjamin
 * CheckFullHouse-Mike
 * CheckThreeOfAKind-Benjamin
 * CheckFourOfAKind-Mike
 * CheckStraight-Mike
 * CheckHighCard
 * CheckFlush
 * CheckFinal
 * CompareHands
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.pokerGame.Hand;



public class LoadHands {
    public static void main(String[] args){

        String inputLine;
        URL projEU = null;
        List<String> p1 = new ArrayList(Arrays.asList());
        List<String> p2 = new ArrayList(Arrays.asList());

        try {
            projEU = new URL("https://projecteuler.net/project/resources/p054_poker.txt");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(
                            projEU.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Bit that deals with each line of the file
        try {
            while ((inputLine = in.readLine()) != null) {
               // inputLine.replaceAll(" ", "");
               // System.out.println(inputLine);
                //inputLine = inputLine.replaceAll(" ", ",");


                /*TODO
                * make the line of text an array
                * Separate the array into two arrays (P1 and P2)
                * Evaluate each hand
                * If P1 wins, count++
                * */


                //make the line of text an array

                List<String> lineArray = new ArrayList(Arrays.asList(inputLine.split(" ")));
                p1.clear();
                p2.clear();



                //System.out.println(lineArray.get(0));
               // System.out.println(inputLine);
                for (int i = 0; i < lineArray.size(); i++){
                    if (i < 5 ){
                        p1.add(lineArray.get(i));
                    }
                    else {
                        p2.add(lineArray.get(i));


                    }

                }
                Hand P1 = new Hand(p1);

                P1.convertList();

                System.out.println("p1");
                System.out.println(p1);
                System.out.println("P2");
                System.out.println(p2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
