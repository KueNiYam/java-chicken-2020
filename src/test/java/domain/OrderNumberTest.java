package domain;

import domain.exceptions.OrderNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderNumberTest {

	@Test
	@DisplayName("음수 예외 테스트")
	void Order_NegativeNumber() {
		assertThatThrownBy(() -> new OrderNumber(-1))
				.isInstanceOf(OrderNumberException.class);
	}

	@Test
	@DisplayName("99 초과 예외 테스트")
	void Order_MoreThanNinetyNine() {
		assertThatThrownBy(() -> new OrderNumber(100))
				.isInstanceOf(OrderNumberException.class);
	}

	@Test
	@DisplayName("두 수 더하기 테스트")
	void add() {
		OrderNumber a = new OrderNumber(1);
		OrderNumber b = new OrderNumber(2);
		assertThat(a.add(b)).isEqualTo(new OrderNumber(3));
	}

}