package christmas.service;

import christmas.constant.ErrorMessage;
import christmas.constant.ServiceNumber;
import christmas.view.InputView;
import christmas.view.OutputView;

public class DateService {
    private int date;

    public void chooseDate() {
        boolean isDateValid = false;

        while (!isDateValid) {
            try {
                String input = InputView.inputDate();

                checkDate(input);
                isDateValid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void checkDate(String input) {
        try {
            date = convertToInt(input);
            checkDateRange(date);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.DATE_WRONG.getMessage());
        }
    }

    private int convertToInt(String input) {
        return Integer.parseInt(input);
    }

    private void checkDateRange(int date) {
        if (date < ServiceNumber.DATE_MIN.getNumber() || date > ServiceNumber.DATE_MAX.getNumber()) {
            throw new IllegalArgumentException();
        }
    }
}
