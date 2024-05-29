/**
 * Array
 * - 실제 타입은 object
 * - 속성명으로 index를 가지고, 속성값을 관리한다.
 * - length 속성을 통해 요소수를 관리한다.
 * - 타입을 가리지 않고, 개수 제한없이 배열을 제어할 수 있다. (실제로는 하나의 타입 요소를 관리한다)
 */

/**
 * 배열 생성
 */
// 1. 리터럴 생성
const arr = [1, 2, 3];
console.log(typeof arr);  // object

// 2. new 연산자
const arr2 = new Array('가', '나' , '다'); // []
console.log(arr2);

// 3. Array.of
const arr3 = Array.of('a', 'b', 'c');
console.log(arr3);

// 길이제한이 없다. 
arr3[3] = 'd';
arr3[4] = 'e';
console.log(arr3);

// 값참조
console.log(arr3[0]);
console.log(arr3[1]);
console.log(arr3[2]);
console.log(arr3[3]);
console.log(arr3[4]);
console.log(arr3[5]); // undefined 존재하지 않는 요소를 참조시에도 오류가 발생하지 않는다.

//반복처리
for(let i = 0; i < arr3.length; i++){
    // console.log(arr3[i]);
    console.log(`arr3[${i}] : ${arr3[i]}`);
}

// for..in문의 변수에는 속성몀(인덱스)이 들어온다.
// length속성은 enumerable: false이므로 처리되지 않는다.
console.log(Object.getOwnPropertyDescriptors(arr3));

for(const i in arr3){
    console.log(`arr3[${i}] : ${arr3[i]}`);

}

// for..of문 (자바 foreach문과 흡사)
for(const value of arr3){
    console.log(value);
}


/**
 * 배열 메소드
 *  - Array.prototype 객체(Array의 부모객체)에 선언된 메소드를 자식 배열객체에서는 선언 없이 이용할 수 있다.
 * 
 */

const foods = ['물회', '삼계탕', '초계 국수', '수박', '물회', '냉면'];

/**
 * indexOf(요소): 존재하는 요소의 인덱스를 반환. 존재하지 않는다면 -1 반환
 */
console.log(`food.indexOf(물회) : ${foods.indexOf('물회')}`);     // food.indexOf(물회) : 0
console.log(`food.indexOf(물회) : ${foods.lastIndexOf('물회')}`) // food.indexOf(물회) : 4
console.log(`food.indexOf(막국수) : ${foods.lastIndexOf('막국수')}`) // food.indexOf(막국수) : -1
console.log(`food.includes(막국수) : ${foods.includes('막국수')}`) // food.inclunde(막국수) : false


/**
 * unshift(E) 요소를 0번지에 추가
 * shift(): E 0번지 요소를 제거 후 반환
 * push(E) : 요소를 맨 마지막에 추가
 * pop():E : 맨 마지막 요소를 제거 후 반환
 */ 

const stations = ['교대', '강남', '역삼'];

stations.unshift('서초');
stations.push('선릉');

console.log(stations.shift());
console.log(stations.pop());

// console.log(stations.pop());
stations.unshift(stations.pop())

console.log(stations);

/**
 * concat(arr1, arr2 ) : 두 배열의 요소를 합친 새 배열을 반환 (immutable)
 */

const chars1 = ['가', '나', '다']
const chars2 = ['a', 'b', 'c'];

// const chars = chars1.concat(chars2);
// console.log(chars);

// const chars = chars1.concat(chars2);

const chars = [...chars1, ...chars2];
console.log(chars);
console.log(chars1, chars2);

/**
 * slice(starIndex, endIndex) : statrtIndex부터 endIndex전 까지의 요소를 새 배열에 반환
 */

const origin = ['a', 'b', 'c', 'd', 'e'];
const copied1 = origin.slice (2,4 );
console.log(copied1);
const copied2 = origin.slice(2);
console.log(copied2);
console.log(origin);

/**
 * splice(startIndex, delCount, newItem1, newItem2, ... ) deletedItems : 삭제와 요소추가를 동시에 하는 메소드 (원본배열을 직접 수정)
 */
const editors = ['vscode', 'notepad', 'notion']
const deletedItems = editors.splice(1, 1, 'intellij');

console.log(deletedItems); // [ 'notepad' ]
console.log(editors); // [ 'vscode', 'intellij', 'notion' ]

/**
 * reversed() : 원본배열의 순서를 뒤집어 반환 (mutable | in place 방식)
 * toReversed() : 순서가 뒤집힌 새 배열반환 (imutable)
 */

let cars = ['소나타', '그랜져', '카니발'];
// cars2 = cars.reverse();
cars2 = cars.cars.toReversed();

console.log(cars2);