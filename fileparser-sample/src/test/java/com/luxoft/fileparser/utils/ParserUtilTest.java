package com.luxoft.fileparser.utils;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParserUtilTest {

	ParserUtil util = new ParserUtil();

	ParserUtil mockUtil = Mockito.mock(ParserUtil.class);

	@Test
	public void processOutputTest() {
		String inp = "SampleInput";

		PrintWriter mockWriter = Mockito.mock(PrintWriter.class);
		Mockito.doReturn(mockWriter).when(mockUtil).invokePrintWriter();
		Mockito.doReturn("([a, e, u, i], 11) -> 2").when(mockUtil).processVowels(inp);

		assertEquals(util.processVowels(inp), "([a, e, u, i], 11) -> 2");
	}

	@Test
	public void countVowelsTest() {
		String inp = "SampleInput";
		String out = "([a, e, u, i], 11) -> 2";
		assertEquals(util.processVowels(inp), out);
	}

	@Test
	public void invokePrintWriterTest() {
		PrintWriter mockWriter = Mockito.mock(PrintWriter.class);
		Mockito.doReturn(mockWriter).when(mockUtil).invokePrintWriter();
	}
}
