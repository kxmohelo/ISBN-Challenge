package com.isbn.app;

public class ISBN {
    /**
     * Takes an ISBN-10 or ISBN-13 and returns its corresponding ISBN-13, or returns "Valid" if the
     * input is already an ISBN-13. If the input is not a valid ISBN-10 or ISBN-13, returns "Invalid".
     * 
     * @param isbn The input ISBN-10 or ISBN-13 string.
     * @return The ISBN-13 value if the input is valid ISBN-10, "Valid" if the input is already
     *      an ISBN-13, or "Invalid" if the input is not a valid ISBN-10 or ISBN-13.
     */
    public static String isbn13(String isbn) {
        int sum = 0;

        if (isbn.length() == 10) { // check if  ISBN-10
            for (int i = 0; i < 10; i++) {
                char c = isbn.charAt(i);
                if (c == 'X') {
                    sum += 10 * (10 - i); // add the check digit value for 'X'
                } else if (Character.isDigit(c)) {
                    int digit = Character.getNumericValue(c);
                    sum += digit * (10 - i);
                } else {
                    return "Invalid"; // contains non-digit characters
                }
            }
            if (sum % 11 == 0) { // check if the sum is divisible by 11, the ISBN-10 is valid
                // convert to ISBN-13
                String isbn13 = "978" + isbn.substring(0, 9);

                // reset the sum so we can calculate the sum for the ISBN-13 number
                sum = 0;
                for (int i = 0; i < 12; i++) {
                    int digit = Character.getNumericValue(isbn13.charAt(i));
                    sum += (i % 2 == 0) ? digit : digit * 3; // multiply odd indices by 3 or even indices by 1
                }
                int checkDigit = 10 - (sum % 10);
                return isbn13 + checkDigit;
            } else {
                return "Invalid"; // the sum is not divisible by 11, the ISBN-10 is invalid
            }
        } else if (isbn.length() == 13) { // check if it's ISBN-13
            for (int i = 0; i < 13; i++) {
                char c = isbn.charAt(i);
                if (Character.isDigit(c)) {
                    int digit = Character.getNumericValue(c);
                    sum += (i % 2 == 0) ? digit * 1 : digit * 3; // multiply odd indices by 3 or even indices by 1
                } else {
                    return "Invalid"; // contains non-digit characters
                }
            }
            
            if (sum % 10 == 0) {
                return "Valid"; // check if sum is divisible by 10, the ISBN-13 is valid
            } else {
                return "Invalid"; // the sum is not divisible by 10, the ISBN-13 is invalid
            }
        } else {
            return "Invalid"; // wrong length
        }
    }
    
    public static void main(String[] args) {
        if (args.length == 1) {
            System.out.println(ISBN.isbn13(args[0]));
        } else {
            System.out.println(
                "\nPlease add the ISBN string as an argument when running the program" +
                "\nFor example, run: java -jar path/to/isbn-1.0-SNAPSHOT.jar \"123456789X\""
            );
        }
    }
}
