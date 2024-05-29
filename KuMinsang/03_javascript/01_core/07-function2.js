/**
 * 함수의 여러가지 형태
 * 1. 즉시 실행 함수
 * 2. 재귀함수
 * 3. 중첩함수
 * 4. 콜백함수
 * 5. 순수함수
 * 6. 클로저함수
 */

/**
 * 1. 즉시 실행함수 (IIFE)
 * - Immediately Invoked Function Expression
 * - 선언과 실행을 동시에 작성하는 함수
 */

(()=>{
    console.log("🦄");
})();

((food)=>{
    console.log(food);
})('💟');

let salad ="🦄🦄";
console.log(salad);

(()=>{
    // 지역스코프
    let salad = "🕹️";
    console.log(salad);
})();

/**
 * 2. 재귀호출함수
 * - 함수 안에서 함수 자신을 다시 호출하는 경우
 */

const factorial = (n) => {
    if(n==1) return 1;
    return n * factorial(n-1);
};
console.log(factorial(5));

/**
 * 3. 중첩함수
 * - 함수 내부에 함수를 선언해 사용
 * - 내부 함수를 굳이 노출할 필요가 없는 경우 사용할 수 있다
 */

// 10 -> 10, 3 -> 03
const outer = (n) => {
    const inner = (k) => k < 10 ? '0' + k : k;
    console.log(inner(n));
};
outer(15);
outer(7);

/**
 * 4. 콜백함수 Callback
 * - js의 함수는 일급객체이다. 그러므로 매개인자로 전달할 수 있다. 
 * - 함수A의 매개인자로 전달 받은 함수B를 함수A 내부에서 호출할 수 있다.
 */
const a = (f) =>{
    f();
};
const b = () => console.log('🕹️');
a(b);

/**
 * 5. 순수함수 , 비순수함수
 *  - 모든 함수에는 입력/출력이 있다.
 *  - 함수에는 부입력 / 부출력이 있을수 있다. (명시적으로 전달한 매개인자 / 리턴값외에 외부 스코프의 값을 입력/출력으로 사용할 수 있다)
 * 
 *  - 순수함수 : 외부상태에 의존/변경하지 않는 함수
 *  - 비순수함수 : 외부상태에 의존 / 변경하는 함수
 * 
 *  - 되도록이면 순수함수를 사용하는 것이 좋음
 *  - 순수함수를 이용해서 불변성을 추가하는 프로그래밍 방식이 함수형 프로그래밍이다.
 */
const pureFunc = (n) => {
    return ++n;
};
console.log(pureFunc(1));

let count = 0;
const impureFunc = (n) => {
    count = count +1;
    return ++n;
};
console.log(impureFunc(1));

/**
 * 6. Closure함수
 * - 자유변수 free variable : 함수 지역범위에서 선언되지 않은 변수
 * 
 *  클로저함수란? 자유변수를 가지고 외부로부터 닫힌 함수
 *  
 */

const word = "안녕";
//word는 greeting의 자유변수이다
const greeting=(name) =>{
    const word2 = "반가워";
    console.log(`${word}, ${name}. ${word2}`);
};
greeting('길동')

function yoo(){
    const num = 100;
    return () => {
        console.log(`num = ${num} , car = ${car}`);
    }
}
const num = 200;
const coo = yoo('🏍️');

let cnt = 0;
const golobalCounter = () => console.log(++cnt);
golobalCounter();
golobalCounter();
golobalCounter();
golobalCounter();
cnt = 100;
golobalCounter();
golobalCounter();

const closureCounterMaker = () => {
    let cnt = 0;
    return () => console.log(++cnt);
};
const closureCounter1 = closureCounterMaker();
const closureCounter2 = closureCounterMaker();
closureCounter1();
closureCounter2();
closureCounter1();
closureCounter2();
closureCounter1();
closureCounter2();
closureCounter1();
