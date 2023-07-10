import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        loadMenu();
    }
    static Scanner s1 = new Scanner(System.in);
    static String planeSeats[][] = {   {"A","A","A","A","A","A"},
                                {"A","A","A","A","A","A"},
                                {"A","A","A","A","A","A"},
                                {"A","A","A","A","A","A"}
    };

    public static void loadMenu(){
        int command;

        do{
            System.out.println("Main Menu");
            System.out.println("1. View Plane Seats");
            System.out.println("2. Purchase Ticked");
            System.out.println("0. Exit");

            command = s1.nextInt();

            switch(command) {
                case 1:
                    printPlaneSeats();
                    break;
                case 2:
                    purchaseTicket();
                    break;
                case 0:
                    System.out.println("Shutting Down...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }while(command != 0);
    }

    public static void printPlaneSeats(){

        System.out.println("Seating Options:");
        System.out.println();
        System.out.println("  123   456");

        for(int i=0; i<planeSeats.length;i++){
            System.out.print(i+1 + " ");
            for(int j=0;j<planeSeats[i].length;j++){
                if(j==3){
                    System.out.print("   ");
                }
                System.out.print(planeSeats[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void purchaseTicket(){

        int seatNum;
        int seatRow;
        int ticketPrice = 100;

        System.out.println("Do you want to pick your seat?   1. Yes 2.No");
        int choice = s1.nextInt();

        if(choice == 1){
            int seatCost = 10;

            System.out.println("Enter Row Number:");
            seatRow = s1.nextInt();
            System.out.println("Enter Seat Number:");
            seatNum = s1.nextInt();

            planeSeats[seatRow-1][seatNum-1] = "X";
            ticketPrice = ticketPrice + seatCost;

            System.out.println("Total ticket price is £" + ticketPrice + ".00");
        }
        else if(choice == 2){
            Random rand = new Random();
            seatRow = rand.nextInt(4);
            seatNum = rand.nextInt(6);
            planeSeats[seatRow][seatNum] = "X";
            System.out.println("Total ticket price is £" + ticketPrice + ".00");
            System.out.println();
        }
        else{
            System.out.println("Error! Invalid option");
        }

    }
}
