# 데코레이터 패턴 (Decorator Pattern)
## 데코레이터 패턴은 언제 사용해야 하나요 ?
기존 코드를 변경하지 않고 부가 기능을 추가하는 패턴 <br>

상속이 아닌 위임을 사용해서 보다 유연하게(런타임) 부가 기능을 추가하는 것도 가능하다.

## 데코레이터 패턴의 장점과 단점은 ?
### 장점
- 새로운 클래스를 만들지 않고 기존 기능을 조합할 수 있다.
- 컴파일 타임이 아닌 런타임에 동적으로 기능을 변경할 수 있다.
### 단점
- 데코레이터를 조합하는 코드가 복잡할 수 있다.

### 자바와 스프링에서 데코레이터 패턴이 사용된 경우
Collections.checkedList() 체크하는 로직이 추가된 형태가 되기 때문에 데코레이터 패턴으로 볼수 있다.
