# 자바 상속과 인터페이스 완전 정복 매뉴얼

뇌를 버리지 마세요! 이 매뉴얼이 도와드립니다. 두 개념은 자바의 강력함을 이해하는 핵심 열쇠입니다.

## 1. 상속 (Inheritance) - "is-a" 관계 (물려받기)

상속은 **부모 클래스의 특징(필드와 메소드)을 자식 클래스가 그대로 물려받는 것**입니다.
"자식 클래스는 부모 클래스의 한 종류이다 (is-a)" 관계가 성립합니다.

-   **예시:** `lowClass`는 `highClass`이다. `HankookTire`는 `Tire`이다.

### 왜 사용하나요?

-   **코드 재사용:** 부모 클래스에 작성된 코드를 자식 클래스에서 또 작성할 필요가 없어 효율적입니다.
-   **논리적 구조:** 클래스들을 "부모-자식"의 논리적인 계층 구조로 관리할 수 있습니다.
-   **다형성 구현:** 하나의 타입으로 여러 자식 타입을 다룰 수 있게 해줍니다. (객체 지향의 꽃!)

### 사용법: `extends` 키워드

```java
// 부모 클래스 (Superclass)
class highClass {
    int value1 = 10;
    int value2 = 20;

    void showValue() {
        System.out.println(">>highClass method access<<");
    }
}

// 자식 클래스 (Subclass)
class lowClass extends highClass { // highClass를 상속받음
    int value3 = 30;
}
```

-   `lowClass`는 코드를 직접 작성하지 않았지만, `highClass`의 `value1`, `value2`, `showValue()`를 모두 자신의 것처럼 사용할 수 있습니다.

### 메소드 오버라이딩 (Method Overriding)

부모에게 물려받은 메소드를 자식 클래스에서 **내용만 바꿔서 재정의**하는 것입니다.

-   **규칙:** 부모 메소드와 **이름, 매개변수, 반환 타입이 모두 같아야** 합니다.
-   **동작 원리:** 오버라이딩된 메소드를 호출하면, 변수의 타입이 아닌 **실제 객체의 타입(태생)**을 따라 자식 클래스의 메소드가 항상 우선적으로 실행됩니다.

```java
// Example1.java 요약
class highClass {
    void showValue() {
        System.out.println(">>highClass method access<<");
    }
}

class lowClass extends highClass {
    // highClass의 showValue()를 오버라이딩
    @Override // 이 메소드가 오버라이딩된 것임을 명시 (실수 방지용)
    void showValue() {
        System.out.println(">>lowClass method access<<");
    }
}

// 실행 코드
lowClass obj2 = new lowClass();
obj2.showValue(); // 당연히 ">>lowClass method access<<" 출력

highClass obj3 = obj2; // 부모 타입으로 자동 형변환
obj3.showValue(); // 띠용? ">>lowClass method access<<" 출력
                  // 변수의 타입은 highClass지만, 실제 객체는 lowClass이므로
                  // 오버라이딩된 lowClass의 메소드가 실행됩니다. 이게 핵심!
```

### 다형성 (Polymorphism) with 상속

하나의 부모 타입 변수에 여러 종류의 자식 객체를 담아 다룰 수 있는 성질입니다. `Example2.java`의 `Car`와 `Tire` 예시가 완벽한 예입니다.

```java
// Example2.java 요약
class Car {
    Tire tire; // 부모 타입의 멤버 변수
    void run() {
        this.tire.roll(); // 타이어를 굴린다!
    }
}

class Tire { void roll() { /* ... */ } }
class HankookTire extends Tire { @Override void roll() { /* ... */ } }
class KumhoTire extends Tire { @Override void roll() { /* ... */ } }

// 실행 코드
Car myCar = new Car();
myCar.tire = new Tire();       // Tire 객체 장착
myCar.run();                   // -> 일반 타이어가 굴러감

myCar.tire = new HankookTire(); // HankookTire 객체로 교체! (자동 타입 변환)
myCar.run();                   // -> 한국 타이어가 굴러감

myCar.tire = new KumhoTire();   // KumhoTire 객체로 교체! (자동 타입 변환)
myCar.run();                   // -> 금호 타이어가 굴러감
```

`myCar`는 타이어를 교체해도 `run()` 메소드를 수정할 필요가 없습니다. `tire` 변수에 어떤 자식 객체가 대입되느냐에 따라 `roll()`의 실행 결과가 동적으로 바뀌기 때문입니다. 이것이 바로 **다형성**입니다.

---

## 2. 인터페이스 (Interface) - "can-do" 관계 (자격증)

인터페이스는 어떤 객체가 **"무엇을 할 수 있는지(can-do)"**를 정의하는 **설계도** 또는 **규약(contract)**입니다.

