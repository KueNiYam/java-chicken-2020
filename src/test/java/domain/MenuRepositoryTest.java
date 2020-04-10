package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MenuRepositoryTest {

	@Test
	@DisplayName("메뉴 번호로 메뉴 찾기 테스트")
	void findMenuByNumber() {
		assertThat(MenuRepository.findMenuByNumber(4))
				.isEqualTo(new Menu(4, "통구이", Category.CHICKEN, 16_000));
	}
}