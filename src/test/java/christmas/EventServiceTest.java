package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Menu;
import christmas.service.EventService;
import christmas.service.MenuService;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("이벤트 서비스 테스트")
public class EventServiceTest {

    @DisplayName("이벤트 적용 대상이 아닌 경우")
    @Test
    void notEventTarget() {
        // given
        int date = 1;
        MenuService menuService = new MenuService();
        menuService.addOrder(Menu.TAPAS, 1);
        int orderPrice = menuService.getOrderPrice();
        EventService eventService = new EventService(date, menuService);

        // when
        boolean isTarget = eventService.isEventTarget(orderPrice);

        // then
        assertThat(isTarget).isFalse();
    }
}
