package day22; // package name

import java.util.ArrayList;
import java.util.Random;

public class Example2 {
    public static void main(String[] args) {

        /*
            [ Random ] 난수 클래스
                1. 사용법
                    1) 랜덤 객체 생성
                        Random random = new Random();
                    2) 주요 메소드
                        .nextInt()               : int타입의 허용범위내 난수 생성
                        .nextInt(값);            : 0부터 n-1 사이의 난수 생성
                        .nextInt(끝값) + 시작값    : 시작값부터 끝값 사이의 난수 생성


        */

        // [1] Random 객체 생성
        Random random = new Random();
        System.out.println(random);
        // [2] 1~10 사이의 난수 생성 ( int 타입 )
        int value1 = random.nextInt();
        System.out.println( value1 ); // -21억 ~ +21억 사이의 난수
        int value2 = random.nextInt( 10 ) + 1;
        System.out.println( value2 );
        // [3] 0~(n-1)까지 난수 생성
        int value3 = random.nextInt( 100 );
        System.out.println( value3 ); // 0~99 사이의 정수 난수
        // [4] 0과 1 사이의 실수 생성
        double value4 = random.nextDouble();
        System.out.println(value4);
        // [5] true와 false 생성
        boolean value5 = random.nextBoolean();
        System.out.println(value5);

        // 활용1] 임의 여러개 데이터중 하나 선택하기
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("유재석"); nameList.add("강호동"); nameList.add("신동엽");
        int randomIndex = random.nextInt( nameList.size() ); // .size() : arrayList 길이 반환 메소드
        System.out.println("추첨된 이름 : " + nameList.get(randomIndex));

        // 활용2] 새로운 비밀번호 , 인증코드 문자 난수 표현
        String code = ""; // 빈 문자열
        for ( int i = 1; i <= 6; i++){  // 6자리 만들기 위한 6회전 반복문
            // 아스키코드 a : 97 ~ z : 122
            Random ran = new Random();
            int val = ran.nextInt( 26 ) + 97;
            char str = (char)val;
            System.out.print(str);  // a부터 z까지의 인증문자가 난수로 생성됨
            code += str;
        }
        System.out.println("생성된 코드 : " + code);

        // 활용3] 아스키코드 패턴으로 난수 계산식 못 만들 경우 직접 난수에 넣을 데이터를 배열로 선언
        char[] ranStr = { '1' , '2' , '3' , 'A' , 'B' , '%' , '!' , '0' , '김' }; // 난수로 표현하고싶은 배열을 미리 만들고 하는 경우가 다수
        String newPwd = "";
        for (int i = 1; i <= 8; i++){
            Random ran = new Random();
            int index = ran.nextInt( ranStr.length );
            newPwd += ranStr[index];
        }
        System.out.println("생성된 패스워드 : " + newPwd);

        // 활용4] 주사위 : 1~6 사이
        int diceRoll = random.nextInt( 6 ) + 1;    // 1~6
        System.out.println(diceRoll);

        // 활용5] 로또 번호 생성 : 1~45사이의 중복 없이
        ArrayList< Integer > lottoList = new ArrayList<>();
        for (int i = 1; i <= 6; i++){
            int lotto = random.nextInt(45) + 1; // 생성된 로또 번호
            if (lottoList.contains(lotto)){ // 리스트에 생성된 로또 번호 존재하면
                i--;
                continue;                   // 이번 반복문 무효 처리
            }
            lottoList.add(lotto);   // 생성된 로또 번호 리스트에 담기
        } // for end
        System.out.println(lottoList); // 중복 없는 로또 번호

        ArrayList< Integer > lottoList2 = new ArrayList<>();
        for(;;){
            int lotto = random.nextInt(45) + 1; // 생성된 로또 번호
            if (lottoList2.contains(lotto)){ // 리스트에 생성된 로또 번호 존재하면
                continue;                   // 이번 반복문 무효 처리
            }
            lottoList2.add(lotto);   // 생성된 로또 번호 리스트에 담기
            if(lottoList2.size() == 6 ) break; // 6개 담았으면 무한반복 종료
        }
        System.out.println(lottoList2); // 무한반복으로 만든 6개 로또 번호

        // 활용6] 하나의 문자열에서 추출한 문자로 문자열 난수 생성
        String ranStr2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        // (1) 문자열 길이 구하기
        int strlen = ranStr2.length();
        // (2) 문자열 길이내 난수 생성
        int ranIndex = random.nextInt(strlen);
        // (3) 문자열내 인덱스 위치한 문자 1개 추출
        char str = ranStr2.charAt( ranIndex );
        System.out.print(str);

    } // main end
} // class end
