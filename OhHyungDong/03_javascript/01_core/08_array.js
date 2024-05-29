/**
 * Array
 * - 실제 타입은 object 
 * - 속성명으로 index를 가지고, 속성값을 관리한다.
 * - length 속성을 통해 요소수를 관리한다.
 * - 타입을 가리지 않고, 개수 제한없이 배열을  제어할 수 있다. (실제로는 하나의 타입요소를 관리)
 */

/**
 * 배열 생성 
 */

//1. 리터럴 생성 
const arr = [1,2,3];
console.log(arr); //object 

//2. new 연산자
const arr2 = new Array(); // []
console.log(arr2);

//3. Array.of
const arr3 = Array.of('a','b','c')
console.log(arr3);

//길이 제한이 없다. 동적으로 추가 가능 
arr3[3] = 'd';
arr3[4] = 'e';
console.log(arr3);

// 값 참조 
console.log(arr[0]);
console.log(arr[1]);
console.log(arr[2]);
console.log(arr[3]);
console.log(arr[4]);// undefined : 존재하지 않는 요소를 참조시에도 오류가 발생하지 앟는다.
console.log(arr[5]);// undefined : 존재하지 않는 요소를 참조시에도 오류가 발생하지 앟는다.

//반복처리 
for(let i = 0 ; i <arr3.length; i++){
        
    console.log(`arr[${i}] : ${arr3[i]}`);
}

//for .. in문의 변수에는 속성명(인덱스)이 들어온다.
//length 속성은 enumerable : false 이므로 처리되지 않는다.
console.log(Object.getOwnPropertyDescriptors);

for(const i in arr3){
    console.log(`arr[${i}] : ${arr3[i]}`);
}

//for..of문 (자바 for .. each문 )
for(const value of arr3){
    console.log(value);

}

/**
 * 배열 메소드 
 * - Array.prototyperorcp(Array 부모 객체)에 선언된 메소드를 자식 배열객체에서는 선언없이 이용할 수 있다.
 */

const foods = ['물회','삼계탕','초계국수','수박','물회','냉면'];
/**
 * indexOf(요소) : 존재하는 요소의 인덱스 반환. 존재하지 않는다면 -1반환
 *
 **/

console.log(`foods.indexOf('물회') : ${foods.indexOf('물회')}`);
console.log(`foods.indexOf('물회') : ${foods.lastIndexOf('물회')}`); 
console.log(`foods.indexOf('막국수') : ${foods.indexOf('막국수')}`);
console.log(`foods.indexOf('막국수') : ${foods.includes('막국수')}`);
console.log(`foods.indexOf('막국수') : ${foods.includes('막국수')}`);


 /**
  * unshift(E) : 요소를 0번지에 추가 
  * shift(E) : E 0번지 요소를 맨 마믹에 추가
  * push(E) : 요소를 맨 마지막에 추가 
    pop(E) : 맨 마지막에 요소를 제거 후반환
 */

    const stations= ['교대','강남','역삼']

    stations.unshift('서초');
    stations.push('선릉');

    console.log(stations.shift());
    console.log(stations.pop());

    stations.unshift(stations.pop());

    console.log(stations);
    
    /**
     * concat(arr1, arr2) : 두 배열의 요소를 합친 새 배열을 반환 
     */
    const chars1 = ['가','나','다'];
    const chars2 = ['a','b','c'];

    // const chars = chars1.concat(chars2);
    const chars = [...chars1, ...chars2] //스프레드 오퍼레이터
    console.log(chars);
    console.log(chars1,chars2);

    /**
     * slice(startIndex, endIndex) : startIndex부터 endIndex전까지의 요소를 새별에 반환(immutable 기존 원소를 건드리지 않음)
     */

    const origin = ['a','b','c','d','e'];
    const copied1 = origin.slice(2,4); // 2~3까지
    console.log(copied1);

    const copied2 = origin.slice(2);
    
    /**
     * splice(startIndex,delCount,newItem1,newItem2,..) : 삭제와 요소 추가를 동시에 하는 메소드(원본 배열 직접 수정)
     * 반환값 : 삭제된 배열의 요소를 배열로 반환 
     */

    const editors = ['vscode','notepad','notion'];
    const deletedItems = editors.splice(1,1,'intellij');
    console.log(deletedItems);
    console.log(editors);
    
/**
 * reversed() : 원본 배열의 순서를 뒤집어 반환 (mutable / inplace)
 * toReversed() : 순서가 뒤집힌 새로운 배열 반환 (immutable)
 */
    let cars = ['소나타','그랜져','카니발'];
    cars.reverse()
    console.log(cars);
    let cars2 = cars.toReversed()
    console.log(cars2);
    
    


