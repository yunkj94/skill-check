package q005;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Q005 データクラスと様々な集計
 *
 * 以下のファイルを読み込んで、WorkDataクラスのインスタンスを作成してください。
 * resources/q005/data.txt
 * (先頭行はタイトルなので読み取りをスキップする)
 *
 * 読み込んだデータを以下で集計して出力してください。
 * (1) 役職別の合計作業時間
 * (2) Pコード別の合計作業時間
 * (3) 社員番号別の合計作業時間
 * 上記項目内での出力順は問いません。
 *
 * 作業時間は "xx時間xx分" の形式にしてください。
 * また、WorkDataクラスは自由に修正してください。
 *
[出力イメージ]
部長: xx時間xx分
課長: xx時間xx分
一般: xx時間xx分
Z-7-31100: xx時間xx分
I-7-31100: xx時間xx分
T-7-30002: xx時間xx分
（省略）
194033: xx時間xx分
195052: xx時間xx分
195066: xx時間xx分
（省略）
 */
public class Q005 {
    private static Map<String, Integer> tmpMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        var path = Paths.get("src/main/resources/q005/data.txt");
        List<String> fileList = Files.readAllLines(path);
        List<WorkData> workDataList = fileList.stream()
                .filter(l -> !Objects.equals(l, "社員番号,部署名,役職名,P-CODE,作業時間"))
                .map(WorkData::create)
                .collect(Collectors.toList());

        //(1) 役職別の合計作業時間
        for(var workData : workDataList) {
            if(tmpMap.containsKey(workData.getPosition())) {
                tmpMap.replace(workData.getPosition(),
                        tmpMap.get(workData.getPosition()) + workData.getWorkTime());
            } else {
                tmpMap.put(workData.getPosition(), workData.getWorkTime());
            }
        }
        System.out.println("(1) 役職別の合計作業時間");
        printResult();

        //(2) Pコード別の合計作業時間
        tmpMap.clear();
        for(var workData : workDataList) {
            if(tmpMap.containsKey(workData.getPCode())) {
                tmpMap.replace(workData.getPCode(),
                        tmpMap.get(workData.getPCode()) + workData.getWorkTime());
            } else {
                tmpMap.put(workData.getPCode(), workData.getWorkTime());
            }
        }
        System.out.println("(2) Pコード別の合計作業時間");
        printResult();

        //(3) 社員番号別の合計作業時間
        tmpMap.clear();
        for(var workData : workDataList) {
            if(tmpMap.containsKey(workData.getNumber())) {
                tmpMap.replace(workData.getNumber(),
                        tmpMap.get(workData.getNumber()) + workData.getWorkTime());
            } else {
                tmpMap.put(workData.getNumber(), workData.getWorkTime());
            }
        }
        System.out.println("(3) 社員番号別の合計作業時間");
        printResult();
    }

    private static void printResult() {
        tmpMap.forEach((k, v) -> System.out.println
                        (k + ": " + v / 60 + "時間" + v % 60 + "分")
        );
    }
}
// 完成までの時間: xx時間 50分