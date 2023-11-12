package christmas;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.service.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("메뉴 서비스 테스트")
public class MenuServiceTest {

    @DisplayName("없는 메뉴인 경우")
    @ParameterizedTest
    @ValueSource(strings={"해산물-1", "abc", "123.2"})
    void menuNameWrong(String input) {
        // then
        assertThatThrownBy(
                () -> Validation.checkMenu(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴가 20개보다 많은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-21"})
    void menuTooMany(String input) {
        // then
        assertThatThrownBy(
                () -> Validation.checkMenu(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴가 중복된 경우")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-1,양송이수프-2,해산물파스타-1"})
    void menuDuplicated(String input) {
        // then
        assertThatThrownBy(
                () -> Validation.checkMenu(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("음료 메뉴만 시킨 경우")
    @ParameterizedTest
    @ValueSource(strings = {"콜라-1,사이다-2", "콜라-2"})
    void menuOnlyDrink(String input) {
        // then
        assertThatThrownBy(
                () -> Validation.checkMenu(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
