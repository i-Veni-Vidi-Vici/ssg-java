/**
 * 함수의 여러가지 형태
 * 
 * 1. 즉시 실행함수
 * 2. 재귀함수 
 * 3. 중첩함수
 * 4. 콜백함수
 * 5. 순수함수
 * 6. 클로져함수
 */

/**
 * 1. 즉시 실행 함수(IIFE)
 * - immediately invoked Functino Expression
 * - 선언과 실행을 동시에 작성하는 함수 
 */

(() => {
    console.log('🥩');
    
})();

((food) => {
   console.log(food);
   
})('🍺');

let meat = "🥩";
console.log(meat);

(() => {
    // 지역스코프
    // 지역변수를 선언하고, 값을 보호하기 위해서 IIFE를 사용한다.
    let meat = "🥩";
    console.log(meat);
    
 })();

 /**
  * 2. 재귀호출함수 
  * - 함수 안에서 함수 자신을 다시 호출하는 경우
  * - 종료조건을 반드시 명시해야 한다. (stackover flow 오류가 발생할 수 있어 주의해야한다.)
  */

 const factorial = (n) => {
    if(n == 1) return 1; // 종료 조건 
    return n * factorial(n-1);

 };
 console.log(factorial(5));

 /**
  * 3, 중첩함수 
  * - 함수 내부에 함수를 선언해서 사용
  * - 내부함수를 굳이 노출할 필요가 없는 경우 사용할 수 있다.
  * 
  */

 const outer = (n) =>{
    const inner = (k) => k < 10 ? '0' + k : k;
    console.log(inner(n));
 };

 outer(15);
 outer(2);
 
 /**
  * 4. 콜백함수(call back)
  * - js의 함수는 일급객체(값)으로써 매개인자로 전달할 수 있고, 이를 함수 내부에서 호출할 수 있따.
  */

 const a = (f) => {
    f();
 }

 const b = () => console.log('🐰');
 a(b);

 /**
  * 순수 / 비순수 함수 
  * - 모든 함수에는 입력 / 출력이 있다.
  * - 함수에는 부입력 / 부출력이 있을 수 있다. (명시적으로 전달한 매개인자 / 리턴값 외에 외부 스코프의 값을 입력 /출력으로 사용할 수 있다.)
  * 
  * 순수함수 : 외부 상태에 의존 / 변경하지 않는 함수 
  * 비순수함수 : 외부 상태에 의존 / 변경하는 함수 
  * -> 되도록 순수함수를 사용하자 !
  * 
  * - 순수함수를 이용해서 불변성을 추가하는 프로그래밍 방식이 함수형 프로그래밍이다.
  */

 //순수함수 : pureFunc
 const pureFunc= (n) => {
    return ++n ;
 };
 console.log(pureFunc(1));

 //비순수함수 : impureFunc
let count = 0; //매개인자 외에 다른 값을 추가해서 출력하는 것 -> 부입력
 const impureFunc = (n) => {
    count = count + 1; //전역스코프에 있는 값을 읽거나 쓰는 작업을 하는 것을 부입력 / 부출력
    return ++n ;
 };
 console.log(impureFunc(1));

 /**
  * 6. closure 함수 
  * - 자유변수 : free variable : 함수 지역범위에서 선언되지 않은 변수
  * - 모든 자유변수가 전역변수 인것은 아니다.
  * 
  * 클로져 함수란 ? 자유변수를 가지고 외부로부터 닫힌 함수 
  * - 클로져가 가진 자유변수는 외부로부터 접근이 불가능하고, 안전하게 관리할 수 있다.
  */

 const word = "안녕";
 //word는 greeting의 자유변수이다.
 const greeting = (name) =>{
    const word2 = "반가워";
    console.log(`${word}, ${name}. ${word2}`);
 }
 greeting('길동')


 function yoo(){
    const num = 100;
    return () => console.log(`num = ${num}`);
}
const num = 200;
const too = yoo(); // closure함수 ( 자유변수 num (100)을 가지고 외부로부터 닫힌 함수
console.log(too);
too(); // 100

let cnt = 0;
const globalCounter = () => console.log(++cnt);

 const closureCounterMaker = () =>{
    let cnt  = 0;
    return () => console.log(++cnt);
 }
 const closureCounter = closureCounterMaker();
 closureCounter();
 closureCounter();
 closureCounter();