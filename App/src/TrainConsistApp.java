import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainConsistApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define Regex Patterns
        // TRN- followed by exactly 4 digits
        String trainIdRegex = "TRN-\\d{4}";
        // PET- followed by exactly 2 uppercase letters
        String cargoCodeRegex = "PET-[A-Z]{2}";

        System.out.println("--- Train Consist Management System: UC11 (Regex Validation) ---");

        // 1. Train ID Validation
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainIdInput = scanner.nextLine();
        validateInput("Train ID", trainIdInput, trainIdRegex);

        // 2. Cargo Code Validation
        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCodeInput = scanner.nextLine();
        validateInput("Cargo Code", cargoCodeInput, cargoCodeRegex);

        System.out.println("-------------------------------------------------------------");
        scanner.close();
    }

    /**
     * Helper method to validate input against a regex pattern
     */
    public static void validateInput(String fieldName, String input, String regex) {
        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher for the specific input
        Matcher matcher = pattern.matcher(input);

        // Check if the entire input matches the pattern
        if (matcher.matches()) {
            System.out.println("✔ [SUCCESS] " + fieldName + " '" + input + "' is valid.");
        } else {
            System.out.println("❌ [ERROR] " + fieldName + " '" + input + "' is invalid.");
            System.out.println("   Rule: Must follow the pattern: " + regex);
        }
    }
}