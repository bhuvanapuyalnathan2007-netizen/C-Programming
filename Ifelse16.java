import java.util.Scanner;
public class Ifelse16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        String roomCategory = sc.nextLine();
        String season = sc.nextLine();
        int nights = sc.nextInt();
        sc.nextLine(); // consume newline
        String loyalty = sc.nextLine();

        double baseRate = 0;
        double seasonalMultiplier = 1.0;
        double extendedDiscount = 0;
        double loyaltyDiscount = 0;

        // Room Category Base Price
        if (roomCategory.equalsIgnoreCase("Standard")) {
            baseRate = 150;
        } else if (roomCategory.equalsIgnoreCase("Deluxe")) {
            baseRate = 300;
        } else if (roomCategory.equalsIgnoreCase("Suite")) {
            baseRate = 500;
        } else if (roomCategory.equalsIgnoreCase("Presidential")) {
            baseRate = 1000;
        }

        // Season Multiplier
        if (season.equalsIgnoreCase("Off-Peak")) {
            seasonalMultiplier = 0.7;
        } else if (season.equalsIgnoreCase("Regular")) {
            seasonalMultiplier = 1.0;
        } else if (season.equalsIgnoreCase("Peak")) {
            seasonalMultiplier = 1.5;
        } else if (season.equalsIgnoreCase("Holiday")) {
            seasonalMultiplier = 2.0;
        }

        // Extended Stay Discount
        if (nights >= 7 && nights <= 14) {
            extendedDiscount = 0.10;
        } else if (nights > 14) {
            extendedDiscount = 0.20;
        }

        // Loyalty Discount
        if (loyalty.equalsIgnoreCase("Member")) {
            loyaltyDiscount = 0.05;
        } else if (loyalty.equalsIgnoreCase("Gold")) {
            loyaltyDiscount = 0.15;
        } else if (loyalty.equalsIgnoreCase("Platinum")) {
            loyaltyDiscount = 0.25;
        }

        // Calculations
        double priceAfterSeason = baseRate * seasonalMultiplier;
        double priceAfterExtended = priceAfterSeason * (1 - extendedDiscount);
        double finalNightRate = priceAfterExtended * (1 - loyaltyDiscount);
        double totalCost = finalNightRate * nights;

        // Complimentary upgrades
        String upgrades = "None";
        if (loyalty.equalsIgnoreCase("Gold") || loyalty.equalsIgnoreCase("Platinum")) {
            upgrades = "Free breakfast and spa access";
        }

        // Output
        System.out.println("Room Category: " + roomCategory);
        System.out.println("Season: " + season);
        System.out.println("Nights Booked: " + nights);
        System.out.println("Loyalty Tier: " + loyalty);
        System.out.println("Base Rate Per Night: $" + baseRate);
        System.out.println("Seasonal Multiplier: " + seasonalMultiplier + "x");
        System.out.println("Extended Stay Discount: " + (extendedDiscount * 100) + "%");
        System.out.println("Loyalty Discount: " + (loyaltyDiscount * 100) + "%");
        System.out.println("Nightly Rate: $" + finalNightRate);
        System.out.println("Total Booking Cost: $" + totalCost);
        System.out.println("Complimentary Upgrades: " + upgrades);
    }
}

