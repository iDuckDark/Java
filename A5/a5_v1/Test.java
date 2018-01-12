import java.util.ListIterator; 
import java.util.LinkedList; 
 
public class Test { 
 
    public static void main( String[] args ) { 
 
        LinkedList a, b; 
 
        a = new LinkedList(); 
        b = new LinkedList(); 
 
        a.add("alpha"); 
        a.add("bravo"); 
        a.add("tango"); 
        a.add("charlie"); 
 
        ListIterator i, j; 
 
        i = a.listIterator(); 
        j = b.listIterator(); 
 
        while (i.hasNext()) { 
            j.add(i.next()); 
            System.out.println(j);
        } 
 
        System.out.println(a); 
        System.out.println(b); 
 
    } 
}