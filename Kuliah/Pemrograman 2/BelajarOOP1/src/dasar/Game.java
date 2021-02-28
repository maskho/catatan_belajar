package dasar;
public class Game {
  public static void main(String[] args){
      Player petani = new Player();
      petani.name = "Kaswan ";
      petani.speed = 78;
      petani.score = 0;
      petani.run();
      if(petani.isDead()){
          System.out.println("Game Over");
      }
  }    
}
