package 테스트용.함수형인터페이스;

public class Foo {
    public static void main(String[] args) {
        RunSomething runSomething = new RunSomething() {
            // 익명 내부 클라스 (Anonymous inner class)
            @Override
            public void doIt() {
                System.out.println("this is anonymous inner class");
            }
        };

        // 함수형 인터페이스를 구현할 때 람다 사용
        RunSomething runSomething1 = ()-> System.out.println("this is Lambda ");
        runSomething1.doIt();
    }
}
