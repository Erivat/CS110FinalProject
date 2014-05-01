// Emile Rivat

import java.util.Scanner;
import java.text.NumberFormat;
import java.io.IOException;
import java.util.Locale;
import java.text.DecimalFormat;

public class cardGame
{
   public static void main(String[] args) throws IOException
   {
    Card cardOfHearts;
    Card cardOfDiamond;
    Card cardOfSpades;
    Card cardOfClubs;
    int numOfPlays = 0;

    Scanner keyboard = new Scanner(System.in);
    Deck deckOfCards = new Deck();
    Deck player1Pile = new Deck();
    Deck player2Pile = new Deck();
    for(int i = 2; i < 15; i++)
    {
        char heart = '\u0003';
        char diamond ='\u0004';
        char spade = '\u0005';
        char club = '\u0006';
        
        deckOfCards.add(cardOfHearts = new Card(heart, i));
        deckOfCards.add(cardOfDiamond = new Card(diamond, i));
        deckOfCards.add(cardOfSpades = new Card(spade, i));
        deckOfCards.add(cardOfClubs = new Card(club, i));
   }
 
    System.out.println("Deck Of Cards: " + deckOfCards);
    deckOfCards.shuffle();
    System.out.println("Deck of Cards after shuffled: " + deckOfCards);
    System.out.println("" + deckOfCards.size());
    for(int i = 0; i < 26; i++)
    {
        player1Pile.add(deckOfCards.getTopCard());
        player2Pile.add(deckOfCards.getTopCard());
    }
    System.out.println("Deck of Cards after removing cards into two piles: " + deckOfCards);
    System.out.println("Player 1's Cards: " + player1Pile);
    System.out.println("Player 2's Cards: " + player2Pile);
    
    System.out.println("" + player1Pile.size());
    System.out.println("" + player2Pile.size());
 
    System.out.println("Lets have a war!!!");
    System.out.println("\n\tPlayer 1                                         Player 2");
    System.out.println("\n\t--------                                         --------");

    try
    { 
        do
        {
            Card player1RemovedTopCard = player1Pile.getTopCard();
            Card player2RemovedTopCard = player2Pile.getTopCard();
 
            if(player1RemovedTopCard.compareTo(player2RemovedTopCard) < player2RemovedTopCard.compareTo(player1RemovedTopCard))
            {
                System.out.println("Player 1: " + player1RemovedTopCard + " Player 2: " + player2RemovedTopCard);
                System.out.println("Player 2 is Winning");
                player2Pile.add(player1RemovedTopCard);
                player2Pile.add(player2RemovedTopCard);
                System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
                System.out.println("Player 2 has:" + player2Pile.size() + " cards left.");
                System.out.println("\n");
                keyboard.nextLine();
            }
            else if(player1RemovedTopCard.compareTo(player2RemovedTopCard) > player2RemovedTopCard.compareTo(player1RemovedTopCard))
            {
                System.out.println("Player 1: " + player1RemovedTopCard + " Player 2: " + player2RemovedTopCard);
                System.out.println("Player 1 is Winning");
                player1Pile.add(player1RemovedTopCard);
                player1Pile.add(player2RemovedTopCard);
                System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
                System.out.println("Player 2 has:" + player2Pile.size() + " cards left.");
                System.out.println("\n");
                keyboard.nextLine();
            }
            else
            {
                System.out.println("Player 1: " + player1RemovedTopCard + " Player 2: " + player2RemovedTopCard);
                System.out.println("Let's Play!");
                

                if(player1Pile.size() == 1 || player2Pile.size() == 1)
                {
                    Card player1RemovedTopCard2 = player1Pile.getTopCard();

                    Card player2RemovedTopCard2 = player2Pile.getTopCard();
                    System.out.println("Player1's 2nd card is: " + player1RemovedTopCard2 + " Player2's 2nd card is: " + player2RemovedTopCard2);
                    if(player1RemovedTopCard2.compareTo(player2RemovedTopCard2) > player2RemovedTopCard2.compareTo(player1RemovedTopCard2))
                    {
                        System.out.println("Player 1 is the winner of the War! ");
                        player1Pile.add(player1RemovedTopCard);
                        player1Pile.add(player1RemovedTopCard2);
                        player1Pile.add(player2RemovedTopCard);
                        player1Pile.add(player2RemovedTopCard2);
                        System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
                        System.out.println("Player 2 has: " + player2Pile.size() + " cards left.");
                        System.out.println("\n");
                        keyboard.nextLine();
                    }
                    else if(player1RemovedTopCard2.compareTo(player2RemovedTopCard2) < player2RemovedTopCard2.compareTo(player1RemovedTopCard2))
                    {
                        System.out.println("Player 2 is the winner of the War! ");
                        player2Pile.add(player1RemovedTopCard);
                        player2Pile.add(player1RemovedTopCard2);
                        player2Pile.add(player2RemovedTopCard);
                        player2Pile.add(player2RemovedTopCard2);
                        System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
                        System.out.println("Player 2 has: " + player2Pile.size() + " cards left.");
                        System.out.println("\n");
                        keyboard.nextLine();
                    }
                    else
                    {
                        if(player2Pile.size() == 0)
                        {
                            player1Pile.add(player2RemovedTopCard2);
                            player1Pile.add(player2RemovedTopCard);
                            player1Pile.add(player1RemovedTopCard2);
                            player1Pile.add(player1RemovedTopCard);
                        }
                        else
                        {
                            player2Pile.add(player2RemovedTopCard2);
                            player2Pile.add(player2RemovedTopCard);
                            player2Pile.add(player1RemovedTopCard2);
                            player2Pile.add(player1RemovedTopCard);
                        }
                    }
                }
                else if(player1Pile.size() == 2 || player2Pile.size() == 2)
                {
                    Card player1RemovedTopCard2 = player1Pile.getTopCard();
                    Card player1RemovedTopCard3 = player1Pile.getTopCard();
 
                    Card player2RemovedTopCard2 = player2Pile.getTopCard();
                    Card player2RemovedTopCard3 = player2Pile.getTopCard();
               do
                    {
                        System.out.println("Player1's 3rd card is: " + player1RemovedTopCard3 + " Player2's 3rd card is: " + player2RemovedTopCard3);
                        if(player1RemovedTopCard3.compareTo(player2RemovedTopCard3) > player2RemovedTopCard3.compareTo(player1RemovedTopCard3))
                        {
                            System.out.println("Player 1 is the winner of the War! ");
                            player1Pile.add(player1RemovedTopCard);
                            player1Pile.add(player1RemovedTopCard2);
                            player1Pile.add(player1RemovedTopCard3);
                            player1Pile.add(player2RemovedTopCard);
                            player1Pile.add(player2RemovedTopCard2);
                            player1Pile.add(player2RemovedTopCard3);
                            System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
                            System.out.println("Player 2 has: " + player2Pile.size() + " cards left.");
                            System.out.println("\n");
                            keyboard.nextLine();
                        }
                        else if(player1RemovedTopCard3.compareTo(player2RemovedTopCard3) < player2RemovedTopCard3.compareTo(player1RemovedTopCard3))
                        {
                            System.out.println("Player 2 is the winner of the War! ");
                            player2Pile.add(player1RemovedTopCard);
                            player2Pile.add(player1RemovedTopCard2);
                            player2Pile.add(player1RemovedTopCard3);
                            player2Pile.add(player2RemovedTopCard);
                            player2Pile.add(player2RemovedTopCard2);
                            player2Pile.add(player2RemovedTopCard3);
                            System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
                            System.out.println("Player 2 has: " + player2Pile.size() + " cards left.");
                            System.out.println("\n");
                            keyboard.nextLine();
                        }
                    }while(player1RemovedTopCard3.compareTo(player2RemovedTopCard3) == player2RemovedTopCard3.compareTo(player1RemovedTopCard3));
                }
                else if(player1Pile.size() == 3 || player2Pile.size() == 3)
                {
                    Card player1RemovedTopCard2 = player1Pile.getTopCard();
                    Card player1RemovedTopCard3 = player1Pile.getTopCard();
                    Card player1RemovedTopCard4 = player1Pile.getTopCard();
 
                    Card player2RemovedTopCard2 = player2Pile.getTopCard();
                    Card player2RemovedTopCard3 = player2Pile.getTopCard();
                    Card player2RemovedTopCard4 = player2Pile.getTopCard();
 
                    do
                    {
                        System.out.println("Player1's fourth card is: " + player1RemovedTopCard4 + " Player2's fourth card is: " + player2RemovedTopCard4);
                        if(player1RemovedTopCard4.compareTo(player2RemovedTopCard4) > player2RemovedTopCard4.compareTo(player1RemovedTopCard4))
                        {
                            System.out.println("Player 1 is the winner of the War! ");
                            player1Pile.add(player1RemovedTopCard);
                            player1Pile.add(player1RemovedTopCard2);
                            player1Pile.add(player1RemovedTopCard3);
                            player1Pile.add(player1RemovedTopCard4);
                            player1Pile.add(player2RemovedTopCard);
                            player1Pile.add(player2RemovedTopCard2);
                            player1Pile.add(player2RemovedTopCard3);
                            player1Pile.add(player2RemovedTopCard4);
                            System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
                            System.out.println("Player 2 has: " + player2Pile.size() + " cards left.");
                            System.out.println("\n");
                            keyboard.nextLine();
                        }
                        else if(player1RemovedTopCard4.compareTo(player2RemovedTopCard4) < player2RemovedTopCard4.compareTo(player1RemovedTopCard4))
                        {
                            System.out.println("Player 2 is the winner of the War! ");
                            player2Pile.add(player1RemovedTopCard);
                            player2Pile.add(player1RemovedTopCard2);
                            player2Pile.add(player1RemovedTopCard3);
                            player2Pile.add(player1RemovedTopCard4);
                            player2Pile.add(player2RemovedTopCard);
                            player2Pile.add(player2RemovedTopCard2);
                            player2Pile.add(player2RemovedTopCard3);
                            player2Pile.add(player2RemovedTopCard4);
                            System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
                            System.out.println("Player 2 has: " + player2Pile.size() + " cards left.");
                            System.out.println("\n");
                            keyboard.nextLine();
                        }
                    }while(player1RemovedTopCard4.compareTo(player2RemovedTopCard4) == player2RemovedTopCard4.compareTo(player1RemovedTopCard4));
                }
                else if(player1Pile.size() >= 4 || player2Pile.size() >= 4)
                {
                    Card player1RemovedTopCard2 = player1Pile.getTopCard();
                    Card player1RemovedTopCard3 = player1Pile.getTopCard();
                    Card player1RemovedTopCard4 = player1Pile.getTopCard();
                    Card player1RemovedTopCard5 = player1Pile.getTopCard();
                    Card player2RemovedTopCard2 = player2Pile.getTopCard();
                    Card player2RemovedTopCard3 = player2Pile.getTopCard();
                    Card player2RemovedTopCard4 = player2Pile.getTopCard();
                    Card player2RemovedTopCard5 = player2Pile.getTopCard();
                    do
                    {
                        System.out.println("Player1's 5th card is: " + player1RemovedTopCard5 + " Player2's 5th card is: " + player2RemovedTopCard5);
                        if(player1RemovedTopCard5.compareTo(player2RemovedTopCard5) > player2RemovedTopCard5.compareTo(player1RemovedTopCard5))
                        {
                            System.out.println("Player 1 is the winner of the War! ");
                            player1Pile.add(player1RemovedTopCard);
                            player1Pile.add(player1RemovedTopCard2);
                            player1Pile.add(player1RemovedTopCard3);
                            player1Pile.add(player1RemovedTopCard4);
                            player1Pile.add(player1RemovedTopCard5);
                            player1Pile.add(player2RemovedTopCard);
                            player1Pile.add(player2RemovedTopCard2);
                            player1Pile.add(player2RemovedTopCard3);
                            player1Pile.add(player2RemovedTopCard4);
                            player1Pile.add(player2RemovedTopCard5);
                            System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
                            System.out.println("Player 2 has: " + player2Pile.size() + " cards left.");
                            System.out.println("\n");
                            keyboard.nextLine();
                        }
                        else if(player1RemovedTopCard5.compareTo(player2RemovedTopCard5) < player2RemovedTopCard5.compareTo(player1RemovedTopCard5))
                        {
                            System.out.println("Player 2 is the winner of the War! ");
                            player2Pile.add(player1RemovedTopCard);
                            player2Pile.add(player1RemovedTopCard2);
                            player2Pile.add(player1RemovedTopCard3);
                            player2Pile.add(player1RemovedTopCard4);
                            player2Pile.add(player1RemovedTopCard5);
                            player2Pile.add(player2RemovedTopCard);
                            player2Pile.add(player2RemovedTopCard2);
                            player2Pile.add(player2RemovedTopCard3);
                            player2Pile.add(player2RemovedTopCard4);
                            player2Pile.add(player1RemovedTopCard5);
                            System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
                            System.out.println("Player 2 has: " + player2Pile.size() + " cards left.");
                            System.out.println("\n");
                            keyboard.nextLine();
                        }

                    }while(player1RemovedTopCard5.compareTo(player2RemovedTopCard5) == player2RemovedTopCard5.compareTo(player1RemovedTopCard5));
                }
            }
            numOfPlays++;
            if(numOfPlays >= 10)
            {
                player1Pile.shuffle();
                player2Pile.shuffle();
                System.out.println("Cards Shuffled");
                numOfPlays = 0;
            }
        }while(player1Pile.size() > 0 || player2Pile.size() > 0);
    }
 
    catch (IndexOutOfBoundsException theException)
        {
            if(player1Pile.size() == 0)
            {
                System.out.println("Winner is Player 2" );
            }
            else
            System.out.println("Winner is Player 1" );
 
        }
 
    } 
}
