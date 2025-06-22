import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter a number: "); 
            int number = sc.nextInt(); // Explore: string, float, double, boolean, char
            switch (number) {
                case 1:
                    System.out.println("You entered one.");
                    break;
                
                case 2:
                    System.out.println("You entered two.");
                    break;
                
                case 3:
                    System.out.println("You entered three.");
                    break;
                
                case 4:
                    System.out.println("You entered four.");
                    break;
                
                default:
                    System.out.println("You entered a number other than one, two, three, or four.");
            }
        }
    }
}
