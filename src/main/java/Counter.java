import java.io.File;

public class Counter {
    public static void main(String[] args) {
        
        Counter counter = new Counter();
        File dir = new File("output");
        int count = counter.csvCount(dir.listFiles());
        System.out.println("Number of CSV files in the directory: " + count);

    }

    private int csvCount(File[] files) {
        int count = 0;
        for (File file : files) {
            if (file.isDirectory()) {
                // ディレクトリの場合は再帰呼び出し
                count += csvCount(file.listFiles());
            } else {
                if (file.getName().endsWith(".csv")){
                    // csvファイルのみカウント
                    count++;
                }
            }
        }
        return count;
    }
}
