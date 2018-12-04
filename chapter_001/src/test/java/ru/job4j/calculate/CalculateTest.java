package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Roman Korolchuk (rom.kor@yandex.ru)
* @version $Id$
* @since 0.1
*/
public class CalculateTest {
/**
* Test echo.
*/
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Roman Korolchuk";
		String expect = "Echo, echo, echo : Roman Korolchuk"; 
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
 
}