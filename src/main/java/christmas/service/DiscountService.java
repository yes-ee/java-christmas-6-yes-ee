package christmas.service;

import christmas.domain.Menu;
import java.util.Map;

public class DiscountService {
    int date;
    Map<Menu, Integer> orderList;
    int orderPrice;
    int benefitPrice = 0;

    public DiscountService(int date, Map<Menu, Integer> orderList, int orderPrice) {
        this.date = date;
        this.orderList = orderList;
        this.orderPrice = orderPrice;
    }

    public void applyDiscount() {
    }

    public int getBenefitPrice() {
        return benefitPrice;
    }
}
