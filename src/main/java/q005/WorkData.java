package q005;

import lombok.Data;

/**
 * 作業時間管理クラス
 * 自由に修正してかまいません
 */
@Data
public class WorkData {
    /** 社員番号 */
    private String number;

    /** 部署 */
    private String department;

    /** 役職 */
    private String position;

    /** Pコード */
    private String pCode;

    /** 作業時間(分) */
    private int workTime;

    public static WorkData create(String line)
    {
        var rows = line.split(",");
        var workData = new WorkData();
        workData.number = rows[0];
        workData.department = rows[1];
        workData.position = rows[2];
        workData.pCode = rows[3];
        workData.workTime = Integer.parseInt(rows[4]);
        return workData;
    }
}
