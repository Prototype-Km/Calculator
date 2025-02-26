package app2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Integer> arData = new ArrayList<>();

    public List<Integer> getArData() {
        return new ArrayList<>(arData);
    }

    public void setArData(List<Integer> arData) {
        this.arData = arData;
    }

    // 가장 먼저 저장된 데이터를 삭제하는 기능
    public void removeFirst() {
        if (!arData.isEmpty()) {
            arData.remove(0);
        }
    }

    /*연산*/
    private int plus(int num1, int num2) {return num1 + num2;}
    private int minus(int num1, int num2) {return num1 - num2;}
    private int multiply(int num1, int num2) {return num1 * num2;}
    private int div(int num1, int num2) {return num1 / num2;}




    //결과값 반환하는 메소드, 연산 결과를 저장하는 컬렉션 타입 필드
    int calculate(int num1, int num2, String oper) {
        int result = 0;
        switch (oper) {
            case "+":
                result = plus(num1, num2);
                break;
            case "-":
                result = minus(num1, num2);
                break;
            case "*":
                result = multiply(num1, num2);
                break;
            case "/":
                if(num2 == 0){
                    throw new ArithmeticException("0으로 나눌 수 없습니다");
                }
                result = div(num1, num2);
                break;
            default:
                throw new IllegalArgumentException("연산자를 다시 입력하세요");
        }
        arData.add(result);
        return result;
    }

}