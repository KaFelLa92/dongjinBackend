
# Java 컬렉션 프레임워크(Collection Framework) 복습

이 문서는 Java의 컬렉션 프레임워크의 핵심 인터페이스인 `List`, `Set`, `Map`에 대한 개념을 정리하고, 간단한 예제를 통해 사용법을 복습하는 것을 목표로 합니다.

---

## 1. 컬렉션 프레임워크란?

- **컬렉션(Collection)**: 데이터의 집합 또는 그룹
- **프레임워크(Framework)**: 작업을 위한 표준화된 틀
- 즉, **데이터 그룹을 저장하고 관리하기 위한 표준화된 클래스들의 집합**입니다. 자료구조 및 알고리즘을 구현해 놓은 라이브러리로, 개발자가 더 쉽게 데이터를 처리할 수 있도록 돕습니다.

### 주요 인터페이스

- **`List`**: 순서가 있는 데이터의 집합. 데이터 중복을 허용합니다.
- **`Set`**: 순서가 없는 데이터의 집합. 데이터 중복을 허용하지 않습니다.
- **`Map`**: 키(Key)와 값(Value)의 쌍으로 이루어진 데이터의 집합. 키는 중복될 수 없지만, 값은 중복될 수 있습니다.

---

## 2. `List` 인터페이스

`List`는 순서가 있는 데이터 컬렉션으로, 인덱스를 통해 데이터에 접근할 수 있습니다. 데이터의 중복 저장을 허용합니다.

### 주요 구현 클래스

- **`ArrayList`**: 배열 기반의 리스트. 데이터 조회(get)가 빠르지만, 데이터 추가/삭제 시 성능 저하가 발생할 수 있습니다. (비동기)
- **`LinkedList`**: 연결(link) 기반의 리스트. 데이터 추가/삭제가 빠르지만, 데이터 조회 시 성능이 `ArrayList`보다 느릴 수 있습니다.
- **`Vector`**: `ArrayList`와 유사하지만, 동기화(synchronization)를 지원하여 멀티스레드 환경에서 안전하게 사용할 수 있습니다.

### 주요 메소드

- `add(E element)`: 리스트의 끝에 요소를 추가합니다.
- `add(int index, E element)`: 지정된 인덱스에 요소를 추가합니다.
- `get(int index)`: 지정된 인덱스의 요소를 반환합니다.
- `set(int index, E element)`: 지정된 인덱스의 요소를 새로운 요소로 변경합니다.
- `remove(int index)`: 지정된 인덱스의 요소를 삭제합니다.
- `size()`: 리스트의 크기(요소의 개수)를 반환합니다.
- `contains(Object o)`: 리스트에 특정 요소가 포함되어 있는지 확인합니다.
- `clear()`: 리스트의 모든 요소를 삭제합니다.
- `isEmpty()`: 리스트가 비어있는지 확인합니다.

### 예제 코드

```java
import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        // ArrayList 생성 (다형성)
        List<String> names = new ArrayList<>();

        // 1. 데이터 추가 (add)
        names.add("유재석");
        names.add("강호동");
        names.add("신동엽");
        names.add(1, "서장훈"); // 1번 인덱스에 "서장훈" 추가

        System.out.println("전체 리스트: " + names); // [유재석, 서장훈, 강호동, 신동엽]

        // 2. 데이터 조회 (get)
        String name = names.get(2);
        System.out.println("2번 인덱스: " + name); // 강호동

        // 3. 데이터 개수 (size)
        System.out.println("리스트 크기: " + names.size()); // 4

        // 4. 데이터 수정 (set)
        names.set(0, "유느님");
        System.out.println("수정 후 리스트: " + names); // [유느님, 서장훈, 강호동, 신동엽]

        // 5. 데이터 삭제 (remove)
        names.remove(1); // 1번 인덱스 "서장훈" 삭제
        System.out.println("삭제 후 리스트: " + names); // [유느님, 강호동, 신동엽]

        // 6. 반복문으로 전체 요소 출력
        System.out.println("--- 전체 요소 출력 ---");
        for (String s : names) {
            System.out.println(s);
        }
    }
}
```

---

## 3. `Set` 인터페이스

`Set`은 순서가 보장되지 않는 데이터의 집합이며, 가장 큰 특징은 **데이터 중복을 허용하지 않는다**는 것입니다.

### 주요 구현 클래스

- **`HashSet`**: 가장 일반적인 `Set` 구현체. 순서를 보장하지 않으며, 해시(hash)를 사용하여 데이터를 저장하므로 검색 속도가 빠릅니다.
- **`TreeSet`**: 정렬된 순서대로 데이터를 저장하는 `Set` 구현체. 데이터를 추가할 때 자동으로 오름차순 정렬됩니다.
- **`LinkedHashSet`**: 추가된 순서대로 데이터를 저장하는 `Set` 구현체입니다.

