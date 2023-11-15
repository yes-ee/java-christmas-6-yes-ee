package christmas.view;

import christmas.constant.ErrorMessage;
import christmas.constant.ServiceMessage;
import christmas.domain.Benefit;
import christmas.domain.Menu;
import christmas.service.BenefitService;
import christmas.service.EventService;
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

    public static void printPreviewStart(int date) {
        System.out.println("12월 " + date + ServiceMessage.OUTPUT_BENEFIT_PREVIEW.getMessage());
        System.out.println();
    }

    public static void printOrderList(Map<Menu, Integer> orderList) {
        System.out.println(ServiceMessage.OUTPUT_MENU.getMessage());

        for (Menu order : orderList.keySet()) {
            String menuName = order.getName();
            int count = orderList.get(order);

            System.out.printf("%s %d개", menuName, count);
            System.out.println();
        }
        System.out.println();
    }

    public static void printOrderPrice(int orderPrice) {
        DecimalFormat formatter = new DecimalFormat("###,###");

        System.out.println(ServiceMessage.OUTPUT_BEFORE_DISCOUNT.getMessage());
        System.out.println(formatter.format(orderPrice) + "원");
        System.out.println();
    }

    public static void printGiveawayMenu(Map<Benefit, Integer> benefitList, Menu giveawayMenu, int giveawayCount) {
        System.out.println(ServiceMessage.OUTPUT_GIVEAWAY_MENU.getMessage());

        printGiveawayList(benefitList, giveawayMenu, giveawayCount);
        System.out.println();
    }

    private static void printGiveawayList(Map<Benefit, Integer> benefitList, Menu giveawayMenu, int giveawayCount) {
        boolean isGiveaway = false;

        for (Benefit benefit : benefitList.keySet()) {
            if (benefit.getType() == "giveaway") {
                System.out.printf("%s %d개", giveawayMenu.getName(), giveawayCount);
                System.out.println();
                isGiveaway = true;
            }
        }

        if (!isGiveaway) {
            System.out.println("없음");
        }
    }

    public static void printBenefitList(Map<Benefit, Integer> benefitList) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println(ServiceMessage.OUTPUT_BENEFIT_HISTORY.getMessage());

        for (Benefit benefit : benefitList.keySet()) {
            System.out.printf("%s: -%s원", benefit.getName(), formatter.format(benefitList.get(benefit)));
            System.out.println();
        }
        System.out.println();
    }

    public static void printBenefitPrice(int totalBenefitPrice) {
        DecimalFormat formatter = new DecimalFormat("###,###");

        System.out.println(ServiceMessage.OUTPUT_BENEFIT_PRICE.getMessage());
        System.out.println("-" + formatter.format(totalBenefitPrice) + "원");
        System.out.println();
    }

    public static void printDiscountedPrice(int discountedPrice) {
        DecimalFormat formatter = new DecimalFormat("###,###");

        System.out.println(ServiceMessage.OUTPUT_AFTER_DISCOUNT.getMessage());
        System.out.println(formatter.format(discountedPrice) + "원");
        System.out.println();
    }
}
