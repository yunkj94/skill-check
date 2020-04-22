package q006.value;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * 足し算を行うクラス
 */
public class MinusValue implements IValue {
    @Override
    public void execute(Stack<BigDecimal> values) {
        // スタックから2つの値を抜き出し、足し算した結果をスタックに積む
        BigDecimal right = values.pop();
        BigDecimal left = values.pop();
        values.push(left.subtract(right));
    }
}
