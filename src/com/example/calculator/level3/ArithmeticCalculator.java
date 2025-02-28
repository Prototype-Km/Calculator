package com.example.calculator.level3;

import java.util.*;
import java.util.stream.Collectors;


// 제네릭 <T extends Number> 로 타입 제한
public class ArithmeticCalculator<T extends Number> {

    //입력값 num1,num2
//    private T num1;
//    private T num2;

    // 연산결과 저장하는 타입 필드
    private  Queue<T> results = new LinkedList<>();
    private List<T> arResults = new ArrayList<>();

    //연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정(캡슐화)
    public Queue<T> getResults() {
        return results;
    }

    // 추가하기, FIFO (마지막 idx)
    public void setResults(T t) {
        results.add(t);
    }

    // 첫번째 계산된거 삭제
    public void removeResults() {
        //선입선출
        results.poll();
    }

    /*getter & setter */
//    public T getNum1() {
//        return num1;
//    }
//
//    public T getNum2() {
//        return num2;
//    }
//
//    public void setNum1(T num1) {
//        this.num1 = num1;
//    }
//
//    public void setNum2(T num2) {
//        this.num2 = num2;
//    }


    //연산 수행 , 수행후 results 저장
    //calculate
    //사칙 연산 수행, 결과 반환 메소드
    public T calculate(T num1, T num2, OperatorType oper) {
        double result;
        //값을 받아서 enum이랑 비교하기
        //double 이면 바로
        switch (oper) {
            case PLUS:
                result = num1.doubleValue() + num2.doubleValue();
                break;
            case MINUS:
                result = num1.doubleValue() - num2.doubleValue();
                break;
            case MULTI:
                result = num1.doubleValue() * num2.doubleValue();
                break;
            case DIV:
                if (num2.doubleValue() == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다. ");
                }
                result = num1.doubleValue() / num2.doubleValue();
                break;
            default:
                throw new IllegalArgumentException("연산자를 잘못 입력하셨습니다.");
        }

        //instanceof ( 타입검사)
        // 들어오기전에 압력값에서 실수 정수 검사하긴하는데
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) Integer.valueOf((int) result);
        } else if (num1 instanceof Long && num2 instanceof Long) {
            return (T) Long.valueOf((long) result);
        } else if (num1 instanceof Float && num2 instanceof Float) {
            return (T) Float.valueOf((float) result);
        } else
            return (T) (Double.valueOf(result));
    }

    //조회 메소드 구현
    // 람다 스트림으로, 저장된 연산 결과들 . 입력받은 값보다 큰 결과값들을 출력하기
    public void printResultBiggerThan(T input) {
        results.stream().filter(n -> n.doubleValue() > input.doubleValue()).forEach(n -> System.out.print(n+"\t"));
    }

    /*input값 , 결과 보다 작은 값들*/
    public void printResultLessThan(T input){
        results.stream().filter(n -> n.doubleValue() < input.doubleValue()).forEach(System.out::println);
    }

    /*결과값중 짝수만 출력*/
    public void printEven(){
        results.stream().filter(n-> (n.doubleValue() % 2 ==0)).forEach(n->System.out.print("짝수만 출력 ->>>"+n+"\n"));
    }

    public void multiplyResultByThree(){
        results =
            results.stream()
                .map(result -> (T) Double.valueOf(result.doubleValue() * 3))
                .collect(Collectors.toCollection(LinkedList::new));
    }


    public void maxNum() {
       double max =  results.stream().mapToDouble(v -> v.doubleValue())
                .max().orElseThrow(()->new NoSuchElementException("결과가없습니다"));
        System.out.println("최대값 : "+ max);

    }

    public T sumResults(){
        return results.stream().reduce((n1,n2)->{
            return (T) Double.valueOf(n1.doubleValue() + n2.doubleValue());
        }).orElseThrow(null);
    }

}