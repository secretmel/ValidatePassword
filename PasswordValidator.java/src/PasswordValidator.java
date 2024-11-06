import java.util.Scanner;

public class PasswordValidator {
    public static boolean isValidPassword(String password) {
        if (password.length()< 8 || password.length() > 16){
            return false;
        }
        
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()){
            if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if ("~!@#$%^&*()-=+_".indexOf(c) != -1) hasSpecial = true;
        }

        int categoriesMet = 0;
        if (hasLower) categoriesMet++;
        if (hasUpper) categoriesMet++;
        if (hasDigit) categoriesMet++;
        if (hasSpecial) categoriesMet++;

        return categoriesMet >= 3;
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a password to check validation: ");
            String userPassword = scanner.nextLine();
            if (isValidPassword(userPassword)) {
                System.out.println("Password is valid.");
            } else {
                System.out.println("Password is invalid. It must be 8-16 characters long and contain at least three of the following: lowercase letters, uppercase letters, numbers, or special symbols (~!@#$%^&*()-=+_).");
            }
            scanner.close();
        }
    }
}
