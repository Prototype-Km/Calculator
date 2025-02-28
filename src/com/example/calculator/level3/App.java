package com.example.calculator.level3;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.example.calculator.level3.InputHandler.operCheck;

public class App {

    public static void main(String[] args) throws IOException {
        String[] message ={"첫 번째 정수를 입력해 주세요 (exit 종료)  >>> ", "두 번째 정수를 입력해 주세요 (exit 종료)  >>> " };
        ArithmeticCalculator cal = new ArithmeticCalculator();
        InputHandler inputHandler = new InputHandler();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("====================계산기====================");
        //전역 변수로 선언해야 함
        //다시 계산할때 값 가져오기
        boolean isContinue = false;
        Number result =0;

        /*계산기 시작 */
        while (true) {
            //정수 실수 판별하기
            Number num1;  //밑에 while문안에서 선언해버리면 지역변수라 숫자들을 못쓴다.
            Number num2;

            //************분기처리*********//
            //첫번째 숫자 입력
            //이전값 안가져오는거
            if (!isContinue) {
                num1 = inputHandler.getNum(br,message[0]);
            } else {
                num1 = result;
                System.out.println("이전 결과 >> " + num1);
            }
            //************분기처리*********//
            //두번째 숫자 입력
            num2 = inputHandler.getNum(br,message[1]);
            //************분기처리*********//

            //연산자 받아서 검사 /
            OperatorType oper = inputHandler.operCheck(br);

            //연산메소드
            try{
                result = cal.calculate(num1,num2,oper);
                //연산결과 큐에 저장
                cal.setResults(result);
            }catch(ArithmeticException are){
                System.out.println("0으로 나눌 수 없습니다.");
                continue;
            }catch(Exception e){
                System.out.println("예상치 못한 오류 발생. 다시 시도해주세요!");
                continue;
            }

            System.out.println("결과 >> " + result);
            System.out.printf("저장된 결과 %s\n",cal.getResults());

            while (true) {
                System.out.println("계속 계산 하시겠습니까 ? (y/n)");
                String input = br.readLine().trim();

                if (input.equalsIgnoreCase("y")) {
                    isContinue = true;
                    break;
                } else if (input.equalsIgnoreCase("n")) {
                    System.out.println("현재 결과 :  " + result);
                    cal.maxNum();

                    System.out.println("=============================");
                    System.out.println("결과들 : " + cal.getResults());
                    System.out.print(result+"보다 큰 값들 >>>>");
                    cal.printResultBiggerThan(result);
                    System.out.println("===========");
                    System.out.printf("result보다 작은것 . >> ",result);
                    cal.printResultLessThan(result);
                    cal.printEven();
                    System.out.println("====");
                    cal.multiplyResultByThree();
                    System.out.println("3배 하기>>" + cal.getResults());
                    System.out.println("==========첫번째 결과 삭제 =====");
                    cal.removeResults();
                    System.out.println("삭제된 결과 : " + cal.getResults());
                    System.out.println("==========프로그램 종료==========");
                    return;
                } else if (input.equalsIgnoreCase("exit")) {
                    System.out.println("==========프로그램 종료==========");
                    return;
                } else {
                    System.out.println("다시 입력해주세요");
                }
            }
        }
    }


}




