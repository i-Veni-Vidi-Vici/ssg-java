/**
 * 고차함수 high-order function
 *   - 함수를 인자로 받거나 리턴하는 함수
 */

/**
 * sort(compareFunction): 정렬된 기존 배열 반환
 *   - compareFunction 두 요소를 비교 후 정수를 반환
 */

const arr = [2, 1, 10, 20, 3];

// arr.sort(); // [ 1, 10, 2, 20, 3 ] -> 기본 compare함수는 문자단위로 비교 (사전등재순)

arr.sort((a, b) => a - b); // 숫자 오름차순
arr.sort((a, b) => b - a); // 숫자 내림차순

console.log(arr);


/**
 * forEach(loopfunction) : 각 요소별로 처리할 함수를 전달
 *  - for문 대신 반복처리 가능한 함수
 */
const vagitables = ['오이', '감자', '당근', '양파'];

vagitables.forEach((item, index, arr) => {
    console.log(item, index, arr);
    
})

vagitables.forEach((item, index) => {
    console.log(item, index);
    
})

/**
 * map(mappingFunction): 새 요소로 구성된 배열반환
 *   - mappingFunction의 반환값이 새 배열의 요소가 된다.
 */
const squared = [1, 2, 3].map((item, index, arr) => {
    console.log(item, index, arr);
    return item * item;
});
console.log(squared);


// ['<p>안녕</p>', '<p>잘가</p>', '<p>반가웠어</p>']
const hello = ['안녕', '잘가', '반가웠어'].map((item) => {
    return `<p>${item}</p>`;
})
console.log(hello);

/**
 * filter(filterFunction): 필터링된 새 배열 반환
 *  - filterFunction 각 요소별로 true/false를 반환. true인 요소만 새 배열에 포함
 */
const evenNums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].filter((item, index, arr) => item % 2 == 0);
console.log(evenNums); // [ 2, 4, 6, 8, 10 ]

/**
 * reduce(aggFunction, initValue): resultValue 배열요소에 대한 연산 후 결과값을 하나로 반환하는 함수
 */
const sum = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].reduce((value, item, index, arr) => {
    console.log(value, item, index);
    return value + item;
}, 0);
console.log(sum);

const evens = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].reduce((evens, item) => {
    if(item % 2 == 0) {
        evens.push(item)
    };
    return evens;
}, []);
console.log(evens);

/**
 * find(cbFunction): 특정조건을 만족하는 첫번째 요소를 반환
 * findIndex(cbFunction) : 특정조건을 만족하는 첫번째 요소의 인덱스를 반환
 * every(cbFunction):boolean : 모든 요소가 특정조건을 만족하는지 여부 
 * some(cbFunction):boolean : 특정조건을 만족하는 요소가 하나라도 있는지 여부
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
console.log(students);
// 신사임당 학생이 존재하는가?
console.log( students.find((student) => student.name === "신사임당"));
console.log( students.find((student) => student.name === "세종대왕")); // undefined

// 70점을 넘은 학생이 존재하는가?
console.log(students.findIndex((student) => student.score > 70)); // 0
console.log(students.findIndex((student) => student.score > 90)); // -1

// 모든 학생이 60점 이상인가?
console.log(students.every((student) => student.score >= 60)); // false
console.log(students.every((student) => student.score >= 50)); // true

// 반에 이순신 학생이 있는가?
console.log(students.some((student) => student.name === "이순신")); // true
console.log(students.some((student) => student.name === "논개")); // false
