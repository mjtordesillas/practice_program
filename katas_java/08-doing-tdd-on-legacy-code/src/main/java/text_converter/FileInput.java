package text_converter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileInput {

    private final BufferedReader reader;

    public FileInput(String htmlFile) throws IOException {
        reader = new BufferedReader(new FileReader(htmlFile));
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }
}
