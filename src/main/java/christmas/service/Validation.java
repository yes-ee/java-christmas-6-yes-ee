package christmas.service;

import christmas.constant.ErrorMessage;
import christmas.constant.ServiceNumber;
import christmas.domain.Menu;
import christmas.domain.MenuList;
import java.util.HashMap;
import java.util.Map;

public class Validation {
    public static int checkDate(String input) {
        int date;

        try {
            date = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_PREFIX.getMessage() + ErrorMessage.DATE_WRONG.getMessage());
        }

        if (date < ServiceNumber.DATE_MIN.getNumber() || date > ServiceNumber.DATE_MAX.getNumber()) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_PREFIX.getMessage() + ErrorMessage.DATE_WRONG.getMessage());
        }

        return date;
    }

    public static Map<Menu, Integer> checkMenu(String input) {
        MenuList menuList = new MenuList();
        Map<Menu, Integer> orderList = new HashMap<>();

        String [] orders = input.split(",");

        for (String order : orders) {
            String [] splitOrder = order.split("-");

            if (splitOrder.length != 2) {
                throw new IllegalArgumentException(
                        ErrorMessage.ERROR_PREFIX.getMessage() + ErrorMessage.MENU_WRONG.getMessage());
            }

            String name = splitOrder[0];
            Integer count = Integer.parseInt(splitOrder[1]);
            Menu menu = Menu.getMenu(name);

            if (menu == null) {
                throw new IllegalArgumentException(
                        ErrorMessage.ERROR_PREFIX.getMessage() + ErrorMessage.MENU_WRONG.getMessage());
            }

            if (orderList.containsKey(menu)) {
                throw new IllegalArgumentException(
                        ErrorMessage.ERROR_PREFIX.getMessage() + ErrorMessage.MENU_WRONG.getMessage());
            }

            orderList.put(menu, count);
        }

        boolean onlyDrink = true;

        for (Menu order : orderList.keySet()) {
            if (order.getType() != "drink") {
                onlyDrink = false;
                break;
            }
        }

        if (onlyDrink) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_PREFIX.getMessage() + ErrorMessage.MENU_WRONG.getMessage());
        }

        int totalCount = 0;

        for (Integer count : orderList.values()) {
            totalCount += count;
        }

        if (totalCount > ServiceNumber.MENU_MAX.getNumber()) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_PREFIX.getMessage() + ErrorMessage.MENU_WRONG.getMessage());
        }

        return orderList;
    }
}
