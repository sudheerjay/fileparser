package com.luxoft.parser.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.luxoft.parser.util.FileParser;

@RestController
@RequestMapping("/file")
public class FileParserResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileParserResource.class);

	@Autowired
	private FileParser parser;

	@PostMapping("/parse")
	public String parseFile(@RequestParam("file") MultipartFile file) {
		LOGGER.info("Entering parseFile() in Resource");
		return parser.parseFile(file);
	}
}
