package christmas.service;

import christmas.constant.ServiceNumber;
import christmas.domain.Benefit;

public class DdayDiscountService {
    public int applyDiscount(int date) {
        if (date > ServiceNumber.DDAY_DISCOUNT_END.getNumber()) {
            return 0;
        }

        return getBenefitPrice(date);
    }

    private int getBenefitPrice(int date) {
        return Benefit.DDAY_DISCOUNT.getPrice() + (date - ServiceNumber.DATE_MIN.getNumber()) * 100;
    }

}
