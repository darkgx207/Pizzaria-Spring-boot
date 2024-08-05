package com.example.pizza_app;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PizzaAppApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertThat(42).isEqualTo(42);
	}


}
