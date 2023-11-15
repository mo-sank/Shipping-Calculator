
import java.util.Scanner;

public class ShippingCalculator {

    /**
     * Declares constants for the charged rates of the different types of shipping.
     */

    static final double OVERNIGHT_CHARGE = 5.0;
    static final double TWO_DAY_CHARGE = 2.0;
    static final double ECONOMY_CHARGE = 1.0;


    public static void main(String[] args) {


        Scanner console = new Scanner(System.in);  // Scanner object to pass around.

        // Get item description.
        String itemDescription = getItemDescription(console);

        if (itemDescription.equals("")) {
            System.out.println("Invalid description.");
            return;
        }

        double shipWeight = getShipWeight(console);
        if (shipWeight <= 0.0) {
            System.out.println("Invalid weight.");
            return;
        }

        // Get shipping method and convert to uppercase.
        char shipMethod = getShipMethod(console);
        shipMethod = Character.toUpperCase(shipMethod);
        if (shipMethod != 79 && shipMethod != 84 && shipMethod != 69) {
            System.out.println("Invalid shipping method.");
            return;
        }

        // Calculate shipping cost and display results.
        double shipCost = calculateShipping(shipMethod, shipWeight);
        displayResults(itemDescription, shipWeight, shipMethod, shipCost);
    }

    // Prompts the user for the item description and returns it.
    public static String getItemDescription(Scanner console) {
        System.out.print("Enter item description: ");
        String description = console.nextLine();
        return description;
    }

    // Prompts the user for the item weight and returns it.
    public static double getShipWeight(Scanner console) {
        System.out.print("Enter item weight (in lbs): ");
        double weight = console.nextDouble();

        return weight;
    }

    // Prompts the user for the shipping method and returns it.
    public static char getShipMethod(Scanner console) {
        char method;

        System.out.print("Enter ship method (O)vernight - (T)wo Days - (E)conomy: ");
        method = console.next().charAt(0);  // I've been told to leave this line in here.
        // Will be explained in class.
        return method;
    }

    // Calculates and returns the shipping charge.
    public static double calculateShipping(char method, double weight) {

        double shipCharge = 0.0;

        if (method == 'O') {
            shipCharge = weight * OVERNIGHT_CHARGE;
        } else if (method == 'T') {
            shipCharge = weight * TWO_DAY_CHARGE;
        } else shipCharge = weight * ECONOMY_CHARGE;
        return shipCharge;
    }

    // Print shipping charge invoice.
    public static void displayResults(String description, double weight,
                                      char method, double cost) {
        System.out.println("*** WE SHIP INVOICE ***");
        System.out.println("Item Description: " + description);
        System.out.printf("Item Weight: %.2f\n", weight);
        System.out.println("Ship Method: " + method);
        System.out.printf("Total Cost: $%.2f\n", cost);
    }
}
