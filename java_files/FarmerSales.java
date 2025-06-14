
public class FarmerSales {
    public static void main(String[] args) {
        
        int totalAcres = 80;
        int segments = 5;
        int acresPerSegment = totalAcres / segments;

        double tomato30 = 0.3 * acresPerSegment; 
        double tomato70 = 0.7 * acresPerSegment;  
        double tomatoYield = (tomato30 * 10) + (tomato70 * 12); 
        double tomatoSales = tomatoYield * 1000 * 7; 

      
        double potatoYield = acresPerSegment * 10; 
        double potatoSales = potatoYield * 1000 * 20; 

        double cabbageYield = acresPerSegment * 14; // in tonnes
        double cabbageSales = cabbageYield * 1000 * 24; // Rs.

        // Sunflower yield and sales
        double sunflowerYield = acresPerSegment * 0.7; // in tonnes
        double sunflowerSales = sunflowerYield * 1000 * 200; // Rs.

        // Sugarcane yield and sales
        double sugarcaneYield = acresPerSegment * 45; 
        double sugarcaneSales = sugarcaneYield * 4000; // Rs.

        double totalSales = tomatoSales + potatoSales + cabbageSales + sunflowerSales + sugarcaneSales;

        double chemicalFreeSales_11months = totalSales;

        // Output
        System.out.printf("a. Overall sales achieved by Mahesh from 80 acres: Rs. %.2f\n", totalSales);
        System.out.printf("b. Sales realisation from chemical-free farming at the end of 11 months: Rs. %.2f\n", chemicalFreeSales_11months);
    }
}
    

