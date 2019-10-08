package com.luxoft.fileparser.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/*
 * ParserUtil.java is an utility class that provides service to resources that want to perform operations on files.
 */
public class ParserUtil {

	/*
	 * This method splits the string of words and calls processVowels.
	 */
	public void processOutput(String inp) {
		
		String[] words = inp.split("\n");
		
		PrintWriter p = invokePrintWriter();

		for (String line : words) {
			String out = processVowels(line);
			if(null!=p) {
				p.println(out);		
			}
		}
		
		p.close();
	}

	/*
	 * This method contains the business logic to count the vowels and average
	 * number of vowels in a single word. and appends that to output.txt method
	 */
	public String processVowels(String line) {
		
		line = line.toLowerCase();
		int vowelCount = 0, length = line.length();
		Set<Character> vowels = new HashSet<Character>();
		
		for (int i = 0; i < line.length(); ++i) {
			char ch = line.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				vowels.add(ch);
				++vowelCount;
			}
		}	
		return getOutputInFormat(vowels, vowelCount, length);
	}

	/*
	 * This method returns the output in the required format
	 */
	public String getOutputInFormat(Set<Character> vowels, int vowelCount, int length) {

		int average = 0;

		if (vowelCount != 0) {
			average = length / vowelCount;
		}
		return "(" + vowels + ", " + length + ") -> " + average;
	}

	/*
	 * This method creates a file named output.txt in the current directory and
	 * returns the PrintWrite object for it
	 */
	public PrintWriter invokePrintWriter() {
		PrintWriter p = null;
		try {
			p = new PrintWriter("output.txt", "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}

}
