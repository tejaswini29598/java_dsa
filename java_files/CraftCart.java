import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.printf("Product ID: %d | Name: %s | Price: Rs%.2f\n", id, name, price);
    }
}

class CartItem {
    Product product;
    int quantity;

    // Required constructor
    CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    double getTotalPrice() {
        return product.price * quantity;
    }

    void display() {
        System.out.printf(" - %s x %d = Rs%.2f\n", product.name, quantity, getTotalPrice());
    }
}

class Order {
    int orderId;
    List<CartItem> items;
    String customerName;
    String status;
    LocalDate orderDate;
    LocalDate deliveryDate;
    double totalPrice;
    double discount;
    double finalPrice;

    Order(int orderId, List<CartItem> items, String customerName) {
        this.orderId = orderId;
        this.items = items;
        this.customerName = customerName;
        this.status = "Placed";
        this.orderDate = LocalDate.now();
        this.deliveryDate = orderDate.plusDays(5);
        calculateTotals();
    }

    void calculateTotals() {
        totalPrice = 0;
        for (CartItem item : items) {
            totalPrice += item.getTotalPrice();
        }

        if (totalPrice >= 3000) discount = 0.40;
        else if (totalPrice >= 2000) discount = 0.25;
        else if (totalPrice >= 1000) discount = 0.15;
        else discount = 0;

        finalPrice = totalPrice - (totalPrice * discount);
    }

    long daysRemaining() {
        return LocalDate.now().until(deliveryDate, ChronoUnit.DAYS);
    }

    void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    void displayStatus() {
        System.out.printf(
            "Order ID: %d | Customer: %s | Items: %d | Status: %s\n",
            orderId, customerName, items.size(), status
        );
        System.out.printf("Total: Rs%.2f | Payable: Rs%.2f | Delivery in %d day(s)\n",
                totalPrice, finalPrice, daysRemaining());
    }

