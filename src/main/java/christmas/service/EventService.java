package christmas.service;

import christmas.constant.ServiceNumber;
import christmas.domain.Menu;
import java.util.Map;

public class EventService {
    int date;
    private Map<Menu, Integer> orderList;
    private int orderPrice;

    private BenefitService benefitService;
    private BadgeService badgeService;

    public EventService(int date, Map<Menu, Integer> orderList, int orderPrice) {
        this.date = date;
        this.orderList = orderList;
        this.orderPrice = orderPrice;
    }

    public void applyEvent() {
        benefitService = new BenefitService(date, orderList, orderPrice);
        badgeService = new BadgeService(benefitService.getBenefitPrice());

        benefitService.applyBenefit();
        badgeService.applyBadge();
    }

    public boolean isEventTarget(int orderPrice) {
        return orderPrice >= ServiceNumber.EVENT_MIN_PRICE.getNumber();
    }
}
