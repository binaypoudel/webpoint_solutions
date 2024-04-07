package pages;
import java.io.FileWriter;
import java.io.IOException;


public class CSVWriter {
    private FileWriter writer;

    public CSVWriter(String fileName) {
        try {
            writer = new FileWriter(fileName);
            writer.append("Name,Price\n"); // Adding header
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData(String name, String price) {
        try {
            writer.append(name);
            writer.append(",");
            writer.append(price);
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
