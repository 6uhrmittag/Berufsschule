// Aufgabe6
// foobar    
//Programm gibt "foo" aus, sobald Zahl durch 3 teilbar und "bar" sobald sie durch 5 teilbar ist.                                 

public class Aufgabe6{
  
  public static void main (String[] args) {
    System.out.println("foobar\n"); 
    
    
    for (int i = 1; i <=100 ;i++ ) {
      
      if (i%3==0) {
        System.out.println("foo");
      }
      if (i%5==0) {
        System.out.println("bar");
      }
      if(i%3!=0 && i%5!=0){
        System.out.println(i);
      }
      
      
    } // end of for
  System.out.println("\nEnde"); 
  }
}  
