package Utiles;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.UUID;
import java.util.regex.Pattern;

public class HelperUtils {

    // --- 1. Null Check Methods (Overloaded) ---
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNull(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    public static boolean isNotNull(String str) {
        return !isNull(str);
    }

    // --- 2. String Validation Methods (Overloaded) ---
    public static boolean isValidString(String str) {
        return isNotNull(str);
    }

    public static boolean isValidString(String str, int minLength) {
        return isNotNull(str) && str.trim().length() >= minLength;
    }

    public static boolean isValidString(String str, int minLength, int maxLength) {
        if (isNull(str)) return false;
        int length = str.trim().length();
        return length >= minLength && length <= maxLength;
    }

    public static boolean isValidString(String str, String regex) {
        if (isNull(str)) return false;
        return Pattern.matches(regex, str);
    }

    // --- 3. ID Generation Methods (Overloaded) ---
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static String generateId(String prefix) {
        return prefix + "-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public static String generateId(String prefix, int length) {
        String randomPart = UUID.randomUUID().toString().replace("-", "").substring(0, length).toUpperCase();
        return prefix + "-" + randomPart;
    }

    public static String generateId(String prefix, String suffix) {
        return prefix + "-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase() + "-" + suffix;
    }

    // --- 4. Date Validation Methods (Overloaded) ---
    public static boolean isValidDate(LocalDate date) {
        return isNotNull(date);
    }

    public static boolean isValidDate(String dateStr) {
        try {
            LocalDate.parse(dateStr);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isValidDate(LocalDate date, LocalDate minDate, LocalDate maxDate) {
        if (isNull(date)) return false;
        return (date.isAfter(minDate) || date.isEqual(minDate)) &&
                (date.isBefore(maxDate) || date.isEqual(maxDate));
    }

    public static boolean isFutureDate(LocalDate date) {
        return isNotNull(date) && date.isAfter(LocalDate.now());
    }

    public static boolean isPastDate(LocalDate date) {
        return isNotNull(date) && date.isBefore(LocalDate.now());
    }

    public static boolean isToday(LocalDate date) {
        return isNotNull(date) && date.isEqual(LocalDate.now());
    }

    // --- 5. Numeric Validation Methods (Overloaded) ---
    public static boolean isValidNumber(int num, int min, int max) {
        return num >= min && num <= max;
    }

    public static boolean isValidNumber(double num, double min, double max) {
        return num >= min && num <= max;
    }

    public static boolean isPositive(int num) {
        return num > 0;
    }

    public static boolean isPositive(double num) {
        return num > 0.0;
    }

    public static boolean isNegative(int num) {
        return num < 0;
    }

    public static boolean isNegative(double num) {
        return num < 0.0;
    }

    // --- 6. Input Validation Methods (Overloaded) ---
    public static boolean isValidAge(int age) {
        return age >= 0 && age <= 120;
    }

    public static boolean isValidAge(LocalDate dateOfBirth) {
        if (isNull(dateOfBirth)) return false;
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return isValidAge(age);
    }
}

