package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MenuRepositoryTest {

	@Test
	void findMenuByNumber() {
		assertThat(MenuRepository.findMenuByNumber(4))
				.isEqualTo(new Menu(4, "통구이", Category.CHICKEN, 16_000));
	}
}