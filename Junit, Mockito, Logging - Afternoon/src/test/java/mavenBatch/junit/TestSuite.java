package mavenBatch.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   TestJUnit.class,
   JavaTest.class
})

public class TestSuite {

}
