package christmas.service;

import christmas.constant.ErrorMessage;
import christmas.constant.ServiceNumber;

public class Validation {
    public static void checkDate(String input) {
        int date;

        try {
            date = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_PREFIX.getMessage() + ErrorMessage.DATE_WRONG.getMessage());
        }

        if (date < ServiceNumber.DATE_MIN.getNumber() || date > ServiceNumber.DATE_MAX.getNumber()) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_PREFIX.getMessage() + ErrorMessage.DATE_WRONG.getMessage());
        }
    }

}
