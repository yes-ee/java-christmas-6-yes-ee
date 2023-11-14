package christmas.domain;

public enum Benefit {
    DDAY_DISCOUNT("크리스마스 디데이 할인", "discount", 1000),
    WEEKDAY_DISCOUNT("평일 할인", "discount", 2023),
    WEEKEND_DISCOUNT("주말 할인", "discount", 2023),
    SPECIAL_DISCOUNT("특별 할인", "discount", 1000),
    GIVEAWAY_EVENT("증정 이벤트", "giveaway", 25000);

    private String name;
    private String type;
    private int price;

    Benefit(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}
