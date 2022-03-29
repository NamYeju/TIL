package 테스트용.함수형인터페이스.Function인터페이스;

import java.util.function.Function;

public class Foo2 {
    public static void main(String[] args) {
        Function<Integer, Integer> plus = (i)-> i + 10;
        plus.apply(10);
    }

}
