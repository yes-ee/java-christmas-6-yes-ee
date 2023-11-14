package christmas.service;

import christmas.constant.ServiceNumber;
import christmas.domain.Benefit;
import christmas.domain.Menu;

public class GiveawayService {
    private int benefitPrice = 0;
    private final Menu giveawayMenu = Menu.CHAMPAGNE;
    private final int giveawayMenuCount = 1;

    public void applyGiveaway(int orderPrice) {
        if (!isGiveawayTarget(orderPrice)) {
            return;
        }

        calculateBenefitPrice(orderPrice);
    }

    private boolean isGiveawayTarget(int orderPrice) {
        return orderPrice >= ServiceNumber.GIVEAWAY_EVENT_MIN_PRICE.getNumber();
    }

    private void calculateBenefitPrice(int orderPrice) {
        benefitPrice = Benefit.GIVEAWAY_EVENT.getPrice();
    }

    public int getBenefitPrice() {
        return benefitPrice;
    }

    public Menu getGiveawayMenu() {
        return giveawayMenu;
    }

    public int getGiveawayMenuCount() {
        return giveawayMenuCount;
    }
}
