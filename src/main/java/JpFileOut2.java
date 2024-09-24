import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class JpFileOut2 {
    public static void main(String[] args) throws IOException {
        File f = new File("jpout_日本語.txt");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write("ハロー, World!".getBytes());
        fos.close();
    }
}
