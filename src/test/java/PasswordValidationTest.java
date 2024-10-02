import org.example.PasswordValidation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidationTest {
    @Test
    void checkMoreThanEightChars(){
    //given
        String password = "wer das liesst, kann lesen";
    //when
        boolean actual = PasswordValidation.moreThanEightChars(password);
    //then
        assertTrue(actual);
    }

    @Test
    void checkLessThanEightChars() {
        // given
        String password = "kurz";

        // when
        boolean actual = PasswordValidation.moreThanEightChars(password);

        // then
        assertFalse(actual);
    }

    @Test
    void checkIfContainsDigit(){
        // given
        String password = "hallo123";

        //when
        boolean actual = PasswordValidation.pwWithDigits(password);

        //then
        assertTrue(actual);
    }
    @Test
    void checkIfContainsNoDigit(){
        // given
        String password = "hallo";

        //when
        boolean actual = PasswordValidation.pwWithDigits(password);

        //then
        assertFalse(actual);
    }
    @Test
    void checkIfContainsUpperAndLowerChars(){
        // given
        String password = "Hallo";

        //when
        boolean actual = PasswordValidation.hasUpperAndLowerChars(password);

        //then
        assertTrue(actual);
    }
    @Test
    void checkIfNoContainsUpperAndLowerChars(){
        // given
        String password = "hallo";

        //when
        boolean actual = PasswordValidation.hasUpperAndLowerChars(password);

        //then
        assertFalse(actual);
    }

    @Test
    void checkIfPwIsCommon(){
        //given
        String password = "1234";

        //when
        boolean actual = PasswordValidation.pwIsNotCommonlyUsed(password);

        //then
        assertFalse(actual);
    }

    @Test
    void checkIfPwIsNotCommon(){
        //given
       String password = "RqByMEthf4w&";

       //when
       boolean actual = PasswordValidation.pwIsNotCommonlyUsed(password);

       //then
       assertTrue(actual);
    }

    @Test
    void checkIfPwContainsSpecialCharacters(){
        //given
        String password = "RqByMEthf4w&";

        //when
        boolean actual = PasswordValidation.pwContainsSpecialCharacters(password);

        //then
        assertTrue(actual);
    }

    @Test
    void checkIfPwNotContainsSpecialCharacters(){
        //given
        String password = "huhu";

        //when
        boolean actual = PasswordValidation.pwContainsSpecialCharacters(password);

        //then
        assertFalse(actual);
    }

    @Test
    void checkIfCreateUniquePwWithOldMethodsWorks(){
        //given
        String password = "RqByMEthf4w&";

        //when
        boolean actual = PasswordValidation.createUniquePwWithOldMethods(password);

        //then
        assertTrue(actual);
    }
}
