package christmas.controller;

import christmas.service.BadgeService;
import christmas.service.DateService;
import christmas.service.DiscountService;
import christmas.service.MenuService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ReservationController {
    InputView inputView;
    OutputView outputView;
    DateService dateService;
    MenuService menuService;
    DiscountService discountService;
    BadgeService badgeService;

    ReservationController() {
        inputView = new InputView();
        outputView = new OutputView();
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
