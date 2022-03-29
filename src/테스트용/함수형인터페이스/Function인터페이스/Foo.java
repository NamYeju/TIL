package 테스트용.함수형인터페이스.Function인터페이스;

import java.util.function.Function;

public class Foo implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }

    public static void main(String[] args) {
        Foo foo  = new Foo();
        System.out.println(foo.apply(10));
    }
}
