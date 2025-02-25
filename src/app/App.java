package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isContinue = false;
        int result =0;

        while (true) {
        int num1;
        int num2;
        String input;
            if(isContinue){
                num1 = result; //이전 결과값 넣기
                System.out.println("첫번쨰 정수 :" + result);

            }else{
            System.out.println("첫 번째 (양의 정수)숫자를 입력하세요.");

            input = sc.nextLine();

            if(input.equalsIgnoreCase("exit")){
                return;
            }
            try{
                num1 = Integer.parseInt(input);

                if(num1 >= 0){;}
                else{
                    System.out.println("양의 정수만 입력 가능합니다 !!");
                    continue;
                }
            }catch(NumberFormatException e){
                System.out.println("숫자만 입력 가능합니다.");
                continue;
                }
            }

            System.out.println("두 번째 (양의 정수)숫자를 입력하세요.");

            input = sc.nextLine();
            if(input.equalsIgnoreCase("exit")){
                return;
            }
            try{
                num2 = Integer.parseInt(input);
                if(num2 >= 0){;}
                else{
                    System.out.println("양의 정수만 입력 가능합니다 !!");
                    continue;}
            }catch(NumberFormatException e){
                System.out.println("숫자만 입력 가능합니다.");
                continue;
            }

            System.out.println("연산자를 입력해주세요(+, -, *, /)");
            input = sc.nextLine();
            if(input.equalsIgnoreCase("exit")){
                return;
            }

            switch(input){
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
                    if (num2 == 0){
                        System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요.");
                        continue;
                    }
                    result = num1/num2;
                    break;
                default :
                    System.out.println("다시 입력해주세요");
                    continue;

            }
            System.out.println("결과 : " + result);


            System.out.println("계속 계산 하시겠습니까? (y/n)");
            input = sc.nextLine();
            if(input.equalsIgnoreCase("y")){
                System.out.println("y들어옴?");
                isContinue = true;
                //첫번째로
//                num1 = result; //첫번쨰 값에 result값 넣기?
//                System.out.println(result);
            }else if(input.equalsIgnoreCase("n")){
//                그냥 출력 하고 멈춤
                System.out.println("결과 : "+result);
                break;
            }else if(input.equalsIgnoreCase("exit")){
                break;
            }

        }
    }

}

