package com.pokerGame;


import java.util.List;
import java.util.Collections;

/**
 * Created by benjamin on 6/22/15.
 */
public class Hand{

    private int highCard1;
    private int highCard2;
    private int highCard3;
    private int highCard4;
    private int highCard5;
    private String handName = null;
    private boolean flush = false;
    private List<String> cardsString;
    private List<Integer> cardsInt;

    public Hand(List<String> String1){
        cardsString = String1;
    }
    public int convertList(){
        //this.cardsString.add(3, " this");
        for (int i = 0; i < this.cardsString.size(); i++) {
            String temp = this.cardsString.get(i);
            temp = temp.substring(0,1);

            switch(temp){
                case "T": temp = "10";
                    break;
                case "J": temp = "11";
                    break;
                case "Q": temp = "12";
                    break;
                case "K": temp ="13";
                    break;
                case "A": temp = "14";
                    break;
            }

            Integer holder = Integer.valueOf(temp);
            cardsInt.add(i, holder);
            Collections.sort(cardsInt);

            System.out.println("cardsInt = " + cardsInt);
        }

        return 0;
    }




}

