package christmas.controller;

import christmas.service.BadgeService;
import christmas.service.DateService;
import christmas.service.DiscountService;
import christmas.service.MenuService;
import christmas.view.OutputView;

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
        OutputView.printStartMessage();
        selectDate();
        selectMenu();
        applyEvent();
        OutputView.printBenefitPreview(dateService.getDate(), menuService.getOrderList());
        // 혜택 출력 예정
    }

    private void selectDate() {
         dateService.chooseDate();
    }

    private void selectMenu() {
        menuService.chooseMenu();
    }

    private void applyEvent() {

    }
}
