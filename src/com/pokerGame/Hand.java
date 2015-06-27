package com.pokerGame;


import java.util.List;
import java.util.Collections;
import java.util.ArrayList;


/**
 * Created by benjamin on 6/22/15.
 */
public class Hand {

    private int highCard1;
    private int highCard2;
    private int highCard3;
    private int highCard4;
    private int highCard5;
    private int cardHand;
    private boolean flush = false;
    private List<String> cardsString;
    private List<Integer> cardsInt = new ArrayList<Integer>();


    public Hand(List<String> playerHand) {
        cardsString = playerHand;
    }



    public int convertList() {
        for (int i = 0; i < this.cardsString.size(); i++) {
            String temp = this.cardsString.get(i);
            temp = temp.substring(0, 1);

            switch (temp) {
                case "T":
                    temp = "10";
                    break;
                case "J":
                    temp = "11";
                    break;
                case "Q":
                    temp = "12";
                    break;
                case "K":
                    temp = "13";
                    break;
                case "A":
                    temp = "14";
                    break;
            }

            Integer holder = Integer.valueOf(temp);
            cardsInt.add(i, holder);
            Collections.sort(cardsInt, Collections.reverseOrder());


        }
        System.out.println("cardsInt = " + cardsInt);

        return 0;
    }

    public void twoPair() {
        int size = cardsInt.size() - 1;
        int counter = 0;
        int pair1 = 0;
        int pair2 = 0;
        boolean onePair = false;
        boolean twoPair = false;

        for (int i = 0; i < size; i++) {
            if (cardsInt.get(i) == cardsInt.get(i+1)) {
                counter++;
            }
            if ((counter == 1) && (onePair == false)) {
                pair1 = cardsInt.get(i);
                pair2 = pair1;
                onePair = true;
            }
            else if ((counter == 2) && (twoPair == false)) {

                pair2 = cardsInt.get(i);
                twoPair = true;

            }
        }

        if (pair1 != pair2 && counter != 3) {
            int counter2 = 0;
            int size2 = cardsInt.size() -1;
            boolean firstHigh = false;
            boolean secondHigh = false;
            highCard3 = cardsInt.get(0);
            for (int i = 0; i < size2; i++) {
                if (cardsInt.get(i) == cardsInt.get(i+1)) {
                    counter2++;

                }
                if ((counter2 == 1) && (firstHigh == false)) {
                    highCard1 = cardsInt.get(i);
                    firstHigh = true;
                    if (highCard3 <= highCard1){
                        highCard3 = cardsInt.get(i+2);
                    }


                }
                else if ((counter2 == 2) && (secondHigh == false)) {
                    highCard2 = cardsInt.get(i);
                    secondHigh = true;
                    if (highCard3 <= highCard2){
                        highCard3 = cardsInt.get(i+2);
                    }

                }
            }
            System.out.println("2Pair only" +" High pair "+ highCard1+ " Second High Pair "+highCard2+ "Third High Paire"+highCard3);
        } else {
            System.out.println("Not a 2 pair");
        }


    }
    public void fullHouse() {
        int size = cardsInt.size() - 1;
        int counter = 0;
        int pair1 = 0;
        int pair2 = 0;
        boolean fullHouse = false;

        for (int i = 0; i < size; i++) {
            if (cardsInt.get(i) == cardsInt.get(i+1)) {
                counter++;
            }
            if (counter == 1) {
                pair1 = cardsInt.get(i);
                pair2 = pair1;
            }

            else if ((counter == 3) && (fullHouse == false)) {

                pair2 = cardsInt.get(i);
                fullHouse = true;

            }
        }
        if (pair1 != pair2 && counter == 3) {
            highCard1 = cardsInt.get(0);
            int counter2 =0;
            boolean fullHouse2 = false;
            for (int i = 0; i < size; i++) {
                if (cardsInt.get(i) == cardsInt.get(i+1)) {
                    counter2++;
                }
                if (counter2 == 1) {
                    highCard1 = cardsInt.get(i);
                }

                else if ((counter2 == 3) && (fullHouse2 == false)) {

                    highCard2 = cardsInt.get(i);
                    fullHouse = true;

                }
            }
            System.out.println("Full house, with high card 1 is "+highCard1+" And High card 2 is "+highCard2);
        } else {
            System.out.println("Not a full House");
        }


    }
    public void straight() {
        int size = cardsInt.size() - 1;
        int counter = 0;
        int nextCard = 0;
        highCard1 = cardsInt.get(0);
        for (int i = 0; i < size; i++) {
            nextCard = cardsInt.get(i+1)-1;
            if (cardsInt.get(i) == nextCard) {
                counter++;
            }

            }
        if (counter == 4){
            System.out.println("You have a straight, with a high card of" + highCard1);
        }
        else
            System.out.println("You do not have a straight");
        }
}

