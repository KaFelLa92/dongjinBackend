# 대기 시스템 프로젝트 매뉴얼

## 1. 프로젝트 개요

본 프로젝트는 식당이나 카페 등에서 사용할 수 있는 간단한 콘솔 기반의 고객 대기 시스템입니다. 자바(Java)와 MySQL 데이터베이스를 사용하여 MVC (Model-View-Controller) 패턴으로 개발되었습니다.

주요 기능은 다음과 같습니다:
- 대기 등록
- 대기 목록 조회
- 대기 취소 (구현 예정)
- 대기 인원 수정 (구현 예정)

## 2. 프로젝트 구조 (MVC 패턴)

프로젝트는 역할에 따라 다음과 같은 패키지 및 파일로 구성되어 있습니다.

```
src/
└── 종합/
    └── 과제8/
        ├── AppStart.java               # 애플리케이션 시작점
        ├── view/
        │   └── WaitingView.java        # 사용자 인터페이스 (View)
        ├── controller/
        │   └── WaitingController.java  # 비즈니스 로직 (Controller)
        ├── model/
        │   ├── dao/
        │   │   └── WaitingDao.java     # 데이터베이스 접근 (DAO)
        │   └── dto/
        │       └── WaitingDto.java     # 데이터 전송 객체 (DTO)
        └── resource/
            └── sampleData.sql          # 데이터베이스 초기 설정 SQL
```

### 2.1. 각 파일의 역할

- **`AppStart.java`**: `main` 메소드를 포함하며, 프로그램을 시작하고 `WaitingView`를 호출하는 역할을 합니다.
- **`view/WaitingView.java`**: 사용자에게 메뉴를 보여주고, 키보드 입력을 받아 `Controller`에 전달하며, 처리 결과를 다시 사용자에게 보여주는 화면(콘솔) 관련 로직을 담당합니다.
- **`controller/WaitingController.java`**: `View`로부터 요청을 받아 비즈니스 로직을 수행하고, `DAO`를 호출하여 데이터베이스 작업을 지시합니다. `View`와 `Model(DAO)` 사이의 중재자 역할을 합니다.
- **`model/dao/WaitingDao.java`**: 데이터베이스에 직접 접근하여 SQL 쿼리를 실행하고, CRUD(Create, Read, Update, Delete) 작업을 수행합니다. JDBC를 사용하여 MySQL과 연동됩니다.
- **`model/dto/WaitingDto.java`**: 데이터의 구조를 정의하는 클래스입니다. 각 계층(View, Controller, DAO) 간에 데이터를 전달할 때 사용하는 객체(Data Transfer Object)입니다. `wno`, `wnumber`, `wcount` 필드를 가집니다.
- **`resource/sampleData.sql`**: 프로젝트 실행에 필요한 데이터베이스와 테이블을 생성하고, 초기 샘플 데이터를 추가하는 SQL 스크립트입니다.

## 3. 실행 방법

### 3.1. 데이터베이스 설정

1.  **MySQL 설치**: 로컬 환경에 MySQL 서버가 설치되어 있어야 합니다.
2.  **데이터베이스 생성**: MySQL 클라이언트(Workbench, DBeaver 등)에서 `resource/sampleData.sql` 파일의 내용을 실행하여 `waitingList` 데이터베이스와 `wait` 테이블을 생성하고 샘플 데이터를 추가합니다.
    - **DB 접속 정보**: `WaitingDao.java`에 하드코딩된 접속 정보는 다음과 같습니다. 필요시 자신의 환경에 맞게 수정해야 합니다.
      - URL: `jdbc:mysql://localhost:3306/waitingList`
      - User: `root`
      - Password: `1234`

### 3.2. JDBC 드라이버 설정

-   프로젝트의 빌드 경로(Build Path)에 **MySQL Connector/J** (JDBC 드라이버)가 추가되어 있어야 합니다. `WaitingDao.java`에서 `com.mysql.cj.jdbc.Driver` 클래스를 로드합니다.

### 3.3. 애플리케이션 실행

1.  IDE(IntelliJ, Eclipse 등)에서 프로젝트를 엽니다.
2.  `AppStart.java` 파일을 찾습니다.
3.  `main` 메소드를 실행하여 프로그램을 시작합니다.
4.  콘솔에 나타나는 메뉴에 따라 원하는 기능을 선택하여 사용합니다.

## 4. 기능 상세 및 데이터 흐름

### 4.1. 대기 등록

1.  **View (`WaitingView`)**: 사용자가 메뉴 `1`을 선택하면, 전화번호와 인원수를 입력받습니다.
2.  **Controller (`WaitingController`)**: `View`는 입력받은 `wnumber`와 `wcount`를 `waitAdd()` 메소드의 인자로 하여 `Controller`를 호출합니다. `Controller`는 이 정보로 `WaitingDto` 객체를 생성합니다.
3.  **DAO (`WaitingDao`)**: `Controller`는 생성된 `WaitingDto` 객체를 `WaitAdd()` 메소드의 인자로 하여 `DAO`를 호출합니다.
4.  **Database**: `DAO`는 `INSERT` SQL 쿼리를 실행하여 `wait` 테이블에 새로운 대기 정보를 추가합니다.
5.  **결과 반환**: `DAO`는 작업 성공 여부(`boolean`)를 `Controller`에 반환하고, `Controller`는 다시 `View`에 반환합니다. `View`는 이 결과에 따라 성공 또는 실패 메시지를 콘솔에 출력합니다.

### 4.2. 대기 조회

1.  **View (`WaitingView`)**: 사용자가 메뉴 `2`를 선택하면, `waitPrint()` 메소드가 호출됩니다.
2.  **Controller (`WaitingController`)**: `View`는 `waitPrint()` 메소드를 통해 `Controller`를 호출합니다.
3.  **DAO (`WaitingDao`)**: `Controller`는 `waitPrint()` 메소드를 통해 `DAO`를 호출합니다.
4.  **Database**: `DAO`는 `SELECT * FROM wait` SQL 쿼리를 실행하여 모든 대기 목록을 조회합니다.
5.  **결과 반환**: `DAO`는 조회된 각 행(row)을 `WaitingDto` 객체로 만들어 `ArrayList<WaitingDto>`에 담아 `Controller`에 반환합니다. `Controller`는 이 리스트를 다시 `View`에 반환합니다.
6.  **View (`WaitingView`)**: `View`는 전달받은 `ArrayList`를 반복하여 모든 대기 정보를 정해진 형식에 맞게 콘솔에 출력합니다.
