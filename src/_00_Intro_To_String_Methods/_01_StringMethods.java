package _00_Intro_To_String_Methods;

import java.util.Base64;
import java.util.Iterator;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if (s1.length() == s2.length()) {
			return "equal";
		} else if (s1.length() > s2.length()) {
			return s1;
		}
		return s2;
	}

	// If String s contains the word "underscores", change all of the spaces
	// to underscores
	public static String formatSpaces(String s) {
		if (s.contains("underscores")) {
			String newString = "";
			String[] array = s.split(" ");

			for (int i = 0; i < array.length; i++) {
				newString += array[i];
				if (i != array.length - 1) {
					newString += "_";
				}

			}

			return newString;
		}
		return s;
	}

	// Return the name of the person whose LAST name would appear first if they
	// were in alphabetical order.
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		// get first character
		char[] st1 = s1.toCharArray();
		char[] st2 = s2.toCharArray();
		char[] st3 = s3.toCharArray();
		String val1 = "";
		String lastname1 = "";
		String val2 = "";
		String lastname2 = "";
		String val3 = "";
		String lastname3 = "";
		boolean ready = false;
		// val 1
		for (int j = 0; j < st1.length; j++) {
			if (ready && Character.isUpperCase(st1[j])) {
				val1 += " ";
				val1 += st1[j];
				lastname1 += "" + st1[j];
				ready = false;
			} else if (st1[j] != ' ') {
				val1 += st1[j];
				ready = true;
			}
		}
		// val 2
		for (int j = 0; j < st2.length; j++) {
			if (ready && Character.isUpperCase(st2[j])) {
				val2 += " ";
				val2 += st2[j];
				lastname2 += "" + st2[j];
				ready = false;
			} else if (st2[j] != ' ') {
				val2 += st2[j];
				ready = true;
			}
		}
		// val 3
		for (int j = 0; j < st3.length; j++) {
			if (ready && Character.isUpperCase(st3[j])) {
				val3 += " ";
				val3 += st3[j];
				lastname3 += "" + st3[j];
				ready = false;
			} else if (st3[j] != ' ') {
				val3 += st3[j];
				ready = true;
			}
		}
		System.out.println(val1);
		System.out.println(val2);
		System.out.println(val3);

		if (lastname2.compareTo(lastname1) >= 0 && lastname3.compareTo(lastname1) >= 0) {
			return val1;
		} else if (lastname3.compareTo(lastname2) > 0) {
			return val2;
		} else
			return val3;
	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		char[] nums = s.toCharArray();
		int integer = 0;
		for (int i = 0; i < nums.length; i++) {
			if (Character.isDigit(nums[i])) {
				String num = "" + nums[i];
				integer += Integer.parseInt(num);
			}
		}
		return integer;
	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		char[] asChar = substring.toCharArray();
		char[] compareS = s.toCharArray();
		boolean count = true;
		int counter = 0;
		for (int i = 0; i < compareS.length; i++) {

			if (compareS[i] == asChar[0]) {
				count = true;
				for (int j = 0; i + j < compareS.length && j < asChar.length; j++) {
					if (compareS[i + j] != asChar[j]) {
						count = false;
					}
				}
				if (count) {
					counter++;
					count = false;
				}
			}
		}

		return counter;
	}

	// Call Utilities.encrypt at the bottom of this file to encrypt String s
	public static String encrypt(String s, char key) {
		byte[] b = s.getBytes();
		byte by = (byte) key;

		return Utilities.encrypt(b, by);
	}

	// Call Utilities.decrypt at the bottom of this file to decrypt the
	// cyphertext (encrypted text)
	public static String decrypt(String s, char key) {
		byte by = (byte) key;

		return Utilities.decrypt(s, by);
	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
char[] str = s.toCharArray();
char[] substr = substring.toCharArray();
for (int i = 0; i < str.length; i++) {
	if (str[i] == ' ') {
		
	}
}
		return 0;
	}

	// Given String s, return the number of characters between the first
	// occurrence of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
char[] str = s.toCharArray();
char[] substr = substring.toCharArray();

//from last char of substring
// to first char of substringa
		return 0;
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {

		return true;
	}
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a
	// single byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
