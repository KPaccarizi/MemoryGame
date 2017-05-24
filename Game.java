package cardgame;

import java.util.Random;
import java.util.Scanner;


public class Game {
   private static final int POINTS = 1;
   private static int size = 6;// sa letra me kan
	
   public static void main(String[] args) {
      Game game = new Game();
      game.startGame();
   }

   public void startGame(){
   //		Card  card1 = new Card("1");
      Player player1 = new Player (0 , "Player1");
      Player player2 = new Player (0 , "Player2");
   	
      Card[] cards = new Card[size];
      String figs = "abcdefgwpoiu";
      for (int i = 0; i < cards.length-1; i = i + 2) {
         cards[i] = new Card(figs.charAt(i/2)+"");
         cards[i+1] = new Card(figs.charAt(i/2)+"");
      }
   	
      mixCards(cards);
   
      int turn = 0;// kush e ka radhen me lujt, lojtari 1 apo 2/ turn = 0(plyaer 1)
      int counter = 0; // numron sa here nje lojtar ka zgjedhur, duhet 2 here
      int firstCard = -1;
      while(true){
         showCards(cards);
         if(turn == 0){
            System.out.println(player1.getName() +" choose a card: ");
         }
         else {
            System.out.println(player2.getName() +" choose a card: ");
         }
         Scanner scanner = new Scanner(System.in);
         String input = scanner.nextLine();
         int number;
         try {
            number = Integer.parseInt(input);
         } 
         catch (NumberFormatException e) {
            System.out.println("Not a number, input a valid number");
            continue;//ktheu edhe niher ne while
         }
         if(number >= size){
            System.out.println("Input a number from 0 to "+(size-1));
            continue;//ktheu edhe niher ne while
         }
      	//nqs e ka zgjedh nje numer te zgjedur vazhdo numer tjeter
         if(cards[number].isOpened()){
            System.out.println("This card is already opened, try another one");
            continue;//ktheu edhe niher ne while				
         }
         if(counter == 0){
            firstCard = number;
         }
         cards[number].setOpened(true);
      //			showCards(cards);
         counter ++;
         if(counter == 2){
            if(isCorrect(firstCard, number, cards)){
               if(turn == 0){
                  player1.addPoints(POINTS);
               }
               else{
                  player2.addPoints(POINTS);
               }
               counter = 0;
               if(isGameFinished(cards)){
                  finishGame(player1, player2);
                  System.exit(0);
               }
               System.out.println("Correct, continue the game");
               continue;
            }
            else{// e pasake
               showCards(cards);
               System.out.println("Incorrect");
               counter = 0;
               if(turn == 0){
                  turn =1;
               }
               else{
                  turn = 0;
               }
               cards[number].setOpened(false);
               cards[firstCard].setOpened(false);
               continue;
            }
         }
      }
   		
   }

   private void mixCards(Card[] cards) {
      int index;
      Card temp;
      Random random = new Random();
      for (int i = cards.length - 1; i > 0; i--)
      {
         index = random.nextInt(i + 1);
         temp = cards[index];
         cards[index] = cards[i];
         cards[i] = temp;
      }
   }

   private boolean isGameFinished(Card[] cards) {
      for (int i = 0; i < cards.length; i++) {
         if(!cards[i].isOpened()){
            return false;
         }
      }
      return true;
   }
	
   public void finishGame(Player player1 ,Player player2){
      
     
   	//print winner
      System.out.println("Game finished, The winner is : ");
      
      if(player1.getPoints() > player2.getPoints()){
         System.out.println("Player 1 " ); 
      } 
      else if(player1.getPoints() == player2.getPoints()) {
         System.out.println("Player 1 and Player 2 are equals" ); 
      } 
      else {
         System.out.println("Player 2  ");
      }
   }
   private boolean isCorrect(int firstCard, int number, Card[] cards) {
      return cards[firstCard].getFigure().equals(cards[number].getFigure());
   }

   private void showCards(Card[] cards) {
      for (int i = 0; i < cards.length; i++) {
         if(i % 3 == 0 ){ System.out.println(); }
         
         if (cards[i].isOpened()) {
            System.out.print("   |"+cards[i].getFigure()+"|  ");
         } 
            
         else{
            System.out.print("   |X|  ");
         }
      }              
      
      
   }
}