package christmas.service;

import christmas.constant.ServiceNumber;
import christmas.domain.Benefit;

public class DdayDiscountService {
    int benefitPrice = 0;

    public void applyDiscount(int date) {
        if (date > ServiceNumber.DDAY_DISCOUNT_END.getNumber()) {
            return;
        }

        calculateBenefitPrice(date);
    }

    private void calculateBenefitPrice(int date) {
        benefitPrice = Benefit.DDAY_DISCOUNT.getPrice() + (date - ServiceNumber.DATE_MIN.getNumber()) * 100;
    }

    public int getBenefitPrice() {
        return benefitPrice;
    }
}
