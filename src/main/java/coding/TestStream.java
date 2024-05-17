package coding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author xpmiao
 * @date 2023/7/20
 */
public class TestStream<T,S> implements TestStrea<T> {

    List<?> object;
    public TestStream(List<?> in) {
        this.object = in;
    }
    public static void main(String[] args) {
    }
    public static <T> TestStrea<T> build(List<T> in){
        return new TestStream<>(in);
    }
}
interface TestStrea<T>{

}