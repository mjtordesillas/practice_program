package text_converter;

import java.io.IOException;
import java.util.ArrayList;

public class TestingHtmlTextConverter extends HtmlTextConverter {

    ArrayList<String> stringsWritten;

    String lineToReturn = null;
    String outputFile = null;

    public TestingHtmlTextConverter(String fullFilenameWithPath) {
        super(fullFilenameWithPath);
        stringsWritten = new ArrayList<>();
    }

    protected void closeWriter() throws IOException {
    }

    protected void write(String htmlString) throws IOException {
        stringsWritten.add(htmlString);
    }

    protected String readLine() throws IOException {
        String line = lineToReturn;
        lineToReturn = null;
        return line;
    }

    protected void initializeReader(String htmlFile) throws IOException {
    }

    protected void initializeWriter(String htmlFile) throws IOException {
        outputFile = htmlFile;
    }

}
