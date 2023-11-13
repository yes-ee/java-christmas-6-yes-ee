package christmas.domain;

public enum Menu {
    SOUP("양송이수프", 6000, "appetizer"),
    TAPAS("타파스", 5500, "appetizer"),
    CAESAR_SALAD("시저샐러드", 8000, "appetizer"),
    T_BONE_STEAK("티본스테이크", 55000, "main"),
    BABY_BACK_RIBS("바비큐립", 54000, "main"),
    SEAFOOD_PASTA("해산물파스타", 35000, "main"),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, "main"),
    CHOCOLATE_CAKE("초코케이크", 15000, "dessert"),
    ICE_CREAM("아이스크림", 5000, "dessert"),
    ZERO_COLA("제로콜라", 3000, "drink"),
    RED_WINE("레드와인", 60000, "drink"),
    CHAMPAGNE("샴페인", 25000, "drink");

    private String name;
    private int price;
    private String type;

    Menu(String name, int price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public static Menu getMenu(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(name)) {
                return menu;
            }
        }
        return null;
    }
}