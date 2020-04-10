import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    private static final Orders orders = Orders.ofTables();

	public static void main(String[] args) {
		while (true) {
            run();
        }
	}

    private static void run() {
        final int commendNumber = start();
        if (Commend.ofNumber(commendNumber) == Commend.REGISTER) {
            register();
        }
        if (Commend.ofNumber(commendNumber) == Commend.PAY) {

        }
        if (Commend.ofNumber(commendNumber) == Commend.EXIT) {
            System.exit(0);
        }
    }

    private static void register() {
        final Table table = selectTable();
        orderAtTable(table);
    }

    private static Table selectTable() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();
        return TableRepository.findTableByNumber(tableNumber);
    }

    private static void orderAtTable(final Table table) {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        final int menuNumber = InputView.inputMenuNumber();
        final int quantity = InputView.inputQuantity();
        final Order order = orders.getOrderOfTable(table);
        order.add(MenuRepository.findMenuByNumber(menuNumber), new OrderQuantity(quantity));
    }

    private static int start() {
        OutputView.printMain();
        return InputView.inputCommendNumber();
    }
}
