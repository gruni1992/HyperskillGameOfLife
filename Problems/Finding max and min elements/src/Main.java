import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main{
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> list = stream.collect(Collectors.toList());
        if(list.isEmpty()){
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.stream().min(order).get(), list.stream().max(order).get());
        }
    }
}