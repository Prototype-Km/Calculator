package com.example.calculator.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("====================계산기====================");

        //전역 변수로 선언해야 함
        boolean isContinue = false; //다시 계산할때 값 가져오기
        int result = 0;

        while (true) {
            int num1 = 0;  //밑에 while문안에서 선언해버리면 지역변수라 숫자들을 못쓴다.
            int num2 = 0;

            //첫번째 숫자 입력
            while (true) {

                try {
                    // y누르면 이전값 가져오기
                    if (!isContinue) {
                        System.out.println("첫 번째 정수를 입력해 주세요 (exit 종료)  >>>  ");
                        String input = br.readLine();

                        // exit누르면 프로그램 종료,반복되니까 -> ,메소드
                        if (input.equalsIgnoreCase("exit")) {
                            System.out.println("프로그램을 종료합니다 ^_^ ! ");
                            return;
                        }

                        num1 = Integer.parseInt(input);
                        if(num1 < 0) {
                            System.out.println("양의 정수를 입력해주세요 >>> ");
                            continue;
                        }

                        System.out.println("첫번쨰숫자 " + num1);
                    } else {
                        num1 = result;
                        System.out.println("이전 결과 >> " + num1);
                    }
                    break;
                } catch (NumberFormatException ne) {
                    System.out.println("숫자만 입력해주세요!");
                } catch (Exception e) {
                    System.out.println("예상치 못한 오류 발생. 다시 시도해주세요!!");
                }
            }


            //두번째 숫자 입력
            while (true) {
                try {
                    System.out.println("두 번째 정수를 입력해 주세요 (exit 종료)  >>>  ");
                    String input = br.readLine();

                    //반복(메소드)
                    if (input.equalsIgnoreCase("exit")) {
                        System.out.println("프로그램을 종료합니다 ^_^ ! ");
                        return;
                    }

                    num2 = Integer.parseInt(input);
                    if(num2 < 0) {
                        System.out.println("양의 정수를 입력해주세요 >>> ");
                        continue;
                    }
                    System.out.println("두 번째 정수 " + num2);
                    break;

                } catch (NumberFormatException ne) {
                    System.out.println("숫자만 입력해주세요! ");
                } catch (Exception e) {
                    System.out.println("예상치 못한 오류 발생. 다시 시도해주세요!!");
                }
            }

            //연산자 받기 / 연산하기
            while (true) {
                try {

                    System.out.println("연산자를 입력해주세요 (+, -, *, /) , exit 종료");
                    String input = br.readLine();

                    //exit 검사
                    if (input.equalsIgnoreCase("exit")) {
                        System.out.println("프로그램을 종료합니다 ^_^ ! ");
                        return;
                    }

                    //정규식 검사
                    // "+", "-", "*", "/" 만 허용
                    if (!input.matches("^[+\\-*/]$")) {
                        //연산자 아닐경우 반복
                        continue;
                    }

                    //계산
                    switch (input) {
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
                                System.out.println("0으로 나눌수 없습니다. ! ");
                                continue;
                            }
                            result = num1 / num2;
                            break;
                        default:
                            System.out.println("다시 입력해주세요. ");
                            continue;
                    }

                } catch (IllegalArgumentException iea) {
                    System.out.println("(+, -, *, /)중 입력해주세요. , exit 종료");
                } catch (Exception e) {
                    System.out.println("예상치 못한 오류 발생. 다시 시도해주세요!!");
                }
                break;
            }

            System.out.println("결과 >> " + result);
            while (true) {

                System.out.println("계속 계산 하시겠습니까 ? (y/n)");
                String input = br.readLine();


                if (input.equalsIgnoreCase("y")) {
                    isContinue = true;
                    break;
                } else if (input.equalsIgnoreCase("n")) {
                    System.out.println("결과 : " + result);
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

