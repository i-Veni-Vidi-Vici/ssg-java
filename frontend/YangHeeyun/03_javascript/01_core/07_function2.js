/*
함수의 여러가지 형태
1. 즉시실행함수
2. 재귀함수
3. 중첩함수
4. 콜백함수
5. 순수함수
6. 클로져함수
*/

/*
1. 즉시실행함수(IIFE)
    Immediately Invoke Function Expression
    - 선언과 실행을 동시에 작성하는 함수
    - 1회용 (재사용할 수 없다)
*/

// (() => {
//     console.log("🥗");
// })여기까지 선언부 (); 여기만 실행부

(() => {
    console.log("🥗");
})();

((food) => {
    console.log(food);
})('🍖');



// 전역 스코프
let salad = "🥗";
salad = "🍔"; // 전역 스코프는 쉽게 재설정이 가능한 장점 겸 단점이 있다.
console.log(salad); 

(() => {
    // 지역 스코프
    // 지역변수를 선언하고, 값을 보호하기 위해서 IIFE 사용한다.
    let salad = "🥗";
    console.log(salad);
})();

(() => {
    // 지역 스코프
    // 지역스코프의 경우, 동일한 이름의 변수를 다른 스코프에 선언해 쓰는 것이 가능하다. 
    let salad = "🥗";
    console.log(salad);
})();

/*
2. 재귀호출함수
- 함수 안에서 함수 자신을 다시 호출하는 경우
- 종료조건을 반드시 명시해야 한다. (stackover flow 오류가 발생할수 있어 주의)
- 반복처리 보다 더 간단히 처리가능한 경우 사용하면 좋다. (하노이 탑)
*/

// n! (factorial) = 1 * 2 * 3 * ... * n
// 5! = 5 * 4 * 3 * 2 * 1
const factorial = (n) => {
    if(n==1) return 1; // 종료조건 
    return n * factorial(n-1);
};
console.log(factorial(5)); // 120

/*
3. 중첩함수
- 함수내부에 함수를 선언해 사용
- 내부함수를 굳이 노출할 필요가 없는 경우 사용할 수 있다.
*/
// 10 -> 10, 3 -> 03
const outer = (n) => {
    const inner = (k) => k < 10 ? '0' + k : k;
    console.log(inner(n));
};
outer(15); // 15
outer(7); // 07

/*
4. 콜백함수 Callback
- js의 함수는 일급객체(값)으로써 매개인자로 전달할 수 있고, 이를 함수 내부에서 호출할 수 있다.
*/
const a = (f) => {
    f();
};

const b = () => console.log('🍳');
b()

a(b); // f=b가 되므로 f() -> b();

/*
5. 순수/비순수 함수
모든 함수에는 입력/출력이 있다.
함수에는 부입력/부출력이 있을 수 있다.
(명시적으로 전달한 매개인자/리턴값 외에 외부스코프의 값을 입력/출력으로 사용할 수 있다.)
 
순수함수 : 외부상태에 의존/변경하지 않는 함수(값을 받아 읽거나 바꾸거나 안함)
비순수함수 : 외부사애에 의존/변경하는 함수

되도록 순수함수를 사용하도록 하면 좋다(부수적 입출력을 없애서 부작용을 없앰)
순수함수를 이용해서 불변성을 추구하는 프로그래밍 방식이 함수형 프로그래밍이다.
*/
const pureFunc = (n) => { // 입력받고 출력만 하는 순수함수
    return ++n;
}
console.log(pureFunc(1));


let count = 0;
const impureFunc = (n) => { // 비순수함수
    count = count + 1;
    return ++n;
};
console.log(impureFunc(1));

/*
6. Closure함수
자유변수 free variable : 함수 지역범위에서 선언되지 않은 변수
모든 자유변수가 전역변수인 것은 아니다.

클로져함수란? 자유변수를 가지고 외부로부터 닫힌 함수. 
- 클로져가 가진 자유변수는 외부로붜 접근이 불가능하고, 안전하게 관리할 수 있다.
- 이미 모든 것을 가지고 있어서 외부에서 끌어다 가져오지 않음

*/

const word = "안녕";

// word는 greeting의 자유변수이다.
const greeting = (name) => {
    const word2 = "반가워";
    console.log(`${word}, ${name}. ${word2}`);
};
greeting('길동');

function yoo(){
    const num = 100;
    return () => console.log(`num = ${num}`);
  }
const num = 200;
const too = yoo(); // closure함수. 자유변수 num(100)을 가지고 외부로부터 닫힌 함수. 리턴함수 + 자유변수 num = 100까지 too에 넣어줌
//   const too = () => console.log(`num = ${num}`);
console.log(too);
too(); // 100

let cnt = 0;
const globalCounter = () => console.log(++cnt);
globalCounter();
globalCounter();
globalCounter();

cnt = 100; // 값 재설정(값 오염)
globalCounter();
globalCounter();
globalCounter();


// cnt를 closireCounterMaker에서 재정의하더라도 안에 함수 cnt = 0은 변경할 수 없다
// 접근제한자가 없는 자바스크립트에서 우회적으로 변수를 보호할 수 있는 방법이 closure다.
const closureCounterMaker = () => {
    let cnt = 0;
    return () => console.log(++cnt);
};
const closureCounter = closureCounterMaker();
closureCounter();
closureCounter();
closureCounter();