package domain;

import domain.exceptions.OrderNumberException;

import java.util.Objects;

public class OrderQuantity {
	private static final int MIN_NUM = 0;
	private static final int MAX_NUM = 99;
	private final int orderNumber;

	public OrderQuantity(final int orderNumber) {
		if (orderNumber < MIN_NUM) {
			throw new OrderNumberException("주문 번호는 0보다 작을 수 없습니다.");
		}

		if (orderNumber > MAX_NUM) {
			throw new OrderNumberException("주문 번호는 99보다 클 수 없습니다.");
		}

		this.orderNumber = orderNumber;
	}

	public OrderQuantity add(OrderQuantity other) {
		return new OrderQuantity(orderNumber + other.orderNumber);
	}

	public boolean isMoreThanZero() {
		return orderNumber > MIN_NUM;
	}

	public int getInt() {
		return orderNumber;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final OrderQuantity that = (OrderQuantity) o;
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
