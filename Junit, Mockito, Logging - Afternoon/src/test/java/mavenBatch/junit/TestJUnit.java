package mavenBatch.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestJUnit {

	@Test
	public void check() {
		String str = "Junit is working fine";
		assertEquals("Junit is working fine", str);
	}
}
