package dasar;
public class Player {
  String name;
  int speed;
  int score; 
  void run(){
      System.out.println(name+" is running ...");
      System.out.println("Speed = "+speed);
  }
  boolean isDead(){
      if(score==0) return true;
      return false;
  }
}
