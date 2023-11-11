package christmas.view;

import christmas.constant.ServiceMessage;

public class InputView {
    public String inputDate() {
        System.out.println(ServiceMessage.INPUT_DATE.getMessage());
        return System.console().readLine();
    }

    public String inputMenu() {
        System.out.println(ServiceMessage.INPUT_MENU.getMessage());
        return System.console().readLine();
    }
}
