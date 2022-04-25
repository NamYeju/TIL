## Object 클래스

java.lang.Object 자바의 최상위 클래스

### 1. toString()
**public String toString()**

개체의 문자열 표현을 반환한다.  

객체가 인스턴스인 클래스의 이름, at 기호 문자 '@' 및 객체 해시 코드의 부호 없는 16진수 표현으로 구성된 문자열을 반환한다.   
getClass().getName() + '@' + Integer.toHexString(hashCode())   

일반적으로 클래스에서 toString 메소드를 재정의하여 새로운 문자열로 객체의 값이나 정보를 표현해준다. 

````java
public class Member {
    private String name;
    private int age;

    public Member(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "이름:" + name + " 나이:" + age;
    }
}



````

````java
public class Test {
    public static void main(String[] args) {
        Member member = new Member("예주", 23);
        System.out.println(member); // 이름:예주 나이:23
        // toString() 메소드는 자동으로 호출되기 때문에 따로 호출하지 않아도 된다. 
        //System.out.println(member.toString());
    }
}

````

