package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class WishListTest {
	private WishList wishList;
	private Menu menu;

	@BeforeEach
	void setUp() {
		wishList = WishList.create();
		menu  = MenuRepository.menus().get(0);
	}

	@Test
	@DisplayName("인스턴스 테스트")
	void create_IsNotNull() {
		assertThat(wishList).isNotNull();
	}

	@Test
	@DisplayName("모든 메뉴 키가 있는지 테스트")
	void create_HasAllMenusKey() {
		final List<Menu> keys = new ArrayList<>(wishList.getWishList()
				.keySet());
		final List<Menu> menus = MenuRepository.menus();

		assertThat(keys).isEqualTo(menus);
	}

	@Test
	@DisplayName("주문 등록 테스트")
	void add_register() {
		wishList.add(menu, 1);
		assertThat(wishList.getWishList().get(menu)).isEqualTo(1);
	}

	@Test
	@DisplayName("주문 추가 테스트")
	void add() {
		wishList.add(menu, 1);
		wishList.add(menu, 1);
		assertThat(wishList.getWishList().get(menu)).isEqualTo(2);
	}
}