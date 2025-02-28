package com.example.calculator.level3;

import java.io.BufferedReader;
import java.io.IOException;

public class InputHandler {

    //    숫자를 입력하세요 , 받은 값이 정수인지 실수인지 판별 해서 num에 넣기
    // Integer, Double, float, long 숫자 타입으로 리턴.
    public static Number getNum(BufferedReader br, String message) throws IOException {
        while (true) {
            try {
                System.out.println(message);
                String input = br.readLine().trim();
                //exit 체크 메소드
                exitCheck(input);

//                input 실수0.0  / 정수 0
                if(input.contains(".")){
                    return Double.parseDouble(input);
                }else{
                    return  Integer.parseInt(input);
                }

            } catch (NumberFormatException ne) {
                System.out.println("숫자만 입력해주세요! ");
            } catch (Exception e) {
                System.out.println("예상치 못한 오류 발생. 다시 시도해주세요!!");
            }
        }
    }
    /** exit 입력시 프로그램 종료 **/
    private static void exitCheck(String input){
        if (input.equalsIgnoreCase("exit")) {
            System.out.println("프로그램을 종료합니다 ^_^ ! ");
            System.exit(0);
        }
    }

    /*연산자 받아서 enum 타입으로 변경*/
    public static OperatorType operCheck(BufferedReader br) throws IOException{
        while (true) {
            try {
                System.out.print("연산자를 입력해주세요 (+, -, *, /) , exit 종료 >>> ");
                String oper = br.readLine().trim();

                //exit 검사
                exitCheck(oper);

                return OperatorType.fromString(oper);
            } catch (IllegalArgumentException iea) {
                System.out.println("(+, -, *, /)중 입력해주세요. , exit 종료 >>> ");
            } catch (Exception e) {
                System.out.println("예상치 못한 오류 발생. 다시 시도해주세요!!");

            }
        }
    }
}
