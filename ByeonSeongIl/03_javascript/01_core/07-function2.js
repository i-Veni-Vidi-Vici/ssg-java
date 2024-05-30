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
 * 1. 즉시실행함수(IIFE)
 *  - Immediately Invoked Function Expression
 *  - 선언과 실행을 동시에 작성하는 함수
 *  - 1회용 (재사용할 수 없다.)
 */
(()=> {
    console.log("🐫");
})();

((k)=> {
console.log(k);
})('🐽');

// 전역스코프
let salad = "🐱‍🏍";
console.log(salad);

(()=>{
    // 지역스코프
    // 지역변수를 선언하고, 값을 보호하기 위해서 IIFE 사용한다.
    let salad = "🐾";
    console.log(salad);
})();

/**
 * 2. 재귀호출함수
 * - 함수 안에서 함수 자신을 다시 호출하는 경우
 * - 종료조건을 반드시 명시해야 한다. (stackover flow 오류가 발생할 수 있어 주의)
 */

// n! (factorial) = 1 * 2 * 3 * ... * n
// 5! = 1 * 2 * 3 * 4 * 5
const factorial = (n) =>{
    if(n==1) return 1; // 종료조건
    return n * factorial(n-1);
}

console.log(factorial(5));

/**
 * 3. 중첩함수
 * - 함수내부에 함수를 선언해 사용
 * - 내부함수를 굳이 노출할 필요가 없는 겨우 사용할 수 있다.
 */
// 10 -> 10, 3 -> 03
const outer = (n) => {
    const inner = k => k<10? '0' + k:k;
    console.log(inner(n));
};
outer(15); // 15
outer(7); // 07

/**
 * 4. 콜백함수 Callback
 *  - js의 함수는 일급객체(값)으로써 매개인자로 전달할 수 있고, 이를 함수 내부에서 호출할 수 있다.
 */
const a = (f) =>{
    f();
};

const b = () => console.log('🐨');
a(b);

/**
 * 5. 순수/비순수 함수
 * - 모든 함수에는 입력/출력이 있다.
 * - 함수에는 부입력/부출력이 있을 수 있다. (명시적으로 전달한 매개인자/리턴값외에 외부스코프의 값을 입력/출력으로 사용할 수 있다.)
 * 
 * - 순수함수 : 외부상태에 의존/변경하지 않는 함수
 * - 비순수함수 : 외부상태에 의존/변경하는 함수
 * 
 * - 되도록 순수함수를 사용하도록 하면 좋다.
 * - 순수함수를 이용해서 불변성을 추가하는 프로그래밍 방식이 함수형 프로그래밍이다.
 */


const pureFunc = n =>{
    return ++n;
}


let count = 0;
const impureFunc = (n)=>{
    count = count +1;
    return ++n;
}

console.log(impureFunc(1));
console.log(count);


/**
 * 자바스크립트에서 함수는 일급객체이다. (값으로써 취급한다.)
 * 1. 변수에 대입가능해야 한다.
 * 2. 함수호출시 전달이 가능해야 한다.
 * 3. 함수반환값으로 사용할 수 있어야 한다.
 * 
 * 함수형프로그래밍에서는 함수를 일급객체로 다루는 것이 중요하다.
 *  (자바는 람다를 통해서 우회적으로 위의 조건을 만족시킨다.)
 * 
 */
// 1. 값으로써 변수에 대입가능
const func =function(){
    console.log("aaaaa");
}
func();
const func2 = func;
func2();

console.log(func == func2); // true

// 2. 값으로써 매개인자로 사용
const runner = (f, count)=> {
    for(let i =0; i<count; i++)
        f();
};
runner(func, 5);

// 3. 값으로써 리턴값으로 사용
const carFactoryBuilder = () =>{
    return () => console.log('🐱‍🏍');
};
const carFactory = carFactoryBuilder();
console.log(carFactory);
carFactory();

// 매개변수 있는 함수
const myfunc =(n) => console.log('🐵'+n);

const runner2 =(f) => {
    for(let i =0; i<3; i++){
        f(i+ 1);
    }
};

runner2(myfunc);

// 어떤차를 n대 생산할건지 매개변수로 정해준다.
const carFactoryBuilder2= (car)=>{
    return (n) => {
        for(let i =0; i<n; i++){
            console.log(car);
        }
    };
};

const carFactory2 = carFactoryBuilder2('🐱‍💻');
carFactory2(3);

// 경찰차 factory를 지어서(함수) 10대 출력하세요.
const policeCarFactory= carFactoryBuilder2('🐕');
policeCarFactory(10);


/**
 * 6. Closure함수
 * - 자유변수 free variable : 함수 지역범위에서 선언되지 않은 변수
 * - 모든 자유변수가 전역변수인 것은 아니다.
 * 
 * 클로져함수란? 자유변수를 가지고 외부로부터 닫힌 함수
 * - 클로져가 가진 자유변수는 외부로부터 접근이 불가능하고, 안정하게 관리할 수 있다.
 */
const word = "안녕";

// word는 greeting의 자유변수이다.
const greeting = (name) => {
    const word2 ="반가워";
    console.log(`${word}, ${name}, ${word2}`);
};
greeting('길동');


function yoo(){
    let num = 100;
    return () => {
        num+=1;
        console.log(`num = ${num}`);
    };
  }
  const num = 200;
  const too = yoo(); // closure함수 (자유변수 num(100)을 가지고 외부로부터 닫힌 함수)
  // const too = () => console.log(`num = ${num}`); 
  console.log(too);
  too(); // 101
  too(); // 102

  let cnt = 0;
  const globalCounter = () =>console.log(++cnt);
  globalCounter();
  globalCounter();
  globalCounter();
  cnt = 100;
  globalCounter();
  globalCounter();
  globalCounter();

const closureCounterMaker = ()=>{
    let cnt =0;
    return () => console.log(++cnt);
};
const closureCounter = closureCounterMaker();
closureCounter();
closureCounter();
closureCounter();
// 자유변수 cnt는 외부에서 접근할 수 없다.
// closureCounterMaker()();