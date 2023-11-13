package christmas.constant;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR] "),
    DATE_WRONG("유효하지 않은 날짜 형식입니다. 다시 입력해 주세요."),
    MENU_WRONG("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
