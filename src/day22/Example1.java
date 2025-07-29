package day22; // package name

import java.util.Arrays;

public class Example1 {
    public static void main(String[] args) {
        /*
        [ String 클래스 ] : 자바에서 문자열 표현하는 방법
            - 컴퓨터는 문자를 알아도 문자열은 모른다.
            - 문자 번역 : 바이트 <--번역방법--> 문자
                1. 아스키코드    : (영문/숫자/특수문자) 128문자 표현하는 규칙 , 7비트(요즘은 8비트)
                2. 유니코드      : 전세계 공용어(한글포함) , 자바가 사용하는 코드
            - 65 <--> 'A' , { 74 , 65 , 86, 65 } <--> 'JAVA' , 44608 <--> '김'
            
            1. 문자열 사용하는 방법
                1) "문자열"                              : "큰따옴표 안에 문자열 표현"
                2) new String("문자열")                  : new String() 생성자 이용한 문자열 표현
            2. 문자열 비교하는 방법
                1) 문자열A == 문자열B                     : "리터럴" 문자만 비교 가능하다.
                2) 문자열A.equals(문자열B)                : "리터럴"과 객체문자열을 비교 가능하다.
            3. 주요 메소드
                1) 문자열A.concat(문자열B)                : 연결메소드
                2) String.format("형식문자" , 문자열A)     : 지정한 형식으로 문자열 반환 메소드
                3) StringBuilder builder = new StringBuilder()
                    builder.append(문자열A);
                    builder.append(문자열B);             : 문자열 연결 클래스
                4) 문자열A.charAt( 인덱스 )               : 지정한 인덱스의 문자 1개 반환 메소드
                5) 문자열A.length()                      : 지정한 문자열의 문자개수 반환 메소드
                6) 문자열A.replace( 기존문자열 , 새로운문자열 )     : 지정한 문자열내 (하나)기존문자열이 존재하면 새로운문자열로 변경후 반환
                   문자열A.replaceAll( 기존문자열 , 새로운문자열 )  : 지정한 문자열내 (모든)기존문자열이 존재하면 새로운문자열로 변경후 반환
                7) 문자열A.subString( 시작인덱스 , [끝인덱스] )    : 지정한 문자열내 시작인덱스 부터 끝인덱스 전까지 문자열 반환 메소드
                8) 문자열A.split( "구분문자" )                     : 지정한 문자열내 구분문자 기준으로 쪼개서 String[] 타입으로 반환 메소드
                9) 문자열A.indexOf( "찾을문자열" )                  : 지정한 문자열내 찾을문자열이 존재하면 찾을문자열 인덱스 반환, 없으면 -1 반환
                10) 문자열A.contains( "찾을문자열" )                : 지정한 문자열내 찾을문자열이 존재하면 true 없으면 false 반환
                11) 문자열A.getBytes()                   : 지정한 문자열을 byte[] 타입으로 반환 메소드
                    <--> new String ( byte[]변수 ) ;     : 지정한 byte[] 타입을 String 타입 변환


         */

        // [1] 배열을 이용한 문자열 표현
        char c1 = 'a';
        char c2 = '유';  // ' ' 작은 따옴표로 감싼 문자 1개 char 타입
        char[] c3 = {'유' , '재' , '석'}; // 작은 따옴표 3개를 char 배열 타입에 넣기
        System.out.println(c3);

        // [2] char 타입에 아스키코드 10진수
        char str1 = 65;
        System.out.println(str1);                   // A가 나옴. char는 정수를 입력해도 문자가 나옴
        char[] str2 = {74 , 65 , 86 , 65};
        System.out.println(str2);                   // JAVA
        System.out.println(Arrays.toString(str2));  // [J, A, V, A]
        char str3 = '김';
        System.out.println((int)str3);              // 인트로 타입 변환하면 44608 나옴

        // [3] 문자열 리터럴 : " " 큰따옴표 , String 클래스
        String str4 = "유재석";             // 101호
        String str5 = "유재석";             // 101호           // 문자열 동일하면 동일한 객체 취급
        String str6 = new String("유재석"); // 102호           // new String 사용시 문자열 동일해도 다른 객체 취급
        System.out.println(str4 + str5 + str6);

        // [4] == vs .equals()
        // 1. == 주소값(객체저장위치) 비교
        // 2. .equals() : 문자열 비교 메소드(객체내값비교)
        System.out.println(str4 == str5);           // true
        System.out.println(str4 == str6);           // false    , 주소값이 달라서 같지 않다.
        System.out.println(str4.equals(str5));      // true
        System.out.println(str4.equals(str6));      // true     , 문자열이 같아서 같다.
        // * 문자는 불변( 변하지 않는다/수정이 없다 )

        // [5] 주요 메소드
        // 1. 문자열A.concat( 문자열B ) : 문자열 연결 메소드 vs 문자열A+문자열B
        String str9 = "자바".concat("프로그래밍1"); // 자바프로그래밍1
        System.out.println(str9);
        System.out.println("자바" + "프로그래밍2"); // 자바프로그래밍2

        // 2. StringBuilder 클래스 : 문자열을 단게적으로 연결하는 메소드 제공하는 클래스
        StringBuilder builder = new StringBuilder();
        builder.append("자바");
        builder.append("프로그래밍3");
        System.out.println(builder);            // 자바프로그래밍3 // 메모리 효율성이 높다. 객체를 하나만 씀

        // 3. String.format("형식문자" , "문자열A");
        String str10 = String.format("%s%s" , "자바" , "프로그래밍4");
        System.out.println(str10);

        // 4. +연결연산자
        String str11 = "";
        str11 += "자바";
        str11 += "프로그래밍5";
        System.out.println(str11);  // 문자열 연결연산하기
        // 활용] JDBC SQL의 매개변수 연결
        String name = "유재석";
        String sql1 = "insert into table(name) values("+name+" )"; // 비권장
        String sql2 = String.format("insert into table(name) values(%s);" , name);
        String sql3 = "";
        sql3 += "insert into ";
        sql3 += "table(name) ";     // 띄어쓰기 주의
        sql3 += "values("+name+") "; // 비권장 : 주의할점은 띄어쓰기
        System.out.println(sql3);
        String name2 = "강호동";
        StringBuilder builder2 = new StringBuilder();
        builder2.append("insert into table(name) ");
        builder2.append("values("+name2+") ");
        System.out.println(builder2);
        // DB 연동은 ? 넣은 예제 방식을 권장

        // 5. .charAt(인덱스) : 지정한 인덱스 번호의 문자 1개 반환 메소드
        char gender = "012345-1230123".charAt(7);
        System.out.println(gender); // 1
        // 활용] nextChar()[x] --> 문자1개입력 : scan.next().charAt(0)

        // 6. .length() : 문자열내 문자수 반환 메소드
        System.out.println("012345-1230123".length()); // 인덱스 : 0~13 , 길이 : 14
        // 활용] for( int index = 0; index < 문자열.length(); index++) { }

        // 7. .replace( 기존문자열 , 새로운 문자열 ) , replaceAll( 기존문자열 , 새로운문자열 )
        // : 지정한 문자열내 기존문자열을 새로운문자열 생성후 반환 메소드
        String str12 = "자바프로그래밍".replace("자바" , "JAVA"); // .replace는 주소값이 바뀐다
        System.out.println(str12); // JAVA프로그래밍
        // 활용] HTML 줄바꿈 <br/> -----> JAVA 줄바꿈 \n
        String htmlData = "<div>유재석<br/>안녕하세요</div>";
        String newData = htmlData.replaceAll("<br/>" , "\n");
        System.out.println(newData);    // <br/>이 \n으로 변경됨

        // 8. .subString( 시작인덱스 , 끝인덱스 ); : 시작인덱스부터 끝인덱스 전까지 문자열 추출
        String str13 = "012345-1230123".substring(0 , 6);
        System.out.println(str13);  // 0번 인덱스부터 6번 인덱스까지 012345
        String str14 = "012345-1230123".substring(7); 
        System.out.println(str14); // 7번 인덱스부터 (마지막 인덱스)까지 추출 1230123
        // 활용] 차량번호 조회 : 214가7531 , 차량번호 뒷자리 : 차량번호.subString( 차량번호.length()-4 );

        // 9. .split( "구분문자" ); : 지정한 문자열내 구분문자 기준으로 잘라서 배열로 반환 메소드
        String[] str15 = "012345-1230123".split("-"); // "-" 기준으로 문자열 쪼개기
        System.out.println(str15[0]);   // 012345
        System.out.println(str15[1]);   // 1230123
        // 활용1] CSV형식 다루기 , CSV란 ,(쉼표)로 속성을 구분하고 \n 줄바꿈 구분한다.
        // 활용2] 날짜( 연-월-일 )
        // 활용3] 주소( 시 군 구 동 )

        // 10. .indexOf( "찾을문자열" ); : 지정한 문자열내 찾을문자열이 존재하면 찾은 인덱스 반환 , 없으면 -1 반환
        int findIndex = "자바 프로그래밍 언어".indexOf("프로");
        System.out.println(findIndex);  // 3, 띄어쓰기도 인덱스에 포함됨
        // 활용] 도서찾기 , 검색기능 구현

        // 11. .contains( "찾을문자열" ); : 지정한 문자열내 찾을문자열이 존재하면 true 없으면 false 반환 메소드
        boolean findBool = "자바 프로그래밍 언어".contains("프로");
        System.out.println(findBool);   // true
        // 활용] 도서찾기 , 검색기능 구현

        // 12. .getBytes() : 지정한 문자열을 byte[] 타입으로 반환 메소드
        byte[] str16 = "자바 프로그래밍 언어".getBytes();
        System.out.println(Arrays.toString(str16));
        byte[] str17 = "JAVA Program".getBytes();
        System.out.println(Arrays.toString(str17)); // 아스키코드 표로 해석 가능
        // [74, 65, 86, 65, 32, 80, 114, 111, 103, 114, 97, 109]
        String str18 = new String (str17);
        System.out.println(str18);  // 바이트 처리해서 아스키코드로 바뀐 문자열을 다시 스트링 타입으로 반환 JAVA Program
        // 활용] 문자열을 바이트로 변환 , 파일처리 , 네트워크 , 업로드/다운로드 등등


    } // main end
} // class end
