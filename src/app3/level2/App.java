package app3.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class App {

    public static void main(String[] args) throws IOException {
        String[] message ={"첫 번째 정수를 입력해 주세요 (exit 종료)  >>> ", "두 번째 정수를 입력해 주세요 (exit 종료)  >>> " };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("====================계산기====================");
        Calculator cal = new Calculator();
        //전역 변수로 선언해야 함
        //다시 계산할때 값 가져오기
        boolean isContinue = false;
        int result = 0;

        while (true) {
            int num1 = 0;  //밑에 while문안에서 선언해버리면 지역변수라 숫자들을 못쓴다.
            int num2 = 0;

            //************분기처리*********//
            //첫번째 숫자 입력
            //이전값 안가져오는거
            if (!isContinue) {
                num1 = getNum(br,message[0]);
            } else {
                num1 = result;
                System.out.println("이전 결과 >> " + num1);
            }
            //************분기처리*********//
            //두번째 숫자 입력
            num2 = getNum(br,message[1]);
            //************분기처리*********//

            //연산자 받아서 검사 /
            String oper = operCheck(br);

            //연산메소드
            try{
                result = cal.calculate(num1,num2,oper);
                //연산결과 큐에 저장
                cal.setResults(result);
            }catch(ArithmeticException are){
                System.out.println("0으로 나눌 수 없습니다.");
                continue;
            }catch(Exception e){
                System.out.println("예상치 못한 오류 발생. 다시 시도해주세요!");
                continue;
            }

            System.out.println("결과 >> " + result);
            System.out.printf("결과였던것들 %s\n",cal.getResults());

            while (true) {
                System.out.println("계속 계산 하시겠습니까 ? (y/n)");
                String input = br.readLine();

                if (input.equalsIgnoreCase("y")) {
                    isContinue = true;
                    break;
                } else if (input.equalsIgnoreCase("n")) {
                    System.out.println("현재 결과 :  " + result);
                    System.out.println("=============================");
                    System.out.println("결과들 : " + cal.getResults());
                    System.out.println("==========첫번째 결과 삭제 =====");
                    cal.removeResults();
                    System.out.println("삭제된 결과 : " + cal.getResults());
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

//    숫자를 입력하세요 ,
    private static int getNum(BufferedReader br,String message) throws IOException{
        while (true) {
            try {
                System.out.println(message);
                String input = br.readLine();

                //exit 체크 메소드
                exitCheck(input);

                int num2 = Integer.parseInt(input);
                if (num2 < 0) {
                    System.out.print("양의 정수를 입력해주세요 >>> ");
                    continue;
                }
                return num2;
            } catch (NumberFormatException ne) {
                System.out.println("숫자만 입력해주세요! ");
            } catch (Exception e) {
                System.out.println("예상치 못한 오류 발생. 다시 시도해주세요!!");
            }
        }
    }
    // exit
    private static void exitCheck(String input){
        if (input.equalsIgnoreCase("exit")) {
            System.out.println("프로그램을 종료합니다 ^_^ ! ");
            System.exit(0);
        }
    }

    private static String operCheck(BufferedReader br) throws IOException{
        while (true) {
            try {
                System.out.print("연산자를 입력해주세요 (+, -, *, /) , exit 종료 >>> ");
                String oper = br.readLine();

                //exit 검사
                exitCheck(oper);

                //정규식 검사
                // "+", "-", "*", "/" 만 허용
                if (oper.matches("^[+\\-*/]$")) {
                    return oper;
                }
            } catch (IllegalArgumentException iea) {
                System.out.println("(+, -, *, /)중 입력해주세요. , exit 종료 >>> ");
            } catch (Exception e) {
                System.out.println("예상치 못한 오류 발생. 다시 시도해주세요!!");
            }
        }
    }
}




