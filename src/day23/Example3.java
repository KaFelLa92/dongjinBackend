package day23; // package name

import java.util.*;

public class Example3 {
    public static void main(String[] args) {

        /*
            [ 컬렉션 프레임워크3 ]
            List 인터페이스 : 순서(인덱스)대로 저장하는 구조
            Set 인터페이스 : 순서(인덱스)없이 저장하는 구조
            Map 인터페이스 : keyt와 value를 한 쌍(entry)으로 여러 쌍을 저장하는 구조
                -> HTML/CSS/JS <-> JAVA <-> DB
                -> JSON : 자바스크립트에서 사용하는 객체 형식
                -> JAVA에는 JSON이 없음. 비슷한 형식이 map

        */

        // [1] HashMap 객체 생성 < key타입 , value타입 >
        Map< String , Integer > map = new HashMap<>();
        // [2] 주요 메소드
            // 1) .put( key자료1 , value자료2 ) : Map 객체내 key와 value 자료를 한 쌍(entry)으로 저장한다.
        map.put( "유재석" , 95 );      // "유재석" 자료는 key , 95 자료는 value
        map.put( "강호동" , 100 );     // "강호동" 속성(key)명에 100 대입/저장한다.
        map.put( "신동엽" , 78 );
        map.put( "유재석" , 67 );      // key(속성명) 중복이 불가능하다. ( *식별자* )
        map.put( "서장훈" , 100 );     // value(속성값) 중복이 가능하다.
        System.out.println(map);      // {서장훈=100, 유재석=67, 강호동=100, 신동엽=78}
            // 2) .get( key ) : Map 객체내 지정한 key의 value 반환
        System.out.println( map.get("유재석"));    // 67
            // 3) .size( ) : Map 객체내 entry(쌍) 개수 반환
        System.out.println( map.size() );       // 엔트리 : 4 , key : 4 , value : 4 (자료 8개)
            // 4) .remove( key ) : Map 객체내 지정한 key의 entry(쌍) 삭제한다.
        map.remove("유재석");
        System.out.println(map);                // {서장훈=100, 강호동=100, 신동엽=78}, key를 삭제하면 value도 같이 삭제
            // 5) .containsKey( key ) , .containsValue( value )
        System.out.println(map.containsKey("강호동"));     // "강호동" key가 있으므로 true
        System.out.println(map.containsValue(65));        // 65 value가 없으므로 false
            // 6) .clear( ) : Map 객체내 모든 entry 삭제한다.
//        map.clear();
//        System.out.println(map); // {}
            // 7) .isEmpty( ) : Map 객체내 entry 하나도 없으면 true , 있으면 false
        System.out.println(map.isEmpty());  // entry가 있으므로 false
            // + .entrySet( ) : Map 객체내 모든 entry를 set 인터페이스 반환
        System.out.println(map.entrySet()); // [서장훈=100, 강호동=100, 신동엽=78] 중괄호에서 대괄호로 반환
            // + .keySet( ) : Map 객체내 모든 key를 set 인터페이스 반환
        System.out.println(map.keySet());   // [서장훈, 강호동, 신동엽]
            // + .values( ) : Map 객체내 모든 value를 List 인터페이스 반환
        System.out.println(map.values());   // [100, 100, 78]
        // 비정형화 vs 정형화(DB)

        // [3] Map과 반복문 관계
            // 1) 일반 for문 표현 못함 (인덱스 없음)

            // 2) 향상된 for문 :
        for( String key : map.keySet() ){   // map 객체내 모든 키를 반복한다.
            System.out.println(key);            // key      * value 활용하여 key 호출한다 [x]
            System.out.println(map.get(key));   // value    * key 활용하여 value 호출한다 [o]
        }

            // 3) forEach문
        map.keySet().forEach( (key) -> {
            System.out.println(key);
            System.out.println(map.get(key));
        });

        // 활용] JSON( JavaScript 객체 ) <---> MAP/DTO ( JAVA 객체 )
        // DTO는 다회성 객체 , MAP은 일회성 객체

        // [4] 구현체
        // Map 인터페이스 : key와 value를 (자료 2개) 한 쌍(entry 자료 1개)으로 여러 쌍을 저장한다.
        // 1) HashMap       : key와 value로 구성된 entry 객체를 저장하는 구조
        HashMap< Integer , Object > hashMap = new HashMap<>();
        // 2) HashTable     : + 동기화 메소드 제공 ( 멀티 스레드 플랫폼 )
        Hashtable< Integer , Object > hashtable = new Hashtable<>();
        // 3) TreeMap       : + key값 기준으로 자동 정렬(오름차순)
        TreeMap< Integer, Object > treeMap = new TreeMap<>();
        // 4) Properties    : + 제네릭이 없다. + 주로 세팅/설정 파일 사용된다. Spring 환경
        Properties properties = new Properties();
        
        Map< Integer , Object > map2;
        map2 = hashMap;
        map2 = hashtable;
        map2 = treeMap;




    } // main method end
} // class end
