import java.util.Scanner;

public class WarGame2 {

   public static void main(String[] args) {

    Card[][] hands = new Card[2][1];
    Deck myDeck = new Deck();

    //reduced this to 26 iterations because two cards are dealt each iteration
    for (int i = 0; i < 26; i++) {
        System.out.printf("\n Round %s of The War \n", i);

        //You really don't need to loop just once here...
        //Simply assign the card to hands[player][0] since that's the only option
        //for (int c = 0; c < 1; c++)
            for (int player = 0; player < hands.length; player++)
                hands[player][0] = myDeck.dealCard();

        for (int player = 0; player < hands.length; player++) {
            System.out.printf("Player %d: ", player);
            printHand(hands[player]);
        }

        int player1 = hands[0][0].getValue(); //get the value from the Card object
        int player2 = hands[1][0].getValue();

        if (player1 > player2)
            System.out.println("Player One Wins The War");
        else if (player2 > player1)
            System.out.println("Player Two Wins The War");
        else
            System.out.println("The War Is A Tie");

    }
    }
}