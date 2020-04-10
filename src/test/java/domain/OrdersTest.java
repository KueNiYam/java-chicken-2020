package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrdersTest {

	@Test
	void ofTables() {
		final Orders orders = Orders.ofTables();
		final List<Table> tables = new ArrayList<>(orders.keySet());
		assertThat(tables).isEqualTo(TableRepository.tables());
	}
}