public class Maryland extends State {
Maryland() { }
public void printMe() { System.out.println("Read it."); }
public static void main(String[] args) {
  Region east = new State();
  State md = new Maryland();
  Object obj = new Place();
  Place usa = new Region();
  md.printMe();                   
  east.printMe();                  
  ((Place) obj).printMe();         
  usa.printMe();                   
  ((State) md).printMe();          
  ((Region) east).printMe();
}
}
class State extends Region {
State() {  }
public void printMe() { System.out.println("Ship it."); }
}
class Region extends Place {
Region() { }
public void printMe() { System.out.println("Box it."); }
}
class Place extends Object {
Place() {  }
public void printMe() { System.out.println("Buy it."); }
}
