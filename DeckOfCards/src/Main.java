import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Suit[] suitsArray = {Suit.SPADES, Suit.HEARTS, Suit.CLUBS, Suit.DIAMONDS};
        ArrayList<Suit> suits = new ArrayList<>(Arrays.asList(suitsArray));

        Face[] facesArray = {Face.ACE, Face.KING, Face.QUEEN, Face.JACK};
        ArrayList<Face> faces = new ArrayList<>(Arrays.asList(facesArray));

        ArrayList<Card> deck = new ArrayList<>();

        //Creating the deck of cards
        for(Suit suit : suits){
            for(Face face : faces){
                deck.add(new FaceCard(face, suit));
            }

            for(int i = 10; i > 1; i--){
                deck.add(new NumericCard(i, suit));
            }

        }

        //Testing the shuffling & sorting
        System.out.println("---------------Original-----------------");
        System.out.println(deck + "\n");

        Collections.shuffle(deck);

        System.out.println("---------------Shuffled-----------------");
        System.out.println(deck + "\n");

        SortBySuitAndValue defaultSort = new SortBySuitAndValue();

        Collections.sort(deck, defaultSort);

        System.out.println("---------------Resorted-----------------");
        System.out.println(deck + "\n");

        Collections.shuffle(deck);

        ArrayList<Card> hand = new ArrayList<>();

        //Creating the hand
        //Asking for size of hand
        System.out.println("How many cards do you want to draw?");
        Scanner askUser = new Scanner(System.in);
        System.out.println('\n');

        //Attempting to parse the input and pull that many cards from deck into hand
        try{
            int handSize = Integer.parseInt(askUser.nextLine());
            for(int i = 0; i < handSize; i++){
                hand.add(deck.remove(deck.size() - 1));
            }
            System.out.println("Drew " + hand.size() + " Cards");
            System.out.println(hand);
            System.out.println(deck);
        } catch (Exception e){
            System.out.println("Something went wrong.");
        }

    }
}
