package q004;

/**
 * Q004 ソートアルゴリズム
 *
 * ListManagerクラスをnewして、小さい順に並び変えた上でcheckResult()を呼び出してください。
 *
 * 実装イメージ:
 * ListManager data = new ListManager();
 * // TODO 並び換え
 * data.checkResult();
 *
 * - ListManagerクラスを修正してはいけません
 * - ListManagerクラスの dataList を直接変更してはいけません
 * - ListManagerクラスの比較 compare と入れ替え exchange を使って実現してください
 */
public class Q004 {
    public static void main(String[] args) {
        var data = new ListManager();
        int index = 0;
        while(true) {
            if(index == data.size() - 1) {
                try {
                    data.checkResult();
                    break;
                } catch (RuntimeException e) {
                    index = 0;
                    continue;
                }
            }
            if(data.compare(index, index + 1) == 1) {
                data.exchange(index, index + 1);
            }
            index++;
        }
    }
}
// 完成までの時間: xx時間 10分