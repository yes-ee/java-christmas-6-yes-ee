package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class EventReservation {
    private int date;
    private Map<Menu, Integer> eventOrderList;
    private int eventOrderPrice;

    public EventReservation(int date, Map<Menu, Integer> eventOrderList, int eventOrderPrice) {
        this.date = date;
        this.eventOrderList = new HashMap<>(eventOrderList);
        this.eventOrderPrice = eventOrderPrice;
    }

    public void addOrder(Menu menu, int count) {
        eventOrderList.put(menu, count);
    }

    public void setEventOrderPrice(int discountedPrice) {
        eventOrderPrice = discountedPrice;
    }

    public int getDate() {
        return date;
    }

    public Map<Menu, Integer> getEventOrderList() {
        return eventOrderList;
    }

    public int getEventOrderPrice() {
        return eventOrderPrice;
    }
}
