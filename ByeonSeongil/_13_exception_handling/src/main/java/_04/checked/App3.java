package _04.checked;


/**
 * <pre>
 * 두 정수를 입력받고, 그 합을 출력하는 프로그램을 작성합니다.
 * - 정수가 아닌 숫자를 입력하면, "유효한 정수를 입력해주세요." 출력후 다시 정상적으로 작동해야 합니다.
 * - Caluclator#sum() 메소드를 작성하세요.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.sum();
        System.out.println("프로그램 정상 종료!");
    }
}
