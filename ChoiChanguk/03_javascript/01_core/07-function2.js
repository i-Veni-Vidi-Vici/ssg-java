/**
 * 함수의 여러가지 형태
 * 1. 즉시실행함수
 * 2. 재귀함수
 * 3. 중첩함수
 * 4. 콜백함수
 * 5. 순수함수
 * 6. 클로져함수
 */

/**
 * 1. 즉시실행함수 (IIFE)
 *  - Immediately Invoked Function Expresstion
 *  - 선언과 실행을 동시에 작성하는 함수
 *  - 일회용
 */
((num)=>{
    console.log("즉시실행함수",num);
}) (123);

let number="123";
console.log(number);

(()=>{
let number="123";
    console.log(`즉시실행함수 지역스코프 `+number);
}) ();

/**
 * 2. 재귀호출함수
 *  - 함수 안에서 함수 자신을 다시 호출하는 경우
 *  - 종료조건을 반드시 명시해야 한다. (stackover flow 오류가 발생할 수 있다 주의)
 */

const factorial=(n)=>{
    if(n==1)
        return 1;
    return n* factorial(n-1)
}
console.log(factorial(5));

/**
 * 3. 중첩함수
 *  - 함수내부에 함수를 선언해 사용
 *  - 내부함수를 굳이 노출할 필요가 없는 경우 사용할 수 있다.
 */
const outer = (n)=>{
    const inner =(k)=> k<10?'0'+k :k
    console.log(inner(n));
};

outer(5);
outer(140);

/**
 * 4. 콜백함수 Callback
 *  - js의 함수는 일급객체(값)으로써 매개인자로 전달할 수 있고, 이를 함수 내부에서 추출할 수 있다.
 */
const a= (f)=>{
    f();
}
const b=()=>console.log('🎈');
