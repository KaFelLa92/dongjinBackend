### **Java-MySQL DB 연동 문제 해결 매뉴얼**

현재 `WaitingDao` 클래스의 DB 연동 코드에는 몇 가지 핵심적인 문제들이 있습니다. 이 매뉴얼을 통해 각 문제를 이해하고 단계별로 해결해 보겠습니다.

---

#### **1단계: 문제의 핵심 원인 파악하기**

현재 `connectDB()` 메소드가 작동하지 않는 근본적인 이유는 다음과 같습니다.

1.  **호출되지 않는 메소드**: `connectDB()` 메소드를 정의했지만, `waitingAdd()` 나 다른 어떤 곳에서도 이 메소드를 **호출(실행)**하지 않았습니다. 코드는 작성되어 있지만 실행되지 않으니 아무 일도 일어나지 않습니다.
2.  **잘못된 SQL 문법**: 데이터를 삽입할 때, 전화번호와 인원수를 두 개의 다른 `INSERT` 문으로 실행하고 있습니다.
    ```java
    String number = "insert into list(number) values('010-1234-5678')";
    String count = "insert into list(count) values(3)";
    ```
    이렇게 하면 DB에는 두 개의 **별도 행**이 생깁니다. 하나는 전화번호만 있고, 다른 하나는 인원수만 있는 반쪽짜리 데이터가 두 개 생기는 셈입니다. 올바른 방법은 **하나의 `INSERT` 문**으로 관련 데이터를 함께 넣는 것입니다.
3.  **고정된(하드코딩된) 데이터**: 현재 코드는 `'010-1234-5678'` 와 `3` 이라는 정해진 값만 DB에 넣게 되어 있습니다. 사용자가 `WaitingView`에서 입력한 동적인 값을 받아와서 처리해야 합니다.
4.  **`PreparedStatement`의 잘못된 사용**: `PreparedStatement`는 SQL 문에 `?` (물음표)를 사용하여 값을 나중에 채워 넣는 방식으로, **SQL 인젝션이라는 해킹 공격을 방어**하는 매우 중요한 기능입니다. 현재 코드처럼 SQL문에 직접 값을 합치면 이 장점을 전혀 활용하지 못합니다.

---

#### **2단계: `WaitingDao` 클래스 구조 변경하기**

문제를 해결하기 위해, DAO가 생성될 때 DB와 연결하고, 각 메소드가 필요할 때마다 SQL을 실행하도록 구조를 변경해야 합니다.

**수정 목표:**

*   **생성자 (`WaitingDao()`)**: 클래스가 처음 만들어질 때 **DB 연결을 한 번만** 수행합니다.
*   **`waitingAdd()`**: `INSERT` SQL문을 실행하여 **데이터를 저장**하는 역할만 합니다.
*   **`waitingListPrint()`**: `SELECT` SQL문을 실행하여 **데이터를 조회**하는 역할만 합니다.

---

#### **3단계: 코드 직접 수정하기**

이제 `Waiting-Dao.java` 파일을 열고 아래 설명에 따라 직접 코드를 수정해 보세요.

**1. DB 연결 코드(Connection)를 생성자로 옮기기**

*   `Connection`, `PreparedStatement`, `ResultSet` 객체를 클래스의 멤버 변수로 선언합니다.
*   기존 `connectDB()` 메소드의 내용을 `WaitingDao` 생성자 안으로 옮겨서, `WaitingDao` 객체가 생성될 때 DB 연결이 이루어지게 합니다.

**수정 전:**
```java
public class WaitingDao {
    private WaitingDao() {
        openCSV(); // CSV 관련 코드는 이제 사용하지 않으므로 삭제하거나 주석처리 합니다.
    }
    // ...
    public void connectDB() {
        // ... DB 연결 로직 ...
    }
}
```

**수정 후:**
```java
public class WaitingDao {
    // DB 연동에 사용할 인터페이스 선언
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    private WaitingDao() {
        try {
            // 1. MYSQL JDBC 드라이버 라이브러리 호출
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. DB서버와 연동 후 결과는 conn 인터페이스에 대입
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/waitingList", "root", "1234");
            System.out.println("DB 연동 성공");
        } catch (Exception e) {
            System.out.println("DB 연동 실패 : " + e);
        }
    }
    // ... (싱글톤 코드는 그대로 둡니다)
}
```

