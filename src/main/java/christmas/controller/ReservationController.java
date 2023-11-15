package christmas.controller;

import christmas.domain.EventReservation;
import christmas.service.DateService;
import christmas.service.EventService;
import christmas.service.MenuService;
import christmas.view.OutputView;

public class ReservationController {
    private DateService dateService;
    private MenuService menuService;
    private EventService eventService;
    private EventReservation eventReservation;

     public ReservationController() {
        dateService = new DateService();
        menuService = new MenuService();
    }

    public void run() {
        OutputView.printStartMessage();
        selectDate();
        selectMenu();
        checkEvent();
        printBenefit();
    }

    private void printBenefit() {
        OutputView.printPreviewStart(dateService.getDate());
        OutputView.printOrderList(menuService.getOrderList());
        OutputView.printOrderPrice(menuService.getOrderPrice());
        OutputView.printGiveawayMenu(
                eventService.getBenefitService().getBenefitList(),
                eventService.getBenefitService().getGiveawayMenu(),
                eventService.getBenefitService().getGiveawayCount());
        OutputView.printBenefitHistory(eventService.getBenefitService().getBenefitList());
        OutputView.printBenefitPrice(eventService.getBenefitService().getTotalBenefitPrice());
        OutputView.printDiscountedPrice(eventService.getBenefitService().getDiscountedPrice());
        OutputView.printBadge(eventService.getBadgeService().getBadge());
    }

    private void selectDate() {
         dateService.chooseDate();
    }

    private void selectMenu() {
        menuService.chooseMenu();
    }

    private void checkEvent() {
        eventReservation = new EventReservation(
                dateService.getDate(), menuService.getOrderList(), menuService.getOrderPrice());
        eventService = new EventService(eventReservation, menuService);

        if (!eventService.isEventTarget(menuService.getOrderPrice())) {
            return;
        }

        eventService.applyEvent();
    }
}
