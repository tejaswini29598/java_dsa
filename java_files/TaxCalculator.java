import java.util.*;
public class TaxCalculator {
    public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter location (cosmopolitan/semiurban/rural): ");
        String location = scanner.nextLine().toLowerCase();
        System.out.print("Enter designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter basic salary: ");
        double basic = scanner.nextDouble();

        
        double hra = 0;
        if (location.equals("cosmopolitan")) {
            hra = 0.15 * basic;
        } else if (location.equals("semiurban")) {
            hra = 0.10 * basic;
        } else if (location.equals("rural")) {
            hra = 0.05 * basic;
            } else {
            System.out.println("Invalid location. Assuming rural.");
            hra = 0.05 * basic;
        }
        double da = 0.12 * basic;
        double monthlyBonus = 0.20 * basic;

        // Level 1 Calculations
        double monthlySalaryWithoutBonus = basic + hra + da;
        double monthlyGrossSalary = monthlySalaryWithoutBonus + monthlyBonus;
        double annualGrossSalary = monthlyGrossSalary * 12;
        double annualBonus = monthlyBonus * 12;

        // Level 2: Deductions
        System.out.print("Enter charity amount under 80G: ");
        double charity = scanner.nextDouble();
        System.out.print("Enter interest paid on home loan: ");
        double homeLoanInterest = scanner.nextDouble();
        if (homeLoanInterest > 120000) homeLoanInterest = 120000;

        System.out.print("Eligible for Section 87 deduction? (yes/no): ");
        scanner.nextLine(); 
        String eligible87 = scanner.nextLine().toLowerCase();
        double section87 = eligible87.equals("yes") ? 300000 : 0;

        
        double totalDeductions = charity + homeLoanInterest + section87;

        
        double taxableIncome = annualGrossSalary - totalDeductions;
        if (taxableIncome < 0) taxableIncome = 0;

        // Level 2: Tax Calculation
        double tax = 0;
        double income = taxableIncome;

        if (income > 2000000) {
            tax += (income - 2000000) * 0.30;
            income = 2000000;
        }
        if (income > 1500000) {
            tax += (income - 1500000) * 0.25;
            income = 1500000;
        }
        if (income > 1200000) {
            tax += (income - 1200000) * 0.20;
            income = 1200000;
        }
        if (income > 1000000) {
            tax += (income - 1000000) * 0.20;
            income = 1000000;
        }
        if (income > 800000) {
            tax += (income - 800000) * 0.15;
            income = 800000;
        }
        if (income > 500000) {
            tax += (income - 500000) * 0.10;
            income = 500000;
        }
      

        // Level 3: Print all details
        System.out.println("\n--- Employee Details ---");
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Designation: " + designation);

        System.out.println("\n--- Salary Details ---");
        System.out.printf("Basic Salary: %.2f\n", basic);
        System.out.printf("Monthly Gross Salary: %.2f\n", monthlyGrossSalary);
        System.out.printf("Annual Gross Salary: %.2f\n", annualGrossSalary);
        System.out.printf("Annual Bonus: %.2f\n", annualBonus);
         System.out.println("\n--- Tax Calculation ---");
        System.out.printf("Taxable Income: %.2f\n", taxableIncome);
        System.out.printf("Total Standard Deductions: %.2f\n", totalDeductions);
        System.out.printf("Tax Amount Payable: %.2f\n", tax);

        scanner.close();
    }
    }

}
