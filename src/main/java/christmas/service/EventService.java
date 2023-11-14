package christmas.service;

import christmas.constant.ServiceNumber;

public class EventService {
    int date;
    private MenuService menuService;
    private BenefitService benefitService;
    private BadgeService badgeService;

    public EventService(int date, MenuService menuService) {
        this.menuService = menuService;
        this.date = date;
    }

    public void applyEvent() {
        benefitService = new BenefitService(date, menuService);
        badgeService = new BadgeService(benefitService.getTotalBenefitPrice());

        benefitService.applyBenefit();
        badgeService.applyBadge();
    }

    public boolean isEventTarget(int orderPrice) {
        return orderPrice >= ServiceNumber.EVENT_MIN_PRICE.getNumber();
    }


}
