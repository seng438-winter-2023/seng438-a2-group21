SENG 438 - Software Testing, Reliability, and Quality
Lab. Report #2 - Requirements based TTest Generation

Group #:
21
Student Names:
Tony Tan


Evan Wong


Johnny Yuen


Bryant Zhang


1 Introduction

	The objective of this lab is to give students an experience in understanding and developing unit testing suites. This is done through several methods of classes provided in JFreeChart System, where the team builds several tests by implementing black box testing design. Through this, the team will determine input variables, and from that, systematically design tests around it. It is important to test boundary conditions as it ensures all system inputs.


2 Detailed description of unit test strategy

	In this lab exercise, a variety of test strategies were implemented. These included blackbox testing, boundary test, and utilization of equivalence classes. We also used mocking in order to test methods that take in interfaces as parameters. When testing in range, many classes do not take in input values, but instead rely on variables.
The methods of testing we used for testing the class Range were boundary value analysis, and equivalent classes. During the testing of the upper and lower bounds, we used boundary value analysis. We tested values above the bounds and under the bounds for both the upper and lower bounds. For example for the upper bound, we tested values right above the range bound, and right inside of the range bound. Using equivalent classes, we identified the independent variables and then determined the number of distinct partitions for each variable, and created test cases from that.
However for cases where input does matter, methods of attempting to cover all possible equivalence classes are done by testing inputs. When testing data utilities, implementing some methods from range, determine the equivalence class, and test using inputs, variables, and boundaries. Classes such as in createNumberArray(), values of positives, negatives and both values ranging from negative to positive were tested. Invalid inputs were also tested.
The benefits of mocking are that it allows us to test the system independently without relying on another class to fulfill the objects we’re testing. It allows for isolation of the system so when a dependent class is unavailable, the system can still be tested. The drawbacks to mocking is that creating a mockery takes more time and effort in order to test methods, and can become overwhelming when testing large systems. As well as when using mock objects they can sometimes provide the wrong answers, so when you actually deploy the system it won’t work as intended, therefore providing false confidence in your system.

3 Test Cases Developed


Class Being Tested
Method Being Tested
Description of Test
Pass or Fail Test?
Range 
constrain()
Tests constrain() for value within range
Pass
Range 
constrain()
Tests constrain() for value less than lower bounds of the range. Should return the lowest value in range.
Fail
Returns middle value of range instead of lowest value.


Range 
constrain()
Tests constrain() for value greater than upper bounds of the range
Pass
Range 
constrain()
Tests constrain() for double value within range
Pass
Range 
contains()
Tests contains() for value less than lower bounds of range
Pass
Range
contains()
Tests contains() for value greater than upper bounds of range
Pass
Range
contains()
Tests contains() for value within range
Pass
Range
contains()
Tests contains() for value on the lower bounds
Pass
Range
contains()
Tests contains() for value on the upper bounds
Pass
Range 
getUpperBound()
Tests getUpperBound() for same range values
Pass
Range 
getUpperBound()
Tests getUpperBound() for different range values with zero
Fail
Upper bound is expected to be 10.0, but returned 0.0
(0.0, 10.0)
Range 
getUpperBound()
Tests getUpperBound() for different range values
Fail
Upper bound is expected to be 5.0, but returned -1.0
(-1.0, 5.0)
Range 
getLowerBound()
Tests getLowerBound() for same range values
Pass


Range 
getLowerBound()
Tests getLowerBound() for different range values with zero
Pass
Range 
getLowerBound()
Tests getLowerBound() for different range values
Pass
Range 
getLength()
Tests getLength() with two different positive numbers in the range.
Pass
Range 
getLength()
Tests getLength() with two of the same numbers in the range this time positive.
Pass
Range
getLength()
Tests getLength() with two of the same numbers in the range this time 0.
Pass
Range
getLength()
Tests getLength() with two of the same numbers in the range negative.
Pass
Range
getLength()
Tests getLength() with two different numbers in the range negative and positive.
Pass
Range
getLength()
Tests getLength() with two different numbers in the range negative.
Pass
DataUtilities
calculateColumnTotal()
Tests calculateColumnTotal() with two values. Should return the sum of the two values in the column.
Pass
DataUtilities
calculateColumnTotal()
Tests calculateColumnTotal() for InvalidParameterException when an invalid data object is passed in.
Fail
NullPointerException is thrown instead of InvalidParameterException
DataUtilities
calculateColumnTotal()
Tests calculateColumnTotal() for a column index that does not exist. Should return zero for invalid input.
Fail
Method returns the number of rows instead of zero
DataUtilities
calculateColumnTotal()
Tests calculateColumnTotal() for table with multiple columns.
Pass
DataUtilities
calculateRowTotal()
Tests calculateRowTotal() for two values in a row
Fail
Expected value is 10, but is 7.5 instead 
(7.5, 2.5)
DataUtilities
calculateRowTotal()
Tests for InvalidParameterException when an invalid data object is passed in
Fail
NullPointerException is thrown instead of InvalidParameterException


