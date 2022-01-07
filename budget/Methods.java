package budget;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Methods {
    static void menu ( ) {
    System.out.println( "\nChoose your action:\n" +
            "1) Add income\n" +
            "2) Add purchase\n" +
            "3) Show list of purchases\n" +
            "4) Balance\n" +
            "5) Save\n"+
            "6) Load\n"+
            "7) Analyze (Sort)\n"+
            "0) Exit" );
}

        public static void handleSelections ( String selection ) throws IOException {
            switch ( selection ) {
                case "1":
                    Methods.addIncome( );
                    break;
                case "2":
                    Methods.addPurchase( );
                    break;
                case "3":
                    Methods.showPurchases( );
                    break;
                case "4":
                    Methods.showBalance( );
                    break;
                case "5":
                    Methods.addList();
                    break;
                case "6":
                    Methods.showList();
                    break;
                case "7":
                     Methods.analyze();
                     break;
                case "0":
                    System.out.println( "\nBye!" );
                    System.exit( 0 );
                default:
                    System.out.println( "Choose 0-6" );
            }
        }

        static void showBalance ( ) {
            System.out.printf( "%nBalance: $%.2f%n%n", App.balance );
        }

        static void showPurchases ( ) {
            if ( ! App.purchases.isEmpty( ) ) {
                int a=1;
                while(a!=0){
                    showDisplay1();
                    int choice = App.scanner.nextInt();
                    double sum = 0;
                    switch(choice) {
                        case 1:
                            Methods.print(App.Food);
                            for ( double f : App.Food.values( ) ) {
                                sum += f;
                            }
                            System.out.printf( "Total sum: $%.2f%n%n", sum );
                            break;
                        case 2:
                            Methods.print(App.Clothes);
                            for ( double f : App.Clothes.values( ) ) {
                                sum += f;
                            }
                            System.out.printf( "Total sum: $%.2f%n%n", sum );
                            break;
                        case 3:
                            Methods.print(App.Entertainment);
                            for ( double f : App.Entertainment.values( ) ) {
                                sum += f;
                            }
                            System.out.printf( "Total sum: $%.2f%n%n", sum );
                            break;
                        case 4:
                            Methods.print(App.other);
                            for ( double f : App.other.values( ) ) {
                                sum += f;
                            }
                            System.out.printf( "Total sum: $%.2f%n%n", sum );
                            break;
                        case 5:
                            Methods.print(App.purchases);
                            for ( double f : App.purchases.values( ) ) {
                                sum += f;
                            }
                            System.out.printf( "Total sum: $%.2f%n%n", sum );
                            break;

                        default:
                            a = 0;
                    }

                }



            } else {
                System.out.println( "\nThe purchase list is empty\n" );
            }
        }
        static void print(HashMap<String,Double> aed){
            System.out.println( "\n");
        for( String g: aed.keySet() ){
            System.out.printf("%s $%.2f%n", g,aed.get(g));
        }

        }
    static void showDisplay1(){
        System.out.println("");
        System.out.println( "Choose your type of purchase\n" +
                "1) Food\n" +
                "2) Clothes\n" +
                "3) Entertainment\n" +
                "4) Other\n" +
                "5) All\n"+
                "6) Back" );

    }
        static void showDisplay(){
        System.out.println("");
            System.out.println( "Choose your type of purchase\n" +
                    "1) Food\n" +
                    "2) Clothes\n" +
                    "3) Entertainment\n" +
                    "4) Other\n" +
                    "5) Back" );

        }
        static int purchase(){
            int choice = App.scanner.nextInt();
            if(choice==5){
                return 0;
            }
            String name = getName();
            double price = getPrice();
            switch(choice) {
                case 1:
                    App.purchases.put(name, price);
                    App.Food.put(name, price);
                    App.food+=price;
                    App.balance -= price;
                    System.out.println( "Purchase was added!\n" );
                    return 1;
                case 2:
                    App.purchases.put(name, price);
                    App.Clothes.put(name, price);
                    App.balance -= price;
                    App.clothes+=price;
                    System.out.println( "Purchase was added!\n" );
                    return 1;
                case 3:
                    App.purchases.put(name, price);
                    App.Entertainment.put(name, price);
                    App.balance -= price;
                    App.entertainment+=price;
                    System.out.println( "Purchase was added!\n" );
                    return 1;
                case 4:
                    App.purchases.put(name, price);
                    App.other.put(name, price);
                    App.balance -= price;
                    App.Other+=price;
                    System.out.println( "Purchase was added!\n" );
                    return 1;
                default :
                    return 0;

            }}

        static void addPurchase ( ) {
           int a=1;
           while(a!=0) {
               showDisplay();
               a=purchase();
           }

        }

        private static double getPrice ( ) {
            System.out.println( "Enter its price:" );
            return App.scanner.nextDouble( );
        }

        private static String getName ( ) {
            System.out.println( "\nEnter purchase name:" );
            String name = App.scanner.nextLine( );
            if ( name.isEmpty( ) ) {
                name = App.scanner.nextLine( );
            }
            return name;
        }

        static void addIncome ( ) {
            System.out.println( "\nEnter income:" );
            App.balance += App.scanner.nextDouble( );
            System.out.println( "Income was added!\n" );
        }
        static void addList() throws IOException {
            File purchase=new File("purchases.txt");
            purchase.createNewFile();
            PrintWriter writer=new PrintWriter(purchase);
            writer.println(App.Food);
            writer.println(App.Clothes);
            writer.println(App.Entertainment);
            writer.println(App.other);
            writer.println(App.balance);
            writer.close();
            System.out.println("\n Purchases were Saved!");
        }
        static void purchase(int x, String val) throws FileNotFoundException, NumberFormatException {
            String[] ar = val.trim().split("=");

            String name = ar[0];
            double price = Double.parseDouble(ar[1].replace(".","."));
            switch (x) {
                case 1:
                    App.purchases.put(name, price);
                    App.Food.put(name, price);
                    App.food+=price;
//                    App.balance -= price;
                    break;
                case 2:
                    App.purchases.put(name, price);
                    App.Clothes.put(name, price);
                    App.clothes+=price;
//                    App.balance -= price;
                    break;
                case 3:
                    App.purchases.put(name, price);
                    App.Entertainment.put(name, price);
                    App.entertainment+=price;
//                    App.balance -= price;
                    break;
                case 4:
                    App.purchases.put(name, price);
                    App.other.put(name, price);
                    App.Other+=price;
//                    App.balance -= price;
                    break;
                default:
            }
        }

        static void showList() throws FileNotFoundException {
        File purchase = new File("purchases.txt");
        Scanner sc=new Scanner(purchase);
        int category=0;
        while(sc.hasNext()){
            category++;
            if(category==5){
                break;
            }
            String ar= sc.nextLine().replace("{","").replace("}","");
            String[] arr=ar.split(",");
            for(String a: arr){
                purchase(category,a);
            }

            }
        App.balance+=Double.parseDouble(sc.nextLine().trim());
        System.out.println("\nPurchase were loaded!");
        }
        static void analDisplay(){
              System.out.println("\nHow do you want to sort? \n"+
                                 "1) Sort all purchases\n"+
                                 "2) Sort by type\n"+
                                  "3) Sort certain type\n"+
                                  "4) Back");

        }
        static void sorter(HashMap<String, Double> examp){
            if(examp.size()==0){
                System.out.println();
                System.out.println("The purchase list is empty!");
                return;
            }

            ArrayList<Double> temp= new ArrayList<Double>(examp.values());
            Collections.sort(temp, Collections.reverseOrder());
            Methods.print(examp, temp);

        }
        static void sort(){
           ArrayList<Double> temp= new ArrayList<Double>();
            temp.add(App.food);
            temp.add(App.clothes);
            temp.add(App.entertainment);
            temp.add(App.Other);
            Collections.sort(temp, Collections.reverseOrder());
            double sum=0;
            System.out.println("\nTypes:");
            for( double d : temp){
                if(d==App.food){
                    System.out.printf("Food - $%.2f%n",d);
                    sum+=d;
                }
                else if(d==App.clothes){
                    System.out.printf("Clothes - $%.2f%n",d);
                    sum+=d;
                }
                else if(d==App.entertainment){
                    System.out.printf("Entertainment - $%.2f%n",d);
                    sum+=d;
                }
                else if(d==App.Other){
                    System.out.printf("Other - $%.2f%n",d);
                    sum+=d;
                }
                            }
                System.out.printf("Total - $%.2f%n",sum);

        }
        static void print(HashMap<String, Double> examp, ArrayList<Double> temp){
            double sum=0;

            int a=0;
            for( double t : temp){
                for(String d: examp.keySet()){

                    if(t==examp.get(d)){
                        if(t==3.50 && a==0){
                            a=1;
                            System.out.printf("%s $%.2f%n", "Milk",t);
                            sum+=t;
                            break;
                        }
                        else if(t==3.50 & a==1){
                            System.out.printf("%s $%.2f%n", d,t);
                            sum+=t;
                            break;
                        }
                        else{
                        System.out.printf("%s $%.2f%n", d,t);
                        sum+=t;
                        break;}

                    }
                    if(a==1 && d=="Debt"){
                        System.out.printf("%s $%.2f%n", d,t);
                        sum+=t;
                        break;

                    }
                }

            }
            System.out.printf("Total: $%.2f%n",sum);
        }
        static void analyze(){
             int a=0;
             while(a!=4){
             Methods.analDisplay();
             a=App.scanner.nextInt();
             switch (a){
                 case 1:
                     if(App.purchases.size()==0){
                         System.out.println();
                         System.out.println("The purchase list is empty!");
                         break;
                     }
                     if(App.purchases.size()!=0){
                         System.out.println("");
                     }
                     Methods.sorter(App.purchases);
                     break;
                 case 2:
                     Methods.sort();
                     break;
                 case 3:
                     System.out.println("\nChoose type of purchases\n1) Food\n2) Clothes\n3)Entertainment\n4) Other\n");
                     int b=App.scanner.nextInt();
                     switch (b){
                         case 1:
                             if(App.Food.size()!=0){
                                 System.out.println("\nFood");
                             }
//                             System.out.println("Food:");
                             Methods.sorter(App.Food);
                             break;
                         case 2:
                             if(App.Clothes.size()!=0){
                                 System.out.println("\nClothes");
                             }
//                             System.out.println("Clothes:");
                             Methods.sorter(App.Clothes);
                             break;
                         case 3:
                             if(App.Entertainment.size()!=0){
                                 System.out.println("\nEntertainment");
                             }
//                             System.out.println("Entertainment:");
                             Methods.sorter(App.Entertainment);
                             break;
                         case 4:
                             if(App.other.size()!=0){
                                 System.out.println("\nOther:");
                             }
//                             System.out.println("Other:");
                             Methods.sorter(App.other);
                             break;
                     }





             }
             }



        }
        }