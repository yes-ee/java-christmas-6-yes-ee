package christmas.constant;

public enum ServiceNumber {
    DATE_MIN(1),
    DATE_MAX(31),
    MENU_MIN(1),
    MENU_MAX(20),
    EVENT_MIN_PRICE(10000),
    DDAY_DISCOUNT_END(25),
    FREE_EVENT_MIN_PRICE(120000);

    private int number;

    ServiceNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
