# Calculator Program

# 프로젝트 소개  
 계산기를 만들어보자!<br>
1. 클래스를 활용한 계산기**: 이 버전에서는 자바의 객체 지향 원칙을 적용하여 클래스를 정의하고, 연산을 수행하는 메소드를 작성해야 합니다.<br>이 과정에서 클래스와 객체의 개념을 이해하고 활용하는 방법을 익힐 수 있습니다.
2. 클래스를 사용하지 않는 계산기**: 이 버전에서는 클래스 없이 자바의 기본 문법만을 사용하여 계산기를 구현합니다.<br>
 변수와 메소드를 이용하여 연산을 수행하는 과정에서 자바의 절차적 프로그래밍을 경험할 수 있습니다.

<br>
<hr/>

# Stack
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white">


# 주요기능  

> Lv1    - 사용자 입력을 통한 기본 계산 수행,<br>
         - 입력 예외 처리,<br>
         - 이전결과 활용 기능,<br>
         - 반복적 입력검증, <br>
         - exit 입력시 프로그램 종료<br>
         - 결과 값 전체 조회 (getResults)<br>
         - 첫 번째 결과 삭제 (removeResults)<br>
      <br>
      <br>
 > Lv2   - 연산결과 Queue<Integer>에 저장,
         - 결과 삭제 <br>

 > Lv3   - 입력 값보다 큰 결과 출력 (printResultBiggerThan)<br>
         - 입력 값보다 작은 결과 출력 (printResultLessThan)<br>
         - 짝수 결과만 출력 (printEven)<br>
         - 저장된 결과를 3배로 변경 (multiplyResultByThree)<br>
         - 최대값 찾기 (maxNum)<br>
         - 결과 총합 계산 (sumResults)<br>

<hr/>


# 디렉토리 구조
```
/src
└── /main
    └── /java
        └── /com
            └── /example
                └── /calculator
                    ├── /level1
                    │   └── App1.java
                    ├── /level2
                    │   ├── App1.java
                    │   └── Calculator.java
                    └── /level3
                        ├── App.java
                        ├── ArithmeticCalculator.java
                        ├── InputHandler.java
                        ├── OperatorType.enum
                        └── Result.java
```
