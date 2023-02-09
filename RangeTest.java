package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {

	private Range exampleRange;
    private Range exampleRange2;
    private Range exampleRange3;
    private Range exampleRange4;
	@BeforeClass public static void setUpBeforeCLass() throws Exception {
		
	}
	
	@Before
	public void setUp() throws Exception { 
		exampleRange = new Range(0, 10); 
        exampleRange2 = new Range(-1, -1);
        exampleRange3 = new Range(1, 1);
        exampleRange4 = new Range(-1, 5);
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
	
    // Tests getUpperBound() for same range values
	@Test
    public void getUpperBoundSameRangeValuesTest() {  	
    	assertEquals("Upper bound is the value of -1 (-1,-1)", -1, exampleRange2.getUpperBound(), .000000001d);
    }
    
    // Tests getUpperBound() for different range values with zero
    @Test
    public void getUpperBoundDifferentRangeValuesTestWithZero() {  	
    	assertEquals("Upper bound value is the value of 10 (0,10)", 10, exampleRange.getUpperBound(), .000000001d);
    }
    
    // Tests getUpperBound() for different range values
    @Test
    public void getUpperBoundDifferentRangeValuesTest() {  	
    	assertEquals("Upper bound value is the value of 5 (-1,5)", 5, exampleRange4.getUpperBound(), .000000001d);
    }
    
    // Tests getLowerBound() for same range values
	@Test
    public void getLowerBoundSameRangeValuesTest() {  	
    	assertEquals("Lower bound is the value of -1 (-1,-1)", -1, exampleRange2.getLowerBound(), .000000001d);
    }
    
    // Tests getLowerBound() for different range values with zero
    @Test
    public void getLowerBoundDifferentRangeValuesTestWithZero() {  	
    	assertEquals("Lower bound value is the value of 0 (0,10)", 0, exampleRange.getLowerBound(), .000000001d);
    }
    
    // Tests getLowerBound() for different range values
    @Test
    public void getLowerBoundDifferentRangeValuesTest() {  	
    	assertEquals("Lower bound value is the value of -1 (-1,5)", -1, exampleRange4.getLowerBound(), .000000001d);
    }
    
    //Tests getLength() with two different numbers in the range.
    @Test 
    public void lengthTestWithDifferentRanges() {
        assertEquals("The length of the range should be the total distance of the range", 10, exampleRange.getLength(), .000000001d);
    }

    //Tests getLength() with two of the same numbers in the range.
    @Test 
    public void lengthTestWithTheSameRange() {
        assertEquals("The length of the range should be Zero", 0, exampleRange3.getLength(), .000000001d);
    }

    @After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}