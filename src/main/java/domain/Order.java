package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
	private static final int ZERO = 0;
	private final Map<Menu, OrderNumber> wishList;

	private Order(final Map<Menu, OrderNumber> wishList) {
		this.wishList = wishList;
	}

	public static Order create() {
		final Map<Menu, OrderNumber> wishList = new LinkedHashMap<>();
		for (Menu menu : MenuRepository.menus()) {
			wishList.put(menu, new OrderNumber(ZERO));
		}
		return new Order(wishList);
	}

	public void add(final Menu menu, final OrderNumber orderNumber) {
		wishList.put(menu, wishList.get(menu).add(orderNumber));
	}

	public Map<Menu, OrderNumber> getWishList() {
		return wishList;
	}

	public int computePriceOfCash() {
		return 0;
	}
}
