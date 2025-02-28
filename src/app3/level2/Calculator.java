package app3.level2;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static app3.level2.App.exitCheck;

//사칙연산 수행 결과값 반환 메소드,
public class Calculator {

    // 연산결과 저장하는 타입 필드
    private static Queue<Integer> results = new LinkedList<>();

    //연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정(캡슐화)
    public Queue<Integer> getResults(){
        return results;
    }

    // 추가하기, FIFO (마지막 idx)
    public void setResults(Integer result){
            results.add(result);
    }

    //연산 수행 , 수행후 results 저장
    //calculate
    //사칙 연산 수행, 결과 반환 메소드
    public Integer calculate(int num1,int num2, String oper){
            int result =0;
            switch (oper) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;

                case "/":

                    if (num2 == 0) {
                        throw new ArithmeticException("0으로 나눌 수 없습니다. ");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("연산자를 잘못 입력하셨습니다.");
            }
        return result;
    }





    // 첫번째 계산된거 삭제
    public void removeResults(){
    //선입선출
    results.poll();


    }
}
