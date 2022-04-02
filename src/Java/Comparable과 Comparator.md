### Comparable 인터페이스
- `compareTo(T o)` 메소드    
 왜 매개변수 하나?   
 **자기 자신과 매개변수 객체 비교**

````java
public class Student implements Comparable<Student>{ // Student와 또다른 Student 객체를 비교할 것이므로 제네릭 타입은 Student
    private int score;
    private int age;

    public Student(int grade, int age){
        this.score = grade;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        if(this.score > o.score)
            return 1;
        else if(this.score == o.score)
            return 0;
        else
            return -1;
    }
}
````
````java
public class Main{
    public static void main(String[] args) {
        Student yeju = new Student(100, 23);
        Student ayeong = new Student(80, 23);
        int result = yeju.compareTo(ayeong);
        if(result == 1)
            System.out.println("아싸 내가 아영이보다 점수높당");
        else if(result == 0)
            System.out.println("옹 동점~!");
        else
            System.out.println("ㅜㅜㅜㅜㅜ...");
    }
}
````
### Comparator 인터페이스 
- `compareTo(T o1, T o2)` 메소드    
  왜 매개변수 두개?   
  **매개변수로 들어온 두 객체의 값을 비교**

````java
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.grade > o2.grade)
            return 1;
        else if(o1.grade == o2.grade)
            return 0;
        else return -1;
    }
````
````java
    public static void main(String[] args) {
        Student A = new Student(23,100);
        Student B = new Student(23, 99);
        Student forCompare = new Student(0,0);

        // 방법 1
        int result = forCompare.compare(A,B);
        // 방법 2
        int result = A.compare(A,B);
        
        if(result==1)
        ... (생략) ...
    }
````

객체의 값을 비교한다는 관점에서 Comparable과 Comparator의 구현코드는 크게 다르지 않다.    
다만 구현할 때 방법 1같이 전혀 상관없는 객체를 하나 생성하여 메소드를 호출하던가,
방법2 처럼 아무 객체를 선택하여 그 객체를 통해 메소드를 호출해야한다. 어떤 객체를 선택하여 호출하던 
기능에는 영향이 가지 않지만, 가독성이 떨어지는 단점이 있다.   
이러한 단점을 보완하기 위해 `익명 객체(클라스)`를 사용하게 된다. 

---
+) 익명 객체 
```java
public class Rectangle {
    int height = 10;
    int width = 20;

    int get(){
        return height * width;
    }
}
```

```java
public class Main{
    public static void main(String[] args) {
        Rectangle parent = new Rectangle();
        System.out.println(child.get());
        // 익명 객체
        Rectangle anonymous = new Rectangle(){ // 클래스를 생성한 것과 동일하지만(Rectangle extends와 동일) 객체만 생성되어 있고, 클래스이름으로 정의되지 않음
            int depth = 50;
            @Override
            int get(){
                return height * width * height;
            }
        };
        System.out.println(anonymous.get());
    }
}
```
자식 클라스가 부모 클라스 Rectangle을 상속받을 때 메소드를 재정의하는 것과  동일하게 익명클래스도 변수도 생성하고
Rectangle의 메소드를 재구현하고 있지만 (마치 새로운 클래스를 생성), 클라스 이름이 존재하지 않는다. 
클라스의 이름은 존재하지 않고, anonymous라는 이름의 객체만 생성되어 있다. 
---

#### 익명객체를 사용하여 구현한 Comparator 

````java
public class Student {
    private int age;
    private int grade;

    public Student(int age, int grade) {
        this.age = age;
        this.grade = grade;
    }
}
````
````java
public class Main {
    public static Comparator<Student> comparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.grade - o2.grade;
        }
    };

    public static void main(String[] args) {
        Student A = new Student(23,100);
        Student B = new Student(23, 99);
        
        int result = comparator.compare(A,B);
        ...(생략)...
    }
}
````

익명객체를 통해 Comparator 인터페이스를 상속받기 때문에 Student 클래스에서 상속하지 않아도 된다. 