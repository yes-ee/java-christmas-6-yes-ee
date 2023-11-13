package christmas;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DateServiceTest {

    @DisplayName("날짜 범위 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints={0, 32, 100, -1})
    void dateValidationTest(int input) {
        // then
        assertThatThrownBy(
                () -> Validation.validateDate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
