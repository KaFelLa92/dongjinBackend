package day23; // package name


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Example1 {
    public static void main(String[] args) {

        /*
        인터페이스 : 추상메소드를 가진 타입
        추상메소드 : 선언만 하고 구현부{}를 정의하지 않은 메소드
        구현체 : 추상메소드를 가진 인터페이스를 implements 해서 추상메소드를 구현한 클래스의 객체
        ** 다형성 ** : 다양한 타입을 가지는 성질 , extends / implements 키워드 구조관계
        [ 컬렉션 프레임워크 ]
            - 컬렉션(수집) 프레임(틀) 워크(작업) : 자료 수집(=자료구조) 방법
            - 종류 : List , Set , Map 인터페이스
            - 구현체 :
                1) List : ArrayList , Vector , LinkedList 등
                    .add( 자료 )
                2) Set : HashSet , TreeSet 등
                3) Map : HashMap , TableMap 등
        */
        
        // [1] 인터페이스타입 변수명 = new 클래스명();
        // ArrayList<> 대신 List<> 가능
        ArrayList< String > list1 = new ArrayList<>();    // (1)
        List< String > list2 = new ArrayList<>();       // (2)
        
        // [2] List 인터페이스 주요 메소드
            // 1) .add( 자료 ) : 리스트내 지정한 자료를 마지막 요소 추가
        list2.add("유재석");
        list2.add("강호동");
        list2.add("신동엽");
        list2.add("유재석");             // 중복허용
        list2.add( 2 , "서장훈");        // 리스트내 지정한 인덱스의 자료를 추가
        System.out.println(list2);      // [유재석, 강호동, 서장훈, 신동엽, 유재석]
            // 2) .set( 인덱스 , 자료 ) : 리스트내 지정한 인덱스의 자료를 수정/변경
        list2.set( 0 , "유재석2");
        System.out.println(list2);      // [유재석2, 강호동, 서장훈, 신동엽, 유재석]
            // 3) .get( 인덱스 ) : 리스트내 지정한 인덱스 자료 호출/반환
        String result = list2.get( 2 );
        System.out.println(result);     // 서장훈
            // 4) .size() : 리스트내 전체 요소/자료 개수 반환
        int count = list2.size();
        System.out.println(count);      // 5개의 요소가 있어서 5 나옴
            // 5) .contains( 자료 ) : 리스트내 지정한 자료 존재하면 true, 없으면 false
        boolean bool = list2.contains("서장훈");
        System.out.println(bool);   // 서장훈 있으면 true
            // 6) .indexOf( 자료 ) : 리스트내 지정한 자료의 인덱스 반환, 없으면 -1
        int index = list2.indexOf("서장훈");
        System.out.println(index);  // 서장훈이 세 번째 인덱스에 있으므로 2 반환
            // 7) .remove( 인덱스 ) : 리스트내 지정한 인덱스의 요소/항목/자료 삭제
        list2.remove(2);    // 2번(서장훈) 삭제
        System.out.println(list2);  // [유재석2, 강호동, 신동엽, 유재석]
            // 8) .isEmpty() : 리스트내 요소가 비어있으면 true , 1개이상 존재하면 false
        System.out.println(list2.isEmpty()); // 비어있지 않아서 false
            // 9) .clear() : 리스트내 모든 요소 삭제
//        list2.clear();
//        System.out.println(list2);  // [] 빈 배열 남음
            
            // 10) 리스트/배열와 반복문 활용
                // 리스트( 여러가지 자료(객체)들을 갖는 자료(객체) )
                // 여러가지 자료들을 순서대로 호출/순회/확인 == 반복문 통해 작업
            // (1) 일반 for문
        for( int i = 0; i < list2.size(); i++){
            System.out.println(list2.get(i));
        } // for end
        
            // (2) 향상된 for문
        for (String str : list2){
            System.out.println(str);
        } // for end 인덱스 필요없으면 이거 쓰기

            // (3) forEach문 : 리스트내 첫번째 요소부터 마지막 요소까지 *순서대로* 반복변수에 대입하여 실행처리한다.
            // 리스트/배열명.forEach( )
            // list2.forEach( (반복변수) -> {실행문} );
            // 람다식/화살표 함수 : 복잡한 메소드 선언 방식을 간소화 , ( 매개변수 ) -> { 실행문 }
        list2.forEach(str -> {
            System.out.println( str );
        });
        list2.forEach((str) -> {
            System.out.println(list1);  // list2의 배열 숫자인 4번만큼 list1의 []빈배열 출력
        });

        // ------------------------------------------------------------------------ //
        // List : 순서대로 요소 저장하는 자료구조
        // ArrayList : 배열 구조로 사용되는 List 구현체 + 메소드 비동기화( 단일 스레드 플랫폼 )
        ArrayList< Integer > arrayList = new ArrayList<>();
        // Vector : 배열 구조로 사용되는 List 구현체 + 메소드가 동기화 처리됨 ( 멀티 스레드 플랫폼 )
        Vector< Integer > vector = new Vector<>();
        // LinkedList : 링크(체인/꼬리연결) 구조로 사용되는 List 구현체 + 중간 삽입/삭제 효율성 극대화
            // 배열구조 : [ 5 ] [ 4 ] [ 7 ] [ 10 ]
                //         0     1     2     3
                // 만약 1번 인덱스가 삭제되면 2, 3번 인덱스는 한칸씩 앞으로 이동
                // 즉] 중간에 변화가 있으면 뒤의 요소들의 위치변화가 일어남. (10만개면 99998개 데이터가 움직여야함)
            // 링크구조 : [ 5 ] -> [ 4 ] -> [ 7 ] -> [ 10 ]
                //       5/4주소값 -> 4/7주소값 -> 7/10주소값 -> 10/주소값없다
                // 만약 1번 인덱스가 삭제되면 0번 인덱스 꼬리(4주소값을 -> 7주소값)변경
                // 즉] 중간에 변화가 있으면 변화된 요소와 앞 요소의 연결(꼬리) 주소값만 변경하면 됨.
        LinkedList< Integer > linkedList = new LinkedList<>();

        // 다형성에 따라, List는 ArrayList, Vector, LinkedList와 부모-자식 관계로 접근 가능
        List< Integer > integerList;
        integerList = arrayList;
        integerList = vector;
        integerList = linkedList;
        // vector = arrayList; 자식 대 자식은 안 됨


    } // main end
} // class end
