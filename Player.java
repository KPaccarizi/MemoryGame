package cardgame;


public class Player {

   private int points;
   private String name; 

   public Player(int p, String name ){
      this.points = p;
      this.name = name;
   }

   public int getPoints() {
      return points;
   }

   public void setPoints(int points) {
      this.points = points;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void addPoints(int a){points = points+a;}





}	


