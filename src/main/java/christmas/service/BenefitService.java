package christmas.service;

import christmas.domain.Benefit;
import christmas.domain.Menu;
import java.util.HashMap;
import java.util.Map;

public class BenefitService {
    int date;
    int orderPrice;
    int benefitPrice = 0;
    Map<Menu, Integer> orderList;
    Map<Benefit, Integer> benefitList = new HashMap<>();
    DdayDiscountService ddayDiscountService;

    public BenefitService(int date, Map<Menu, Integer> orderList, int orderPrice) {
        this.date = date;
        this.orderList = orderList;
        this.orderPrice = orderPrice;
        ddayDiscountService = new DdayDiscountService();
    }

    public void applyBenefit() {
        applyDdayDiscount();
    }

    private void applyDdayDiscount() {
        ddayDiscountService.applyDiscount(date);
        addBenefitToList(Benefit.DDAY_DISCOUNT, ddayDiscountService.getBenefitPrice());
    }

    private void addBenefitToList(Benefit benefit, int benefitPrice) {
        if (benefitPrice != 0) {
            benefitList.put(benefit, benefitPrice);
        }
    }

    public int getBenefitPrice() {
        return benefitPrice;
    }


}
