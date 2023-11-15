package christmas.service;

import christmas.constant.ServiceNumber;
import christmas.domain.EventReservation;

public class EventService {
    private EventReservation eventReservation;
    private MenuService menuService;
    private BenefitService benefitService;
    private BadgeService badgeService;

    public EventService(EventReservation eventReservation, MenuService menuService) {
        this.eventReservation = eventReservation;
        this.menuService = menuService;
    }

    public void applyEvent() {
        benefitService = new BenefitService(eventReservation, menuService);
        benefitService.applyBenefit();

        badgeService = new BadgeService(benefitService.getTotalBenefitPrice());
        badgeService.applyBadge();

        eventReservation.setEventOrderPrice(benefitService.getDiscountedPrice());
    }

    public boolean isEventTarget(int orderPrice) {
        return orderPrice >= ServiceNumber.EVENT_MIN_PRICE.getNumber();
    }

    public BenefitService getBenefitService() {
        return benefitService;
    }

    public BadgeService getBadgeService() {
        return badgeService;
    }
}
