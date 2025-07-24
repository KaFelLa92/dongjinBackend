
# BoardController 오류 분석 매뉴얼

`BoardController.java` 파일의 `boardWrite` 및 `boardPrint` 메소드에서 발생하는 오류는 근본적으로 잘못된 클래스를 `import`하여 발생합니다.

## 1. 오류의 핵심 원인: 잘못된 `import`

오류의 직접적인 원인은 `BoardController.java` 파일 상단에 있는 `import` 구문입니다.

**BoardController.java:**
```java
package Practice.Example9.controller;

import Practice.Example9.model.dao.BoardDao;
import 종합.예제9.model.dto.BoardDto; // <--- 문제의 원인

import java.util.ArrayList;

// ... 이하 코드 생략
```

현재 프로젝트의 패키지 구조는 `Practice.Example9`인데, `BoardDto` 클래스를 `종합.예제9`라는 다른 패키지에서 가져오고 있습니다. 이로 인해 `BoardController`가 사용하는 `BoardDto`와 `BoardDao` 및 다른 클래스들이 사용하는 `BoardDto`가 서로 다른 클래스로 인식되어 오류가 발생합니다.

올바른 `BoardDto` 클래스의 위치는 `Practice.Example9.model.dto`입니다.

**BoardDto.java:**
```java
package Practice.Example9.model.dto; // <--- 올바른 패키지 경로

public class BoardDto {
    // ...
}
```

## 2. 오류 발생 지점 분석

### A. `boardWrite` 메소드

```java
// (1) 등록
public boolean boardWrite( String content , String writer ){
    BoardDto boardDto = new BoardDto( content , writer); // 오류 발생
    boolean result = boardDao.boardWrite(boardDto);
    return result;
}
```

- **분석**: `new BoardDto(...)`를 통해 객체를 생성할 때, `import` 구문에 따라 `종합.예제9.model.dto.BoardDto` 타입의 객체가 생성됩니다. 하지만 `boardDao.boardWrite()` 메소드는 `Practice.Example9.model.dto.BoardDto` 타입의 객체를 매개변수로 기대하고 있습니다. 두 타입이 일치하지 않아 컴파일 오류가 발생합니다.

### B. `boardPrint` 메소드

```java
// (2) 전체조회
public ArrayList<BoardDto> boardPrint(){ // 오류 발생
    ArrayList<BoardDto> result = boardDao.boardPrint();
    return result;
}
```

- **분석**: `boardDao.boardPrint()` 메소드는 `ArrayList<Practice.Example9.model.dto.BoardDto>`를 반환합니다. 하지만 `boardPrint` 메소드의 반환 타입은 `ArrayList<종합.예제9.model.dto.BoardDto>`로 선언되어 있습니다. 반환되는 데이터의 타입과 메소드에 선언된 타입이 일치하지 않아 컴파일 오류가 발생합니다.

## 3. 해결 방안

`BoardController.java`의 잘못된 `import` 구문을 올바르게 수정하면 모든 문제가 해결됩니다.

**수정 전 (AS-IS):**
```java
import 종합.예제9.model.dto.BoardDto;
```

**수정 후 (TO-BE):**
```java
import Practice.Example9.model.dto.BoardDto;
```

### 최종 수정 코드

**BoardController.java:**
```java
package Practice.Example9.controller;

import Practice.Example9.model.dao.BoardDao;
import Practice.Example9.model.dto.BoardDto; // <--- 수정된 부분

import java.util.ArrayList;

public class BoardController {
    // (*) 싱글톤 생성
    private BoardController (){}
    public static final BoardController instance = new BoardController();
    public static BoardController getInstance(){
        return instance;
    }
    
    // (*) Dao 싱글톤 호출
    private BoardDao boardDao = BoardDao.getInstance();
    
    // (1) 등록
    public boolean boardWrite( String content , String writer ){
        BoardDto boardDto = new BoardDto( content , writer);
        boolean result = boardDao.boardWrite(boardDto);
        return result;
    } // func end
    
    // (2) 전체조회
    public ArrayList<BoardDto> boardPrint(){
        ArrayList<BoardDto> result = boardDao.boardPrint();
        return result;
    }
}
```

위와 같이 `import` 경로를 수정하면 `BoardController`가 프로젝트 내의 올바른 `BoardDto` 클래스를 사용하게 되어 모든 타입 불일치 오류가 해결됩니다.
