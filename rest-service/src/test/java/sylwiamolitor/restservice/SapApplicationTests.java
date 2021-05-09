package sylwiamolitor.restservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SapApplicationTests {

	@Test
	void contextLoads() {
	}



	/**
	 * Used in exercise 1
	 * @return arguments for tests
	 */
	private static Stream<Arguments> testExercise1() {
		return Stream.of(
				Arguments.of("1","1"),
				Arguments.of("55","110111"),
				Arguments.of("1024","10000000000"),
				Arguments.of("abc","0"),
				Arguments.of("-1","0")

		);
	}
	/**
	 * Tests exercise 1
	 * @param input input
	 * @param output correct output
	 */
	@ParameterizedTest
	@MethodSource
	void testExercise1(String input, String output) {
		try{

			NumberController object = new NumberController();
			assertEquals(object.exercise1(input).getResult(), output, "The expression was not correct!"); //it will always be good

		}
		catch (Exception e)
		{
			fail();
		}
	}



	/**
	 * Used in exercise 2
	 * @return arguments for tests
	 */
	private static Stream<Arguments> testExercise2() {
		return Stream.of(
				Arguments.of("1","0"),
				Arguments.of("55","10"),
				Arguments.of("102","31"),
				Arguments.of("abc","0"),
				Arguments.of("-1","0")
		);
	}
	/**
	 * Tests exercise 2
	 * @param input input
	 * @param output correct output
	 */
	@ParameterizedTest
	@MethodSource
	void testExercise2(String input, String output) {
		try{

			NumberController object = new NumberController();
			assertEquals(object.exercise2(input).getResult(), output, "The expression was not correct!"); //it will always be good

		}
		catch (Exception e)
		{
			fail();
		}
	}

	/**
	 * Used in exercise 3
	 * @return arguments for tests
	 */
	private static Stream<Arguments> testExercise3() {
		return Stream.of(
				Arguments.of("1","1"),
				Arguments.of("55","3b"),
				Arguments.of("102","33"),
				Arguments.of("abc","0"),
				Arguments.of("-1","0")
		);
	}
	/**
	 * Tests exercise 3
	 * @param input input
	 * @param output correct output
	 */
	@ParameterizedTest
	@MethodSource
	void testExercise3(String input, String output) {
		try{

			NumberController object = new NumberController();
			assertEquals(object.exercise3(input).getResult(), output, "The expression was not correct!"); //it will always be good

		}
		catch (Exception e)
		{
			fail();
		}
	}

	/**
	 * Used in exercise 4
	 * @return arguments for tests
	 */
	private static Stream<Arguments> testExercise4() {
		return Stream.of(
				Arguments.of("1","1"),
				Arguments.of("55","62"),
				Arguments.of("102","120"),
				Arguments.of("abc","0"),
				Arguments.of("-1","0")
		);
	}
	/**
	 * Tests exercise 4
	 * @param input input
	 * @param output correct output
	 */
	@ParameterizedTest
	@MethodSource
	void testExercise4(String input, String output) {
		try{

			NumberController object = new NumberController();
			assertEquals(object.exercise4(input).getResult(), output, "The expression was not correct!"); //it will always be good

		}
		catch (Exception e)
		{
			fail();
		}
	}

}
