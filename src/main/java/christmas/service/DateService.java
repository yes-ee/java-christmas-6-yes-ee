package christmas.service;

import christmas.view.InputView;

public class DateService {
    int date = 0;

    public void chooseDate() {
        boolean isInputValid = false;

        while (!isInputValid) {
            try {
                String input = InputView.inputDate();

                Validation.checkDate(input);
                isInputValid = true;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
