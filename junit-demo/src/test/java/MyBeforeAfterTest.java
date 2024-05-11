import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyBeforeAfterTest {
	/**
	 * Class level method, run once before any of the test methods
	 */
	@BeforeAll
	static void beforeAll() {
		System.out.println("Before All test cases");
	}

	// for each test setup
	@BeforeEach
	void beforeEach() {
		System.out.println("Before Each");
	}

	@Test
	void test1() {
		System.out.println("Test 1");
	}

	@Test
	void test2() {
		System.out.println("Test 2");
	}

	@Test
	void test3() {
		System.out.println("Test 3");
	}

	// cleanup after each test
	@AfterEach
	void afterEach() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	/**
	 * Class level method, run once after all the test methods
	 */
	@AfterAll
	static void afterAll() {
		System.out.println("CleanUp after all tests");
	}
}
