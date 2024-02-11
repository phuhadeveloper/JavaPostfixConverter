package postfixconverter;
/*
 * This test assumes that the infix expressions are valid
 * where parenthesis are balanced
 * 
 * */
public class PostfixConverterTest {
	
	public static void main(String[] args) {
		String testString1 = "(a+b)/(c-d)";
		String testString2 = "a/(b-c)*d";
		String testString3 = "a-(b/(c-d)*e+f)^g";
		// testString4 includes some space
		String testString4 = "(a - b * c)/(d * e^f * g + h)";
		String expectedResult1 = "ab+cd-/";
		String expectedResult2 = "abc-/d*";
		String expectedResult3 = "abcd-/e*f+g^-";
		String expectedResult4 = "abc*-def^*g*h+/";	
	
		System.out.println("Testing Postfix Converter:");
		
		// test1
		System.out.println("Test 1: " + testString1);
		System.out.println("Expected result: " + expectedResult1);
		String actualResult1 = PostfixConverter.convertToPostfix(testString1);
		System.out.println("Actual result: " + actualResult1);
		if (actualResult1.equals(expectedResult1)) {
			System.out.println("Passed!");
		} else {
			System.out.println("Failed");
		}
		System.out.println("-----");
		
		// test2
		System.out.println("Test 2: " + testString2);
		System.out.println("Expected result: " + expectedResult2);
		String actualResult2 = PostfixConverter.convertToPostfix(testString2);
		System.out.println("Actual result: " + actualResult2);
		if (actualResult2.equals(expectedResult2)) {
			System.out.println("Passed!");
		} else {
			System.out.println("Failed");
		}
		System.out.println("-----");
		
		//test3
		System.out.println("Test 3: " + testString3);
		System.out.println("Expected result: " + expectedResult3);
		String actualResult3 = PostfixConverter.convertToPostfix(testString3);
		System.out.println("Actual result: " + actualResult3);
		if (actualResult3.equals(expectedResult3)) {
			System.out.println("Passed!");
		} else {
			System.out.println("Failed");
		}
		System.out.println("-----");
		
		// test4
		System.out.println("Test 4: " + testString4);
		System.out.println("Expected result: " + expectedResult4);
		String actualResult4 = PostfixConverter.convertToPostfix(testString4);
		System.out.println("Actual result: " + actualResult4);
		if (actualResult4.equals(expectedResult4)) {
			System.out.println("Passed!");
		} else {
			System.out.println("Failed");
		}
		System.out.println("-----");

	}

}
