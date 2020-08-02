import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double money = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double lightsabers = Double.parseDouble(scan.nextLine());
        double robes = Double.parseDouble(scan.nextLine());
        double belt = Double.parseDouble(scan.nextLine());

        double lightPrice = (students + Math.ceil(students * 0.1)) * lightsabers;
        double robesPrice = students * robes;
        double beltPrice = (students - Math.floor(students / 6.0)) * belt;

        double allNeedMoney = lightPrice + robesPrice + beltPrice;

        if (allNeedMoney <= money)
            System.out.printf("The money is enough - it would cost %.2flv.", allNeedMoney);
        else
            System.out.printf("Ivan Cho will need %.2flv more.", allNeedMoney - money);
    }
}
