package com.example.calculator.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Result {
    private final BufferedReader br;
    private final ArithmeticCalculator cal;

    public Result(BufferedReader br, ArithmeticCalculator cal){
        this.br =br;
        this.cal = cal;
    }

        public boolean stateContinue(Number result) throws IOException {

            while (true) {
                System.out.println("계속 계산 하시겠습니까 ? (y/n)");
                String input = br.readLine().trim();

                if (input.equalsIgnoreCase("y")) {
    //            isContinue = true;
                    return true;
                } else if (input.equalsIgnoreCase("n")) {
                    printResults(result);
                    return false;
                } else if (input.equalsIgnoreCase("exit")) {
                    System.out.println("==========프로그램 종료==========");
                    System.exit(0);
                } else {
                    System.out.println("다시 입력해주세요");
                }
    //            System.out.println("현재 결과 :  " + result);
    //            System.out.println("=============================");
            }
        }

        public void printResults(Number result){
                    cal.maxNum();
                    System.out.printf(result + " 보다 큰 값들 >>>>");
                    System.out.println("결과들 : " + cal.getResults());
                    cal.printResultBiggerThan(result);
                    System.out.println("===========");
                    System.out.printf("%s 보다 작은것  >> ", result);
                    cal.printResultLessThan(result);
                    cal.printEven();
                    System.out.println("====");
                    cal.multiplyResultByThree();
                    System.out.println("3배 하기>>" + cal.getResults());
                    System.out.println("==========첫번째 결과 삭제 =====");
                    cal.removeResults();
                    System.out.println("삭제된 결과 : " + cal.getResults());
                    System.out.println("==========프로그램 종료==========");
        }
}
