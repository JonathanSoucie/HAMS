package com.example.hams;

import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for input validation methods.
 * <p>
 * This class contains methods to validate user input fields by matching them to
 * regular expressions.
 */
public class InputValidation {

    /**
     * Checks the validity of a name based on a regular expression pattern.
     * <p>
     * The check is limited to the English alphabet and latin characters.
     *
     * @param editText The EditText containing the name.
     * @return True if the name is valid; false otherwise.
     */
    public static boolean nameValidity(EditText editText) {
        String namePattern = "^(?=.*[a-z])[\\p{L}\\s'-]+$";
        Pattern pattern = Pattern.compile(namePattern);
        Matcher matcher = pattern.matcher(editText.getText().toString());
        if (!matcher.matches()) {
            editText.setError("Invalid name");
            return false;
        }
        return true;
    }

    /**
     * Checks the validity of a last name based on a regular expression pattern.
     * <p>
     * The check is limited to the English alphabet and latin characters.
     *
     * @param editText The EditText containing the last name.
     * @return True if the last name is valid; false otherwise.
     */
    public static boolean lastNameValidity(EditText editText) {
        String namePattern = "^(?=.*[a-z])[\\p{L}\\s'-]+$";
        Pattern pattern = Pattern.compile(namePattern);
        Matcher matcher = pattern.matcher(editText.getText().toString());
        if (!matcher.matches()) {
            editText.setError("Invalid last name");
            return false;
        }
        return true;
    }

    /**
     * Checks the validity of an email address based on a regular expression
     * pattern and if the database already has an account associated with this email.
     * <p>
     * Many email restrictions (such as consecutive dots) are omitted for simplicity
     * purposes.
     * <p>
     * The check accounts for subdomains.
     *
     * @param editText The EditText containing the email.
     * @return True if the email is valid; false otherwise.
     */
    public static boolean emailValidity(EditText editText) {
        String emailPattern = "^[\\w\\.-]+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(editText.getText().toString());
        if (!matcher.matches()) {
            editText.setError("Invalid email address");
            return false;
        }

        return true;
    }

    /**
     * Checks the validity of a phone number based on a regular expression pattern.
     * <p>
     * The EditText is assumed to be number only, so there is no check for
     * parentheses or dashes.
     *
     * @param editText The EditText containing the phone number.
     * @return True if the phone number is valid; false otherwise.
     */
    public static boolean phoneNumberValidity(EditText editText) {
        String phoneNumberPattern = "^\\d{10,11}$";
        Pattern pattern = Pattern.compile(phoneNumberPattern);
        Matcher matcher = pattern.matcher(editText.getText().toString());
        if (!matcher.matches()) {
            editText.setError("Invalid phone number");
            return false;
        }
        return true;
    }

    /**
     * Checks the validity of an address based on a regular expression pattern.
     * <p>
     * For simplicity, there is no check for postal/zip code.
     *
     * @param editText The EditText containing the address.
     * @return True if the address is valid; false otherwise.
     */
    public static boolean addressValidity(EditText editText) {
        String addressPattern = "^\\d+ [\\p{L}\\. -]+$";
        Pattern pattern = Pattern.compile(addressPattern);
        Matcher matcher = pattern.matcher(editText.getText().toString());
        if (!matcher.matches()) {
            editText.setError("Invalid address");
            return false;
        }
        return true;
    }

    /**
     * Checks the validity of an employee number based on a regular expression
     * pattern.
     *
     * @param editText The EditText containing the employee number.
     * @return True if the employee number is valid; false otherwise.
     */
    public static boolean employeeNumberValidity(EditText editText) {
        String employeeNumberPattern = "^\\d+$";
        Pattern pattern = Pattern.compile(employeeNumberPattern);
        Matcher matcher = pattern.matcher(editText.getText().toString());
        if (!matcher.matches()) {
            editText.setError("Invalid employee number");
            return false;
        }
        return true;
    }

    /**
     * Checks the validity of a health card number based on a regular expression
     * pattern.
     * <p>
     * Since the format varies based on provinces, the check is not rigorous.
     *
     * @param editText The EditText containing the health card number.
     * @return True if the health card number is valid; false otherwise.
     */
    public static boolean healthCardNumberValidity(EditText editText) {
        String employeeNumberPattern = "^[A-Z0-9a-z-]{6,15}$";
        Pattern pattern = Pattern.compile(employeeNumberPattern);
        Matcher matcher = pattern.matcher(editText.getText().toString());
        if (!matcher.matches()) {
            editText.setError("Invalid health card number");
            return false;
        }
        return true;
    }

    /**
     * Checks the validity of a doctor's specialties based on a regular expression
     * pattern.
     * <p>
     * This only checks for one or more words separated by commas or spaces.
     *
     * @param editText The EditText containing the specialties.
     * @return True if the specialties are valid; false otherwise.
     */
    public static boolean specialtiesValidity(EditText editText) {
        String specialtiesPattern = "[\\w, ]+";
        Pattern pattern = Pattern.compile(specialtiesPattern);
        Matcher matcher = pattern.matcher(editText.getText().toString());
        if (!matcher.matches()) {
            editText.setError("Invalid specialties");
            return false;
        }
        return true;
    }

    /**
     * Checks the validity of a password based on a regular expression pattern.
     *
     * @param editText The EditText containing the password.
     * @return True if the password is valid; false otherwise.
     */
    public static boolean passwordValidity(EditText editText) {
        String passwordPattern = "^(?=.*[!@#$%^&*()_\\-+=\\[\\]{};:'\",<>./?\\\\|])(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        Pattern pattern = Pattern.compile(passwordPattern);
        Matcher matcher = pattern.matcher(editText.getText().toString());
        if (!matcher.matches()) {
            editText.setError(
                    "Invalid password. Password must include at least one lowercase letter, one uppercase letter, one number, one symbol, and be at least 8 characters in length.");
            return false;
        }
        return true;
    }

}