-   **예시:** `한국타이어`는 `roll()`을 할 수 있다. `새`와 `비행기`는 `fly()`를 할 수 있다.

### 왜 사용하나요?

-   **표준화:** 여러 클래스들이 따라야 할 **공통 규격**을 정할 수 있습니다. (예: 모든 타이어는 `roll()` 기능이 있어야 한다!)
-   **느슨한 결합:** 클래스들이 특정 클래스가 아닌 **규격(인터페이스)**에 의존하게 만들어, 부품을 쉽게 교체할 수 있는 유연한 설계를 만듭니다.
-   **다중 구현:** 클래스는 단 하나의 클래스만 상속받을 수 있지만, 인터페이스는 **여러 개를 구현(장착)**할 수 있습니다. (자격증을 여러 개 따는 것처럼!)

### 사용법: `implements` 키워드

```java
// 인터페이스 정의 (설계도)
interface 타이어 {
    void roll(); // 추상 메소드 (몸통 {}이 없음)
}

// 클래스가 인터페이스를 구현 (설계도대로 만들기)
class 한국타이어 implements 타이어 {
    // 인터페이스의 추상 메소드를 반드시 구현(오버라이딩)해야 함
    @Override
    public void roll() {
        System.out.println("[한국] 타이어가 회전(구현)");
    }
}
```

### 인터페이스의 멤버

인터페이스는 오직 두 종류의 멤버만 가질 수 있습니다. (뼈대만 있음)

1.  **상수 (`public static final`)**: 모든 변수는 자동으로 `public static final`이 붙은 상수가 됩니다. (생략 가능)
2.  **추상 메소드 (`public abstract`)**: 모든 메소드는 자동으로 `public abstract`가 붙은 추상 메소드가 됩니다. (생략 가능)

**주의!** 인터페이스는 실체가 없는 설계도이므로 생성자가 없습니다. 따라서 `new 타이어()` 처럼 직접 객체를 생성할 수 없습니다.

### 다형성 (Polymorphism) with 인터페이스

상속과 마찬가지로, 인터페이스 타입 변수에 해당 인터페이스를 구현한 모든 클래스의 객체를 담을 수 있습니다.

```java
// Example4.java 요약
class 자동차 {
    타이어 tire; // 인터페이스 타입의 멤버 변수
    void run() {
        this.tire.roll();
    }
}

interface 타이어 { void roll(); }
class 한국타이어 implements 타이어 { @Override public void roll() { /* ... */ } }
class 금호타이어 implements 타이어 { @Override public void roll() { /* ... */ } }

// 실행 코드
자동차 myCar = new 자동차();

myCar.tire = new 한국타이어(); // 한국타이어(구현체) 장착
myCar.run();                  // -> 한국 타이어가 굴러감

myCar.tire = new 금호타이어(); // 금호타이어(구현체)로 교체
myCar.run();                  // -> 금호 타이어가 굴러감
```

`자동차` 클래스는 타이어가 `한국타이어`인지 `금호타이어`인지 전혀 신경쓰지 않습니다. 그저 `타이어`라는 **규격**을 만족하고, `roll()` 메소드를 가지고 있다는 사실만 알면 됩니다. 덕분에 나중에 `미쉐린타이어` 클래스가 추가되어도 `자동차` 클래스 코드는 단 한 줄도 바꿀 필요가 없습니다.

---

## 3. 상속 vs 인터페이스: 언제 무엇을 쓸까?

| 구분 | 상속 (extends) | 인터페이스 (implements) |
| --- | --- | --- |
| **관계** | **is-a** (자식은 부모의 한 종류) | **can-do** (클래스는 이 행동을 할 수 있음) |
| **목적** | 코드 **재사용**, 기능 확장 | 동작에 대한 **규약/명세** 정의, 표준화 |
| **다중 여부** | **단일** 상속만 가능 | **다중** 구현 가능 |
| **강제성** | 오버라이딩은 선택 사항 | 추상 메소드 구현은 **필수** |
| **키워드** | `extends` | `implements` |
| **비유** | **유산** (하나의 가문만 물려받음) | **자격증** (여러 개 취득 가능) |

### 핵심 요약

-   **상속 (`extends`)**: 클래스의 기능과 속성을 **물려받아** 확장하거나 재사용하고 싶을 때. "is-a" 관계가 명확할 때 사용합니다. (예: `고양이`는 `동물`이다)
-   **인터페이스 (`implements`)**: 클래스 종류와 상관없이, 특정 **기능(메소드)을 갖도록 강제**하고 싶을 때. "can-do" 관계를 표현하거나, 서로 관련 없는 클래스들에게 공통 기능을 부여하고 싶을 때 사용합니다. (예: `새`와 `드론`은 날 수 있다 -> `Flyable` 인터페이스 구현)
