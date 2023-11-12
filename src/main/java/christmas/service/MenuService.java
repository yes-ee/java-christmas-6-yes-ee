package christmas.service;

import christmas.domain.Menu;
import christmas.view.InputView;
import java.util.Map;

public class MenuService {
    private Map<Menu, Integer> orderList;

    public void chooseMenu() {
        boolean isInputValid = false;

        while (!isInputValid) {
            try {
                String input = InputView.inputMenu();

                orderList = Validation.checkMenu(input);
                isInputValid = true;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public Map<Menu, Integer> getOrderList() {
        return orderList;
    }
}
