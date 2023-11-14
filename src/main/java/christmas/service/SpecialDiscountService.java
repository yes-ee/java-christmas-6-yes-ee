package christmas.service;

import christmas.domain.Benefit;

public class SpecialDiscountService {
    private int benefitPrice = 0;
    private final int SUNDAY = 3;
    private final int CHRISTMAS = 25;
    private final int DAYS_IN_WEEK = 7;

    public void applyDiscount(int date) {
        if (!isChristmas(date) && !isSunday(date)) {
            return;
        }

        calculateBenefitPrice(date);
    }

    private boolean isChristmas(int date) {
        return date == CHRISTMAS;
    }

    private boolean isSunday(int date) {
        return date % DAYS_IN_WEEK == SUNDAY;
    }

    private void calculateBenefitPrice(int date) {
        benefitPrice = Benefit.SPECIAL_DISCOUNT.getPrice();
    }

    public int getBenefitPrice() {
        return benefitPrice;
    }
}
