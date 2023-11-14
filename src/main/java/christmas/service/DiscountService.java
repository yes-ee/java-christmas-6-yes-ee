package christmas.service;

import christmas.domain.Discount;
import christmas.domain.Menu;
import java.util.HashMap;
import java.util.Map;

public class DiscountService {
    int date;
    int orderPrice;
    int benefitPrice = 0;
    Map<Menu, Integer> orderList;
    Map<Discount, Integer> discountList = new HashMap<>();
    DdayDiscountService ddayDiscountService;

    public DiscountService(int date, Map<Menu, Integer> orderList, int orderPrice) {
        this.date = date;
        this.orderList = orderList;
        this.orderPrice = orderPrice;
        ddayDiscountService = new DdayDiscountService();
    }

    public void applyDiscount() {
        discountList.put(Discount.DDAY_DISCOUNT, ddayDiscountService.applyDiscount(date));
    }

    public int getBenefitPrice() {
        return benefitPrice;
    }


}
