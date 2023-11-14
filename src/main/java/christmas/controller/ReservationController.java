package christmas.controller;

import christmas.service.DateService;
import christmas.service.EventService;
import christmas.service.MenuService;
import christmas.view.OutputView;

public class ReservationController {
    private DateService dateService;
    private MenuService menuService;
    private EventService eventService;

     public ReservationController() {
        dateService = new DateService();
        menuService = new MenuService();
    }

    public void run() {
        OutputView.printStartMessage();
        selectDate();
        selectMenu();
        checkEvent();
        OutputView.printBenefitPreview(dateService.getDate(), menuService);
    }

    private void selectDate() {
         dateService.chooseDate();
    }

    private void selectMenu() {
        menuService.chooseMenu();
    }

    private void checkEvent() {
        eventService = new EventService(
                dateService.getDate(), menuService.getOrderList(), menuService.getOrderPrice());

        if (!eventService.isEventTarget(menuService.getOrderPrice())) {
            return;
        }

        eventService.applyEvent();
    }
}
