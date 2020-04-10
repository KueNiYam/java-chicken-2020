package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
	private static final int ZERO = 0;
	private static final int CHICKEN_NUMBER_FOR_DISCOUNT = 10;
	private static final int CHICKEN_DISCOUNT_PRICE = 10_000;
	private static final double CASH_DISCOUNT_RATIO = 0.05;
	private final Map<Menu, OrderQuantity> wishList;

	private Order(final Map<Menu, OrderQuantity> wishList) {
		this.wishList = wishList;
	}

	public static Order ofMenus() {
		final Map<Menu, OrderQuantity> wishList = new LinkedHashMap<>();
		for (Menu menu : MenuRepository.menus()) {
			wishList.put(menu, new OrderQuantity(ZERO));
		}
		return new Order(wishList);
	}

	public void add(final Menu menu, final OrderQuantity orderQuantity) {
		wishList.put(menu, wishList.get(menu).add(orderQuantity));
	}

	public Map<Menu, OrderQuantity> getWishList() {
		return wishList;
	}

	public double simplySumPrice() {
		double result = ZERO;
		for (Map.Entry<Menu, OrderQuantity> entry : wishList.entrySet()) {
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
		for (Map.Entry<Menu, OrderQuantity> entry : wishList.entrySet()) {
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
}
