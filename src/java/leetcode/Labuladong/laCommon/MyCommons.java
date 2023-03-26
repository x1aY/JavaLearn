package leetcode.Labuladong.laCommon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// import java.util.stream.Collectors;
import java.util.stream.Collectors;

public class MyCommons {
    // T 可接收的参数必须是包装类而非原始类型
    public static <T> void printArray(List<T> array) {
        System.out.println(Arrays.toString(array.toArray()));
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()).toString());
    }

    /**
     * List<Integer>、Integer[]、int[]的相互转化
     * 涉及到stream中的 Stream<Integer>、List<T>、IntStream
     * https://zhuanlan.zhihu.com/p/196698839
     */
    public static void ListConversions(){
        // int[] nums = { 1, 2, 3, 4, 5 };
        // List<Integer> ListNums = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        // int[] List2Int = ListNums.stream().mapToInt(Integer::valueOf).toArray();
        // List<Integer> int2List = Arrays.stream(nums).boxed().collect(Collectors.toList());

        
        // Integer[] IntegerNums = { 1, 2, 3, 4, 5 };
        // Integer[] Int2Integer = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        // Integer[] List2Integer = ListNums.toArray(new Integer[0]);
        // int[] Integer2Int = Arrays.stream(IntegerNums).mapToInt(Integer::valueOf).toArray();
        // List<Integer> Integer2List = Arrays.asList(IntegerNums);
    }

    public static void main(String[] args) {
        List<Integer> ListNums = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        printArray(ListNums);
    }

}
