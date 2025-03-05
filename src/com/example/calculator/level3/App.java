package com.example.calculator.level3;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.example.calculator.level3.InputHandler.operCheck;

public class App {

    public static void main(String[] args) throws IOException {
        String[] message ={"첫 번째 정수를 입력해 주세요 (exit 종료)  >>> ", "두 번째 정수를 입력해 주세요 (exit 종료)  >>> " };
        ArithmeticCalculator cal = new ArithmeticCalculator();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Result printCal = new Result(br,cal);

        System.out.println("====================계산기====================");
        //전역 변수로 선언해야 함
        //다시 계산할때 값 가져오기
        boolean isContinue = false;
        Number result =0;

        /*계산기 시작 */
        while (true) {
            //Integer,Number 부모타입으로 받기
            Number num1;  //밑에 while문안에서 선언해버리면 지역변수라 숫자들을 못쓴다.
            Number num2;

            //************분기처리*********//
            //첫번째 숫자 입력
            //이전값 안가져오는거
            if (!isContinue) {
                num1 = InputHandler.getNum(br,message[0]);
            } else {
                num1 = result;
                System.out.println("이전 결과 >> " + num1);
            }
            //************분기처리*********//
            //두번째 숫자 입력
            num2 = InputHandler.getNum(br,message[1]);
            //************분기처리*********//

            //연산자 받아서 검사후 enum 타입 으로 변경 /
            OperatorType oper = operCheck(br);

            //연산메소드
            try{
                result = cal.calculate(num1,num2,oper);
                //연산결과 큐에 저장
                cal.setResults(result);
                //예외처리
            }catch(ArithmeticException are){
                System.out.println("0으로 나눌 수 없습니다.");
                continue;
            }catch(Exception e){
                System.out.println("예상치 못한 오류 발생. 다시 시도해주세요!");
                continue;
            }

            System.out.println("결과 >> " + result);
            System.out.printf("저장된 결과 %s\n",cal.getResults());


            /*입력(y/n), 결과받고 결과 print*/
            isContinue = printCal.stateContinue(result);
            if (!isContinue) {
                return;
            }
//
        }
    }


}




