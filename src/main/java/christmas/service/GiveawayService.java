package christmas.service;

import christmas.constant.ServiceNumber;
import christmas.domain.Benefit;

public class GiveawayService {
    private int benefitPrice = 0;

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

}
