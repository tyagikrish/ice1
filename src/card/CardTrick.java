/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
@modifier Krish Tyagi - 991762932
*/
package card;

import java.util.Scanner;
import java.util.Random;

public class CardTrick {
    public static void main(String[] args) {
        Card[] deckOfCards = new Card[7];
        Random randomGenerator = new Random();

        for (int i = 0; i < deckOfCards.length; i++) {
            Card randomCard = new Card();
            randomCard.setValue(randomGenerator.nextInt(13) + 1);  
            randomCard.setSuit(Card.SUITS[randomGenerator.nextInt(4)]);  
            deckOfCards[i] = randomCard;  
        }
        
        System.out.println("Deck of Cards:");
        for (Card card : deckOfCards) {
            System.out.println(card.getSuit() + " " + card.getValue());
        }
        
        Scanner inputScanner = new Scanner(System.in);
        
        System.out.print("Enter a card value (1-13): ");
        int chosenCardValue = inputScanner.nextInt();
        
        System.out.print("Enter a suit (0-3 where 0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades): ");
        int chosenSuitIndex = inputScanner.nextInt();
        
        Card chosenCard = new Card();
        chosenCard.setValue(chosenCardValue);
        chosenCard.setSuit(Card.SUITS[chosenSuitIndex]);

        boolean cardExists = false;
        for (Card card : deckOfCards) {
            if (card.getValue() == chosenCard.getValue() && card.getSuit().equals(chosenCard.getSuit())) {
                cardExists = true;
                break;
            }
        }

        if (cardExists) {
            System.out.println("Congratulations! Your card is in the deck.");
        } else {
            System.out.println("Sorry, your card is not in the deck.");
        }

        Card specialCard = new Card();
        specialCard.setValue(2);  
        specialCard.setSuit("Clubs");  

        boolean specialCardExists = false;
        for (Card card : deckOfCards) {
            if (card.getValue() == specialCard.getValue() && card.getSuit().equals(specialCard.getSuit())) {
                specialCardExists = true;
                break;
            }
        }

        if (specialCardExists) {
            System.out.println("Special card (2 of Clubs) is in the deck!");
        } else {
            System.out.println("Special card (2 of Clubs) is not in the deck.");
        }
        
        inputScanner.close();
    }
}
