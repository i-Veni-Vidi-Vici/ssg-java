package overflow;

/**
 * <pre>
 * overflow
 * - 자료형별로 표현할 수 있는 최대값을 벗어나면 다시 최소값으로 순환처리
 * - 자료형별로 표현할 수 있는 최소값을 벗어나면 다시 최대값으로 순환처리
 * </pre>
 */
public class OverflowApp {
    public static void main(String[] args) {
        int i = Integer.MAX_VALUE; // 2_147_483_647
//        i = i + 1; // 최소값으로 순환 -2_147_483_648
        i = i + 2; // -2_147_483_647
        System.out.println(i);

        int j = Integer.MIN_VALUE;
        j = j - 1; // 최대값으로 순환 2_147_483_647
        System.out.println(j);

    }
}
