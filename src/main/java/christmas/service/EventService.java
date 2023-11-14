package christmas.service;

import christmas.constant.ServiceNumber;

public class EventService {
    int date;
    int discountedPrice;
    private MenuService menuService;
    private BenefitService benefitService;
    private BadgeService badgeService;

    public EventService(int date, MenuService menuService) {
        this.menuService = menuService;
        this.date = date;
    }

    public void applyEvent() {
        benefitService = new BenefitService(date, menuService);
        badgeService = new BadgeService(benefitService.getBenefitPriceSum());

        benefitService.applyBenefit();
        badgeService.applyBadge();
        calculateDiscountedPrice();
    }

    public boolean isEventTarget(int orderPrice) {
        return orderPrice >= ServiceNumber.EVENT_MIN_PRICE.getNumber();
    }

    private void calculateDiscountedPrice() {
        discountedPrice = menuService.getOrderPrice() - benefitService.getDiscountPriceSum();
    }

    public int getDiscountedPrice() {
        return discountedPrice;
    }
}
