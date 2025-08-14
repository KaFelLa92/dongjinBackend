# SQL `day08.sql` 명령어 및 개념 정리

이 문서는 `day08.sql` 파일에 포함된 SQL 명령어와 데이터베이스 개념을 설명합니다.

## 1. 데이터베이스 관리

데이터베이스를 생성, 삭제, 사용하는 기본 명령어입니다.

- **`DROP DATABASE IF EXISTS mydb0724;`**
  - `mydb0724`라는 데이터베이스가 존재할 경우에만 삭제합니다. `IF EXISTS`는 데이터베이스가 없을 때 발생할 수 있는 오류를 방지합니다.

- **`CREATE DATABASE mydb0724;`**
  - `mydb0724`라는 이름의 새 데이터베이스를 생성합니다.

- **`USE mydb0724;`**
  - 현재 세션에서 `mydb0724` 데이터베이스를 기본 작업 데이터베이스로 지정합니다. 이 명령어를 실행한 후의 모든 쿼리는 이 데이터베이스에 대해 실행됩니다.

## 2. 테이블 생성 및 제약 조건

데이터를 저장할 테이블을 만들고, 데이터의 무결성을 보장하기 위한 제약 조건을 설정합니다.

### 기본 키 (Primary Key - PK)

- **개념**: 테이블의 각 레코드(행)를 고유하게 식별할 수 있는 값입니다. `NULL` 값을 가질 수 없으며, 중복된 값을 허용하지 않습니다. (예: 회원번호, 제품번호, 학번)

- **명령어**:
  ```sql
  CREATE TABLE table1 (
      num_pk INT,
      CONSTRAINT PRIMARY KEY (num_pk)
  );
  ```
  - `table1`이라는 테이블을 생성합니다.
  - `num_pk`라는 정수(INT) 타입의 컬럼을 생성하고, 이 컬럼을 기본 키(PK)로 지정합니다.

### 외래 키 (Foreign Key - FK)

- **개념**: 한 테이블의 필드(컬럼)가 다른 테이블의 기본 키(PK)를 참조하는 키입니다. 테이블 간의 관계를 설정하며, 데이터의 참조 무결성을 보장합니다. 중복 값과 `NULL` 값을 가질 수 있습니다. (예: 게시물의 작성자 회원번호, 주문 내역의 고객번호)

- **명령어**:
  ```sql
  CREATE TABLE table2 (
      no_pk INT,
      CONSTRAINT PRIMARY KEY (no_pk),
      num_fk INT,
      CONSTRAINT FOREIGN KEY (num_fk) REFERENCES table1(num_pk)
      ON DELETE CASCADE
      ON UPDATE CASCADE
  );
  ```
  - `table2` 테이블을 생성합니다.
  - `num_fk` 컬럼을 외래 키(FK)로 지정하여 `table1` 테이블의 `num_pk` 컬럼을 참조하도록 합니다.

#### 참조 무결성 옵션

외래 키 제약 조건에서 참조하는 PK 값이 변경되거나 삭제될 때의 동작을 정의합니다.

- **`ON DELETE CASCADE`**: 참조하고 있는 `table1`의 PK 레코드가 삭제되면, 해당 레코드를 참조하는 `table2`의 FK 레코드가 **함께 삭제**됩니다.
- **`ON UPDATE CASCADE`**: 참조하고 있는 `table1`의 PK 값이 변경되면, 해당 값을 참조하는 `table2`의 FK 값이 **함께 변경**됩니다.
- **`ON DELETE SET NULL`**: PK 레코드가 삭제되면, FK 값은 `NULL`로 변경됩니다.
- **`ON UPDATE SET NULL`**: PK 값이 변경되면, FK 값은 `NULL`로 변경됩니다.
- **`ON DELETE RESTRICT`** (기본값): `table2`에서 참조하고 있는 PK 레코드는 삭제할 수 없습니다.
- **`ON UPDATE RESTRICT`** (기본값): `table2`에서 참조하고 있는 PK 레코드는 수정할 수 없습니다.

## 3. 데이터 조작 및 조회 (JOIN)

`JOIN`은 관계형 데이터베이스에서 가장 중요한 개념 중 하나로, 두 개 이상의 테이블을 PK와 FK 관계를 기반으로 연결하여 하나의 결과 집합으로 조회하는 기능입니다.

### 샘플 데이터 추가

```sql
INSERT INTO table1 VALUES (1), (2), (3), (4), (5);
INSERT INTO table2 VALUES (1, 1), (2, 2), (3, 1), (4, 1), (5, 2);
```

