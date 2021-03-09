package mavenBatch.junit;

import junit.framework.TestCase;

public class TestUnit extends TestCase{
	public void testString() {
		String str = "Junit is working fine";
		assertEquals("Junit is working fine", str);
	}
	

}
