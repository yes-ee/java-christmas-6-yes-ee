package christmas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.Menu;
import christmas.service.MenuService;
import christmas.validation.Validation;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("메뉴 개수 0개인 경우")
    @Test
    void menuCount0() {
        // given
        int orderCount = 0;

        // then
        assertThatThrownBy(
                () -> Validation.validateCount(orderCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문한 개수 20개 넘어간 경우")
    @Test
    void menuCountMoreThan20() {
        // given
        Map<Menu, Integer> orderList = new HashMap<>();
        orderList.put(Menu.BABY_BACK_RIBS, 10);
        orderList.put(Menu.CAESAR_SALAD, 10);
        orderList.put(Menu.CHRISTMAS_PASTA, 1);

        // then
        assertThatThrownBy(
                () -> Validation.validateOrderList(orderList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료 메뉴만 주문한 경우")
    @Test
    void orderDrinkOnly() {
        // given
        Map<Menu, Integer> orderList = new HashMap<>();
        orderList.put(Menu.RED_WINE, 2);

        // then
        assertThatThrownBy(
                () -> Validation.validateOrderList(orderList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("총주문 금액 계산 기능")
    @Test
    void orderPrice() {
        // given
        MenuService menuService = new MenuService();
        menuService.addOrder(Menu.BABY_BACK_RIBS, 1);
        menuService.addOrder(Menu.CAESAR_SALAD, 1);

        // when
        int orderPrice = menuService.getOrderPrice();

        // then
        assertThat(orderPrice).isEqualTo(62000);
    }
}
