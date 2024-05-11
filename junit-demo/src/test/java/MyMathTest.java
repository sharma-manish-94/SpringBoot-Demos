import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.MyMath;
import org.junit.jupiter.api.Test;

class MyMathTest {
	private final MyMath myMath = new MyMath();
//	{} = 0
	@Test
	void testWithEmptyArray() {
		assertEquals(0, myMath.calculateSum(new int[] {}));
	}

//	{1, 2, 3} => 1 + 2 + 3 = 6
	@Test
	void testWithThreeElements() {
		assertEquals(6, myMath.calculateSum(new int[] { 1, 2, 3 }));
	}
}
