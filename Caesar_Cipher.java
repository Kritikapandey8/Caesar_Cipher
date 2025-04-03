import java.util.Scanner;

public class Caesar_Cipher {

    public static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) { // Check if character is a letter
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char encryptedChar = (char) ((ch - base + shift) % 26 + base);
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(ch); // Keep non-alphabetic characters unchanged
            }
        }
        return encryptedText.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift); // Decrypting is just encrypting with the negative shift
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Caesar Cipher Program");
        
        while (true) {
            System.out.print("Would you like to (E)ncrypt or (D)ecrypt a message? (E/D): ");
            String choice = scanner.nextLine().trim().toUpperCase();
            
            if (!choice.equals("E") && !choice.equals("D")) {
                System.out.println("Invalid choice. Please enter 'E' for encrypt or 'D' for decrypt.");
                continue;
            }

            System.out.print("Enter your message: ");
            String message = scanner.nextLine();
            
            System.out.print("Enter the shift value (positive integer): ");
            int shift = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (choice.equals("E")) {
                String encryptedMessage = encrypt(message, shift);
                System.out.println("Encrypted message: " + encryptedMessage);
            } else {
                String decryptedMessage = decrypt(message, shift);
                System.out.println("Decrypted message: " + decryptedMessage);
            }
            
            System.out.print("Would you like to perform another operation? (Y/N): ");
            String another = scanner.nextLine().trim().toUpperCase();
            if (!another.equals("Y")) {
                break;
            }
        }
        scanner.close();
    }
}
