package christmas.controller;

import christmas.service.BadgeService;
import christmas.service.DateService;
import christmas.service.DiscountService;
import christmas.service.MenuService;

public class ReservationController {
    private DateService dateService;
    private MenuService menuService;
    private DiscountService discountService;
    private BadgeService badgeService;

     public ReservationController() {
        dateService = new DateService();
        menuService = new MenuService();
        discountService = new DiscountService();
        badgeService = new BadgeService();
    }

    public void run() {
        selectDate();
        selectMenu();
        applyDiscount();
        giveBadge();
    }

    private void selectDate() {
    }

    private void selectMenu() {
    }

    private void applyDiscount() {
    }

    private void giveBadge() {
    }
}
