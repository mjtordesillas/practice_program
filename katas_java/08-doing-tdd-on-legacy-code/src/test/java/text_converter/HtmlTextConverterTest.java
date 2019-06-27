package text_converter;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HtmlTextConverterTest {

    private TestingHtmlTextConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new TestingHtmlTextConverter("any path");
    }

    @Test
    public void converts_ampersand_symbol() throws IOException
    {
        converter.lineToReturn = "&";

        converter.convertToHtml("any output file path");

        assertTrue(converter.stringsWritten.contains("&amp;"));
        assertFalse(converter.stringsWritten.contains("&"));
    }

    @Test
    public void converts_less_than_symbol() throws IOException
    {
        converter.lineToReturn = "<";

        converter.convertToHtml("any output file path");

        assertTrue(converter.stringsWritten.contains("&lt;"));
        assertFalse(converter.stringsWritten.contains("<"));
    }

    @Test
    public void converts_greater_than_symbol() throws IOException
    {
        converter.lineToReturn = ">";

        converter.convertToHtml("any output file path");

        assertTrue(converter.stringsWritten.contains("&gt;"));
        assertFalse(converter.stringsWritten.contains(">"));
    }

    @Test
    public void converts_double_quote_symbol() throws IOException
    {
        converter.lineToReturn = "\"";

        converter.convertToHtml("any output file path");

        assertThat(converter.stringsWritten.contains("&quot;"), is(true));
        assertFalse(converter.stringsWritten.contains("\""));
    }
}
