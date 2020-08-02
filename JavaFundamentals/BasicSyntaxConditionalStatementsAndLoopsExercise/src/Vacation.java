import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int groupNumber = Integer.parseInt(scan.nextLine());
        String groupType = scan.nextLine();
        String day = scan.nextLine();

       double price = 0.0, discount = 0.0;
       switch (groupType)
       {
           case "Students":
               switch (day)
               {
                   case "Friday":
                       price = groupNumber * 8.45;
                       break;
                   case "Saturday":
                       price = groupNumber * 9.8;
                       break;
                   case "Sunday":
                       price = groupNumber * 10.46;
                       break;
               }
               if (groupNumber >= 30)
                   price *= 0.85;
               break;
           case "Business":
               if (groupNumber >= 100)
                   groupNumber -= 10;
               switch (day) {
                   case "Friday":
                       price = groupNumber * 10.9;
                       break;
                   case "Saturday":
                       price = groupNumber * 15.6;
                       break;
                   case "Sunday":
                       price = groupNumber * 16;
                       break;
               }
               break;
           case "Regular":
               switch (day)
               {
                   case "Friday":
                       price = groupNumber * 15;
                       break;
                   case "Saturday":
                       price = groupNumber * 20;
                       break;
                   case "Sunday":
                       price = groupNumber * 22.5;
                       break;
               }
               if (groupNumber >= 10 && groupNumber <= 20)
                   price *= 0.95;
               break;
       }
        System.out.printf("Total price: %.2f", price);
    }
}
