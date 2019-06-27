package text_converter;

import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HtmlTextConverterTest {

    private TestingHtmlTextConverter converter;
    private String inputFileName;

    @Before
    public void setUp() throws Exception {
        inputFileName = "any name";
        converter = new TestingHtmlTextConverter(inputFileName);
    }

    @Test
    public void converts_ampersand_symbol() throws IOException
    {
        converter.lineToReturn = "&";

        converter.convertToHtml("any output file name");

        assertTrue(converter.stringsWritten.contains("&amp;"));
        assertFalse(converter.stringsWritten.contains("&"));
    }

    @Test
    public void converts_less_than_symbol() throws IOException
    {
        converter.lineToReturn = "<";

        converter.convertToHtml("any output file name");

        assertTrue(converter.stringsWritten.contains("&lt;"));
        assertFalse(converter.stringsWritten.contains("<"));
    }

    @Test
    public void converts_greater_than_symbol() throws IOException
    {
        converter.lineToReturn = ">";

        converter.convertToHtml("any output file name");

        assertTrue(converter.stringsWritten.contains("&gt;"));
        assertFalse(converter.stringsWritten.contains(">"));
    }

    @Test
    public void converts_double_quote_symbol() throws IOException
    {
        converter.lineToReturn = "\"";

        converter.convertToHtml("any output file name");

        assertThat(converter.stringsWritten.contains("&quot;"), is(true));
        assertFalse(converter.stringsWritten.contains("\""));
    }

    @Test
    public void output_file_has_the_same_name_as_input_file() throws IOException
    {
        converter = new TestingHtmlTextConverter(inputFileName);
        converter.lineToReturn = "any line";

        converter.convertToHtml("");

        assertThat(converter.outputFile, is(inputFileName));
    }

//    @Test
//    public void can_read_from_console() throws IOException
//    {
//
//        converter = new TestingHtmlTextConverter(inputFileName, );
//
//
//
//        converter.convertToHtml("");
//
//        assertThat(converter.outputFile, is(inputFileName));
//    }
}
