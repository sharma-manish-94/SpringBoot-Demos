import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {

	List<String> todos = Arrays.asList("AWS", "Azure", "GCP");

	@Test
	void test() {
		boolean test = todos.contains("AWS");
		assertTrue(test);
		assertEquals(3, todos.size());
		assertTrue(todos.contains("Azure"), () -> "Error Message");
		assertArrayEquals(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 });
		assertArrayEquals(new int[] { 1, 2, 3 }, new int[] { 1, 3, 2 }, "Error Message");
	}
}
