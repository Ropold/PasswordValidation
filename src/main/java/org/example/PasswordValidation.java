package org.example;

public class PasswordValidation {
    public static void main(String[] args) {
         System.out.println("Aufgabe 1: " + moreThanEightChars("huhuhuhuhuhuhu"));
         System.out.println("Aufgabe 2: " + pwWithDigits("11hu"));
         System.out.println("Aufgabe 3: " + hasUpperAndLowerChars("Ddfuhu"));
         System.out.println("Aufgabe 4: " + pwIsNotCommonlyUsed("1234"));
         System.out.println("Aufgabe 5: " + pwContainsSpecialCharacters("$adsad$$$"));
         System.out.println("Aufgabe 6: " + createUniquePw());

    }

    public static boolean moreThanEightChars(String password) {
        return password.length() > 8;
    }

    public static boolean pwWithDigits(String password){
        // return password.matches("^(?=.*\\d).+$");
        for (int i = 0; i < password.length(); i++) {
            char charToCheck = password.charAt(i);
            if (Character.isDigit(charToCheck)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean hasUpperAndLowerChars(String password){
        // return password.matches("^(?=.*[a-z])(?=.*[A-Z]).+$");
        boolean hasUpper = false;
        boolean hasLower = false;

        for(int i = 0; i < password.length(); i++){
            char charToCheck = password.charAt(i);
            if (Character.isUpperCase(charToCheck)) {
                hasUpper = true;
            } else if (Character.isLowerCase(charToCheck)) {
                hasLower = true;
            }if (hasUpper && hasLower) {
                return true;
            }
        }
        return false;
    }

    public static boolean pwIsNotCommonlyUsed(String password){
        //return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}[]:;<>,.?/~_+-=|\\]).{8,32}$");
        //At least one digit [0-9] At least one lowercase character [a-z] At least one uppercase character [A-Z] At least one special character [*.!@#$%^&(){}[]:;<>,.?/~_+-=|\] At least 8 characters in length, but no more than 32.
        String[] commonPasswords = {"1234", "abcd", "qwer"};
        for (String commonPassword : commonPasswords) {
            if (password.equals(commonPassword)) {
                return false;
            }
        }
        return true;
    }

    public static boolean pwContainsSpecialCharacters(String password){
        String[] specialCharacters = { "*", ".", "!", "@", "#", "$", "%", "^", "&", "(", ")", "{", "}", "[", "]", ":", ";", "<", ">", ",", ".", "?", "/", "~", "_", "+", "-", "=", "|", "\\" };
        for (String specialCharacter : specialCharacters){
            for(int k = 0; k < password.length(); k++ ){
                if(Character.toString(password.charAt(k)).equals(specialCharacter)){
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean createUniquePwWithOldMethods(String password){
        return moreThanEightChars(password)
                && pwWithDigits(password)
                && hasUpperAndLowerChars(password)
                && pwIsNotCommonlyUsed(password)
                && pwContainsSpecialCharacters(password);
    }

    public static String createUniquePw(){

        String[] specialCharacters = { "*", ".", "!", "@", "#", "$", "%", "^", "&", "(", ")", "{", "}", "[", "]", ":", ";", "<", ">", ",", ".", "?", "/", "~", "_", "+", "-", "=", "|", "\\" };
        String[] digits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        String[] lowercaseAlphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        String[] uppercaseAlphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

        String password = "";

        for(int i = 1; i < 6; i++){
            int randomIndex = (int) (Math.random() * specialCharacters.length);
            password += specialCharacters[randomIndex];;
        }

        for(int i = 1; i < 6; i++){
            int randomIndex = (int) (Math.random() * digits.length);
            password += digits[randomIndex];;
        }

        for(int i = 1; i < 6; i++){
            int randomIndex = (int) (Math.random() * lowercaseAlphabet.length);
            password += lowercaseAlphabet[randomIndex];;
        }

        for(int i = 1; i < 6; i++){
            int randomIndex = (int) (Math.random() * uppercaseAlphabet.length);
            password += uppercaseAlphabet[randomIndex];;
        }
        //String rndPassword = shuffleString(password);

        char[] passwordArray = password.toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int randomIndex = (int) (Math.random() * passwordArray.length);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[randomIndex];
            passwordArray[randomIndex] = temp;
        }

        return new String(passwordArray);

        // warum geht nicht .sample(5) & .shuffle.... *heul*
    }


}
