package seminar.sample.C1_2.stream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelStreamSample {
  @SuppressWarnings("unused")
  public static void main(String[] args) {}

  Connection con = null;

  public void insertToDB() throws Exception {
    {
      List<String> keys = List.of("1", "2", "3", "4");
      for (String key : keys) {
        insert(key);
      }
    }
    {
      List<String> keys = List.of("1", "2", "3", "4");
      ExecutorService threadPool = Executors.newFixedThreadPool(4);
      for (String key : keys) {
        threadPool.execute(new Runnable() {
          @Override
          public void run() {
            insert(key);
          }
        });
      }
      threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
    }
    {
      List<String> keys = List.of("1", "2", "3", "4");

      // 逐次処理
      keys.stream().forEach(key -> insert(key));
    }
    {
      List<String> keys = List.of("1", "2", "3", "4");

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
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
