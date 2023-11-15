package christmas.service;

import christmas.domain.Benefit;
import christmas.domain.EventReservation;
import java.util.HashMap;
import java.util.Map;

public class BenefitService {
    private int totalDiscountPrice;

    private EventReservation eventReservation;
    private Map<Benefit, Integer> benefitList = new HashMap<>();
    private MenuService menuService;
    private DdayDiscountService ddayDiscountService;
    private WeekdayDiscountService weekdayDiscountService;
    private WeekendDiscountService weekendDiscountService;
    private SpecialDiscountService specialDiscountService;
    private GiveawayService giveawayService;

    public BenefitService(EventReservation eventReservation, MenuService menuService) {
        this.menuService = menuService;
        this.eventReservation = eventReservation;
        ddayDiscountService = new DdayDiscountService();
        weekdayDiscountService = new WeekdayDiscountService();
        weekendDiscountService = new WeekendDiscountService();
        specialDiscountService = new SpecialDiscountService();
        giveawayService = new GiveawayService();
    }

    public void applyBenefit() {
        applyDdayDiscount();
        applyWeekdayDiscount();
        applyWeekendDiscount();
        applySpecialDiscount();
        calculateTotalDiscountPrice();

        applyGiveaway();
    }

    private void applyDdayDiscount() {
        ddayDiscountService.applyDiscount(eventReservation.getDate());
        addBenefitToList(Benefit.DDAY_DISCOUNT, ddayDiscountService.getBenefitPrice());
    }

    private void applyWeekdayDiscount() {
        weekdayDiscountService.applyDiscount(eventReservation.getDate(), menuService.getOrderList());
        addBenefitToList(Benefit.WEEKDAY_DISCOUNT, weekdayDiscountService.getBenefitPrice());
    }

    private void applyWeekendDiscount() {
        weekendDiscountService.applyDiscount(eventReservation.getDate(), menuService.getOrderList());
        addBenefitToList(Benefit.WEEKEND_DISCOUNT, weekendDiscountService.getBenefitPrice());
    }

    private void applySpecialDiscount() {
        specialDiscountService.applyDiscount(eventReservation.getDate());
        addBenefitToList(Benefit.SPECIAL_DISCOUNT, specialDiscountService.getBenefitPrice());
    }

    private void applyGiveaway() {
        giveawayService.applyGiveaway(menuService.getOrderPrice());
        addBenefitToList(Benefit.GIVEAWAY_EVENT, giveawayService.getBenefitPrice());
        giveawayService.addGiveawayMenuToOrderList(eventReservation);
    }

    private void addBenefitToList(Benefit benefit, int benefitPrice) {
        if (benefitPrice != 0) {
            benefitList.put(benefit, benefitPrice);
        }
    }

    private void calculateTotalDiscountPrice() {
        totalDiscountPrice =  benefitList.keySet().stream()
                .filter(benefit -> benefit.getType() == "discount")
                .mapToInt(benefit -> benefitList.get(benefit))
                .sum();
    }

    public int getTotalBenefitPrice() {
        return benefitList.values().stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    public int getDiscountedPrice() {
        return menuService.getOrderPrice() - totalDiscountPrice;
    }

    public int getTotalDiscountPrice() {
        return totalDiscountPrice;
    }
}

