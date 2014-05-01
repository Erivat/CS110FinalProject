// import needed classes and packages

import java.util.Scanner;
import java.text.NumberFormat;
import java.io.IOException;
import java.util.Locale;
import java.text.DecimalFormat;

// Program2
public class cardGame
{
   public static void main(String[] args) throws IOException
   {
    //Declare Variables
    //Creates the cards based on their suite
    Card heartCard;
    Card diamondCard;
    Card spadeCard;
    Card clubCard;
    int countingPlays = 0;

    Scanner keyboard = new Scanner(System.in); //Allows Input
    //creates the cardPile array called DeckOfCards
    CardPile deckOfCards = new CardPile();
    //Creates Player1's Card Pile
    CardPile player1Pile = new CardPile();
    //Creates Player2's Card Pile
    CardPile player2Pile = new CardPile();
    //Creates the cards to fill the array (1-14 of hearts/diamonds/spades/clubs)
    for(int i = 2; i < 15; i++)
    {
        char heart = '\u0003';

        char diamond ='\u0004';
036
        char spade = '\u0005';
037
        char club = '\u0006';
038
 
039
        deckOfCards.add(heartCard = new Card(heart, i));
040
        deckOfCards.add(diamondCard = new Card(diamond, i));
041
        deckOfCards.add(spadeCard = new Card(spade, i));
042
        deckOfCards.add(clubCard = new Card(club, i));
043
    }
044
 
045
    //prints out the deck of Cards
046
    System.out.println("Deck Of Cards: " + deckOfCards);
047
 
048
    //shuffles the cards
049
    deckOfCards.shuffle();
050
 
051
    //Prints out the deck of cards after they are shuffled
052
    System.out.println("Deck of Cards after shuffled: " + deckOfCards);
053
 
054
    //Checking the size of the Deck
055
    System.out.println("" + deckOfCards.size());
056
 
057
    //Takes the deckOfCards and splits them up into 2 piles for Player1 and Player2
058
    for(int i = 0; i < 26; i++)
059
    {
060
        player1Pile.add(deckOfCards.getTopCard());
061
        player2Pile.add(deckOfCards.getTopCard());
062
    }
063
 
064
    //Prints out the deck of Cards and then the player 1's pile and player 2's pile
065
    System.out.println("Deck of Cards after removing cards into two piles: " + deckOfCards);
066
    System.out.println("Player 1's Cards: " + player1Pile);
067
    System.out.println("Player 2's Cards: " + player2Pile);
068
 
069
    //checking the size of each players Pile
070
    System.out.println("" + player1Pile.size());
071
    System.out.println("" + player2Pile.size());
072
 
073
    //Prints the header for the game
074
    System.out.println("Lets have a war!!!");
075
    System.out.println("\n\tPlayer 1                                         Player 2");
076
    System.out.println("\n\t--------                                         --------");
077
 
078
    //Testing tricky spot where the getTopCard removes a the topcard
079
    /*
080
    Card removedTopCard = player1Pile.getTopCard();
081
    System.out.println("Getting player1Pile: " + removedTopCard);
082
    player1Pile.add(removedTopCard);
083
    System.out.println("Player1Pile is " + player1Pile);
084
    System.out.println("Player1Pile size is " +player1Pile.size());
085
    */
086
 
087
    //Starts the game of War
088
    try
089
    {   //do while the sizes of the player piles are greater than 0.
090
        do
091
        {
092
            //gets the top cards of each players Pile
093
            Card player1RemovedTopCard = player1Pile.getTopCard();
094
            Card player2RemovedTopCard = player2Pile.getTopCard();
095
 
096
            //Compares the 2 cards to test which is bigger. If player 1's card is smaller than player 2 is the winner
097
            if(player1RemovedTopCard.compareTo(player2RemovedTopCard) < player2RemovedTopCard.compareTo(player1RemovedTopCard))
098
            {
099
                System.out.println("Player 1: " + player1RemovedTopCard + " Player 2: " + player2RemovedTopCard);
100
                System.out.println("Player 2 is the Winner");
101
                player2Pile.add(player1RemovedTopCard);
102
                player2Pile.add(player2RemovedTopCard);
103
                System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
104
                System.out.println("Player 2 has:" + player2Pile.size() + " cards left.");
105
                System.out.println("\n");
106
                keyboard.nextLine();
107
            }
108
            //Compares the 2 cards to test which is bigger. If player 2's card is smaller than player 1 is the winner.
109
            else if(player1RemovedTopCard.compareTo(player2RemovedTopCard) > player2RemovedTopCard.compareTo(player1RemovedTopCard))
110
            {
111
                System.out.println("Player 1: " + player1RemovedTopCard + " Player 2: " + player2RemovedTopCard);
112
                System.out.println("Player 1 is the Winner");
113
                player1Pile.add(player1RemovedTopCard);
114
                player1Pile.add(player2RemovedTopCard);
115
                System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
116
                System.out.println("Player 2 has:" + player2Pile.size() + " cards left.");
117
                System.out.println("\n");
118
                keyboard.nextLine();
119
            }
120
            //Else it is a war
121
            else
122
            {
123
                System.out.println("Player 1: " + player1RemovedTopCard + " Player 2: " + player2RemovedTopCard);
124
                System.out.println("WAR!!!!!!!");
125
                //War if the player has only 4 cards left.
126
                if(player1Pile.size() == 1 || player2Pile.size() == 1)
127
                {
128
                    Card player1RemovedTopCard2 = player1Pile.getTopCard();
129
 
130
                    Card player2RemovedTopCard2 = player2Pile.getTopCard();
131
                    System.out.println("Player1's 2nd card is: " + player1RemovedTopCard2 + " Player2's 2nd card is: " + player2RemovedTopCard2);
132
                    if(player1RemovedTopCard2.compareTo(player2RemovedTopCard2) > player2RemovedTopCard2.compareTo(player1RemovedTopCard2))
133
                    {
134
                        System.out.println("Player 1 is the winner of the War! ");
135
                        player1Pile.add(player1RemovedTopCard);
136
                        player1Pile.add(player1RemovedTopCard2);
137
                        player1Pile.add(player2RemovedTopCard);
138
                        player1Pile.add(player2RemovedTopCard2);
139
                        System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
140
                        System.out.println("Player 2 has: " + player2Pile.size() + " cards left.");
141
                        System.out.println("\n");
142
                        keyboard.nextLine();
143
                    }
144
                    else if(player1RemovedTopCard2.compareTo(player2RemovedTopCard2) < player2RemovedTopCard2.compareTo(player1RemovedTopCard2))
145
                    {
146
                        System.out.println("Player 2 is the winner of the War! ");
147
                        player2Pile.add(player1RemovedTopCard);
148
                        player2Pile.add(player1RemovedTopCard2);
149
                        player2Pile.add(player2RemovedTopCard);
150
                        player2Pile.add(player2RemovedTopCard2);
151
                        System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
152
                        System.out.println("Player 2 has: " + player2Pile.size() + " cards left.");
153
                        System.out.println("\n");
154
                        keyboard.nextLine();
155
                    }
156
                    else
157
                    {
158
                        if(player2Pile.size() == 0)
159
                        {
160
                            player1Pile.add(player2RemovedTopCard2);
161
                            player1Pile.add(player2RemovedTopCard);
162
                            player1Pile.add(player1RemovedTopCard2);
163
                            player1Pile.add(player1RemovedTopCard);
164
                        }
165
                        else
166
                        {
167
                            player2Pile.add(player2RemovedTopCard2);
168
                            player2Pile.add(player2RemovedTopCard);
169
                            player2Pile.add(player1RemovedTopCard2);
170
                            player2Pile.add(player1RemovedTopCard);
171
                        }
172
                    }
173
                }
174
                //War if the player has only 2 cards left.
175
                else if(player1Pile.size() == 2 || player2Pile.size() == 2)
176
                {
177
                    Card player1RemovedTopCard2 = player1Pile.getTopCard();
178
                    Card player1RemovedTopCard3 = player1Pile.getTopCard();
179
 
180
                    Card player2RemovedTopCard2 = player2Pile.getTopCard();
181
                    Card player2RemovedTopCard3 = player2Pile.getTopCard();
182
 
183
                    do
184
                    {
185
                        System.out.println("Player1's 3rd card is: " + player1RemovedTopCard3 + " Player2's 3rd card is: " + player2RemovedTopCard3);
186
                        if(player1RemovedTopCard3.compareTo(player2RemovedTopCard3) > player2RemovedTopCard3.compareTo(player1RemovedTopCard3))
187
                        {
188
                            System.out.println("Player 1 is the winner of the War! ");
189
                            player1Pile.add(player1RemovedTopCard);
190
                            player1Pile.add(player1RemovedTopCard2);
191
                            player1Pile.add(player1RemovedTopCard3);
192
                            player1Pile.add(player2RemovedTopCard);
193
                            player1Pile.add(player2RemovedTopCard2);
194
                            player1Pile.add(player2RemovedTopCard3);
195
                            System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
196
                            System.out.println("Player 2 has: " + player2Pile.size() + " cards left.");
197
                            System.out.println("\n");
198
                            keyboard.nextLine();
199
                        }
200
                        else if(player1RemovedTopCard3.compareTo(player2RemovedTopCard3) < player2RemovedTopCard3.compareTo(player1RemovedTopCard3))
201
                        {
202
                            System.out.println("Player 2 is the winner of the War! ");
203
                            player2Pile.add(player1RemovedTopCard);
204
                            player2Pile.add(player1RemovedTopCard2);
205
                            player2Pile.add(player1RemovedTopCard3);
206
                            player2Pile.add(player2RemovedTopCard);
207
                            player2Pile.add(player2RemovedTopCard2);
208
                            player2Pile.add(player2RemovedTopCard3);
209
                            System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
210
                            System.out.println("Player 2 has: " + player2Pile.size() + " cards left.");
211
                            System.out.println("\n");
212
                            keyboard.nextLine();
213
                        }
214
                    //Continues the war if the top card at the end of the war are still equal
215
                    }while(player1RemovedTopCard3.compareTo(player2RemovedTopCard3) == player2RemovedTopCard3.compareTo(player1RemovedTopCard3));
216
                }
217
                //War if the player has only 3 cards left.
218
                else if(player1Pile.size() == 3 || player2Pile.size() == 3)
219
                {
220
                    Card player1RemovedTopCard2 = player1Pile.getTopCard();
221
                    Card player1RemovedTopCard3 = player1Pile.getTopCard();
222
                    Card player1RemovedTopCard4 = player1Pile.getTopCard();
223
 
224
                    Card player2RemovedTopCard2 = player2Pile.getTopCard();
225
                    Card player2RemovedTopCard3 = player2Pile.getTopCard();
226
                    Card player2RemovedTopCard4 = player2Pile.getTopCard();
227
 
228
                    do
229
                    {
230
                        System.out.println("Player1's fourth card is: " + player1RemovedTopCard4 + " Player2's fourth card is: " + player2RemovedTopCard4);
231
                        if(player1RemovedTopCard4.compareTo(player2RemovedTopCard4) > player2RemovedTopCard4.compareTo(player1RemovedTopCard4))
232
                        {
233
                            System.out.println("Player 1 is the winner of the War! ");
234
                            player1Pile.add(player1RemovedTopCard);
235
                            player1Pile.add(player1RemovedTopCard2);
236
                            player1Pile.add(player1RemovedTopCard3);
237
                            player1Pile.add(player1RemovedTopCard4);
238
                            player1Pile.add(player2RemovedTopCard);
239
                            player1Pile.add(player2RemovedTopCard2);
240
                            player1Pile.add(player2RemovedTopCard3);
241
                            player1Pile.add(player2RemovedTopCard4);
242
                            System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
243
                            System.out.println("Player 2 has: " + player2Pile.size() + " cards left.");
244
                            System.out.println("\n");
245
                            keyboard.nextLine();
246
                        }
247
                        else if(player1RemovedTopCard4.compareTo(player2RemovedTopCard4) < player2RemovedTopCard4.compareTo(player1RemovedTopCard4))
248
                        {
249
                            System.out.println("Player 2 is the winner of the War! ");
250
                            player2Pile.add(player1RemovedTopCard);
251
                            player2Pile.add(player1RemovedTopCard2);
252
                            player2Pile.add(player1RemovedTopCard3);
253
                            player2Pile.add(player1RemovedTopCard4);
254
                            player2Pile.add(player2RemovedTopCard);
255
                            player2Pile.add(player2RemovedTopCard2);
256
                            player2Pile.add(player2RemovedTopCard3);
257
                            player2Pile.add(player2RemovedTopCard4);
258
                            System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
259
                            System.out.println("Player 2 has: " + player2Pile.size() + " cards left.");
260
                            System.out.println("\n");
261
                            keyboard.nextLine();
262
                        }
263
                    //Continues the war if the top card at the end of the war are still equal
264
                    }while(player1RemovedTopCard4.compareTo(player2RemovedTopCard4) == player2RemovedTopCard4.compareTo(player1RemovedTopCard4));
265
                }
266
                //war if player has more than 4 cards
267
                else if(player1Pile.size() >= 4 || player2Pile.size() >= 4)
268
                {
269
                    Card player1RemovedTopCard2 = player1Pile.getTopCard();
270
                    Card player1RemovedTopCard3 = player1Pile.getTopCard();
271
                    Card player1RemovedTopCard4 = player1Pile.getTopCard();
272
                    Card player1RemovedTopCard5 = player1Pile.getTopCard();
273
 
274
                    Card player2RemovedTopCard2 = player2Pile.getTopCard();
275
                    Card player2RemovedTopCard3 = player2Pile.getTopCard();
276
                    Card player2RemovedTopCard4 = player2Pile.getTopCard();
277
                    Card player2RemovedTopCard5 = player2Pile.getTopCard();
278
                    do
279
                    {
280
                        System.out.println("Player1's 5th card is: " + player1RemovedTopCard5 + " Player2's 5th card is: " + player2RemovedTopCard5);
281
                        if(player1RemovedTopCard5.compareTo(player2RemovedTopCard5) > player2RemovedTopCard5.compareTo(player1RemovedTopCard5))
282
                        {
283
                            System.out.println("Player 1 is the winner of the War! ");
284
                            player1Pile.add(player1RemovedTopCard);
285
                            player1Pile.add(player1RemovedTopCard2);
286
                            player1Pile.add(player1RemovedTopCard3);
287
                            player1Pile.add(player1RemovedTopCard4);
288
                            player1Pile.add(player1RemovedTopCard5);
289
                            player1Pile.add(player2RemovedTopCard);
290
                            player1Pile.add(player2RemovedTopCard2);
291
                            player1Pile.add(player2RemovedTopCard3);
292
                            player1Pile.add(player2RemovedTopCard4);
293
                            player1Pile.add(player2RemovedTopCard5);
294
                            System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
295
                            System.out.println("Player 2 has: " + player2Pile.size() + " cards left.");
296
                            System.out.println("\n");
297
                            keyboard.nextLine();
298
                        }
299
                        else if(player1RemovedTopCard5.compareTo(player2RemovedTopCard5) < player2RemovedTopCard5.compareTo(player1RemovedTopCard5))
300
                        {
301
                            System.out.println("Player 2 is the winner of the War! ");
302
                            player2Pile.add(player1RemovedTopCard);
303
                            player2Pile.add(player1RemovedTopCard2);
304
                            player2Pile.add(player1RemovedTopCard3);
305
                            player2Pile.add(player1RemovedTopCard4);
306
                            player2Pile.add(player1RemovedTopCard5);
307
                            player2Pile.add(player2RemovedTopCard);
308
                            player2Pile.add(player2RemovedTopCard2);
309
                            player2Pile.add(player2RemovedTopCard3);
310
                            player2Pile.add(player2RemovedTopCard4);
311
                            player2Pile.add(player1RemovedTopCard5);
312
                            System.out.println("Player 1 has: " + player1Pile.size() + " cards left.");
313
                            System.out.println("Player 2 has: " + player2Pile.size() + " cards left.");
314
                            System.out.println("\n");
315
                            keyboard.nextLine();
316
                        }
317
                    //Continues the war if the top card at the end of the war are still equal
318
                    }while(player1RemovedTopCard5.compareTo(player2RemovedTopCard5) == player2RemovedTopCard5.compareTo(player1RemovedTopCard5));
319
                }
320
            }
321
            //Adds to the plays that keep track of how many plays have been made
322
            countingPlays++;
323
            //. If there are 10 plays it shuffles and prints out a message that the cards have been shuffled.
324
            if(countingPlays >= 10)
325
            {
326
                player1Pile.shuffle();
327
                player2Pile.shuffle();
328
                System.out.println("Cards Shuffled");
329
                //resets the counter to 0
330
                countingPlays = 0;
331
            }
332
        //Continues the game of war while the players piles are bigger than 0
333
        }while(player1Pile.size() > 0 || player2Pile.size() > 0);
334
    }
335
 
336
    //Catches the Array 0 error and prints out who is the winner based on who has zero cards.
337
    catch (IndexOutOfBoundsException theException)  //tries to catch this type...
338
        {
339
            if(player1Pile.size() == 0)
340
            {
341
                System.out.println("Winner is Player 2" );
342
            }
343
            else
344
            System.out.println("Winner is Player 1" );
345
 
346
        }
347
 
348
    } //end of main
349
}//end of class
