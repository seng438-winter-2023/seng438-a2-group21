package org.jfree.data.test;

import static org.junit.Assert.*; import org.junit.*; import org.jmock.*; import org.jfree.data.*;
import java.security.InvalidParameterException;

public class DataUtilitiesTest {
	
	@BeforeClass
	public static void setUpBeforeCLass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception { 
		
	}
	
	 @Test
	 public void calculateColumnTotalForTwoValues() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(1, 0);
	             will(returnValue(2.5));
	         }
	     });

	     assertEquals("Should return column total of 10.0", 10.0, DataUtilities.calculateColumnTotal(values, 0), .000000001d);

	 }
	
	@Test(expected = InvalidParameterException.class)
	public void calculateColunmTotalForNull() {
		final Values2D nullValue = null;
		DataUtilities.calculateColumnTotal(nullValue, 0);
		
	}
	
	// Tests calculateColumnTotal() for a column index that does not exist
	@Test
	public void calculateColumnTotalForInvalidColumn() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(1, 0);
	             will(returnValue(2.5));
	         }
	     });
	     
	     assertEquals("Should return column total of 0.0", 0.0, DataUtilities.calculateColumnTotal(values, -1), .000000001d);
	}
	
	@Test
	public void calculateColumnTotalForTable() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(1, 0);
	             will(returnValue(2.5));
	             one(values).getValue(0, 1);
	             will(returnValue(1.0));
	             one(values).getValue(1, 1);
	             will(returnValue(2.0));
	         }
	     });
	     
	     assertEquals("Should return column total of 3.0", 3.0, DataUtilities.calculateColumnTotal(values, 1), .000000001d);
	}
	


}

