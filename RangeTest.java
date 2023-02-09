package org.jfree.data;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {

	private Range exampleRange;
	@BeforeClass public static void setUpBeforeCLass() throws Exception {
		
	}
	
	@Before
	public void setUp() throws Exception { 
		exampleRange = new Range(0, 10); 
	}
	
	// Tests constrain() for value within range
	@Test
	public void validConstrainTest() {
		assertEquals("Value being tested is within the range and should return 5.0", 5, exampleRange.constrain(5), .000000001d);
	}
	
	// Tests constrain() for value less than lower bounds of the range
	@Test	// Bug found since -1 is closest to 0.0 but test returns 5.0
	public void lowerOutOfBoundsConstrainTest() {
		assertEquals("Value being tested is out of the lower bounds of the range and should return 0.0", 0, exampleRange.constrain(-1), .000000001d);
	}
	
	// Tests constrain() for value greater than upper bounds of the range
	@Test
	public void upperOutOfBoundsConstrainTest() {
		assertEquals("Value being tested is out of the upper bounds of the range and should return 10.0", 10, exampleRange.constrain(11), .000000001d);
	}
	
	// Tests constrain() for double value within range
	@Test
	public void DoubleConstrainTest() {
		assertEquals("Double value being tested is within the range and should return 5.99", 5.99, exampleRange.constrain(5.99), .000000001d);
	}	
	
	// Tests contains() for value less than lower bounds of range
    @Test
    public void lowerOutOfBoundsValueContains() {
        assertEquals("Value being tested is less than range and should return false", false, exampleRange.contains(-100));
    }

	// Tests contains() for value greater than upper bounds of range
    @Test
    public void upperOutOfBoundsValueContains() {
        assertEquals("Value being tested is greater than range and should return false", false, exampleRange.contains(100));
    }

    // Tests contains() for value within range
    @Test
    public void valueInRangeContains() {
        assertEquals("Value being tested lies within the range and should return true", true, exampleRange.contains(5));
    }

    // Tests contains() for value on the lower bounds
    @Test
    public void valueIsOnLowerBoundsContains() {
        assertEquals("Value being tested is on the lower bounds and should return true", true, exampleRange.contains(0));
    }

    // Tests contains() for value on the upper bounds
    @Test
    public void valueIsOnUpperBoundsContains() {
        assertEquals("Value being tested is on the upper bounds and should return true", true, exampleRange.contains(10));
    }
	
    @After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
