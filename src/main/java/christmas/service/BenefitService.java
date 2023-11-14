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
    WeekdayDiscountService weekdayDiscountService;
    WeekendDiscountService weekendDiscountService;
    SpecialDiscountService specialDiscountService;

    public BenefitService(int date, Map<Menu, Integer> orderList, int orderPrice) {
        this.date = date;
        this.orderList = orderList;
        this.orderPrice = orderPrice;
        ddayDiscountService = new DdayDiscountService();
        weekdayDiscountService = new WeekdayDiscountService();
        weekendDiscountService = new WeekendDiscountService();
        specialDiscountService = new SpecialDiscountService();
    }

    public void applyBenefit() {
        applyDdayDiscount();
        applyWeekdayDiscount();
        applyWeekendDiscount();
        applySpecialDiscount();
    }

    private void applyDdayDiscount() {
        ddayDiscountService.applyDiscount(date);
        addBenefitToList(Benefit.DDAY_DISCOUNT, ddayDiscountService.getBenefitPrice());
    }

    private void applyWeekdayDiscount() {
        weekdayDiscountService.applyDiscount(date, orderList);
        addBenefitToList(Benefit.WEEKDAY_DISCOUNT, weekdayDiscountService.getBenefitPrice());
    }

    private void applyWeekendDiscount() {
        weekendDiscountService.applyDiscount(date, orderList);
        addBenefitToList(Benefit.WEEKEND_DISCOUNT, weekendDiscountService.getBenefitPrice());
    }

    private void applySpecialDiscount() {
        specialDiscountService.applyDiscount(date);
        addBenefitToList(Benefit.SPECIAL_DISCOUNT, specialDiscountService.getBenefitPrice());
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
