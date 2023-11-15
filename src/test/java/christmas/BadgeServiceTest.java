package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.service.BadgeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("뱃지 서비스 테스트")
public class BadgeServiceTest {
    @DisplayName("구입 금액에 따라 뱃지가 부여되는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5000:별", "15000:트리", "30000:산타"}, delimiter = ':')
    void giveBadge(int price, String expected) {
        // given
        BadgeService badgeService = new BadgeService();

        // when
        badgeService.applyBadge(price);

        // then
        assertThat(badgeService.getBadge().getName()).isEqualTo(expected);
    }

}
