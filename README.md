# 디자인 패턴 공부 프로젝트 (Design Pattern)
## 목차

1. [싱글톤 패턴](#1.-싱글톤-패턴-(Signleton-Pattern))

## 1. 싱글톤 패턴 (Singleton Pattern)
### 싱글톤 패턴을 언제 사용해야 하나요 ?
시스템 런타임, 환경 세팅에 대한 정보 등, 인스턴스가 여러개 일 경우 문제가 생길 수 있다. <br>
인스턴스를 오직 한개만 만들어 제공하는 클래스가 필요할때.

### 문제
#### 자바에서 enum 을 사용하지 않고 싱글톤 패턴을 구현하는 방법은 ?
private 생성자를 생성하고 getInstance() 메소드를 통해 Instance 를 제공하게 만들고 static 한 필드에 Instance 가 없으면 새로운 Instance 를 생성해서 반환하도록 만든다.
```java
package com.pattern.design.singleton;

public class App {

    public static void main(String[] args) {
        Settings settings1 = Settings.getInstance();
        Settings settings2 = Settings.getInstance();

        System.out.println(settings1 == settings2);
    }
}
```
```java
package com.pattern.design.singleton;

public class Settings {

    private static Settings instance;

    private Settings() {

    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }

        return instance;
    }
}
```
하지만 위와 같은 방식은 멀티 쓰레드 환경에서는 안전하지 않다. 멀티 쓰레드 환경에서 안전하기 위해선 동기화 처리를 해주면 된다.
```java
package com.pattern.design.singleton;

public class Settings {

    private static Settings instance;

    private Settings() {

    }

    public static synchronized Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }

        return instance;
    }
}
```
synchronized 키워드를 추가함으로써 멀티 쓰레드 환경에서 안전한 코드가 되었다. <br>
하지만 위와 같은 코드는 성능에 대한 이슈가 있을수 있는데, 그러한 이유는 <br>
synchronized 를 호출할때 락이 걸리게 되므로 getInstance() 메소드를 통해 Instance 를 만들때 마다 동기화로 인한 락이 걸리기 때문이다. <br>
이러한 문제를 해결하기 위해 2가지 방법이 존재 한다. <br>
첫번째는 static 한 필드에 미리 Instance 를 생성하는 방식이다.
```java
package com.pattern.design.singleton;

public class Settings {

    private static final Settings INSTANCE = new Settings();

    private Settings() {

    }

    public static Settings getInstance() {
        return INSTANCE;
    }
}
```
하지만 이러한 방식의 문제 점은 이 Instance 를 사용하지 않을때에도 미리 Instance 를 생성해야 한다는 것이다. <br>
이러한 문제점을 해결하기 위해 2번째 방법은 Double Checked Locking 방식을 사용하면 되는데
```java
package com.pattern.design.singleton;

public class Settings {

    private static Settings instance;

    private Settings() {

    }

    public static Settings getInstance() {
        if (instance == null) {
            synchronized (Settings.class) {
                if (instance == null) {
                    instance = new Settings();
                }
            }
        }
        
        return instance;
    }
}
```
하지만 이러한 방식은 굉장히 복잡한 방식을 거치게 된다. 그래서 조금더 단순하고 심플하게 만드는 방식을 알아보면
static inner class 를 사용하는 방식이 존재한다.
```java
package com.pattern.design.singleton;

public class Settings {

    private Settings() {

    }

    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }

    public static Settings getInstance() {
        return SettingsHolder.INSTANCE;
    }
}
```

#### private 생성자와 static 메소드를 사용하는 방법의 단점은 ?
private 생성자와 static 메소드를 통해 싱글톤 패턴을 구현하는 방식에 대해 보았다. <br>
하지만 이러한 방식은 Java 의 리플렉션이나, 직렬화-역직렬화를 사용하게 되면 새로운 Instance 를 생성할 수 있다. <br>
먼저 리플렉션을 이용한 방식을 살펴 보면
```java
package com.pattern.design.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Settings settings1 = Settings.getInstance();
        Settings settings2 = null;
        Constructor<Settings> constructor = Settings.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        settings2 = constructor.newInstance();

        System.out.println(settings1 == settings2);
    }
}
```
위와 같은 방식으로 리플렉션을 활용해 private 생성자에 권한을 풀고 새로운 Instance 를 만드는게 가능해고 직렬화-역직렬화를 살펴 보면
```java
package com.pattern.design.singleton;

import java.io.Serializable;

public class Settings implements Serializable {

    private Settings() {

    }

    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }

    public static Settings getInstance() {
        return SettingsHolder.INSTANCE;
    }
}
```
먼저 Settings class 에 Serializable 을 구현하게 하고
```java
package com.pattern.design.singleton;

import java.io.*;

public class App {

    public static void main(String[] args) {
        Settings settings1 = Settings.getInstance();
        Settings settings2;
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("./test"))) {
            objectOutputStream.writeObject(settings1);
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("./test"));
            settings2 = (Settings) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(settings1 == settings2);
    }
}
```
위와 같이 파일에 객체를 저장후 다시 파일을 통해 객체를 생성할 경우 새로운 객체를 만들 수 있다. 하지만 직렬화-역직렬화는 어느정도 방어가 가능하다.
```java
package com.pattern.design.singleton;

import java.io.Serializable;

public class Settings implements Serializable {

    private Settings() {

    }

    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }

    public static Settings getInstance() {
        return SettingsHolder.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
```
위와 같이 역직렬화를 통해 객체를 만드는 메소드를 getInstance() 메소드를 활용해 가져오게 만들면 되는것이다.

#### enum 을 사용해 싱글톤 패턴을 구현하는 방법의 장점과 단점은 ?
지금 까지 리플렉션, 직렬화-역직렬화를 통해 새로운 Instance 를 만드는 방법을 알아보았는데, 이러한 방식들을 방어할수 있는 방법으로 enum 을 활용하는 방법이 있다.
```java
package com.pattern.design.singleton;

public enum Settings {
    INSTANCE;
}
```
먼저 Settings class 를 enum 으로 변경한 다음
```java
package com.pattern.design.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Settings settings1 = Settings.INSTANCE;
        Settings settings2 = null;
        Constructor<?>[] constructorList = Settings.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructorList) {
            constructor.setAccessible(true);
            settings2 = (Settings) constructor.newInstance("INSTANCE");
        }

        System.out.println(settings1 == settings2);
    }
}
```
리플렉션을 통해 호출 하게 되면 리플렉션에서 생성하는걸 막게 된다.
이러한 점이 enum 을 통한 싱글톤 패턴의 장점으로 볼 수 있지만, 이러한 방법은 미리 Instance 를 생성해 놔야 한다는 단점이 있다.

#### static inner class 를 사용해 싱글톤 패턴을 구현하라.
```java
package com.pattern.design.singleton;

public class Settings {
    
    private Settings() {
        
    }
    
    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }
    
    public static Settings getInstance() {
        return SettingsHolder.INSTANCE;
    }
}
```
```java
package com.pattern.design.singleton;

public class App {

    public static void main(String[] args) {
        Settings settings1 = Settings.getInstance();
        Settings settings2 = Settings.getInstance();
        System.out.println(settings1 == settings2);
    }
}
```
### 자바와 스프링에서 싱글톤 패턴이 사용된 경우
자바는 Runtime 클래스의 경우가 존재하고, 스프링은 ApplicationContext 가 있을수 있다. <br>
또한, 다른 패턴들의 기반이 되기도 한다.