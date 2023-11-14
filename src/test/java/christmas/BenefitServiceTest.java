package christmas;

import christmas.domain.Menu;
import christmas.service.DdayDiscountService;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.service.SpecialDiscountService;
import christmas.service.WeekdayDiscountService;
import christmas.service.WeekendDiscountService;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
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
}
