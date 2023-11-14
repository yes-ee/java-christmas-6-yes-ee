package christmas;

import christmas.service.DdayDiscountService;
import static org.assertj.core.api.Assertions.assertThat;
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
}
