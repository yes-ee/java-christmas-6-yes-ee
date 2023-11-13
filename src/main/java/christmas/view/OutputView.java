package christmas.view;

import christmas.constant.ErrorMessage;

public class OutputView {
    public static void printErrorMessage(String message) {
        System.out.println(ErrorMessage.ERROR_PREFIX.getMessage() + message);
    }

}
