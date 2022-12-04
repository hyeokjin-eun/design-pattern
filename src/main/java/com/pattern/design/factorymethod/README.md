# 팩토리 메소드 패턴 (Factory Method Pattern)
## 팩토리 메소드 패턴은 언제 사용해야 하나요 ?
구체적으로 어떤 인스턴스를 만들지는 서브 클래스가 정한다. <br>
다양한 구현체가 있고, 그중에서 특정한 구현체를 만들수 있는 다양한 팩토리를 제공해야 할때

### 문제
#### 팩토리 메소드 패턴을 적용했을때 장점과 단점은 ?
##### 장점
- 확장에는 열려있고 변경에는 닫혀있는 객체 지향 원칙에 맞춰서 개발을 할수 있다.
- 책임과 역할을 분리함으로써 기존에 코드에 대한 변경점이 낮다.
- Product 와 Creator 의 결합도를 느슨하게 만들수 있다.
- 구체적인 타입에 의존하지 않게 된다.
##### 단점
- 책임에 대한 역할을 분리하다 보니 클래스가 많아지는 단점이 존재한다.

#### "확장에는 열려있고 변경에는 닫혀있는 객체 지향 원칙" 을 설명하시오.
확장에는 열려있고 변경에는 닫혀있는 객체 지향 원칙은 SOLID 의 O 즉, 개방 폐쇄의 원칙(Open-Close Principle)이다. <br>
이는 즉, 기존 코드는 수정하지 않고 기능을 추가 할수 있어야 한다는 원칙이다. <br>
보통 이 원칙을 만족하기 위해선 추상화와 다향성을 많이 활용한다.

#### 자바 8에 추가된 default 메소드에 대해 설명하시오.
default method 는 인터페이스에 있는 구현 메소드를 의미합니다. <br>
default method 의 장점은
- 인터페이스에 새로운 메소드를 사용하였다고 하면 인터페이스를 구현하고 있는 모든 구현체는 새로운 메소드를 구현해야하는데 default method 는 이를 방지해 줍니다.

default method 를 사용항때 주의할 점이 있는데,
- 여러 인터페이스들간의 default method 의 충돌이 일어날수 있다.
- default method 와 상위 클래스의 method 충돌

여러 인터페이스들간의 default method 의 충돌은 아래와 같이 구현할수 있는데
```java
package com.pattern.design.factorymethod.defaultmethod;

public interface CarFactory {

    default void order() {
        System.out.println("차를 생산합니다.");
    }
}
```

```java
package com.pattern.design.factorymethod.defaultmethod;

public interface ShipFactory {
    default void order() {
        System.out.println("배를 생산합니다.");
    }
}
```

```java
package com.pattern.design.factorymethod.defaultmethod;

import com.pattern.design.factorymethod.defaultmethod.problem1.CarFactory;
import com.pattern.design.factorymethod.defaultmethod.problem1.ShipFactory;

public class Vehicle implements CarFactory, ShipFactory {
}
```
위와 같이 구현하게 되면 어떤 default method 를 사용해야할지 몰라서 컴파일 에러가 발생하게 된다.

```java
package com.pattern.design.factorymethod.defaultmethod;

import com.pattern.design.factorymethod.defaultmethod.problem1.CarFactory;
import com.pattern.design.factorymethod.defaultmethod.problem1.ShipFactory;

public class Vehicle implements CarFactory, ShipFactory {
    @Override
    public void order() {
        CarFactory.super.order();
        ShipFactory.super.order();
    }
}
```
위와 같이 default Method 를 오버라이드 해서 사용해야한다. <br>

default method 와 상위 클래스의 method 충돌은
```java
package com.pattern.design.factorymethod.defaultmethod.problem2;

public interface CarFactory {

    default void order() {
        System.out.println("차를 생산합니다.");
    }
}
```
```java
package com.pattern.design.factorymethod.defaultmethod.problem2;

public interface ShipFactory {
    default void order() {
        System.out.println("배를 생산합니다.");
    }
}
```
```java
package com.pattern.design.factorymethod.defaultmethod.problem2;

public class Car implements CarFactory{

    @Override
    public void order() {
        CarFactory.super.order();
    }
}
```
```java
package com.pattern.design.factorymethod.defaultmethod.problem2;

public class Vehicle extends Car implements ShipFactory {
}
```
위와 같은 경우 컴파일 에러가 발생하지 않는다.
```java
package com.pattern.design.factorymethod.defaultmethod.problem2;

public class Client {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.order();
    }
}
```
만약 위와같이 호출하게 된다면, 상위 클래스의 오버라이드한 method 가 우선순위가 높게 호출 된다는걸 알수 있다. <br>
또한, java 8 에서 추가된 default method 와 java 9 에서 추가된 인터페이스의 private method 까지 활용한다면 훨씬 좋다.
### 자바와 스프링에서 팩토리 메소드 패턴이 사용된 경우
자바의 경우 Calendar 클래스가 단순한 팩토리 메소드 패턴(Simple Factory Method) 을 사용하고 있다. <br>
스프링의 경우 BeanFactory 가 팩토리 메소드 패턴을 사용하고 있다고 볼수 있다.
