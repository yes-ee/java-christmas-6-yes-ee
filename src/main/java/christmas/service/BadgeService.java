package christmas.service;


import christmas.domain.Badge;

public class BadgeService {
    int benefitPrice;
    Badge badge;

    public BadgeService(int benefitPrice) {
        this.benefitPrice = benefitPrice;
        this.badge = Badge.NOTHING;
    }

    public void applyBadge() {
        if (benefitPrice >= Badge.SANTA.getBenefitPrice()) {
            badge = Badge.SANTA;
        } else if (benefitPrice >= Badge.TREE.getBenefitPrice()) {
            badge = Badge.TREE;
        } else if (benefitPrice >= Badge.STAR.getBenefitPrice()) {
            badge = Badge.STAR;
        }
    }

    public Badge getBadge() {
        return badge;
    }
}
