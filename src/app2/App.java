package app2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();
        boolean isContinue = false;
        int result =0;

        while (true) {
            int num1 =0;
            int num2 =0;
            String input = "";

            if(isContinue){
                num1 = result;
                System.out.println("첫 번째 정수 : " + result);
            }else{
                System.out.print("첫 번째 (양의 정수)숫자를 입력하세요. >>  (exit 입력시 종료)");
                input = sc.nextLine();

                if(input.equalsIgnoreCase("exit")) return;

                try{
                    num1 = Integer.parseInt(input);
                    if(num1 < 0){
                        System.out.println("양의 정수만 입력 해주세요 (exit 입력시 종료)");
                        continue;
                    }
                }catch(NumberFormatException e){
                    System.out.println("숫자만 입력 해주세요. (exit 입력시 종료)");
                    continue;
                }
            }

            System.out.print("두 번째 (양의 정수)숫자를 입력하세요. >> (exit 입력시 종료) ");
            input = sc.nextLine();

            if(input.equalsIgnoreCase("exit")) return;

            try{
                num2 = Integer.parseInt(input);
                if( num2 <0 ){
                    System.out.println("양의 정수만 입력 해주세요 (exit 입력시 종료)");
                    continue;
                }
            }catch(NumberFormatException e){
                System.out.println("숫자만 입력 해주세요. (exit 입력시 종료)");
                continue;
            }

            System.out.print("연산자를 입력해주세요(+, -, *, /) >>   (exit 입력시 종료)");
            String oper = sc.nextLine();

            if(input.equalsIgnoreCase("exit")){
                return;
            }

            //연산
            try {
                result = calculator.calculate(num1, num2, oper);
                System.out.println("결과 : " + result);
            }catch(ArithmeticException are) {
                System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
                continue;
            }catch(IllegalArgumentException iae){
                System.out.println("연산자를 다시 입력해주세요(+, -, *, /) exit 입력시 종료");
                continue;
            } catch (Exception e) {
                System.out.println("예상치 못한 오류 발생 다시 입력해주세요 (exit 입력시 종료)");
                continue;
            }


            System.out.println("계속 계산 하시겠습니까? (y/n) /(exit 입력시 종료)");
            input = sc.nextLine();

            if(input.equalsIgnoreCase("y")){
                isContinue = true;
            }else if(input.equalsIgnoreCase("n")){
                System.out.println("결과 : "+calculator.getArData());
                System.out.println("==========프로그램 종료==========");
                break;
            }else if(input.equalsIgnoreCase("exit")){
                break;
            }else{
                System.out.println("다시 입력해주세요");
                continue;
            }
        }
        System.out.print("첫번째 인덱스 삭제 >> ");
        calculator.removeFirst();
        System.out.println(calculator.getArData());
    }

}



