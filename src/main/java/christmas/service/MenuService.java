package christmas.service;

import christmas.Validation;
import christmas.constant.ErrorMessage;
import christmas.domain.Menu;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.HashMap;
import java.util.Map;

public class MenuService {
    private Map<Menu, Integer> orderList = new HashMap<>();

    public void chooseMenu() {
        boolean isMenuValid = false;

        while (!isMenuValid) {
            try {
                orderList.clear();

                String [] orders = InputView.inputMenu().split(",");
                makeOrderList(orders);
                Validation.validateOrderList(orderList);

                isMenuValid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(ErrorMessage.MENU_WRONG.getMessage());
            }
        }
    }

    private void makeOrderList(String[] orders) {
        for (String order: orders) {
            String [] splitOrder = order.split("-");

            Validation.validateSplitOrder(splitOrder);
            Menu orderMenu = Menu.getMenu(splitOrder[0]);
            Validation.validateMenu(orderMenu, orderList);

            orderList.put(orderMenu, Integer.parseInt(splitOrder[1]));
        }
    }

    public Map<Menu, Integer> getOrderList() {
        return orderList;
    }

    public int getOrderPrice() {
        int orderPrice = 0;

        for (Menu order: orderList.keySet()) {
            orderPrice += order.getPrice() * orderList.get(order);
        }

        return orderPrice;
    }
}
