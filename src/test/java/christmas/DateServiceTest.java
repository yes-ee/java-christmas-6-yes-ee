package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import christmas.service.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DateServiceTest {

    @DisplayName("날짜 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings={"a", "-1", "32", "55", "0", "3a"})
    void dateValidationTest(String input) {
        // then
        assertThatThrownBy(
                () -> Validation.checkDate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

}
