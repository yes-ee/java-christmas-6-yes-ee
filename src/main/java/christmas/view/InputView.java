package christmas.view;

import christmas.constant.ServiceMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputDate() {
        System.out.println(ServiceMessage.INPUT_DATE.getMessage());
        return Console.readLine();
    }

}
