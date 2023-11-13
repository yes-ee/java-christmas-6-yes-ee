package christmas;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.Menu;
import christmas.service.MenuService;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("메뉴 서비스 테스트")
public class MenuServiceTest {

    @DisplayName("메뉴 입력 형식 잘못된 경우")
    @Test
    void menuFormatNotValid() {
        // given
        String [] splitOrder = {"해산물파스타1"};

        // then
        assertThatThrownBy(
                () -> Validation.validateSplitOrder(splitOrder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문한 메뉴 존재하지 않는 경우")
    @Test
    void menuNotExist() {
        // given
        Menu orderMenu = null;
        Map<Menu, Integer> orderList = new HashMap<>();

        // then
        assertThatThrownBy(
                () -> Validation.validateMenu(orderMenu, orderList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("같은 메뉴 여러 번 입력한 경우")
    @Test
    void menuDuplicate() {
        // given
        Menu orderMenu = Menu.BABY_BACK_RIBS;
        Map<Menu, Integer> orderList = new HashMap<>();
        orderList.put(Menu.BABY_BACK_RIBS, 1);

        // then
        assertThatThrownBy(
                () -> Validation.validateMenu(orderMenu, orderList))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
