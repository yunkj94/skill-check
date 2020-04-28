package q008;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Q008 埋め込み文字列の抽出
 *
 * 一般に、定数定義の場合を除いて、プログラム中に埋め込み文字列を記述するのは良くないとされています。
 * そのような埋め込み文字列を見つけるために、埋め込み文字列や埋め込み文字（"test"や'a'など）が
 * 記述された行を出力するプログラムを作成してください。
 *
 * - 実行ディレクトリ配下（再帰的にチェック）に存在するすべてのjavaファイルをチェックする
 * - ファイル名はディレクトリ付きでも無しでも良い
 * - 行の内容を出力する際は、先頭のインデントは削除しても残しても良い

[出力イメージ]
Q001.java(12): return "test";  // テストデータ
Q002.java(10): private static final DATA = "test"
Q002.java(11): + "aaa";
Q002.java(20): if (test == 'x') {
Q004.java(13): Pattern pattern = Pattern.compile("(\".*\")|(\'.*\')");

 */
public class Q008 {
    private static String[] checkWords = new String[]{"test", "TEST", "aa", ".*"};

    public static void main(String[] args) throws IOException {
            var fileList = listJavaFiles().collect(Collectors.toList());
            for(var file : fileList) {
                try {
                    var fileLines = Files.readAllLines(file.toPath());
                    int lineCount = 1;
                    for(var line : fileLines) {
                        for(var checkWord : checkWords) {
                            if(line.contains(checkWord)) {
                                System.out.println(file.getName() + "(" + lineCount + "): " + line);
                            }
                        }
                        lineCount++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }

    /**
     * JavaファイルのStreamを作成する
     *
     * @return
     * @throws IOException
     */
    private static Stream<File> listJavaFiles() throws IOException {
        return Files.walk(Paths.get(".")).map(Path::toFile).filter(f -> f.getName().endsWith(".java"));
    }
}

// 完成までの時間: 50分
