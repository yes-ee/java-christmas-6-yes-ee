package christmas.service;

import christmas.domain.Benefit;
import christmas.domain.Menu;
import java.util.Map;

public class WeekendDiscountService {
    private final int FRIDAY = 1;
    private final int SATURDAY = 2;
    private final int DAYS_IN_WEEK = 7;
    private int benefitPrice = 0;

    public void applyDiscount(int date, Map<Menu, Integer> orderList) {
        if (!isWeekend(date)) {
            return;
        }

        calculateBenefitPrice(orderList);
    }

    private boolean isWeekend(int date) {
        return date % DAYS_IN_WEEK == FRIDAY || date % DAYS_IN_WEEK == SATURDAY;
    }

    private void calculateBenefitPrice(Map<Menu, Integer> orderList) {
        int benefitMenuCount = 0;

        for (Menu menu : orderList.keySet()) {
            if (isBenefitMenu(menu)) {
                benefitMenuCount += orderList.get(menu);
            }
        }
        benefitPrice = benefitMenuCount * Benefit.WEEKEND_DISCOUNT.getPrice();
    }

    private boolean isBenefitMenu(Menu menu) {
        return menu.getType() == "main";
    }

    public int getBenefitPrice() {
        return benefitPrice;
    }
}
