package budget;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner( System.in );
    static double balance;
    static HashMap<String, Double> purchases = new HashMap<>( );
    static HashMap<String, Double> Food = new HashMap<>( );
    static HashMap<String, Double> Clothes = new HashMap<>( );
    static HashMap<String, Double> Entertainment = new HashMap<>( );
    static HashMap<String, Double> other = new HashMap<>( );
    static double food=0;
    static double clothes=0;
    static double entertainment=0;
    static double Other=0;




    public void run ( ) throws IOException {
        while ( true ) {
            Methods.menu( );
            Methods.handleSelections( scanner.next( ) );
        }
    }

}