### (1) 교차 조인 (Cross Join)

- 두 테이블의 모든 가능한 레코드 조합을 반환합니다. (table1의 5개 * table2의 5개 = 25개 레코드)
- 보통 조건 없이 사용하지 않으며, `WHERE` 절과 함께 사용하여 `INNER JOIN`처럼 사용될 수 있습니다.
```sql
SELECT * FROM table1, table2;
```

### (2) 내부 조인 (Inner Join) - 교집합

- 두 테이블 간에 공통된 값(PK와 FK가 일치하는)을 가진 레코드만 조회합니다.

- **`WHERE` 절 사용**:
  ```sql
  SELECT * FROM table1, table2 WHERE table1.num_pk = table2.num_fk;
  ```

- **`INNER JOIN ON` 절 사용 (권장)**:
  - `JOIN` 조건과 `WHERE`의 일반 조건을 명확히 구분할 수 있어 가독성이 높습니다.
  ```sql
  SELECT * FROM table1 INNER JOIN table2 ON table1.num_pk = table2.num_fk;
  ```
  - `INNER`는 생략 가능합니다. (`JOIN ON`)
  - `AS`를 사용하여 테이블에 별칭(alias)을 부여할 수 있습니다.
  ```sql
  SELECT t1.num_pk, t2.num_fk FROM table1 AS t1 JOIN table2 AS t2 ON t1.num_pk = t2.num_fk;
  ```

- **`NATURAL JOIN`**:
  - 두 테이블에서 이름이 같은 모든 컬럼을 기준으로 조인합니다. 의도치 않은 컬럼이 조인될 수 있어 **사용을 권장하지 않습니다.**
  ```sql
  SELECT * FROM table1 NATURAL JOIN table2;
  ```

### (3) 외부 조인 (Outer Join)

- 교집합(Inner Join) 결과와 함께, 한쪽 테이블에는 있지만 다른 쪽 테이블에는 없는 데이터도 포함하여 조회합니다.

- **`LEFT OUTER JOIN`**:
  - **왼쪽 테이블(`table1`)의 모든 레코드**를 포함하고, 오른쪽 테이블(`table2`)에서는 조인 조건에 맞는 레코드만 포함합니다. 일치하는 레코드가 없으면 `NULL`로 표시됩니다.
  ```sql
  SELECT * FROM table1 t1 LEFT OUTER JOIN table2 t2 ON t1.num_pk = t2.num_fk;
  ```

- **`RIGHT OUTER JOIN`**:
  - **오른쪽 테이블(`table2`)의 모든 레코드**를 포함하고, 왼쪽 테이블(`table1`)에서는 조인 조건에 맞는 레코드만 포함합니다.
  ```sql
  SELECT * FROM table1 t1 RIGHT OUTER JOIN table2 t2 ON t1.num_pk = t2.num_fk;
  ```
  - `OUTER`는 생략 가능합니다. (`LEFT JOIN`, `RIGHT JOIN`)

### (4) 전체 조인 (Full Outer Join) - 합집합

- 두 테이블의 모든 레코드를 조회합니다. (양쪽 테이블의 `OUTER JOIN` 결과를 합친 것)
- MySQL은 `FULL OUTER JOIN`을 직접 지원하지 않으므로, `LEFT JOIN`과 `RIGHT JOIN`의 결과를 `UNION`으로 합쳐서 구현합니다.

```sql
SELECT * FROM table1 t1 LEFT JOIN table2 t2 ON t1.num_pk = t2.num_fk
UNION
SELECT * FROM table1 t1 RIGHT JOIN table2 t2 ON t1.num_pk = t2.num_fk;
```

### (5) 차집합

- 한쪽 테이블에만 존재하는 레코드를 조회합니다. `OUTER JOIN` 결과에서 `NULL`인 부분을 필터링하여 구현합니다.

- **왼쪽 테이블(`table1`) 기준 차집합**: `table1`에는 있지만 `table2`에는 없는 데이터
  ```sql
  SELECT t1.* FROM table1 t1 LEFT JOIN table2 t2 ON t1.num_pk = t2.num_fk WHERE t2.num_fk IS NULL;
  ```

- **오른쪽 테이블(`table2`) 기준 차집합**: `table2`에는 있지만 `table1`에는 없는 데이터
  ```sql
  SELECT t2.* FROM table1 t1 RIGHT JOIN table2 t2 ON t1.num_pk = t2.num_fk WHERE t1.num_pk IS NULL;
  ```
