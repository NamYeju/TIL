### Arrays.asList()
List를 생성할 때 List<E> arr = new ArrayList<>()를 통해 생성하는 방법이 있고, 
List<E> arr = Arrays.asList(...)를 통해 생성하는 방법이 있다.



### new ArrayList<>() vs Arrays.asList()

1. 리턴 타입   
   `new ArrayList<>()`: import java.util.ArrayList;   
   `Arrays.asList()`: import java.util.Arrays;

2. 원소 추가 or 삭제   
   `new ArrayList<>()`: 가능  
   `Arrays.asList()`: 불가능
    - asList()를 통해 생성된 리스트는 **고정된 리스트**이기 때문에 add() 혹은 remove()가 불가능하다.
    - 단, 수정은 가능 
      >String[] str = {"a", "b","c"};   
        List< String > list = Arrays.asList(str);
        와 같은 코드가 있다고 할 때
      - list.set(1, "k"); // ["k", "b", "c"]
      - str[1] = "p"; // ["p", "b", "c"]
    - 원소 추가하고 싶다면   
   `List<E> list = new ArrayList<E>(Arrays.asList());`
