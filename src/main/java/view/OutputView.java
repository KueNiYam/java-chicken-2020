package view;

import domain.*;

import java.util.List;
import java.util.Map;

public class OutputView {
	private static final String STICK_SEPERATOR = " - ";
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";

	public static void printTables(final List<Table> tables) {
		System.out.println("## 테이블 목록");
		final int size = tables.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tables);
		printLine(BOTTOM_LINE, size);
	}

	public static void printMenus(final List<Menu> menus) {
		for (final Menu menu : menus) {
			System.out.println(menu);
		}
	}

	private static void printLine(final String line, final int count) {
		for (int index = 0; index < count; index++) {
			System.out.print(line);
		}
		System.out.println();
	}

	private static void printTableNumbers(final List<Table> tables) {
		for (final Table table : tables) {
			System.out.printf(TABLE_FORMAT, table);
		}
		System.out.println();
	}

	public static void printMain() {
		System.out.println("## 메인화면");
		for (Commend value : Commend.values()) {
			System.out.println(value.getNumber() + STICK_SEPERATOR + value.getMessage());
		}
	}

	public static void printOrder(final Order orderOfTable) {
		System.out.println("## 주문내역");
		System.out.println("메뉴 수량 금액");
		for (Map.Entry<Menu, OrderQuantity> entry : orderOfTable.entrySet()) {
			if (entry.getValue().isMoreThanZero()) {
				System.out.println(entry.getKey().getName()
						+ " "
						+ entry.getValue().getInt()
						+ " "
						+ entry.getKey().getPrice() * entry.getValue().getInt());
			}
		}
	}

	public static void printFinalAmount(final double finalAmount) {
		System.out.println("## 최종 결제할 금액");
		System.out.println((int) finalAmount + "원");
	}
}
