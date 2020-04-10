package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CommendTest {

	@Test
	@DisplayName("번호로 기능 찾기 테스트")
	void findCommendByNumber() {
		assertThat(Commend.ofNumber(2)).isEqualTo(Commend.PAY);
	}

}