**2. `waitingAdd()` 메소드 수정 (데이터 저장)**

*   `waitingDB.add()` 와 `saveCSV()` 코드를 삭제합니다.
*   올바른 `INSERT` SQL문을 작성하고, `PreparedStatement`를 사용하여 `waitingDto`로부터 받은 값을 `?`에 채워 넣습니다.

**수정 전:**
```java
public boolean waitingAdd(WaitingDto waitingDto) {
    waitingDB.add(waitingDto);
    saveCSV();
    return true;
}
```

**수정 후:**
```java
public boolean waitingAdd(WaitingDto waitingDto) {
    try {
        // 1. SQL 작성: list 테이블의 number, count 필드에 값을 삽입
        String sql = "INSERT INTO list(number, count) VALUES(?, ?)";
        // 2. SQL을 조작할 PreparedStatement 객체 생성
        ps = conn.prepareStatement(sql);
        // 3. SQL의 ?(매개변수)에 값 대입 (1, 2는 물음표의 순서)
        ps.setString(1, waitingDto.getNumber());
        ps.setInt(2, waitingDto.getCount());
        // 4. SQL 실행
        ps.executeUpdate();
        return true; // 성공 시 true 반환
    } catch (SQLException e) {
        System.out.println("DB 등록 실패 : " + e);
        return false; // 실패 시 false 반환
    }
}
```

**3. `waitingListPrint()` 메소드 수정 (데이터 조회)**

*   `return waitingDB;` 코드를 삭제합니다.
*   `SELECT` SQL문을 실행하여 DB에서 데이터를 가져온 후, `ResultSet` 객체에 저장합니다.
*   `while` 반복문으로 `ResultSet`의 데이터를 한 줄씩 읽어 `WaitingDto` 객체로 변환하고, 이것을 `ArrayList`에 담아 반환합니다.

**수정 전:**
```java
public ArrayList<WaitingDto> waitingListPrint() {
    return waitingDB;
}
```

**수정 후:**
```java
public ArrayList<WaitingDto> waitingListPrint() {
    ArrayList<WaitingDto> list = new ArrayList<>(); // DTO들을 담을 리스트 생성
    try {
        // 1. SQL 작성: list 테이블의 모든 레코드 조회
        String sql = "SELECT * FROM list";
        ps = conn.prepareStatement(sql);
        // 2. SQL 실행 후 결과를 ResultSet으로 받음
        rs = ps.executeQuery();
        // 3. 결과가 존재할 때까지(next) 반복
        while (rs.next()) {
            // 4. ResultSet에서 number와 count 값을 가져와 DTO 생성
            WaitingDto dto = new WaitingDto(
                    rs.getString("number"),
                    rs.getInt("count")
            );
            // 5. 생성된 DTO를 리스트에 추가
            list.add(dto);
        }
    } catch (SQLException e) {
        System.out.println("DB 조회 실패 : " + e);
    }
    return list; // 조회된 리스트 반환
}
```

---

#### **4단계: 최종 점검 (사전 준비)**

위 코드 수정 후 실행하기 전에, 아래 환경이 준비되었는지 꼭 확인하세요.

1.  **MySQL 서버**: MySQL 서버가 켜져 있는지 확인하세요.
2.  **데이터베이스와 테이블**: `waitingList` 라는 이름의 데이터베이스가 있고, 그 안에 아래 구조를 가진 `list` 테이블이 있는지 확인하세요. 없다면 아래 SQL문을 복사하여 MySQL에서 실행하세요.
    ```sql
    CREATE TABLE list (
        wno INT PRIMARY KEY AUTO_INCREMENT, -- 대기번호 (자동증가)
        number VARCHAR(20),                 -- 전화번호
        count INT                           -- 인원수
    );
    ```
3.  **JDBC 드라이버**: 프로젝트에 MySQL JDBC 드라이버 파일(예: `mysql-connector-j-8.x.x.jar`)이 포함되어 있는지 확인하세요.
