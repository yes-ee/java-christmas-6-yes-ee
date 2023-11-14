package christmas.service;

import christmas.constant.ServiceNumber;
import christmas.domain.Menu;
import java.util.Map;

public class EventService {
    int date;
    private Map<Menu, Integer> orderList;
    private int orderPrice;

    private DiscountService discountService;
    private BadgeService badgeService;

    public EventService(int date, Map<Menu, Integer> orderList, int orderPrice) {
        this.date = date;
        this.orderList = orderList;
        this.orderPrice = orderPrice;
    }

    public void applyEvent() {
        discountService = new DiscountService(date, orderList, orderPrice);
        badgeService = new BadgeService(discountService.getBenefitPrice());

        discountService.applyDiscount();
        badgeService.applyBadge();
    }

    public boolean isEventTarget(int orderPrice) {
        return orderPrice >= ServiceNumber.EVENT_MIN_PRICE.getNumber();
    }
}
