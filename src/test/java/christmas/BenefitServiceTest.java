package christmas;

import christmas.constant.ServiceNumber;
import christmas.domain.Menu;
import christmas.service.BenefitService;
import christmas.service.DdayDiscountService;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.service.GiveawayService;
import christmas.service.MenuService;
import christmas.service.SpecialDiscountService;
import christmas.service.WeekdayDiscountService;
import christmas.service.WeekendDiscountService;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("할인 서비스 테스트")
public class BenefitServiceTest {

    @DisplayName("크리스마스 디데이 할인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1000", "25:3400", "10:1900", "26:0"}, delimiter = ':')
    void ddayDiscount(int date, int expected) {
        // given
        DdayDiscountService discountService = new DdayDiscountService();

        // when
        discountService.applyDiscount(date);
        int discountPrice = discountService.getBenefitPrice();

        // then
        assertThat(discountPrice).isEqualTo(expected);
    }

    @DisplayName("평일 할인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:0", "8:0", "5:4046", "11: 4046"}, delimiter = ':')
    void weekdayDiscount(int date, int expected) {
        // given
        WeekdayDiscountService discountService = new WeekdayDiscountService();
        Map<Menu, Integer> orderList = new HashMap<>();
        orderList.put(Menu.CHOCOLATE_CAKE, 1);
        orderList.put(Menu.ICE_CREAM, 1);
        orderList.put(Menu.SEAFOOD_PASTA, 1);

        // when
        discountService.applyDiscount(date, orderList);
        int discountPrice = discountService.getBenefitPrice();

        // then
        assertThat(discountPrice).isEqualTo(expected);
    }

    @DisplayName("주말 할인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2023", "2:2023", "8:2023", "5:0", "11:0", "12:0"}, delimiter = ':')
    void weekendDiscount(int date, int expected) {
        // given
        WeekendDiscountService discountService = new WeekendDiscountService();
        Map<Menu, Integer> orderList = new HashMap<>();
        orderList.put(Menu.CHOCOLATE_CAKE, 1);
        orderList.put(Menu.ICE_CREAM, 1);
        orderList.put(Menu.SEAFOOD_PASTA, 1);

        // when
        discountService.applyDiscount(date, orderList);
        int discountPrice = discountService.getBenefitPrice();

        // then
        assertThat(discountPrice).isEqualTo(expected);
    }

    @DisplayName("특별 할인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:0", "3:1000", "10:1000", "17: 1000", "24:1000", "25:1000", "26:0"}, delimiter = ':')
    void specialDiscount(int date, int expected) {
        // given
        SpecialDiscountService discountService = new SpecialDiscountService();

        // when
        discountService.applyDiscount(date);
        int discountPrice = discountService.getBenefitPrice();

        // then
        assertThat(discountPrice).isEqualTo(expected);
    }

    @DisplayName("증정 이벤트 혜택 금액 테스트")
    @Test
    void giveawayEventBenefit() {
        // given
        MenuService menuService = new MenuService();
        menuService.addOrder(Menu.BABY_BACK_RIBS, 3);
        GiveawayService giveawayService = new GiveawayService();

        // when
        giveawayService.applyGiveaway(menuService.getOrderPrice());

        // then
        assertThat(giveawayService.getBenefitPrice()).isEqualTo(Menu.CHAMPAGNE.getPrice());
    }

    @DisplayName("증정 이벤트 증정품 주문 내역 추가 테스트")
    @Test
    void giveawayMenuToOrderList() {
        // given
        MenuService menuService = new MenuService();
        menuService.addOrder(Menu.BABY_BACK_RIBS, 3);
        GiveawayService giveawayService = new GiveawayService();

        // when
        giveawayService.applyGiveaway(menuService.getOrderPrice());
        giveawayService.addGiveawayMenuToOrderList(menuService);

        // then
        assertThat(menuService.getOrderList().get(Menu.CHAMPAGNE)).isEqualTo(1);
    }

    @DisplayName("증정 이벤트 해당 안 되는 경우 금액 확인")
    @Test
    void checkBenefitPriceWhenNotGiveaway() {
        // given
        MenuService menuService = new MenuService();
        menuService.addOrder(Menu.BABY_BACK_RIBS, 2);
        GiveawayService giveawayService = new GiveawayService();

        // when
        giveawayService.applyGiveaway(menuService.getOrderPrice());

        // then
        assertThat(giveawayService.getBenefitPrice()).isEqualTo(0);
    }

    @DisplayName("증정 이벤트 해당 안 되는 경우 주문 내역 확인")
    @Test
    void checkOrderListWhenNotGiveaway() {
        // given
        MenuService menuService = new MenuService();
        menuService.addOrder(Menu.BABY_BACK_RIBS, 2);
        GiveawayService giveawayService = new GiveawayService();

        // when
        giveawayService.applyGiveaway(menuService.getOrderPrice());

        // then
        assertThat(menuService.getOrderList().keySet()).doesNotContain(Menu.CHAMPAGNE);
    }

    @DisplayName("총혜택 금액 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:3023", "2:3123", "3:6246", "4:5346", "25: 8446"}, delimiter = ':')
    void totalBenefitPrice(int date, int expected) {
        // given
        MenuService menuService = new MenuService();
        menuService.addOrder(Menu.BABY_BACK_RIBS, 1);
        menuService.addOrder(Menu.CHOCOLATE_CAKE, 1);
        menuService.addOrder(Menu.ICE_CREAM, 1);
        BenefitService benefitService = new BenefitService(date, menuService);

        // when
        benefitService.applyBenefit();

        // then
        assertThat(benefitService.getBenefitPriceSum()).isEqualTo(expected);
    }

    @DisplayName("총혜택 금액 테스트 샴페인 포함")
    @ParameterizedTest
    @CsvSource(value = {"1:32069"}, delimiter = ':')
    void totalBenefitPriceWithGiveaway(int date, int expected) {
        // given
        MenuService menuService = new MenuService();
        menuService.addOrder(Menu.BABY_BACK_RIBS, 3);
        menuService.addOrder(Menu.CHOCOLATE_CAKE, 1);
        menuService.addOrder(Menu.ICE_CREAM, 1);
        BenefitService benefitService = new BenefitService(date, menuService);

        // when
        benefitService.applyBenefit();
        // then
        assertThat(benefitService.getBenefitPriceSum()).isEqualTo(expected);
    }
}
