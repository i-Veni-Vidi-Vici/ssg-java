/**
 * - 실제 타입은 object
 * - 속성 명으로 index를 가지고, 속성값을 관리한다.
 * - length속성을 통해 요소수를 관리한다.
 * - 타입을 가리지 않고, 개수 제한없이 배열을 제어할 수 있다. (실제로는 하나의 타입 요소를 관리)
 */

/**
 * 배열 생성
 */
// 1. 리터럴 생성
const arr = [1, 2, 3];
console.log(typeof arr); // object

const arr2 = new Array('a','b', 'c');

/**
 * 배열 메소드
 * - Array.prototype객체(Array 부모객체)에 선언된 메소드를 자식 배열 객체에서는 선언 없이 이용할 수 있다.
 */
const foods = ['물회', '삼계탕', '초계국수', '물회'];

/**
 * indexOd(요소): 존재하는 요소의 인덱스 반환. 존재하지 않는다면 -1 반환
 */
console.log(`foods.indexOf('물회') : ${foods.indexOf('물회')}`);
console.log(`foods.lastindexOf('물회') : ${foods.lastindexOf('물회')}`);
console.log(`foods.indexOf('막국수') : ${foods.indexOf('막국수')}`);
console.log(`foods.includes('물회') : ${foods.includes('물회')}`);
console.log(`foods.includes('막국수') : ${foods.includes('막국수')}`);
/**
 * unshift(E) : 요소를 0번지에 추가
 * shift():E 0번지 요소를 제거 후 반환
 * push(E) 요소를 맨 마지막에 추가
 * pop():E 맨 마지막 요소를 제거 후 반환
 */
const stations = ['교대', '강남', '역삼'];
stations.unshift('서초');
stations.push('선릉');
console.log(stations.shift());
console.log(stations.pop());
stations.unshift(stations.pop())
console.log(stations);

/**
 * arr1.concat(arr1, arr2) : 두 배열의 요소를 합친 새 배열을 반환
 */
const chars1 = ['가', '나', '다'];
const chars2 = ['a', 'b', 'c'];
const chars = chars1.concat(chars2);
console.log(chars);
console.log(chars1,chars2);

/**
 * slice(startIndex, endIndex) : startIndex부터 endIndex전까지의 요소를 새 배열에 반환
 */
const origin = ['a', 'b', 'c', 'd', 'e'];
const copied1 = origin.slice(2,4);
console.log(copied1);
const copied2= origin.slice(2);
console.log(copied2);
console.log(origin);

/**
 * splice(startIndex, delCount, newItem1, newItem2, ...) : 삭제와 요소 추가를 동시에 하는 메소드(원본배열을 직접 수정)
 */
const editors = ['vscode', 'notepad', 'notion'];
const deletedItems = editors.splice(1,1,'intellij');
console.log(deletedItems);
console.log(editors);

/**
 * reversed() : 원본 배열의 순서를 뒤집어 반환 (mutable | in place 방식)
 * toReversed() : 순서가 뒤집힌 새 배열 반환 (immutable)
 */
let cars = ['소나타', '그랜져', '카니발'];
let cars2 = cars.toReversed();
console.log(cars2);
console.log(cars);
