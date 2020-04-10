package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
	private final Map<Menu, Integer> wishList;

	private Order(final Map<Menu, Integer> wishList) {
		this.wishList = wishList;
	}

	public static Order create() {
		final Map<Menu, Integer> wishList = new LinkedHashMap<>();
		for (Menu menu : MenuRepository.menus()) {
			wishList.put(menu, 0);
		}
		return new Order(wishList);
	}

	public void add(final Menu menu, final int i) {
		wishList.put(menu, wishList.get(menu) + i);
	}

	public Map<Menu, Integer> getWishList() {
		return wishList;
	}
}
