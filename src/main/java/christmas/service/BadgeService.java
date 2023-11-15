package christmas.service;


import christmas.domain.Badge;

public class BadgeService {
    Badge badge;

    public BadgeService() {
        this.badge = Badge.NOTHING;
    }

    public void applyBadge(int benefitPrice) {
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
