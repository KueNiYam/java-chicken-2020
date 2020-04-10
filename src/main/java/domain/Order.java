package domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Order {
	private static final int ZERO = 0;
	private static final int CHICKEN_NUMBER_FOR_DISCOUNT = 10;
	private static final int CHICKEN_DISCOUNT_PRICE = 10_000;
	private static final double CASH_DISCOUNT_RATIO = 0.05;
	private final Map<Menu, OrderQuantity> order;

	private Order(final Map<Menu, OrderQuantity> order) {
		this.order = order;
	}

	public static Order ofMenus() {
		final Map<Menu, OrderQuantity> wishList = new LinkedHashMap<>();
		for (Menu menu : MenuRepository.menus()) {
			wishList.put(menu, new OrderQuantity(ZERO));
		}
		return new Order(wishList);
	}

	public void add(final Menu menu, final OrderQuantity orderQuantity) {
		order.put(menu, order.get(menu).add(orderQuantity));
	}

	public Map<Menu, OrderQuantity> getOrder() {
		return order;
	}

	public double simplySumPrice() {
		double result = ZERO;
		for (Map.Entry<Menu, OrderQuantity> entry : order.entrySet()) {
			result += entry.getKey().computePriceOfNumber(entry.getValue());
		}
		return result;
	}

	public double computeChickenDiscount(final double price) {
		final int chicken = countChicken();
		final int discountNum = chicken / CHICKEN_NUMBER_FOR_DISCOUNT;
		final double discountPrice = discountNum * CHICKEN_DISCOUNT_PRICE;

		return price - discountPrice;
	}

	private int countChicken() {
		int chicken = ZERO;
		for (Map.Entry<Menu, OrderQuantity> entry : order.entrySet()) {
			chicken += countChickForEntry(entry);
		}
		return chicken;
	}

	private int countChickForEntry(final Map.Entry<Menu, OrderQuantity> entry) {
		if (entry.getKey().isChicken()) {
			return entry.getValue().getInt();
		}
		return ZERO;
	}

	public double computeCashDiscount(final double price) {
		return price - price * CASH_DISCOUNT_RATIO;
	}

	public Set<Map.Entry<Menu, OrderQuantity>> entrySet() {
		return order.entrySet();
	}
}
