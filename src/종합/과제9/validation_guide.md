
# ProductControl 유효성 검사 사용법

`ProductControl`의 `productUpdate`와 `productDelete` 기능에 유효성 검사를 추가하여, 물품 번호와 비밀번호가 일치할 때만 수정 및 삭제가 가능하도록 만드는 방법입니다.

## 1단계: `ProductDao`에 유효성 검사 SQL 추가

가장 먼저 데이터베이스에 직접 물품 번호(`pno`)와 비밀번호(`ppwd`)를 확인하는 `checkProduct` 메소드를 구현해야 합니다.

**파일 위치:** `src/종합/과제9/model/dao/ProductDao.java`

`checkProduct` 메소드를 아래와 같이 수정하여, `pno`와 `ppwd`가 일치하는 레코드가 있는지 확인하고 그 결과를 `boolean`으로 반환하도록 합니다.

```java
// src/종합/과제9/model/dao/ProductDao.java

// ... 기존 코드 ...

public boolean productDelete(ProductDto productDto) {
    // ... 기존 코드 ...
} // func end

// 이 메소드를 아래와 같이 수정합니다.
public boolean checkProduct(int pno, String ppwd) {
    try {
        // 1. SQL 작성
        String sql = "select * from product where pno = ? and ppwd = ?";
        // 2. SQL 기재
        PreparedStatement ps = conn.prepareStatement(sql);
        // 3. SQL 매개변수 대입
        ps.setInt(1, pno);
        ps.setString(2, ppwd);
        // 4. SQL 실행
        ResultSet rs = ps.executeQuery();
        // 5. 결과 확인: rs.next()가 true이면 일치하는 레코드가 있다는 의미
        if (rs.next()) {
            return true;
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    // 일치하는 레코드가 없거나 예외가 발생하면 false 반환
    return false;
}

// ... 기존 코드 ...
```

## 2단계: `ProductControl`에 유효성 검사 적용

이제 `ProductDao.checkProduct`를 사용하여 실제 비즈니스 로직에 유효성 검사를 적용합니다.

**파일 위치:** `src/종합/과제9/controller/ProductControl.java`

### 물품 수정 (`productUpdate`)

`productUpdate` 메소드는 이미 유효성 검사 코드가 추가되어 있습니다. 이 코드가 `ProductDao.checkProduct`를 호출하여 `isValid` 변수에 결과를 저장하고, `false`일 경우 수정을 중단시킵니다.

```java
// src/종합/과제9/controller/ProductControl.java

public boolean productUpdate(String pname, String pcontent, int pprice, boolean pboolean, int pno, String ppwd) {
    // 1. 유효성 검사 (이미 추가된 코드)
    boolean isValid = productDao.checkProduct(pno, ppwd);
    if (!isValid) {
        // 비밀번호나 물품 번호가 틀리면 여기서 즉시 false를 반환
        return false;
    }
    // 2. 객체화
    ProductDto productDto = new ProductDto(pno, pname, pcontent, pprice, pboolean, "", "", ppwd);
    // 3. DAO에 수정 요청
    boolean result = productDao.productUpdate(productDto);
    // 4. 결과 반환
    return result;
}
```

### 물품 삭제 (`productDelete`)

물품 삭제 기능에도 동일한 유효성 검사를 추가해야 합니다.

```java
// src/종합/과제9/controller/ProductControl.java

public boolean productDelete(int pno, String ppwd) { // 매개변수 수정
    // 1. 유효성 검사
    boolean isValid = productDao.checkProduct(pno, ppwd);
    if (!isValid) {
        return false; // 유효하지 않으면 삭제 처리 중단
    }
    // 2. DAO에 삭제 요청
    boolean result = productDao.productDelete(new ProductDto(pno, ppwd));
    // 3. 결과 반환
    return result;
}
```

## 3단계: `ProductView`에서 기능 호출

마지막으로 사용자 인터페이스(View)에서 수정 및 삭제 기능을 호출하고 결과를 처리합니다.

**파일 위치:** `src/종합/과제9/view/ProductView.java`

### 물품 수정 (`productUpdate`)

`productUpdate` 메소드에서 사용자로부터 `pno`와 `ppwd`를 입력받고, 컨트롤러의 `productUpdate`를 호출합니다. 컨트롤러에서 반환된 `boolean` 값에 따라 사용자에게 성공 또는 실패 메시지를 보여줍니다.

```java
// src/종합/과제9/view/ProductView.java

public void productUpdate() {
    // 1. 입력 받기
    System.out.print("수정할 물품 번호 입력> ");
    int pno = scan.nextInt();
    System.out.print("비밀번호: ");
    String ppwd = scan.next();
    
    // --- 여기서부터는 수정할 내용 입력 ---
    scan.nextLine(); // 버퍼 비우기
    System.out.print("새 물품명: ");
    String pname = scan.nextLine();
    System.out.print("새 물품가격: ");
    int pprice = scan.nextInt();
    scan.nextLine(); // 버퍼 비우기
    System.out.println("새 물품설명을 입력해주세요");
    String pcontent = scan.nextLine();
    System.out.print("판매여부 (판매중:true / 판매완료:false): ");
    boolean pboolean = scan.nextBoolean();

    // 2. 컨트롤러에 전달 후 결과 받기
    boolean result = productControl.productUpdate(pname, pcontent, pprice, pboolean, pno, ppwd);

    // 3. 결과에 따른 출력
    if (result) {
        System.out.println("[안내] 물품 수정 완료");
    } else {
        System.out.println("[경고] 물품 번호가 없거나 비밀번호가 틀립니다.");
    }
}
```

### 물품 삭제 (`productDelete`)

물품 삭제를 위한 `productDelete` 메소드를 `ProductView`에 만들고, 수정과 동일한 방식으로 사용자 입력을 받아 컨트롤러에 전달합니다.

```java
// src/종합/과제9/view/ProductView.java

// ... productUpdate() 메소드 아래에 추가 ...

public void productDelete() {
    // 1. 입력 받기
    System.out.print("삭제할 물품 번호 입력> ");
    int pno = scan.nextInt();
    System.out.print("비밀번호: ");
    String ppwd = scan.next();

    // 2. 컨트롤러에 전달 후 결과 받기
    boolean result = productControl.productDelete(pno, ppwd);

    // 3. 결과에 따른 출력
    if (result) {
        System.out.println("[안내] 물품 삭제 완료");
    } else {
        System.out.println("[경고] 물품 번호가 없거나 비밀번호가 틀립니다.");
    }
}
```

이제 `index` 메소드에서 `select3 == 3`일 때 `productDelete()`를 호출하도록 연결하면 모든 작업이 완료됩니다.
