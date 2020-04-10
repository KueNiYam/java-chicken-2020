package domain;

import domain.exceptions.OrderNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderQuantityTest {

	@Test
	@DisplayName("음수 예외 테스트")
	void Order_NegativeNumber() {
		assertThatThrownBy(() -> new OrderQuantity(-1))
				.isInstanceOf(OrderNumberException.class);
	}

	@Test
	@DisplayName("99 초과 예외 테스트")
	void Order_MoreThanNinetyNine() {
		assertThatThrownBy(() -> new OrderQuantity(100))
				.isInstanceOf(OrderNumberException.class);
	}

	@Test
	@DisplayName("두 수 더하기 테스트")
	void add() {
		OrderQuantity a = new OrderQuantity(1);
		OrderQuantity b = new OrderQuantity(2);
		assertThat(a.add(b)).isEqualTo(new OrderQuantity(3));
	}

}