import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        // Creating an IceCream object statically (Compile Time)
//        IIceCream another = new IceCream("Coffee");
//        another = new FlavorDecorator(another, "Vanilla");
//        another = new ContainerDecorator(another, "Bowl");
//
//        List<String> anotherToppings = new ArrayList<>();
//        anotherToppings.add("Nuts");
//        anotherToppings.add("Cookies");
//
//        another = new ToppingsDecorator(another, anotherToppings);
//
//        another.serve();

        // -----------------------------------------------------------------

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Marga's Ice Cream Shop");

        // Choose the first flavor
        System.out.println("Which flavor of ice cream do you want?");
        System.out.println("Options: (Enter the number)");
        System.out.println("1. Chocolate");
        System.out.println("2. Strawberry");
        System.out.println("3. Vanilla");
        System.out.println("4. Matcha");
        System.out.println("5. Ube Macapuno");
        System.out.println("6. Salted Caramel");
        System.out.print("Choice: ");
        int flavorChoice = scanner.nextInt();


        // Creation of Object
        IIceCream iceCream = new IceCream(getFlavor(flavorChoice));

        // Ask if the user wants a second flavor
        System.out.println("Do you want a second flavor?");
        System.out.println("Options:");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Choice: ");
        int secondFlavorChoice = scanner.nextInt();

        if (secondFlavorChoice == 1) {
            System.out.println("Which flavor of ice cream do you want next?");
            System.out.println("Options: (Enter the number)");
            System.out.println("1. Chocolate");
            System.out.println("2. Strawberry");
            System.out.println("3. Vanilla");
            System.out.println("4. Matcha");
            System.out.println("5. Ube Macapuno");
            System.out.println("6. Salted Caramel");
            System.out.print("Choice: ");
            int secondFlavorChoiceNumber = scanner.nextInt();
            iceCream = new FlavorDecorator(iceCream, getFlavor(secondFlavorChoiceNumber));
        }

        // Choose the container
        System.out.println("Do you want it in a cup or on a cone?");
        System.out.println("Options:");
        System.out.println("1. Cup");
        System.out.println("2. Cone");
        System.out.print("Choice: ");
        int containerChoice = scanner.nextInt();
        iceCream = new ContainerDecorator(iceCream, getContainerType(containerChoice));

        // Ask if the user wants any toppings
        System.out.println("Do you want any toppings?");
        System.out.println("Options:");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Choice: ");
        int toppingsChoice = scanner.nextInt();

        if (toppingsChoice == 1) {
            List<String> selectedToppings = selectToppings(scanner);
            iceCream = new ToppingsDecorator(iceCream, selectedToppings);
        }

        // Serve the ice cream
        iceCream.serve();

        System.out.println("Thank you and come again!");
        scanner.close();
    }

    private static String getFlavor(int choice) {
        switch (choice) {
            case 1:
                return "Chocolate";
            case 2:
                return "Strawberry";
            case 3:
                return "Vanilla";
            case 4:
                return "Matcha";
            case 5:
                return "Ube Macapuno";
            case 6:
                return "Salted Caramel";
            default:
                return "Unknown Flavor!";
        }
    }

    private static String getContainerType(int choice) {
        return (choice == 1) ? "Cup" : "Cone";
    }

    private static List<String> selectToppings(Scanner scanner) {
        List<String> toppings = new ArrayList<>();

        int numToppings;
        do {
            System.out.println("How many toppings do you want? (up to three only)");
            System.out.print("Choice: ");
            numToppings = scanner.nextInt();

            if (numToppings > 3) {
                System.out.println("You may only have up to 3 toppings.");
            }
        } while(numToppings > 3);

        System.out.println("Choose your toppings");
        System.out.println("Options:");
        System.out.println("1. Chocolate chips");
        System.out.println("2. Marshmallows");
        System.out.println("3. Sprinkles");
        System.out.println("4. Hot fudge");
        System.out.println("5. Cheesecake");
        System.out.println("6. Pistachios");

        int ctr = 0;
        while (ctr < numToppings) {
            System.out.print("Topping " + (ctr+1) + ": ");
            int toppingChoice = scanner.nextInt();
            if (toppingChoice >= 1 && toppingChoice <= 6) {
                toppings.add(getToppingName(toppingChoice));
                ctr++;
            } else {
                System.out.println("Invalid choice. Please choose again.");
            }
        }

        return toppings;
    }

    private static String getToppingName(int choice) {
        switch (choice) {
            case 1:
                return "Chocolate chips";
            case 2:
                return "Marshmallows";
            case 3:
                return "Sprinkles";
            case 4:
                return "Hot fudge";
            case 5:
                return "Cheesecake";
            case 6:
                return "Pistachios";
            default:
                return "Unknown Topping";
        }
    }
}