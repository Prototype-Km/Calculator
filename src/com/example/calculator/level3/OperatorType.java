package com.example.calculator.level3;

public enum OperatorType {
    PLUS("+"), MINUS("-"), MULTI("*"), DIV("/");

    private final String oper;

    OperatorType(String oper){
    this.oper = oper;
    }

    //******  문자열을 Enum으로 바꾸는 메서드  ******
    public static OperatorType fromString(String oper) {
        for (OperatorType type : OperatorType.values()) {
            if (type.oper.equals(oper)) {
                return type;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자 입력: " + oper);
    }
}

