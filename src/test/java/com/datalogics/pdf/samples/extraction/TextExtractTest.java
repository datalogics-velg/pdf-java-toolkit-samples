/*
 * Copyright 2015 Datalogics, Inc.
 */

package com.datalogics.pdf.samples.extraction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.datalogics.pdf.samples.SampleTest;

import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;

/**
 * Tests the TextExtract sample.
 */
public class TextExtractTest extends SampleTest {

    private static final String OUTPUT_FILE_PATH = "TextExtractTest.txt";
    private static final String INPUT_PDF_PATH = "/com/datalogics/pdf/samples/pdfjavatoolkit-ds.pdf";
    private static final String EXTRACTED_DOCUMENT_NAME = "TextExtractTest-ReadingOrder.txt";

    @Test
    public void testExtractTextReadingOrder() throws Exception {
        final File file = newOutputFile(OUTPUT_FILE_PATH);
        if (file.exists()) {
            Files.delete(file.toPath());
        }

        final URL inputUrl = TextExtract.class.getResource(INPUT_PDF_PATH);
        final URL outputUrl = file.toURI().toURL();

        TextExtract.extractTextReadingOrder(inputUrl, outputUrl);;
        assertTrue(file.getPath() + " must exist after run", file.exists());

        final String extractedText = contentsOfTextFile(file);
        assertEquals(contentsOfResource(EXTRACTED_DOCUMENT_NAME), extractedText);
    }
}
