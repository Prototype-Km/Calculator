package com.example.calculator.level3;

public enum OperatorType {
    PLUS("+"), MINUS("-"), MULTI("*"), DIV("/");

    //연산자
    private final String oper;

    /*생성자  / oper받아서 넣기 */
    OperatorType(String oper){
        this.oper = oper;
    }

    public String getOper() {
        return oper;
    }

    //******  입력받은 값,enum값 객체에서 꺼내서 비교 ******
    public static OperatorType findByOper(String inputOper){
        for(OperatorType value : values()){
            if(value.getOper().equals(inputOper)){
                return value;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자 입력: " + inputOper);
    }
}

