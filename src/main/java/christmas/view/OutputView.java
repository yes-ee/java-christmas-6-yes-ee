package christmas.view;

import christmas.constant.ErrorMessage;
import christmas.constant.ServiceMessage;
import christmas.domain.Menu;
import christmas.service.MenuService;
import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    public static void printStartMessage() {
        System.out.println(ServiceMessage.SERVICE_START.getMessage());
    }

    public static void printErrorMessage(String message) {
        System.out.println(ErrorMessage.ERROR_PREFIX.getMessage() + message);
    }

    public static void printBenefitPreview(int date, MenuService menuService) {
        printPreviewStart(date);
        printOrderList(menuService.getOrderList());
        printOrderPrice(menuService.getOrderPrice());
    }

    private static void printPreviewStart(int date) {
        System.out.println("12월 " + date + ServiceMessage.OUTPUT_BENEFIT_PREVIEW.getMessage());
        System.out.println();
    }

    private static void printOrderList(Map<Menu, Integer> orderList) {
        System.out.println(ServiceMessage.OUTPUT_MENU.getMessage());

        for (Menu order : orderList.keySet()) {
            String menuName = order.getName();
            int count = orderList.get(order);

            System.out.printf("%s %d개", menuName, count);
            System.out.println();
        }
        System.out.println();
    }

    private static void printOrderPrice(int orderPrice) {
        DecimalFormat formatter = new DecimalFormat("###,###");

        System.out.println(ServiceMessage.OUTPUT_BEFORE_DISCOUNT.getMessage());
        System.out.println(formatter.format(orderPrice) + "원");
        System.out.println();
    }

}
