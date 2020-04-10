import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
	// TODO 구현 진행 ㅠㅠ
	public static void main(String[] args) {
		while (true) {
		    OutputView.printMain();
            final int commendNumber = InputView.inputCommendNumber();
            if (Commend.ofNumber(commendNumber) == Commend.REGISTER) {
                final List<Table> tables = TableRepository.tables();
                OutputView.printTables(tables);
                final int tableNumber = InputView.inputTableNumber();
            }
            if (Commend.ofNumber(commendNumber) == Commend.PAY) {

            }
            if (Commend.ofNumber(commendNumber) == Commend.EXIT) {
                break;
            }


			final List<Menu> menus = MenuRepository.menus();
			OutputView.printMenus(menus);
		}

	}
}
