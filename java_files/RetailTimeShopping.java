import java.util.Scanner;

public class RetailTimeShopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String code, description;
        int quantity, totalQuantity = 0;
        double price, itemTotal, grandTotal = 0;

        System.out.print("Enter number of items: ");
        int itemCount = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        // Level 1 & 2: Loop for multiple item entry
        for (int i = 1; i <= itemCount; i++) {
            System.out.println("\nItem " + i + " details:");
            System.out.print("Enter item code: ");
            code = sc.nextLine();

            System.out.print("Enter item description: ");
            description = sc.nextLine();

            System.out.print("Enter quantity: ");
            quantity = sc.nextInt();

            System.out.print("Enter price per item: ");
            price = sc.nextDouble();
            sc.nextLine(); // consume newline

            itemTotal = quantity * price;
            totalQuantity += quantity;
            grandTotal += itemTotal;

            System.out.println("Total for item '" + description + "' (Code: " + code + "): ₹" + itemTotal);
        }

        // Level 3: Discounts and surcharges
        System.out.println("\n--- Applying Discounts and Surcharges ---");
        double discount = 0;
        double surcharge = 0;

        if (grandTotal > 10000) {
            discount = 0.10 * grandTotal;
            grandTotal -= discount;
            System.out.println("Applied 10% discount: ₹" + discount);
        }

        System.out.print("Enter payment method (cash/card): ");
        String paymentMethod = sc.nextLine();
        if (grandTotal < 1000 && paymentMethod.equalsIgnoreCase("card")) {
            surcharge = 0.025 * grandTotal;
            grandTotal += surcharge;
            System.out.println("Applied 2.5% card surcharge: ₹" + surcharge);
        }

        if (totalQuantity > 20) {
            double qtyDiscount = 0.05 * grandTotal;
            grandTotal -= qtyDiscount;
            System.out.println("Applied 5% quantity discount (for buying more than 20 items): ₹" + qtyDiscount);
        }

        // Level 4: Membership discount
        System.out.print("Are you a member? (y/n): ");
        String isMember = sc.nextLine();

        if (isMember.equalsIgnoreCase("y")) {
            double memberDiscount = 0.02 * grandTotal;
            grandTotal -= memberDiscount;
            System.out.println("Applied 2% membership discount: ₹" + memberDiscount);
        }

        System.out.println("\n========== FINAL INVOICE ==========");
        System.out.println("Total Quantity Purchased: " + totalQuantity);
        System.out.printf("Final Grand Total: ₹%.2f\n", grandTotal);
        System.out.println("Thank you for shopping with us!");
    }
}
