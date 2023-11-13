package christmas;

import christmas.constant.ServiceNumber;

public class Validation {

    public static void validateDate(int date) {
        checkDateRange(date);
    }

    private static void checkDateRange(int date) {
        if (date < ServiceNumber.DATE_MIN.getNumber() || date > ServiceNumber.DATE_MAX.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

}
