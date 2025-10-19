import java.util.Scanner;
public class ElizabethHotel {
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);

        int j=1;
        do{
            j=1;
        System.out.println("+-----------------+-------------------------------+-----------------------------------------------------------------+");
        System.out.println("| Package ID      | Description                   | Price criteria                                                  |");
        System.out.println("+-----------------+-------------------------------+-----------------------------------------------------------------+");
        System.out.println("| 1               | LAVINIA WEDDING PACKAGE       | Number of guest  * 5500.00                                      |");
        System.out.println("+-----------------+-------------------------------+-----------------------------------------------------------------+");
        System.out.println("| 2               | GOVERNER'S WEDDING PACKAGE    | Number of guest  * 5700.00 UP TO 350 Guest, and                 |");
        System.out.println("|                 |                               | The rate will increase to 6200.00 for more than 350 Guest,      |");
        System.out.println("|                 |                               | (The event can have at most 450 participents in this package)   |");
        System.out.println("+-----------------+-------------------------------+-----------------------------------------------------------------+");
        System.out.println("| 3               | MESTIZO WEDDING PACKAGE       | Number of guest * 6400.00,                                      |");
        System.out.println("|                 |                               | and wedding cake, and                                           |");
        System.out.println("|                 |                               | fireworks as per the request.                                   |");
        System.out.println("+-----------------+-------------------------------+-----------------------------------------------------------------+");
        System.out.println("| 4               | VICTORIAN WEDDING PACKAGE     | Number of guest * 6800.00,                                      |");
        System.out.println("|                 |                               | and one unique gift (900.00 per one ) for all the guest         |");
        System.out.println("|                 |                               | presesnt. If a user request this gift-providing facility, the   |");
        System.out.println("|                 |                               | user be given a 15% discount from total charge                  |");
        System.out.println("+-----------------+-------------------------------+-----------------------------------------------------------------+");

        System.out.print("Enter the packageID : ");
        int PackageID= input.nextInt();

        int GestCount=0;
        int x=1;
        do { 
            x=1;
            System.out.print("Enetr the guest count : ");
            GestCount= input.nextInt();
            if (GestCount<450 && PackageID==2){
                System.out.println("!!!package 2 not supported for upto 450 guests!!!");
                System.out.println("Please, ReEneter the Gest count!!!!");
                x=2;
            }
            
        } while (x==0);

        

        

        int amount=0;
        double other=0;
        switch (PackageID) {
            case 1:
                amount= 5500;
                other= 0;
                break;
            case 2:
                amount= 5700;
                other=0;
                break;
            case 3:
                amount= 6400;
                other=25000.0;//for cake
                break;
            case 4:
                amount= 6800;
                other= 900*GestCount; //foruniqueGift
                break;
            default:
                
        }

        double amountForGest=(GestCount*amount)+other;
        if (GestCount>350){
            amountForGest+=(GestCount-350)*6200;
        }


        int y=1;
        do{
            if (PackageID==4){
            System.out.println("do you want gift providing facility:(y/n)");
            char want=input.next().charAt(0);
                switch (want) {
                    case 'y':
                    case 'Y':
                        amountForGest *= 1.15;
                        y=1;
                        break;
                    case 'n':
                    case 'N':
                        y=1;
                        break;
                    default:
                        y=0;
                        System.out.println("Enter the correct type (Y/N)!!!");
                        break;
                }
            }
        }while(y==0);
        do{
            if (PackageID==3){
            System.out.println("do you want fireworks facility:(y/n)");
            char want=input.next().charAt(0);
                switch (want) {
                    case 'y':
                    case 'Y':
                        amountForGest +=12000;
                        y=1;
                        break;
                    case 'n':
                    case 'N':
                        y=1;
                        break;
                    default:
                        y=0;
                        System.out.println("Enter the correct type (Y/N)!!!");
                        break;
                }
            }
        }while(y==0);
        if (GestCount==-99||PackageID==-99){
            j=0;
        }

        System.out.println("you want to pay: "+amountForGest);
        }while (j==1);
        
        

    }    
}