    void printInvoice() {
        System.out.println("\n————— INVOICE —————");
        System.out.println("Order ID     : " + orderId);
        System.out.println("Customer     : " + customerName);
        System.out.println("Order Date   : " + orderDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy")));
        System.out.println("Delivery ETA : " + deliveryDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy")));
        System.out.println("Status       : " + status);
        System.out.println("\nItems:");
        for (CartItem item : items) {
            item.display();
        }
        System.out.printf("\nSubtotal     : Rs%.2f\n", totalPrice);
        System.out.printf("Discount     : %.0f%%\n", discount * 100);
        System.out.printf("Total Payable: Rs%.2f\n", finalPrice);
        System.out.printf("Delivery in  : %d day(s)\n", daysRemaining());
        System.out.println("——————————————————————");
    }
}

public class CraftCart {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, Product> catalog = new HashMap<>();
    static List<Order> orders = new ArrayList<>();
    static int orderCounter = 1000;

    public static void main(String[] args) {
        initCatalog();
        System.out.println("Welcome to CraftCart!");
        while (true) {
            System.out.println("\nLogin as:");
            System.out.println("1. User");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            int loginChoice = sc.nextInt();
            sc.nextLine();

            switch (loginChoice) {
                case 1 -> userMenu();
                case 2 -> adminMenu();
                case 3 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void initCatalog() {
        catalog.put(101, new Product(101, "woodencraft", 350));
        catalog.put(102, new Product(102, "paintings", 220));
        catalog.put(103, new Product(103, "handmade craft", 499));
        catalog.put(104, new Product(104, "handloom", 599));
        catalog.put(105, new Product(105, "sculpture", 699));
    }

    private static void userMenu() {
        System.out.print("Enter your name: ");
        String userName = sc.nextLine();
        List<CartItem> cart = new ArrayList<>();

        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1. View Catalog");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. Remove Item from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.println("6. Track My Orders");
            System.out.println("7. Print Invoice");
            System.out.println("8. Logout");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> viewCatalog();
                case 2 -> addItemToCart(cart);
                case 3 -> removeItemFromCart(cart);
                case 4 -> viewCart(cart);
                case 5 -> {
                    if (cart.isEmpty()) {
                        System.out.println("Your cart is empty. Add items before placing order.");
                    } else {
                        placeOrder(cart, userName);
                        cart.clear();
                    }
                }
                case 6 -> trackOrders(userName);
                case 7 -> printInvoices(userName);
                case 8 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. View All Orders");
            System.out.println("2. Update Order Status");
            System.out.println("3. Logout");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    if (orders.isEmpty()) System.out.println("No orders yet.");
                    else orders.forEach(Order::displayStatus);
                }
                case 2 -> updateOrderStatus();
                case 3 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void viewCatalog() {
        System.out.println("\nProduct Catalog:");
        for (Product p : catalog.values()) {
            p.display();
        }
    }

    private static void addItemToCart(List<CartItem> cart) {
        System.out.print("Enter Product ID to add: ");
        int pid = sc.nextInt();
        sc.nextLine();
        if (!catalog.containsKey(pid)) {
            System.out.println("Invalid Product ID.");
            return;
        }
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();
        sc.nextLine();
        if (qty <= 0) {
            System.out.println("Quantity must be positive.");
            return;
        }
        for (CartItem item : cart) {
            if (item.product.id == pid) {
                item.quantity += qty;
                System.out.println("Updated quantity for " + item.product.name + " to " + item.quantity);
                return;
            }
        }
        cart.add(new CartItem(catalog.get(pid), qty));
        System.out.println("Added " + catalog.get(pid).name + " x" + qty + " to cart.");
    }

    private static void removeItemFromCart(List<CartItem> cart) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.print("Enter Product ID to remove from cart: ");
        int pid = sc.nextInt();
        sc.nextLine();
        Iterator<CartItem> it = cart.iterator();
        boolean removed = false;
        while (it.hasNext()) {
            CartItem item = it.next();
            if (item.product.id == pid) {
                it.remove();
                System.out.println("Removed " + item.product.name + " from cart.");
                removed = true;
                break;
            }
        }
        if (!removed) System.out.println("Product not found in cart.");
    }

    private static void viewCart(List<CartItem> cart) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("\nCurrent Cart:");
        double total = 0;
        for (CartItem item : cart) {
            item.display();
            total += item.getTotalPrice();
        }
        System.out.printf("Cart Subtotal: Rs%.2f\n", total);
    }

    private static void placeOrder(List<CartItem> cart, String customerName) {
        Order order = new Order(orderCounter++, new ArrayList<>(cart), customerName);
        orders.add(order);
        System.out.println("Order placed successfully! Order ID: " + order.orderId);
    }

    private static void trackOrders(String customerName) {
        boolean found = false;
        for (Order o : orders) {
            if (o.customerName.equalsIgnoreCase(customerName)) {
                o.displayStatus();
                found = true;
            }
        }
        if (!found) System.out.println("No orders found for " + customerName);
    }

    private static void printInvoices(String customerName) {
        boolean found = false;
        for (Order o : orders) {
            if (o.customerName.equalsIgnoreCase(customerName)) {
                o.printInvoice();
                found = true;
            }
        }
        if (!found) System.out.println("No invoices found for " + customerName);
    }

    private static void updateOrderStatus() {
        if (orders.isEmpty()) {
            System.out.println("No orders to update.");
            return;
        }
        System.out.print("Enter Order ID to update: ");
        int oid = sc.nextInt();
        sc.nextLine();
        Optional<Order> orderOpt = orders.stream().filter(o -> o.orderId == oid).findFirst();
        if (orderOpt.isEmpty()) {
            System.out.println("Order ID not found.");
            return;
        }
        Order order = orderOpt.get();
        System.out.print("Enter new status (Placed/Shipped/Delivered): ");
        String status = sc.nextLine();
        if (!status.equalsIgnoreCase("Placed") &&
            !status.equalsIgnoreCase("Shipped") &&
            !status.equalsIgnoreCase("Delivered")) {
            System.out.println("Invalid status.");
            return;
        }
        order.updateStatus(status);
        System.out.println("Order status updated.");
    }
}
