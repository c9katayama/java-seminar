package seminar.sample.C3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ParallelStreamSample {

  public static void main(String[] args) throws Exception {
    new ParallelStreamSample().insertToDB();
  }

  Connection con = null;

  public void insertToDB() throws Exception {
    {
      List<String> keys = new ArrayList<>();
      for (int i = 0; i < 100; i++) {
        keys.add(String.valueOf(i));
      }

      // 並列処理
      keys.parallelStream().forEach(key -> insert(key));
    }
  }

  public void insert(String key) {
    // SQL発行してカラムをインサートする
    try {
      String sql = "UPDATE EMPLOYEE SET PHONENO=? WHERE EMPNO=100 ";
      PreparedStatement prepareStatement = con.prepareStatement(sql);
      prepareStatement.setString(1, key);
      prepareStatement.executeUpdate();
    } catch (Exception e) {
    }
  }
}
