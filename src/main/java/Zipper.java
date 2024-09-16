import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.DatatypeConverter;

public class Zipper {
    
    public static void main(String[] args) {
        Zipper zipper = new Zipper();
        zipper.zipToHexA();
        zipper.hexToZipA();
        zipper.zipToHexB();
        zipper.hexToZipB();
    }

    public void zipToHexA() {
        try {
            InputStream is = new FileInputStream("a.zip");
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            String hex = DatatypeConverter.printHexBinary(bytes);
            System.out.println(hex);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void zipToHexB() {
        try {
            InputStream is = new FileInputStream("b.zip");
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            String hex = DatatypeConverter.printHexBinary(bytes);
            System.out.println(hex);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hexToZipA() {
        try {
            String hex = "504B0304140008000800334F305900000000000000000100000005002000612E74787455540D00078382E7668382E7667682E76675780B0001040000000004000000002B0100504B0708A85A6A850300000001000000504B01021403140008000800334F3059A85A6A850300000001000000050020000000000000000000B68100000000612E74787455540D00078382E7668382E7667682E76675780B000104000000000400000000504B0506000000000100010053000000560000000000";
            OutputStream os = new FileOutputStream("a2.zip");
            byte[] bytes = DatatypeConverter.parseHexBinary(hex);
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hexToZipB() {
        try {
            String hex = "504B0304140008000800C650305900000000000000000100000005002000622E74787455540D00078584E7668C84E7667682E76675780B0001040000000004000000002B0600504B07080BCF0E1B0300000001000000504B01021403140008000800C65030590BCF0E1B0300000001000000050020000000000000000000B68100000000622E74787455540D00078584E7668C84E7667682E76675780B000104000000000400000000504B0506000000000100010053000000560000000000";
            OutputStream os = new FileOutputStream("b2.zip");
            byte[] bytes = DatatypeConverter.parseHexBinary(hex);
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 }
