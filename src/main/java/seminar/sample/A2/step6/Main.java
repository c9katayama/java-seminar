package seminar.sample.A2.step6;

import seminar.sample.A2.step5.CashFlowChartBuilder;

public class Main {

  public static void main(String[] args) throws Exception {

    DIContainer diContainer = new DIContainer("config.json");
    CashFlowChartBuilder builder = diContainer.getBean(CashFlowChartBuilder.class);

    int fromAge = 20;
    int toAge = 40;
    int gender = 1;

    String chartFilePath = builder.createCashFlowChart(fromAge, toAge, gender);

    System.out.println(chartFilePath);
  }
}

