package cardgame;

public class Card {


   private boolean opened ;  // a eshte hapure a ende nuk eshte hapur 
   private String  figure ; 	// cka ka ne leter
   public  Card ( String fig ){
      figure = fig ; 
      opened = false;// ne fillim te gjitha kartat e mbyllura 
   
   
   }
   public boolean isOpened() {
      return opened;
   }
   public void setOpened(boolean opened) {
      this.opened = opened;
   }
   public String getFigure() {
      return figure;
   }
   public void setFigure(String figure) {
      this.figure = figure;
   }



}
