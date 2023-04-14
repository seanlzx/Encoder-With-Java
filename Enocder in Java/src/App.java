import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        char[] reference_table = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, '(', ')', '*', '+', ',', '-', '.', '/'};
        Encoder encoder = new Encoder(
           reference_table,
            'F'            
        );

        System.out.println(
            "Demonstration:\n" +
            "Encode Hello World => " + encoder.encode("HELLO WORLD") + "\n" +
            "Decode FC/ggj Rjmg. => " + encoder.decode("FC/ggj Rjmg.") + "\n" 
        );

        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        byte action = 0;
        String plainText = "";
        String encodedText = "";
        while(action != 3){
            System.out.print(
                "----------------------------------------------" +
                "Enter the following numerical options\n" +
                "1. Encode Text\n" +
                "2. Decode Text\n" +
                "3. Quit\n" +
                "> "
            );

            action = scannerInt.nextByte();

            switch(action){
                case 1:
                    System.out.print("Encode:");
                    plainText = scannerString.nextLine();
                    System.out.println("Encode " + plainText + " => " + encoder.encode(plainText));
                    break;
                case 2:
                    System.out.print("Decode:");
                    encodedText = scannerString.nextLine();
                    System.out.println("Decode " + encodedText + " => " + encoder.decode(encodedText));
                    break;
                default:
                    System.out.println("Invalid Input!");
            }


        }

        scannerInt.close();
        scannerString.close();
    }
}

