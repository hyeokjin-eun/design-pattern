# 퍼사드 패턴 (Facade Pattern)
## 퍼사드 패턴은 언제 사용해야 하나요 ?
복잡한 서브 시스템의 의존성을 최소화 하는 방법 <br>
클라이언트가 사용해야하는 복잡한 서브 시스템의 의존성을 간단한 인터페이스로 추상화 한다.

## 퍼사드 패턴의 장점과 단점은 ?
### 장점
- 서브 시스템에 대한 의존성을 한곳으로 모을수 있다.
### 단점
- 퍼사드 클래스가 서브 시스템에 대한 의존성을 가지게 된다.

### 자바와 스프링에서 퍼사드 패턴이 사용된 경우
Spring 에서 제공하는 Mail 서비스 의 경우 퍼사드 패턴이 적용되어있다고 볼수 있다.
