# `GROUP BY`, 집계 함수, 별칭(Alias) 개념 정리

`day05.sql` 파일의 예제를 바탕으로 `GROUP BY`, 집계 함수, 별칭(Alias)의 개념과 헷갈리는 부분을 정리합니다.

## 1. `GROUP BY`: 데이터 묶기 (`~별`, `~끼리`)

`GROUP BY`는 특정 컬럼(열)의 값이 같은 레코드(행)들을 하나의 그룹으로 묶어주는 역할을 합니다. 주로 각 그룹에 대한 통계를 낼 때 사용합니다.

**기본 사용법:**
```sql
-- 제품명(bpname) 별로 그룹을 묶습니다.
SELECT bpname FROM buy GROUP BY bpname;
```
결과는 `지갑`, `맥북프로`, `아이폰`, `청바지`, `에어팟`, `혼공SQL` 처럼 중복이 제거된 형태로 보입니다. 각 이름이 하나의 그룹이 된 것입니다.

**⚠️ 흔한 오류와 그 이유:**
```sql
-- 오류 발생!
SELECT bpname, bprice FROM buy GROUP BY bpname;
```
*   **이유:** `bpname`으로 그룹을 묶으면, 예를 들어 '청바지' 그룹에는 가격이 50인 레코드가 2개 있습니다. 데이터베이스는 이 중에서 어떤 `bprice`(가격)를 표시해야 할지 알 수 없습니다.
*   **해결책:** `GROUP BY`를 사용할 때 `SELECT` 절에는 **1) `GROUP BY`에서 사용한 컬럼**이나 **2) 집계 함수(SUM, AVG 등)**만 사용할 수 있습니다.

---

## 2. 집계 함수: 그룹의 통계 계산하기

집계 함수는 `GROUP BY`로 묶인 그룹의 통계(합계, 평균 등)를 계산하는 함수입니다.

*   `SUM(컬럼명)`: 합계
*   `AVG(컬럼명)`: 평균
*   `MIN(컬럼명)`: 최솟값
*   `MAX(컬럼명)`: 최댓값
*   `COUNT(*)` 또는 `COUNT(컬럼명)`: 개수 (레코드 수)

**사용 예시:**
```sql
-- (1) 회원(mid)별로 총 구매수량(bamount)은 얼마인가?
SELECT mid, SUM(bamount) FROM buy GROUP BY mid;

-- (2) 회원(mid)별로 총 구매금액(가격*수량)은 얼마인가?
SELECT mid, SUM(bprice * bamount) FROM buy GROUP BY mid;

-- (3) 회원(mid)별로 몇 번이나 구매했는가? (구매 횟수)
SELECT mid, COUNT(*) FROM buy GROUP BY mid;
```
이처럼 `GROUP BY mid`로 회원별 그룹을 만들고, 각 그룹에 대해 `SUM`이나 `COUNT` 같은 집계 함수를 적용하여 원하는 통계치를 얻을 수 있습니다.

---

## 3. 별칭 (Alias) `AS`: 보기 좋게 이름 붙이기

`AS` 키워드는 컬럼이나 테이블에 임시로 새로운 이름을 붙일 때 사용합니다. 쿼리 결과를 더 이해하기 쉽게 만들어 줍니다.

**사용 예시:**
```sql
-- SUM(bprice * bamount) 라는 긴 이름을 '총구매금액'으로 변경
SELECT mid, SUM(bprice * bamount) AS 총구매금액
FROM buy
GROUP BY mid;
```

**⚠️ 별칭 사용 시 주의할 점 (WHERE vs HAVING):**
별칭은 SQL 쿼리의 특정 절에서만 사용할 수 있습니다. 이것은 SQL의 내부적인 실행 순서 때문입니다.

```sql
-- (X) 잘못된 사용: WHERE 절에서는 별칭을 사용할 수 없습니다.
SELECT bamount AS 수량 FROM buy WHERE 수량 > 3; -- 오류!

-- (O) 올바른 사용: 원래 컬럼명을 사용해야 합니다.
SELECT bamount AS 수량 FROM buy WHERE bamount > 3;
```
*   **이유:** SQL은 `WHERE` 절을 `SELECT` 절보다 먼저 처리합니다. 따라서 `WHERE` 절을 처리하는 시점에는 `수량`이라는 별칭이 아직 만들어지지 않았습니다.

---

## 4. `WHERE` vs `HAVING`: 조건절의 차이

`WHERE`와 `HAVING`은 둘 다 조건을 거는 역할을 하지만, 적용되는 시점이 다릅니다.

*   **`WHERE`**: 그룹화 **전(before)**. 테이블의 개별 레코드(행)를 필터링합니다.
    *   집계 함수와 함께 사용할 수 없습니다.
*   **`HAVING`**: 그룹화 **후(after)**. `GROUP BY`로 만들어진 그룹을 필터링합니다.
    *   집계 함수의 결과값을 조건으로 사용할 수 있습니다.

**비교 예시:**
```sql
-- WHERE: '개별' 구매수량이 3개를 초과하는 내역만 조회
SELECT * FROM buy WHERE bamount > 3;

-- HAVING: 그룹별 '총' 구매금액이 1000 이상인 '회원 그룹'만 조회
SELECT mid, SUM(bprice * bamount) AS 총구매금액
FROM buy
GROUP BY mid
HAVING SUM(bprice * bamount) >= 1000;
```

**💡 `HAVING` 절에서는 별칭 사용 가능!**
`HAVING`은 `SELECT` 절보다 나중에 처리되므로, `SELECT`에서 만든 별칭을 사용할 수 있습니다.
```sql
SELECT mid, SUM(bprice * bamount) AS 총구매금액
FROM buy
GROUP BY mid
HAVING 총구매금액 >= 1000; -- OK!
```

---

## 5. 종합: SQL 쿼리 논리적 실행 순서

SQL이 쿼리를 처리하는 논리적인 순서를 이해하면 `WHERE`, `HAVING`, 별칭 사용 규칙을 쉽게 이해할 수 있습니다.

1.  `FROM` / `JOIN`: 어떤 테이블에서 데이터를 가져올지 결정
2.  `WHERE`: 개별 레코드를 조건에 따라 필터링
3.  `GROUP BY`: 지정된 컬럼으로 그룹화
4.  `HAVING`: 그룹화된 결과를 조건에 따라 필터링
5.  `SELECT`: 최종적으로 어떤 컬럼을 보여줄지 결정 (이때 별칭이 만들어짐)
6.  `ORDER BY`: 결과를 정렬
7.  `LIMIT`: 보여줄 레코드 수 제한

이 순서 때문에 `WHERE`(2번)에서는 `SELECT`(5번)에서 만든 별칭을 쓸 수 없지만, `HAVING`(4번)이나 `ORDER BY`(6번)에서는 별칭을 쓸 수 있는 것입니다.
