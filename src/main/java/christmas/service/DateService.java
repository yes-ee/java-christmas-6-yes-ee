package christmas.service;

import static christmas.Validation.validateDate;

import christmas.constant.ErrorMessage;
import christmas.view.InputView;
import christmas.view.OutputView;

public class DateService {
    private int date;

    public void chooseDate() {
        boolean isDateValid = false;

        while (!isDateValid) {
            try {
                String input = InputView.inputDate();

                date = Integer.parseInt(input);
                validateDate(date);

                isDateValid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(ErrorMessage.DATE_WRONG.getMessage());
            }
        }
    }

    public int getDate() {
        return date;
    }
}
