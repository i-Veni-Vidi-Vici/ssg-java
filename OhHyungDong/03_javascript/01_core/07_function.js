/**
 * 함수 function
 * 
 * 함수생성
 * 1. 함수선언식(호이스팅처리 됨) function foo(){}
 * 2. 함수표현식(호이스팅처리 안됨) const foo = function(){};
 * 
 * Hoisting이란?
 * - 실제실행전에 자바스크립트 실행엔진에 의해 함수선언식은 먼저 끌어올려서 처리됨.
 * 
 */

/**
 * 함수 선언식 Function Declaration
 */ 
foo('홍길동');
// 함수 선언식은 호이슽팅 처리가 되기 때문에 미리 호출해도 됨.
function foo(name) {
  console.log(`안녕, ${name}`);
}

foo('홍길동');

/**
 * 함수 표현식 Function Expression
 * - 우항의 선언된 함수명은 무시된다. 
 * - 함수는 선언된 변수명으로 호출해야 한다. 
 * - 보통은 이름을 생략한 익명함수를 우항에 작성한다.
 */
// bar('신사임당'); // ReferenceError: Cannot access 'bar' before initialization
const bar = function (name) {
  console.log(`잘가, ${name}`);
};

bar('신사임당');


/**
 * 자바스크립트에서 함수는 일급객체이다. 
 * 1. 변수에 대입가능해야 한다. 
 * 2. 함수호출시 전달이 가능해야 한다. 
 * 3. 함수반환값으로 사용할 수 있어야 한다. 
 * 
 * 함수형프로그래밍에서는 이 함수는 일급객체로 다루는 것이 중요하다. 
 * (자바는 람다를 통해서 우회적으로 위의 조건을 만족시킨다.)
 */

//1. 값으로써 변수에 대입 가능 
const func = function(){
  console.log(`🚗🚗🚗`);
};



/**
 * 매개변수/매개인자 
 */
const hi = function(name) {
  if(arguments.length !== 1 || typeof name != 'string')
    throw new Error(`name인자가 유효하지 않습니다 : ${name}`);
  console.log(`안녕, ${name}`); 

  // arguments 숨은 참조 변수 : 호출시 전달한 모든 매개인자를 배열로 가지고 있다.
  // 유효성검사용으로 사용가능하다.
  console.log(arguments);
  

};
const name = '이순신';
hi(name); // 안녕, 이순신
// hi(); // 안녕, undefined
// hi('이순신', '세종대왕'); // 안녕, 이순신 (선언되지 않은 매개변수 자리에는 전달하는 매개인자는 무시된다.)

/**
 * 나머지 파라미터 Rest Parameter : 매개변수부에서 복수개의 값을 처리할 수 있는 변수 
 * - 선언부에 존재
 * 전개연산자 Spread Operator : 배열의 요소를 뿌려서 전달(매개인자 / 값)
 * -
 * 파라미터 기본값 : 매개인자가 존재하지 않는 경우(undefined) 지정한 기본값 사용 가능 
 */


function test1(id,...chars){
    console.log(id,chars);
}

// function test2(id,id2, ...chars){
//   console.log(id, id2, chars);
  
// }
// test2(1,2,'나','다','라','마');


test1(123,'가','나','다');
test1(456,'가','나','다','라');

console.log('!!!!!!!!!!!!!!!!!!!!!!!!!!!!!');

function test2(a,b,c){
    console.log(a,b,c)
};
const arr = [1,2,3];
test2(arr[0],arr[1],arr[2]);
test2(...arr);

//전개 연산자는 여러개 나열이 가능하다.
const arr1 = ['🚒'];
const arr2 = ['🚒','📖'];
// const arr3 = 1
// const arr4 = 2
// test1(...arr1, ...arr2, arr3,arr4);
// test2(...arr1, ...arr2, ...arr3, ...arr4) 이거는 또 출력이 안돼 에러 생겨서
//매개 인자를 4개나 준거라고 생각하는데 어떻게 출력이 되는걸까요 ?

function test3(x, y = 8888, z){
    console.log(x,y,z);
 
}

//파라미터 기본값 
test3(10,20,30);
test3(100);
// y,z의 값이 전달되지 않았지만 ,undefined인 경우 기본값이 전달 y의 기본값 : 8888, z : undefined
test3(100,undefined,200);// 100 8888 200

test3(100,null,300);// 100 null 300


/**
 * 리턴값 처리
 * - 모든 자바스크립트 함수는 최소한 undefined를 리턴한다. 
 */
const hello = function(){
  // return 'ㅋㅋㅋ';
  return;
};

const result = hello();
console.log(result, typeof result); // 123 number


/**
 * 화살표 함수 Arrow function
 * - 익명함수를 간단히 작성할 수 있는 문법
 * - (매개변수 부) => {함수 실행부}
 * 
 * - 생성자 함수로 사용할 수 없다.
 * - 함수 자체의 this가 없고, 부모 scope의 this를 가져온다.
 * 
 */

// const myArrow = function(a,b){

//     return a+b;
// }
/**
 * 1. function 키워드를 생략하고, =>를 사용해 매개변수부와 몸통부 연결
 * 2. 몸통부에 return절을 생략({return}; 구문 한줄만 존재 할 때)
   3. 몸통부의 {} 생략 -> 실행코드가 한줄 인경우
   4. 매개변수가 1개인 경우 , 소괄호 생략 가능 
*/
const myArrow = (a,b) => a+b;
const myArrow2 = (k) => console.log(k);
console.log(myArrow(10,20));
const myArrow3 = m => m*m;
myArrow2('🚛')
console.log(myArrow(3));




//1. 값으로써 변수에 대입 가능 
// const func = function(){
//     console.log(`🚗🚗🚗`);
//   };
 
  
const func2 = func; //func2에다가 func가 가리키는 함수의 주소값을 대입 
func2()
const f = func;
f();
console.log(func == func2); //true 사용 

//2. 값으로써 매개인자 사용 
const runner = (f,count) =>{
    
    
    for(let i = 0; i<count; i++){
        f();
    }
    f();
};
runner(func,5)

//3. 값으로써 리턴값으로 사용
const carFactoryBuilder = () => {
    return() => console.log('🛻');
};

const carFactory = carFactoryBuilder();//() => console.log('🛻');, 이것도 결국함수
console.log(carFactory); //Function (anonymous)
carFactory();

//매개배변수 있는 함수 
const myfunc = (n) => console.log('👽' + n);

const runner2 = (f) => {
    for(let i = 0; i< 3; i++){
        f(i+1);
    }
}
runner2(myfunc);


//어떤 차를 n대 생산할건지 매개변수로 정해준다.
const carFactoryBuilder2 = (car) => {
    return(n) => {
        for(let i = 0; i<n; i++){
            console.log(car);
        }
    }
};
const fireCarFactory2 = carFactoryBuilder2('🚒');
//const fireCarFactory2에는 
// (n) => {
//     for(let i = 0; i<n; i++){
//         console.log('🚒');
//     }
// }
//이 전달되기 때문에 n값을 입력해줘야 한다.
fireCarFactory2(3);

const policeCarFactory = carFactoryBuilder2('🚓');
policeCarFactory(10);
