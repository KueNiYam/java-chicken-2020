package domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Orders {
	private final Map<Table, Order> orders;

	private Orders(final Map<Table, Order> orders) {
		this.orders = orders;
	}

	public static Orders ofTables() {
		final Map<Table, Order> orders = new LinkedHashMap<>();
		for (Table table : TableRepository.tables()) {
			orders.put(table, Order.ofMenus());
		}

		return new Orders(orders);
	}

	public Set<Table> keySet() {
		return orders.keySet();
	}

	public Order getOrderOfTable(final Table table) {
		return orders.get(table);
	}

}