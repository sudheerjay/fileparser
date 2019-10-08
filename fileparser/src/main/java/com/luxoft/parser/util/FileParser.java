package com.luxoft.parser.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.luxoft.parser.resources.FileParserResource;

@Component
public class FileParser {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileParserResource.class);
	
	/*
	 * 
	 */
	public String parseFile(MultipartFile multiPartFile) {
		LOGGER.info("Entering parseFile() in Util"); 
		String out = "";
		String[] words = new String[10];
		int i = 0;

		Scanner sc;
		try {
			File file = convertMultiPartToFile(multiPartFile);
			sc = new Scanner(file);
			while (sc.hasNext()) {
				words[i] = sc.next();
				i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String word : words) {
			if (!StringUtils.isEmpty(word)) {
				out = out + word + " -> " + processWord(word) + "\n";
			}
		}
		return out;
	}

	/*
	 * 
	 */
	private File convertMultiPartToFile(MultipartFile multipartFile) throws IOException {
		File convFile = new File(multipartFile.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(multipartFile.getBytes());
		fos.close();
		return convFile;
	}

	/*
	 * 
	 */
	public String processWord(String line) {

		String out = "";
		int average = 0;
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
		if (vowelCount != 0) {
			average = length / vowelCount;
		}
		out = "(" + vowels + ", " + length + ") -> " + average;
		return out;
	}
}
