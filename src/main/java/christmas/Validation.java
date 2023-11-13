package christmas;

import christmas.constant.ServiceNumber;
import christmas.domain.Menu;
import java.util.Map;

public class Validation {

    public static void validateDate(int date) {
        checkDateRange(date);
    }

    private static void checkDateRange(int date) {
        if (date < ServiceNumber.DATE_MIN.getNumber() || date > ServiceNumber.DATE_MAX.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateMenu(Menu orderMenu, Map<Menu, Integer> orderList) {
        checkMenuExist(orderMenu);
        checkMenuDuplicate(orderMenu, orderList);
    }

    private static void checkMenuExist(Menu orderMenu) {
        if (orderMenu == null)
            throw new IllegalArgumentException();
    }

    private static void checkMenuDuplicate(Menu orderMenu, Map<Menu, Integer> orderList) {
        if (orderList.containsKey(orderMenu)) {
            throw new IllegalArgumentException();
        }
    }
}
