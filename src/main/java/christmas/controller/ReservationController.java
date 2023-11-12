package christmas.controller;

import christmas.service.BadgeService;
import christmas.service.DateService;
import christmas.service.DiscountService;
import christmas.service.MenuService;
import christmas.view.OutputView;

public class ReservationController {
    DateService dateService;
    MenuService menuService;
    DiscountService discountService;
    BadgeService badgeService;

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
        dateService.chooseDate();
    }

    private void selectMenu() {
        menuService.chooseMenu();
        OutputView.printOrder(menuService.getOrderList());
    }

    private void applyDiscount() {
    }

    private void giveBadge() {
    }
}
