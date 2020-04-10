package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {
	private Order order;
	private Menu menu;

	@BeforeEach
	void setUp() {
		order = Order.ofMenus();
		menu  = MenuRepository.menus().get(0);
	}

	@Test
	@DisplayName("인스턴스 테스트")
	void create_IsNotNull() {
		assertThat(order).isNotNull();
	}

	@Test
	@DisplayName("모든 메뉴 키가 있는지 테스트")
	void create_HasAllMenusKey() {
		final List<Menu> keys = new ArrayList<>(order.getOrder()
				.keySet());
		final List<Menu> menus = MenuRepository.menus();

		assertThat(keys).isEqualTo(menus);
	}

	@Test
	@DisplayName("주문 등록 테스트")
	void add_register() {
		order.add(menu, new OrderQuantity(1));
		assertThat(order.getOrder().get(menu)).isEqualTo(new OrderQuantity(1));
	}

	@Test
	@DisplayName("주문 추가 테스트")
	void add() {
		order.add(menu, new OrderQuantity(1));
		order.add(menu, new OrderQuantity(1));
		assertThat(order.getOrder().get(menu)).isEqualTo(new OrderQuantity(2));
	}

	@Test
	@DisplayName("아무것도 안 샀을 때 단순 가격 합")
	void simplySumPrice_NotThing() {
		assertThat(order.simplySumPrice()).isEqualTo(0);
	}

	@Test
	@DisplayName("3개 샀을 때 단순 가격 합")
	void simplySumPrice_NotChickenDiscount() {
		order.add(MenuRepository.findMenuByNumber(1), new OrderQuantity(1));
		order.add(MenuRepository.findMenuByNumber(2), new OrderQuantity(1));
		order.add(MenuRepository.findMenuByNumber(3), new OrderQuantity(1));

		assertThat(order.simplySumPrice()).isEqualTo(16_000 * 3);
	}

	@Test
	@DisplayName("15개 샀을 때 치킨 10개 할인 적용")
	void computeChickenDiscount() {
		order.add(MenuRepository.findMenuByNumber(1), new OrderQuantity(5));
		order.add(MenuRepository.findMenuByNumber(2), new OrderQuantity(5));
		order.add(MenuRepository.findMenuByNumber(3), new OrderQuantity(5));

		double simpleSum = order.simplySumPrice();
		assertThat(order.computeChickenDiscount(simpleSum)).isEqualTo(16_000 * 15 - 10000);
	}

	@Test
	@DisplayName("치킨 9개 음료 1개는 적용 안 됨")
	void computeChickenDiscount_OneBeverageNineChicken() {
		order.add(MenuRepository.findMenuByNumber(1), new OrderQuantity(9));
		order.add(MenuRepository.findMenuByNumber(22), new OrderQuantity(1));

		double simpleSum = order.simplySumPrice();
		assertThat(order.computeChickenDiscount(simpleSum)).isEqualTo(16_000 * 9 + 1_000);
	}

	@Test
	@DisplayName("현금 할인")
	void computeCashDiscount() {
		assertThat(order.computeCashDiscount(10_000)).isEqualTo(10_000 * 0.95);
	}
}