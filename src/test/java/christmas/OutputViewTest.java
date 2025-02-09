package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.ErrorMessage;
import christmas.view.OutputView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
}