### 주요 메소드

`Set`은 인덱스가 없으므로 `get()`, `set()` 메소드가 없습니다.
- `add(E element)`: 집합에 요소를 추가합니다. (중복 시 추가되지 않음)
- `remove(Object o)`: 집합에서 특정 요소를 삭제합니다.
- `size()`: 집합의 크기를 반환합니다.
- `contains(Object o)`: 집합에 특정 요소가 포함되어 있는지 확인합니다.
- `clear()`: 집합의 모든 요소를 삭제합니다.
- `isEmpty()`: 집합이 비어있는지 확인합니다.

### 예제 코드

```java
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        // HashSet 생성
        Set<String> languages = new HashSet<>();

        // 1. 데이터 추가 (add)
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        boolean isAdded = languages.add("Java"); // 중복된 데이터 추가 시도

        System.out.println("전체 집합: " + languages); // [Java, Python, C++] (순서 보장 안됨)
        System.out.println("중복 데이터 추가 성공 여부: " + isAdded); // false

        // 2. 데이터 포함 여부 (contains)
        System.out.println("Python 포함 여부: " + languages.contains("Python")); // true

        // 3. 데이터 삭제 (remove)
        languages.remove("C++");
        System.out.println("삭제 후 집합: " + languages); // [Java, Python]

        // 4. 반복문으로 전체 요소 출력
        System.out.println("--- 전체 요소 출력 ---");
        for (String lang : languages) {
            System.out.println(lang);
        }

        // TreeSet 예제 (자동 정렬)
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(30);
        numbers.add(10);
        numbers.add(20);
        System.out.println("TreeSet (자동 정렬): " + numbers); // [10, 20, 30]
    }
}
```

---

## 4. `Map` 인터페이스

`Map`은 키(Key)와 값(Value)을 하나의 쌍(Entry)으로 묶어서 관리하는 데이터 구조입니다. 키는 고유해야 하며(중복 불가), 값은 중복될 수 있습니다.

### 주요 구현 클래스

- **`HashMap`**: 가장 일반적인 `Map` 구현체. 순서를 보장하지 않으며, `key`에 `null`을 허용합니다. (비동기)
- **`Hashtable`**: `HashMap`과 유사하지만, 동기화를 지원하여 멀티스레드 환경에서 안전합니다. `key`에 `null`을 허용하지 않습니다.
- **`TreeMap`**: 키(key)를 기준으로 자동 정렬(오름차순)되는 `Map` 구현체입니다.
- **`Properties`**: `<String, String>` 형태를 가지는 `Map`. 주로 설정 파일의 내용을 읽고 쓰는 데 사용됩니다.

### 주요 메소드

- `put(K key, V value)`: 맵에 키와 값의 쌍(Entry)을 추가합니다. 동일한 키가 존재하면 값을 덮어씁니다.
- `get(Object key)`: 주어진 키에 해당하는 값을 반환합니다.
- `remove(Object key)`: 주어진 키에 해당하는 엔트리를 삭제합니다.
- `size()`: 맵의 엔트리 개수를 반환합니다.
- `containsKey(Object key)`: 맵에 특정 키가 포함되어 있는지 확인합니다.
- `containsValue(Object value)`: 맵에 특정 값이 포함되어 있는지 확인합니다.
- `keySet()`: 맵의 모든 키를 `Set` 형태로 반환합니다.
- `values()`: 맵의 모든 값을 `Collection` 형태로 반환합니다.
- `entrySet()`: 맵의 모든 엔트리(`Map.Entry`)를 `Set` 형태로 반환합니다.

### 예제 코드

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args) {
        // HashMap 생성
        Map<String, Integer> scores = new HashMap<>();

        // 1. 데이터 추가 (put)
        scores.put("유재석", 95);
        scores.put("강호동", 100);
        scores.put("신동엽", 88);
        scores.put("유재석", 92); // 동일한 키에 값을 넣으면 덮어쓴다.

        System.out.println("전체 맵: " + scores); // {강호동=100, 신동엽=88, 유재석=92}

        // 2. 데이터 조회 (get)
        int score = scores.get("강호동");
        System.out.println("강호동의 점수: " + score); // 100

        // 3. 데이터 삭제 (remove)
        scores.remove("신동엽");
        System.out.println("삭제 후 맵: " + scores); // {강호동=100, 유재석=92}

        // 4. 반복문으로 전체 요소 출력 (keySet 사용)
        System.out.println("--- 전체 요소 출력 ---");
        Set<String> keys = scores.keySet(); // 모든 키를 Set으로 가져온다.
        for (String key : keys) {
            System.out.println("이름: " + key + ", 점수: " + scores.get(key));
        }
    }
}
```
