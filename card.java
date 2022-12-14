import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

class Card {
    static List<Card> Deck = new ArrayList<>(); // Every card object that exists in the game
    static List<Card> DrawPile = new ArrayList<>(); // the draw pile -- at the start of a fight, is = to Deck
    // drawpile and deck are separate so that anything happening in gameloop (i.e
    // destruction of cards) does not affect next gameloop
    static List<Card> Hand = new ArrayList<>(); // hand is the cards the player can use at a given time. add from deck
    static List<Card> DiscardPile = new ArrayList<>(); // discard is where cards go after being played
    // add exhaust list -- far far far future
    static int Cost;
    public static Card Defend = new Defend();
    public static Card Strike = new Strike();
    public static Card CardName_ = new Card();



    public static void deckInit() {
        for (int i = 0; i < 6; i++) {
            if (i < 3) {
               Deck.add(Strike);
            }

            if (i >= 3 && i < 6) {
                Deck.add(Defend);

            }
        }
      //  Deck.add("BASH");
    }


    public static void discardHand() {
        int j = 0;
        for (Card x : Hand) {
            x = Hand.get(j);
            DiscardPile.add(x);
            j++;
        }
        Hand.removeAll(Hand);


    }
    public static void discardCard(int i) {
        Card x = Hand.get(i);
        Hand.remove(x);
        DiscardPile.add(x);

    }
    
    
    

    public static void createDrawPile() {
        for (Card x : Deck) {
            DrawPile.add(x);
        }
        Collections.shuffle(DrawPile);
        // eventually implement something slightly more complex to handle exhausting
        // cards
    }

    // places cards into the players hand
    public static void DrawHand() {
        // add checks for index here, add discard + draw, shuffle, then run the for loop
        while(true){
        if(DrawPile.size() >=3){
        for (int j = 0; j <3; j++) {
            CardName_ = DrawPile.get(0);
            DrawPile.remove(0);
            Hand.add(CardName_);
        }
        break;
    }else{
        DrawPile.addAll(DiscardPile);
        DiscardPile.clear();
        Collections.shuffle(DrawPile);    
        }
        }
    }

    public static String getDraw() {
        return DrawPile.toString();
    }

    public static String getHand() {
        return Hand.toString();

    }

    public static List<Card> getDiscard() {
        return DiscardPile;

    }

    public static List<Card> getDeck() {
        return Deck; 

    }
public int getCost(){
    
    return 0;
}
public int getBlock() {
    return 0;
}

public int getDamage() {
    return 0;
}


   
static class Defend extends Card {
    // add a bool to check if card is upgraded
    int Cost = 1;
    int Block = 5;
public int getCost() {
        return Cost;
    }
public int getBlock(){
    
    return Block;
}

public String toString(){
    return "Defend";
}




}

static class Strike extends Card {
    int Cost = 1;
    int Damage = 6;
public int getDamage(){
    return Damage;
}
public int getCost() {
    return Cost;
}
public int getBlock(){

return 0;
}

public String toString(){
    return "Strike";
}
}






}