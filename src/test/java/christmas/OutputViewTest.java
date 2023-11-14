package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.ErrorMessage;
import christmas.domain.Menu;
import christmas.view.OutputView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("출력 테스트")
public class OutputViewTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @DisplayName("에러 메시지 출력 기능")
    @Test
    void printError() {
        // given
        String message = ErrorMessage.DATE_WRONG.getMessage();

        // when
        OutputView.printErrorMessage(message);

        // then
        assertThat(outputStream.toString())
                .contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

//    @DisplayName("주문 내역 출력 기능")
//    @Test
//    void printOrderList() {
//        // given
//        Map<Menu, Integer> orderList = new HashMap<>();
//        orderList.put(Menu.CHRISTMAS_PASTA, 2);
//        orderList.put(Menu.BABY_BACK_RIBS, 3);
//
//        // when
//        OutputView.printOrderList(orderList);
//
//        // then
//        assertThat(outputStream.toString())
//                .contains("<주문 메뉴>",
//                        "크리스마스파스타 2개",
//                        "바비큐립 3개");
//
//    }

}
