import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        // Choose measurement units
        System.out.print("Choose units (1 for Metric, 2 for Imperial): ");
        int choice = userInput.nextInt();

        double weight, height;

        if (choice == 1) { // Metric units
            // Get user input for weight in kilograms
            System.out.print("Enter your weight in kilograms: ");
            weight = getPositiveInput(userInput);

            // Get user input for height in meters
            System.out.print("Enter your height in meters: ");
            height = getPositiveInput(userInput);
        } else if (choice == 2) { // Imperial units
            // Get user input for weight in pounds
            System.out.print("Enter your weight in pounds: ");
            weight = getPositiveInput(userInput);

            // Get user input for height in inches
            System.out.print("Enter your height in inches: ");
            height = getPositiveInput(userInput);
        } else {
            System.out.println("Invalid choice. Exiting program.");
            return;
        }

        // Calculate BMI
        double bmi = calculateBMI(weight, height);

        // Display BMI information
        System.out.println("Your BMI is: " + bmi);
        System.out.println("BMI Category: " + getBMICategory(bmi));
        displayHealthAdvice(bmi);

        userInput.close();
    }

    // Method to get positive input from the user
    private static double getPositiveInput(Scanner scanner) {
        double input;
        do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // consume the invalid input
            }
            input = scanner.nextDouble();

            if (input <= 0) {
                System.out.println("Please enter a positive value.");
            }
        } while (input <= 0);

        return input;
    }

    // Method to calculate BMI
    private static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    // Method to determine BMI category
    private static String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal Weight";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // Method to display health advice based on BMI
    private static void displayHealthAdvice(double bmi) {
        System.out.print("Health Advice: ");
        if (bmi < 18.5) {
            System.out.println("You are underweight. It's important to maintain a balanced diet and consider consulting a nutritionist.");
        } else if (bmi < 24.9) {
            System.out.println("Your weight is within the normal range. Keep up the good work!");
        } else if (bmi < 29.9) {
            System.out.println("You are overweight. Consider adopting a healthier lifestyle, including regular exercise and a balanced diet.");
        } else {
            System.out.println("You are obese. It's crucial to consult with a healthcare professional to discuss potential health risks and develop a plan for improvement.");
        }
    }
}