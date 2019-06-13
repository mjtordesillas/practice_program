package text_converter;

import java.io.*;

public class HtmlTextConverter
{
    private String fileName;
	private BufferedWriter writer;
	private BufferedReader reader;

	public HtmlTextConverter(String fullFilenameWithPath)
    {
        this.fileName = fullFilenameWithPath;
    }

    public void convertToHtml(String htmlFile) throws IOException{
		initializeWriterAndReader(htmlFile);

		String line = readLine();
		write("<body>");
		while (line != null)
	    {
			String output = line;
			output = output.replace("&", "&amp;");
			output = output.replace("<", "&lt;");
			output = output.replace(">", "&gt;");
			write(output);
			write("<br />");
			line = readLine();
	    }
		write("</body>");
		closeWriter();
	}

	protected void closeWriter() throws IOException {
		writer.close();
	}

	protected void write(String output) throws IOException {
		writer.write(output);
	}

	protected String readLine() throws IOException {
		return reader.readLine();
	}

	protected void initializeWriterAndReader(String htmlFile) throws IOException {
		writer = new BufferedWriter(new FileWriter(htmlFile));
		reader = new BufferedReader(new FileReader(fileName));
	}

	public String getFilename() {
		return this.fileName;
	}

	public static void main(String[] args) {
		try {
			HtmlTextConverter htmlTextConverter = new HtmlTextConverter("res/example.txt");
			htmlTextConverter.convertToHtml("res/example.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
