package com.luxoft.fileparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.luxoft.fileparser.utils.ParserUtil;

/*
 * This is the main class that needs to be invoked to read the input.txt file.
 */
public class FileParserMain {

	/*
	 * This method reads all the strings from the input.txt file from
	 * src/main/resources and calls processOutput from the Util class which counts
	 * the vowels and counts the average number of vowels for us
	 */
	public static void main(String[] args) throws IOException {

		ParserUtil util = new ParserUtil();
		String line, out = "";
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream is = classLoader.getResourceAsStream("input.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		while ((line = br.readLine()) != null) {
			String[] words = line.split(" ");

			for (String word : words) {
				if (word != null || !"".equals(word)) {
					out = out + word + "\n";
				}
			}
		}
		util.processOutput(out);
	}
}
