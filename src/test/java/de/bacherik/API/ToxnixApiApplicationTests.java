package de.bacherik.API;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ToxnixApiApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	public void test_no_name_parameter() {
		ToxnixApiApplication app = new ToxnixApiApplication();
		String result = app.hello("");
		assertEquals("Hello !", result);
	}

	@Test
	public void test_with_name_parameter() {
		ToxnixApiApplication app = new ToxnixApiApplication();
		String result = app.hello("John");
		assertEquals("Hello John!", result);
	}

	@Test
	public void test_special_characters_and_spaces() {
		ToxnixApiApplication app = new ToxnixApiApplication();
		String result = app.hello("John Doe");
		assertEquals("Hello John Doe!", result);
	}
}
