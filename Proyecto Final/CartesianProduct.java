import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CartesianProduct {

    public static <T, U> List<List<Object>> cartesianProduct(List<T> collection1, List<U> collection2) {
        return collection1.stream()
                .flatMap(t -> collection2.stream()
                        .map(u -> List.of(t, u)))
                .collect(Collectors.toList());
    }

    public static <T, U> List<List<Object>> cartesianProductWithStreams(List<T> collection1, List<U> collection2) {
        return collection1.stream()
                .flatMap(t -> collection2.stream()
                        .map(u -> Stream.of(t, u)
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> collection1 = List.of("a", "b", "c");
        List<Integer> collection2 = List.of(4, 5);

        List<List<Object>> result = CartesianProduct.cartesianProduct(collection1, collection2);
        System.out.println(result);

        List<List<Object>> resultWithStreams = CartesianProduct.cartesianProductWithStreams(collection1, collection2);
        System.out.println(resultWithStreams);
    }
}
