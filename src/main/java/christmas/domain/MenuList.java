package christmas.domain;

import java.util.Map;

public class MenuList {
    private Map<String, Integer> appetizer;
    private Map<String, Integer> main;
    private Map<String, Integer> dessert;
    private Map<String, Integer> drink;

    public MenuList() {
        appetizer = Map.of(
                "양송이수프", 6000,
                "타파스", 5500,
                "시저샐러드", 8000
        );
        main = Map.of(
                "티본스테이크", 55000,
                "바비큐립", 54000,
                "해산물파스타", 35000,
                "크리스마스파스타", 25000
        );
        dessert = Map.of(
                "초코케이크", 15000,
                "아이스크림", 5000
        );
        drink = Map.of(
                "제로콜라", 3000,
                "레드와인", 60000,
                "샴페인", 25000
        );
    }

    public Map<String, Integer> getAppetizer() {
        return appetizer;
    }

    public Map<String, Integer> getMain() {
        return main;
    }

    public Map<String, Integer> getDessert() {
        return dessert;
    }

    public Map<String, Integer> getDrink() {
        return drink;
    }

    public String checkType(String menuName) {
        if (appetizer.containsKey(menuName)) {
            return "appetizer";
        }
        if (main.containsKey(menuName)) {
            return "main";
        }
        if (dessert.containsKey(menuName)) {
            return "dessert";
        }
        if (drink.containsKey(menuName)) {
            return "drink";
        }
        return "none";

    }

    public Map<String, Integer> getMenu(String type) {
        if (type == "appetizer") {
            return appetizer;
        }
        if (type == "main") {
            return main;
        }
        if (type == "dessert") {
            return dessert;
        }
        if (type == "drink") {
            return drink;
        }
        return null;
    }

}
