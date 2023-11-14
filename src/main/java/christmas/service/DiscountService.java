package christmas.service;

import christmas.constant.ServiceNumber;
import christmas.domain.Discount;
import christmas.domain.Menu;
import java.util.HashMap;
import java.util.Map;

public class DiscountService {
    int date;
    Map<Menu, Integer> orderList;
    int orderPrice;
    Map<Discount, Integer> discountList = new HashMap<>();
    int benefitPrice = 0;

    public DiscountService(int date, Map<Menu, Integer> orderList, int orderPrice) {
        this.date = date;
        this.orderList = orderList;
        this.orderPrice = orderPrice;
    }

    public void applyDiscount() {
        applyDdayDiscount();
    }

    public int getBenefitPrice() {
        return benefitPrice;
    }

    private void applyDdayDiscount() {
        if (date > ServiceNumber.DDAY_DISCOUNT_END.getNumber()) {
            return;
        }

        discountList.put(Discount.DDAY_DISCOUNT, getDdayBenefitPrice());
    }

    private int getDdayBenefitPrice() {
        return Discount.DDAY_DISCOUNT.getPrice() + (date - ServiceNumber.DATE_MIN.getNumber()) * 100;
    }
}
