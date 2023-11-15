package christmas.service;

import christmas.constant.ServiceNumber;
import christmas.domain.Benefit;
import christmas.domain.EventReservation;
import christmas.domain.Menu;

public class GiveawayService {
    private int benefitPrice;
    private final Menu giveawayMenu;
    private final int giveawayCount;

    public GiveawayService() {
        this.benefitPrice = 0;
        this.giveawayMenu = Menu.CHAMPAGNE;
        this.giveawayCount = 1;
    }

    public void applyGiveaway(int orderPrice) {
        if (!isGiveawayTarget(orderPrice)) {
            System.out.println("이벤트 적용 대상이 아닙니다.");
            return;
        }

        calculateBenefitPrice();
    }

    private boolean isGiveawayTarget(int orderPrice) {
        return orderPrice >= ServiceNumber.GIVEAWAY_EVENT_MIN_PRICE.getNumber();
    }

    private void calculateBenefitPrice() {
        benefitPrice = Benefit.GIVEAWAY_EVENT.getPrice();
    }

    public void addGiveawayMenuToOrderList(EventReservation eventReservation) {
        if (benefitPrice != 0) {
            eventReservation.addOrder(this.giveawayMenu, this.giveawayCount);
        }
    }

    public int getBenefitPrice() {
        return benefitPrice;
    }

    public Menu getGiveawayMenu() {
        return giveawayMenu;
    }

    public int getGiveawayCount() {
        return giveawayCount;
    }
}
