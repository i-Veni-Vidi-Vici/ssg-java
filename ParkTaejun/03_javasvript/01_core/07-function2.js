/**
 * 함수의 여러가지 형태
 * 1. 즉시 실행함수
 * 2. 재구함수
 * 3. 중첩함수
 * 4. 콜백함수
 * 5. 순수함수
 * 6. 클로져함수
 */

/**
 * 1. 즉시실행함수(IIFE)
 *  - Immediately Invoked Function Expression 
 *  - 선언과 실행을 동시에 작성하는 함수
 *  - 1회용 (재사용할 수 없다.)
 */

(() => {
    console.log("🔢🔢");
})();

((food) => {
    console.log(food);
})('📕📕📕');

// 전역스코프
let salad = '🥗'
console.log(salad);

(() => {
    //지역스코프
    //지역변수를 선언하고, 값을 보호하기 위해서 IIFE를 사용한다.
    let salad = '🥗'
console.log(salad);
})();

(() => { // 서로 다른 지역스코프기 때문에 연속으로도 사용이 가능하다.
    //지역스코프
    //지역변수를 선언하고, 값을 보호하기 위해서 IIFE를 사용한다.
    let salad = '🥗'
console.log(salad);
})();

/**
 *  2. 재귀호출함수
 *  - 함수 안에서 함수 자신을 다시 호출하는 경우
 *  - 종료조건을 반드시 명시해야 한다. (stackover flow 오류가 발생할 수 있어 주의해야한다.)
 *  - 반복처리 보다 더 간단히 처리 가능한 경우 사용하면 좋다. (하노이탑)
 */

// n!(factorial) = 1* 2* 3 * 4 * 5...* n
// 5! = ~ *5

const factoral = (n) => {
    if (n == 1) return 1; // 종료 조건 만약 n이 1 이라면 그냥 1 반환해라
    return n * factoral(n - 1);
};
console.log(factoral(5));

/**
 * 3. 중첩함수
 * - 함수내부에 함수를 선언하여 사용
 * - 내부함수를 굳이 노출할 필요가 없는 경우 사용할 수 있다.
 */

// 10 -> 10, 3 -> 03
const outer = (n) => {
    const inner = (k) => k < 10 ? '0' + k : k
    console.log(inner(n));
};

outer(15); // 15
outer(7); // 07

/**
 * 4. 콜백함수 Callback 
 *  - js의 함수는 일급객체(값)으로써 매개인자로 전달할 수 있고, 이를 함수 내부에서 호출할 수 있다.
 */

const a = (f) => {
    f()
};

const b = () => console.log('🍳🍳🍳');

a(b);

/**
 * 5. 순수/비순수 함수
 *  - 모든 함수에는 입력/출력이 있다.
 *  - 함수에는 부입력/부출력이 있을 수 있다. (명시적으로 전달한 매개인자/ 리턴값외에 외부스코프의 값을 압력/출력으로 사용할 수 있다.)
 * 
 *  - 순수함수 : 외부상태에 의존/변경하지 않는 함수 
 *  - 비순수함수 : 외부상태에 의존/변경하는 함수
 * 
 * - 되도록 순수함수를 사용하도록 하면 좋다.
 * - 순수함수를 이용해서 불변성을 추가하는 프로그래밍 방식이 함수형 프로그래밍이다.
 */
const pureFunc = (n) => {;  
    return ++n;  
};
console.log(pureFunc(1)); //결과는 같음

let count = 0;
const inpureFunc = (n) => {
    count = count + 1; // 쓰기 작업하는 하나가 더 생긴 것임 부출력이라고 함 
    return ++n + count; //명시적으로 전달한 매개인자 외에 다른값을 가져와 사용할 수있다.
};

console.log(inpureFunc(1));

/**
 * 6. Closures 함수
 */


//5-29
/**
 * 자바스크립트에서 함수는 일급객체이다. 
 * 1. 변수에 대입가능해야 한다. 
 * 2. 함수호출 시 전달이 가능해야 한다.
 * 3. 함수의 반환값으로 사용할 수 있어야한다.
 * 
 * 함수형프로그래밍에서는 이 함수는 일급객체로 다루는 것이 중요하다.
 * (자바는 람다를 통해서 우회적으로 위의 조건들을 만족하고 있다. )
 */

// 1, 값으로써 변수에 대입 가능하다.
const func = function(){
    console.log('🚗🚗🚗');
}
func(); // func 라는 객체 

const fun2 = func; // func2 라는 공간에 갹체에 대한 참조주소를 담은 것임 0x123

fun2();

console.log(func == fun2);// true

// 2. 값으로써 매개인자로 사용 

const runner = (f, count) => {
    for (let i = 0; i < count; i ++)
    f();
};

runner(func, 5);

// 3. 값으로써 리턴값으로 사용 

const carFactoryBuilder = () => {
    return () => console.log('🚕🚕🚕');
};
// const carFactory = carFactoryBuilder; //함수자체를 준 것 
const carFactory = carFactoryBuilder(); // 호출 결과를 준 것 , 저만큼이 그냥 1 2 3 처럼 생각해야 한다. 
console.log(carFactory);
carFactory();

// 매개변수가 있는 함수 
const func2 = (n) => console.log('🥀' + n);

const runner2 = (f) => {
    for(let i = 0; i <3; i++ )
    f(i + 1); //호출부에서 값을 전달해 주어야 한다.
};
runner2(func2);

// 어떤차를 몇대 생산할건지 매개변수로 정해준다.
const carFactoryBuilder2 = (car) => {
    return (n) => {
        for (i = 0; i <n; i++)
        console.log(car);
    }
};
const firecarFactory2 = carFactoryBuilder2('🚒🚒🚒');  
firecarFactory2(3);

// 경찰차 factory를 지어서 (함수) 10 대 출력하세요

const policeFactory = carFactoryBuilder2('🚓')
policeFactory(10);

/**
 * 6. Closuer 함수
 * - 자유변수 free variable : 함수 지역범위에서 선언되지 않은 변수
 * - 모든 자유변수가 전역변수인 것은 아니다.
 * 
 * 클로저함수란? 자유변수를 가지고 외부로부터 닫힌 함수 
 *  - 클로져가 가진 자유변수는 외부로부터 접근이 불가능하고 안전하게 관리할 수 있다. 
 */

const word = '안녕';
const greeting = (name) => {
    const word2 = '반가워';
    console.log(`${word}, ${name}. ${word2}`);
};

greeting('길동');



function yoo(){
    const num = 100;
    return () => console.log(`num = ${num}`); //${num}, num = 100 자유변수 포함한 상ㅇ태로 반환되게 된다.
}

const num = 200;
const too = yoo(); // closure함수 (자유변수 num(100)) 을 가지고 외부로부터 닫힌 함수
// const too = () => console. log ( `num = ${num});
console.log(too);
too(); // 100

let cnt = 0;
const globalCounter = () => console.log(++cnt);
globalCounter();
globalCounter();
globalCounter();
cnt = 100;
globalCounter();
globalCounter();
globalCounter();
globalCounter(); // 이렇게 원치않게 될 수 있다

const closuereCounterMaker = () => {
    let cnt = 0;
    return () => console.log(++cnt); // cnt 가 참조하고 있는 자유벼수까지 가지고 반환이 됨ㄴ
};

const closuereCounter = closuereCounterMaker();
closuereCounter();
closuereCounter();
closuereCounter();
// 자유변수 cnt는 외부에서 접근할 수 없다.