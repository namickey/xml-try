import java.io.FileWriter;
import java.io.IOException;

public class JpFileOut {
    public static void main(String[] args) {
        JpFileOut fileOut = new JpFileOut();
        fileOut.write("ハロー, World!");   
    }

    public void write(String content) {
        try {
            FileWriter file = new FileWriter("jpout_日本語.txt");
            file.write(content);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
