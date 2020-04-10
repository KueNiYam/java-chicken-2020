package domain;

import domain.exceptions.OrderNumberException;

import java.util.Objects;

public class OrderNumber {
	private static final int MIN_NUM = 0;
	private static final int MAX_NUM = 99;
	private final int orderNumber;

	public OrderNumber(final int orderNumber) {
		if (orderNumber < MIN_NUM) {
			throw new OrderNumberException("주문 번호는 0보다 작을 수 없습니다.");
		}

		if (orderNumber > MAX_NUM) {
			throw new OrderNumberException("주문 번호는 99보다 클 수 없습니다.");
		}

		this.orderNumber = orderNumber;
	}

	public OrderNumber add(OrderNumber other) {
		return new OrderNumber(orderNumber + other.orderNumber);
	}

	public int getInt() {
		return orderNumber;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final OrderNumber that = (OrderNumber) o;
		return orderNumber == that.orderNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderNumber);
	}

	@Override
	public String toString() {
		return "OrderNumber{" +
				"orderNumber=" + orderNumber +
				'}';
	}
}
