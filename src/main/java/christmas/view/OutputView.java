package christmas.view;

import christmas.domain.Menu;
import java.util.Map;

public class OutputView {
    public static void printOrder(Map<Menu, Integer> orderList) {
        for (Menu menu : orderList.keySet()) {
            System.out.println(menu.getName() + " " + orderList.get(menu) + "개");
        }
    }
}
