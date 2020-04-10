package domain;

import java.util.Arrays;

public enum Commend {
	REGISTER(1, "주문등록"),
	PAY(2, "결제하기"),
	EXIT(3, "프로그램 종료");

	private final int number;
	private final String message;

	Commend(final int number, final String message) {
		this.number = number;
		this.message = message;
	}

	public static Commend ofNumber(final int number) {
		return Arrays.stream(values())
				.filter(commend -> commend.number == number)
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
