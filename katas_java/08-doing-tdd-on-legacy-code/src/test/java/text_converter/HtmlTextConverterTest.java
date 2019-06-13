package text_converter;

import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class HtmlTextConverterTest {

    @Test
    public void converts_ampersand_symbol() throws IOException
    {
        TestingHtmlTextConverter converter = new TestingHtmlTextConverter("any path");
        converter.lineToReturn = "&";

        converter.convertToHtml("any output file path");

        assertTrue(converter.stringsWritten.contains("&amp;"));
        assertFalse(converter.stringsWritten.contains("&"));
    }
}
