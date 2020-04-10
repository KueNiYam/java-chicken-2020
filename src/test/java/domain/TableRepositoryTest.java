package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TableRepositoryTest {

	@Test
	@DisplayName("테이블 번호로 테이블 찾기 테스트")
	void findTableByNumber() {
		assertThat(TableRepository.findTableByNumber(5)).isEqualTo(new Table(5));
	}
}