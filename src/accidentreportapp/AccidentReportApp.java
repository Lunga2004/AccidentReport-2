
package accidentreportapp;

import java.util.Scanner;

/**
 *Lunga Kwinana
 * @author ST10445079
 */
public class AccidentReportApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cities array
        String[] cities = {"Cape Town", "Johannesburg", "Port Elizabeth"};
        String[] vehicleTypes = {"Car", "Motor Bike"};
        
        // 2D Array to store accident data [city][vehicle type]
        int[][] accidents = new int[cities.length][vehicleTypes.length];
        
        // Input: Get accident data from user
        for (int i = 0; i < cities.length; i++) {
            System.out.println("Enter the number of car accidents for " + cities[i] + ": ");
            accidents[i][0] = scanner.nextInt();  // Car accidents
            
            System.out.println("Enter the number of motor bike accidents for " + cities[i] + ": ");
            accidents[i][1] = scanner.nextInt();  // Motorbike accidents
        }

        // Print accident report header
        System.out.println("\nROAD ACCIDENT REPORT");
        System.out.println("-----------------------------");
        System.out.printf("%-15s %-10s %-10s\n", "", "CAR", "MOTOR BIKE");
        
        // Print accident data for each city
        for (int i = 0; i < cities.length; i++) {
            System.out.printf("%-15s %-10d %-10d\n", cities[i], accidents[i][0], accidents[i][1]);
        }

        // Calculate and print total accidents for each city
        System.out.println("\nROAD ACCIDENT TOTALS FOR EACH CITY");
        int[] totalAccidentsPerCity = new int[cities.length];
        int maxAccidents = 0;
        String cityWithMostAccidents = "";

        for (int i = 0; i < cities.length; i++) {
            totalAccidentsPerCity[i] = accidents[i][0] + accidents[i][1];  // Sum of car and motorbike accidents
            System.out.printf("%-15s %-10d\n", cities[i], totalAccidentsPerCity[i]);

            // Determine the city with the highest accidents
            if (totalAccidentsPerCity[i] > maxAccidents) {
                maxAccidents = totalAccidentsPerCity[i];
                cityWithMostAccidents = cities[i];
            }
        }

        // Print the city with the most accidents
        System.out.println("\nCITY WITH THE MOST VEHICLE ACCIDENTS: " + cityWithMostAccidents);
        
        // Close the scanner
        scanner.close();
    }
}