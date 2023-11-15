package christmas;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.validation.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("날짜 서비스 테스트")
public class DateServiceTest {

    @DisplayName("날짜에 숫자 아닌 값 들어오는 경우 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings={"a", "b2", "11c"})
    void dateNotNumberTest(String input) {
        // then
        assertThatThrownBy(
                () -> Validation.validateDate(Integer.parseInt(input)))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("날짜 범위 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints={0, 32, 100, -1})
    void dateRangeTest(int input) {
        // then
        assertThatThrownBy(
                () -> Validation.validateDate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
