package christmas.service;

import christmas.constant.ErrorMessage;
import christmas.domain.Menu;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class MenuService {
    private Map<Menu, Integer> orderList;

    public void chooseMenu() {
        boolean isMenuValid = false;

        while (!isMenuValid) {
            try {
                orderList.clear();

                String [] orders = InputView.inputMenu().split(",");

                makeOrderList(orders);

                isMenuValid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(ErrorMessage.MENU_WRONG.getMessage());
            }
        }
    }

    private void makeOrderList(String[] orders) {
        for (String order: orders) {
            String [] splitOrder = order.split("-");

            checkSplitOrder(splitOrder);
        }
    }

    private void checkSplitOrder(String[] splitOrder) {
        if (splitOrder.length != 2)
            throw new IllegalArgumentException();
    }
}
