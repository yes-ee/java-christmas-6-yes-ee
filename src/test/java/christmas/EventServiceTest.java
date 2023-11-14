package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Menu;
import christmas.service.EventService;
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
        Map<Menu, Integer> orderList = new HashMap<>();
        int orderPrice = 9000;
        orderList.put(Menu.TAPAS, 1);
        orderList.put(Menu.ZERO_COLA, 1);
        EventService eventService = new EventService(date, orderList, orderPrice);

        // when
        boolean isTarget = eventService.isEventTarget(orderPrice);

        // then
        assertThat(isTarget).isFalse();
    }
}
