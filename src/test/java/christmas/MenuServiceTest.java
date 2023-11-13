package christmas;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.service.MenuService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("메뉴 서비스 테스트")
public class MenuServiceTest {

    @DisplayName("메뉴 입력 형식 잘못된 경우")
    @Test
    void menuFormatNotValid() {
        //given
        String [] splitOrder = {"해산물파스타1"};

        // then
        assertThatThrownBy(
                () -> Validation.validateSplitOrder(splitOrder))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
