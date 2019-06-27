package text_converter;

import java.io.IOException;
import java.util.ArrayList;

public class TestingHtmlTextConverter extends HtmlTextConverter {

    ArrayList<String> stringsWritten;

    String outputFile = null;

    public TestingHtmlTextConverter(String inputFileName, InputInterface input) throws IOException {
        super(inputFileName, input);
        stringsWritten = new ArrayList<>();
    }

    protected void closeWriter() throws IOException {
    }

    protected void write(String htmlString) throws IOException {
        stringsWritten.add(htmlString);
    }

    protected void initializeReader(String htmlFile) throws IOException {

    }

    protected void initializeWriter(String htmlFile) throws IOException {
        outputFile = htmlFile;
    }

}
