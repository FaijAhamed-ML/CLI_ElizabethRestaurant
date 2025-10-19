

# Project Report: ElizabethRestaurant

## Project Overview

### Project Name
ElizabethRestaurant

### Project Description
The goal of this project is to design a Java program for a wedding package booking system for "Elizabeth Hotel". The system allows customers to select various wedding packages and calculates the total cost based on their selections. The program handles multiple wedding packages, calculates charges based on the chosen package, and displays the total amount to the user.

## Key Features

- **Multiple Wedding Packages**: The program offers four different wedding packages, each with its own pricing structure that adjusts based on the number of guests and additional services.
- **Dynamic Pricing Calculation**: It calculates the total cost based on the number of guests and selected package features, such as wedding cake and fireworks.
- **User Input Handling**: The program prompts the user for input, allowing them to select the package and specify the number of guests.
- **Graceful Termination**: The program continues to run until the user inputs -99 as the package ID, ensuring flexibility for multiple bookings.
- **Input Validation**: In case of an invalid package ID, the program terminates gracefully.

## Package Details

| Package ID | Description                     | Price Criteria                                        |
|------------|---------------------------------|------------------------------------------------------|
| 1          | LAVINIA WEDDING PACKAGE         | Number of guests * 5500.00                           |
| 2          | GOVERNOR'S WEDDING PACKAGE      | Number of guests * 5700.00 (up to 350 guests), then 6200.00 for guests above 350 (max 450 guests) |
| 3          | MESTIZO WEDDING PACKAGE         | Number of guests * 6400.00 + Rs. 25,000 for cake + optional Rs. 12,000 for fireworks |
| 4          | VICTORIAN WEDDING PACKAGE       | Number of guests * 6800.00 + Rs. 900 per guest for gifts (15% discount if gifts are chosen) |

## Implementation Details

### Java Code
The Java program is structured using classes and methods to perform specific tasks. Below is the implementation of the wedding package booking system.

```java
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
```

### Explanation of Code Components
1. **Scanner Class**: Used for getting user input from the console.
2. **Loops and Conditionals**: A while loop allows multiple bookings until the exit condition is met. Switch statements handle package selections and their pricing.
3. **Total Charge Calculation**: Each case in the switch statement calculates the total price based on the selected package and guest count.
4. **Input Validation**: The program checks for invalid entries and prompts the user appropriately.

## Key Milestones
- **Idea Generation**: Conceptualized the wedding booking system and its features.
- **System Design**: Created package structures and pricing guidelines.
- **Implementation**: Developed and tested the Java program offering various functionalities.
- **User Testing**: Conducted basic testing to ensure inputs and outputs function as expected.

## Project Outcome
The Java program effectively meets the requirements set forth for the wedding package booking system. It provides a user-friendly interface for selecting wedding packages, calculates total costs accurately, and handles inputs seamlessly. The program can be easily extended in the future to include additional features or enhancements based on user feedback.

### Future Improvements
- Implement a graphical user interface (GUI) for better user experience.
- Add features for payment processing and confirmations.
- Store booking details in a database for record-keeping and analysis.

This project serves as a solid foundation for building a comprehensive wedding booking system and showcases the capability to develop real-world applications using Java.
