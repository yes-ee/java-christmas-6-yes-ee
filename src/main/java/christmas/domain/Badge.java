package christmas.domain;

public enum Badge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private String name;
    private int benefitPrice;

    Badge(String name, int benefitPrice) {
        this.name = name;
        this.benefitPrice = benefitPrice;
    }

    public String getName() {
        return name;
    }

    public int getBenefitPrice() {
        return benefitPrice;
    }
}
