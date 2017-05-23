import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    FilePartReader() {
        this.filePath = "test_data.txt";
        this.fromLine = 1;
        this.toLine = 1;
    }

    void setup(String filepath, Integer fromLine, Integer toLine) throws FileNotFoundException, IllegalArgumentException {
        setFilePath(filepath);
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }
        setFromLine(fromLine);
        setToLine(toLine);
    }

    String readLines() throws IOException, ArrayIndexOutOfBoundsException {
        String output = "";
        String lines[] = read().split("\\r?\\n");
        if (lines.length < getToLine()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        for (Integer line = getFromLine() - 1; line < getToLine();
             line++) {
            output += lines[line] + "\n";
        }
        return output;
    }

    private String read() throws IOException {
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        try (BufferedReader reader = new BufferedReader(new FileReader(this.filePath))) {

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        }
    }

    private Integer getFromLine() {
        return fromLine;
    }

    private void setFromLine(Integer fromLine) {
        this.fromLine = fromLine;
    }

    private Integer getToLine() {
        return toLine;
    }

    private void setToLine(Integer toLine) {
        this.toLine = toLine;
    }

    private void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
