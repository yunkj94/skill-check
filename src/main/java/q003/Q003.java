package q003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Q003 集計と並べ替え
 *
 * 以下のデータファイルを読み込んで、出現する単語ごとに数をカウントし、アルファベット辞書順に並び変えて出力してください。
 * resources/q003/data.txt
 * 単語の条件は以下となります
 * - "I"以外は全て小文字で扱う（"My"と"my"は同じく"my"として扱う）
 * - 単数形と複数形のように少しでも文字列が異れば別単語として扱う（"dream"と"dreams"は別単語）
 * - アポストロフィーやハイフン付の単語は1単語として扱う（"isn't"や"dead-end"）
 *
 * 出力形式:単語=数
 *
[出力イメージ]
（省略）
highest=1
I=3
if=2
ignorance=1
（省略）

 * 参考
 * http://eikaiwa.dmm.com/blog/4690/
 */
public class Q003 {

    public static void main(String[] args) throws IOException {
        var path = Paths.get("src/main/resources/q003/data.txt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        var sb = new StringBuilder();
        for(var line : lines) {
            sb.append(line);
            sb.append(" ");
        }
        var fileStr = sb.toString();
        fileStr = fileStr.replaceAll("[;.,]", "");
        var words = fileStr.split(" ");
        Map<String, Integer> resultMap = new HashMap<>();
        for(var word : words) {
            if(resultMap.containsKey(word)) {
                resultMap.replace(word, resultMap.get(word) + 1);
            } else {
                resultMap.put(word, 1);
            }
        }
        resultMap.forEach((word, count) -> System.out.println(word + "=" + count));
    }

    /**
     * データファイルを開く
     * resources/q003/data.txt
     */
    private static InputStream openDataFile() {
        //コンパイルしないと読めない？
        return Q003.class.getResourceAsStream("data.txt");
    }
}
// 完成までの時間: 0時間 25分