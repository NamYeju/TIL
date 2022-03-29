package 테스트용.함수형인터페이스.자바제공;

import java.util.function.Function;

public class Foo2 {
    public static void main(String[] args) {
        Function<Integer, Integer> plua = (i)-> i + 10;
        plua.apply(10);
    }

}
