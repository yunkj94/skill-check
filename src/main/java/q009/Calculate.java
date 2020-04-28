package q009;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Calculate implements Runnable {
    private final BigInteger inputNum;
    private String result;
    private boolean isNoDisplay;

    public Calculate(BigInteger inputNum) {
        this.inputNum = inputNum;
        isNoDisplay = false;
    }

    @Override
    public void run() {
        if(inputNum.compareTo(BigInteger.ONE) <= 0) {
            setResult(inputNum + ": 2以上の整数を入力してください。");
        }
        var resultList = new ArrayList<BigInteger>();
        var i = BigInteger.TWO;
        var calcTmp = inputNum;
        while(!calcTmp.equals(BigInteger.ONE)) {
            var calcResult = calcTmp.divideAndRemainder(i);
            if(calcResult[1].equals(BigInteger.ZERO)) {
                resultList.add(i);
                calcTmp = calcTmp.divide(i);
                i = BigInteger.TWO;
            } else {
                i = i.add(BigInteger.ONE);
            }
        }
        setResult(inputNum + ": "
                + resultList.stream().map(BigInteger::toString).collect(Collectors.joining(",")));
    }

    public String getResult() {
        if(Objects.isNull(result)) {
            return inputNum + ": 実行中";
        } else {
            //一度計算値を取得したら、二度目は表示させないようフラグをたてる
            isNoDisplay = true;
            return result;
        }
    }

    private void setResult(String result) {
        this.result = result;
    }

    public boolean getIsNoDisplay() {
        return isNoDisplay;
    }
}