DataUtilities
calculateRowTotal()
Tests calculateRowTotal() for a row index that does not exist
Pass
DataUtilities
calculateRowTotal()
Tests calculateRowTotal() for table with multiple rows
Fail
Expected value is 3.0, but is 1.0 instead 
(1.0, 3.0)
DataUtilities
createNumberArray()
Testing testCreateNumberArrayPositive() for positive decimal inputs
Pass
DataUtilities
createNumberArray()
Testing testCreateNumberArrayNegative() for negative decimal inputs
Pass
DataUtilities
createNumberArray()
Testing testCreateNumberArrayAll() for both positive and negative decimal inputs
Pass
DataUtilities
createNumberArray()
Testing createNumberArrayInvalid() for createNumberArray() with an invalid input
Fail
AssertionError Expected test to throw an instance of InvalidParameterException
DataUtilities
createNumberArray2D()
Testing testCreateNumberArray2DPositive() for positive decimal inputs
Pass
DataUtilities
createNumberArray2D()
Testing testCreateNumberArray2DNegative() for negative decimal inputs
Pass
DataUtilities
createNumberArray2D()
Testing testCreateNumberArray2DAll() for both positive and negative decimal inputs
Pass
DataUtilities
createNumberArray2D()
Testing createNumberArray2DInvalid() for createNumberArray2D() with an invalid input
Fail
AssertionError Expected test to throw an instance of InvalidParameterException
DataUtilities
getCumulativePercentages()
Tests the first value for the getCumulativePercentages() method, with a mocked KeyedValues object.
Fail 
AssertionError The first percentage is 10/100, it should be 0.10 expected 0.1 but was 0.1111111111111111
DataUtilities
getCumulativePercentages()
Tests the second value for the getCumulativePercentages() method, with a mocked KeyedValues object.
Fail
AssertionError The second percentage is 50/100, it should be 0.50 expected 0.5 but was 0.5555555555555556
DataUtilities
getCumulativePercentages()
Tests the third value for the getCumulativePercentages() method, with a mocked KeyedValues object.
Fail
AssertionError The third percentage is 80/100, it should be 0.80 expected 0.80 but was 0.8888888888888888
DataUtilities
getCumulativePercentages()
Tests the fourth value for the getCumulativePercentages() method, with a mocked KeyedValues object.
Fail
AssertionError The fourth percentage is 100/100, it should be 1.0 expected 1.0 but was 1.1111111111111111
DataUtilities
getCumulativePercentages()
Testing InvalidParameterException for getCumulativePercentages with an invalid input
Fail
AssertionError Expected test to throw an instance of InvalidParameterException





4 How the team work/effort was divided and managed 

Work/team effort was divided equally between the 4 group members. The team first familiarize ourselves with the system and tools being used to test it. We then came up tests for a method with the Range class and DataUtilities class. Afterwards we all wrote tests for an additional method for each of the classes. After writing the tests, we analyzed and discussed the results, seeing which tests failed and succeeded.

5 Difficulties encountered, challenges overcome, and lessons learned

Some difficulties we encountered during this lab was insufficient experience and knowledge regarding mocking. This prevented us from fully testing all of our equivalence classes and unit tests that we could think of since we did not know how we would be able to implement them with mocking. Another difficulty we experienced was being unfamiliar with the classes being tested and vague information regarding the Javadoc documentation. This added some confusion regarding behavior during testing which caused errors.

6 Comments/feedback on the lab itself

	Overall, this lab exercise is interesting and educational, providing a good learning experience and understanding into designing, creating unit tests, and black box testing. Instructions were clear, the background information and diagrams provided, helped gain better understanding of the purpose and the instructions. The fact that the classes had random intentional defects added confusion to the lab as it made it unclear if the class had a defect or if we were implementing the test incorrectly. 
