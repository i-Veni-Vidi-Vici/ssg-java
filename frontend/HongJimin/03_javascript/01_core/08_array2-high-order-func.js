/**
 * 고차함수 high-order
 * - 함수를 인자로 받거나 리턴하는 함수
 */

/**
 * sort(compareFunction) : 정렬된 기존 배열 반환
 * - compareFunction : 두 요소를 비교 후, 정수를 반환
 */

const arr = [2, 1, 10, 20, 3];

console.log("기본 compare 함수");
arr.sort(); // 기본 compare함수는 문자단위 비교(사전 등재순)
console.log(arr); // [ 1, 10, 2, 20, 3 ]
console.log();

console.log("숫자 오름차순 용 비교 함수");
arr.sort((a, b) => a - b);
console.log(arr); // [ 1, 2, 3, 10, 20 ]

console.log("숫자 내림차순 용 비교 함수");
arr.sort((a, b) => b - a);
console.log(arr); // [ 20, 10, 3, 2, 1 ]

/**
 * forEach(loopFunction) : 각 요소별로 처리할 함수를 전달
 * - for문 대신 반복처리 가능한 함수
 */
const vegitables = ['오이', '감자', '당근', '양파'];
vegitables.forEach((item, index, arr) => {
    console.log(item, index, arr);
})

vegitables.forEach((item, index) => {
    console.log(item, index);
})

/**
 * map(mappingFunction) : 새 요소로 구성된 배열 반환
 * - mappingFunction의 반환값이 새 배열의 요소가 된다.
 */
const squared = [1, 2, 3].map((item, index, arr) => {
    console.log(item, index + "번째 index", arr);
    return item * item;
})
console.log(squared);

const pTags = ['안녕', '잘가', '반가웠어'].map((item) => `<p>${item}</p>`);
console.log(pTags); // [ '<p>안녕</p>', '<p>잘가</p>', '<p>반가웠어</p>' ]

/**
 * filter(filerFunction) : 필터링된 새 배열 반환
 * - filterFunction 각 요소별로 true/false를 반환. true인 요소만 새 배열에 포함
 */
const evenNums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].filter((item, index, arr) => item % 2 == 0) // true로 남는 요소만 반환!
console.log(evenNums); // [ 2, 4, 6, 8, 10 ]

/**
 * reduce (addFunction, initValue) : resultValue 배열 요소에 대한 연산후 결과값을 하나로 반환하는 함수 -> filter를 대체해서 사용할 수 있음
 */
const sum = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].reduce((value, item, index, arr) => {
    console.log(value, item, index);
    return value + item;
}, 0);

console.log(sum); // 55

const evens = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].reduce((evens, item) => {
    if(item % 2 == 0)
        evens.push(item);
    return evens;
}, []);
console.log(evens);

/**
 * find(cbFunction) : 특정 조건을 만족하는 첫번재 요소를 반환 
 * findIndex(cbFunction) : 특정 조건을 만족하는 첫번재의 인덱스를 반환
 * every(cbFunction) : boolean 모든 요소가 특정 조건을 만족하는지 여부
 * some(cbFunction) : boolean 특정 조건을 만족하는 요소가 하나라도 있는지 여부
 */
const students = [
    {
        name : '홍길동',
        score : 87
    },
    {
        name : '신사임당',
        score : 77
    },
    {
        name : '이순신',
        score : 55
    }
];

// 신사임당 학생이 누구인가?
console.log(students.find((student) => student.name === '신사임당')); // { name: '신사임당', score: 77 } -> 조건에 만족하는 값을 반환함
console.log(students.find((student) => student.name === '세종대왕')); // undefined
console.log(students.find((student) => student.name === '이순신')); // { name: '이순신', score: 55 }

// 70점을 넘은 학생이 누구인가?
console.log(students.findIndex((student) => student.score > 70)); // 0
console.log(students.findIndex((student) => student.score > 90)); // -1

// 모든 학생이 60점 이상인가요?
console.log(students.every((student) => student.score >= 60)); // false -> 이순신땜에 false
console.log(students.every((student) => student.score >= 50)); // true

// 이 반에 이순신 학생이 있나요?
console.log(students.some((student) => student.name ==='이순신')); // true
console.log(students.some((student) => student.name ==='논개')); // false