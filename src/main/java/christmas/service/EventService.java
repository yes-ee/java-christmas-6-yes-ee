package christmas.service;

import christmas.constant.ServiceNumber;
import christmas.domain.Menu;
import java.util.Map;

public class EventService {
    int date;
    private Map<Menu, Integer> orderList;
    private int orderPrice;
    private MenuService menuService;
    private BenefitService benefitService;
    private BadgeService badgeService;

    public EventService(int date, MenuService menuService) {
        this.menuService = menuService;
        this.date = date;
        this.orderList = menuService.getOrderList();
        this.orderPrice = menuService.getOrderPrice();
    }

    public void applyEvent() {
        benefitService = new BenefitService(date, menuService);
        badgeService = new BadgeService(benefitService.getBenefitPrice());

        benefitService.applyBenefit();
        badgeService.applyBadge();
    }

    public boolean isEventTarget(int orderPrice) {
        return orderPrice >= ServiceNumber.EVENT_MIN_PRICE.getNumber();
    }
}
