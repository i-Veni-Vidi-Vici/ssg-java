/*
고차함수 high-order function
- 함수를 인자로 받거나 리턴하는 함수
*/

/*
sort(compareFunction) : 정렬된 기존배열 반환
- compareFunction : 두 요소를 비교 후 정수를 반환
 */

const arr = [2,1,10,20,3];

// arr.sort(); // 기본 compare함수는 문자단위 비교 (사전등재순) 

// arr.sort((a,b) => a-b); // 숫자 오름차순 [ 1, 2, 3, 10, 20] . a - b는 a가 b보다 작으면 음수를 반환하므로, a가 b보다 앞에 오게 되어 오름차순으로 정렬됩니다.
arr.sort((a,b) => b-a); // 숫자 내림차순 [ 20, 10, 3, 2, 1 ]  b - a는 b가 a보다 작으면 음수를 반환하므로, b가 a보다 앞에 오게 되어 내림차순으로 정렬됩니다.

console.log(arr);

/**
 * forEach(loopFunction) : 각 요소별로 처리할 함수를 전달
 * - for문 대신 반복처리 가능한 함수
 */
const vegetables = ['오이','감자','당근','양파'];
vegetables.forEach((item, index, arr) => {
    console.log(item,index,arr); 
});
/*
오이 0 [ '오이', '감자', '당근', '양파' ]
감자 1 [ '오이', '감자', '당근', '양파' ]
당근 2 [ '오이', '감자', '당근', '양파' ]
양파 3 [ '오이', '감자', '당근', '양파' ]
*/

vegetables.forEach((item, index) => {
    console.log(item,index); 
});
/*
오이 0
감자 1
당근 2
양파 3
*/

/*
map(mappingFunction) : 새 요소로 구성된 배열반환
- mappingFunction의 반환값이 새 배열의 요소가 된다.
*/
const squared = [1,2,3].map((item,index,arr) => {
    console.log(item,index,arr);

    return item * item;
});
console.log(squared);

// map을 어디다 써먹을까?
['안녕','잘가','반가웠어']

// ['<p>안녕</p>','<p>잘가</p>', '<p>반가웠어</p>']
const pTags = ['안녕','잘가','반가웠어'].map((item) => 
    `<p>${item}</p>`
    // { return `<p>${item}</p>` } // 리턴에 두나 선언부에 두나 똑같다
);
console.log(pTags);

/**
 * filter(filterFunction) : 필터링된 새 배열 반환
 * - filterFunction 각 요소별로 true/false를 반환. true인 요소만 새 배열에 포함
 */
const evenNums =  [1,2,3,4,5,6,7,8,9,10].filter((item,index,arr) => item % 2 == 0);
console.log(evenNums); // [ 2, 4, 6, 8, 10 ]

/**
 * reduce(aggFuncion, initValue) : resultValue 배열요소에 대한 연산 후 결과값을 하나로 반환하는 함수
 * - sum
 */
const sum = [1,2,3,4,5,6,7,8,9,10].reduce((value,item,index,arr) => {
    console.log(value, item, index);
    return value + item;
}, 0); // initValue = 0; 0으로 두지않고 생략하면 55는 똑같이 나오지만 value가 1부터 시작한다.
console.log(sum); // 5

const evens = [1,2,3,4,5,6,7,8,9,10].reduce((evens,item) => {
    if(item%2 == 0) evens.push(item);
    return evens;
},[]);
console.log(evens); // [ 2, 4, 6, 8, 10 ]

/**
 * find(cbFunction) : 특정조건을 만족하는 첫번째 요소를 반환
 * 
 * findIndex(cbFunction) : 특정조건을 만족하는 첫번째 요소의 인덱스를 반환
 * every(cbFunction) : boolean 모든 요소가 특정조건을 만족하는지 여부 
 * some(cbFunction) : boolean 특정조건을 만족하는 요소가 하나라도 있는지 여부
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
    },
];

// 신사임당 학생이 존재하는가?
// item대신 student 사용
console.log(students.find((student) => student.name === '신사임당')); // { name: '신사임당', score: 77 }
console.log(students.find((student) => student.name === '세종대왕')); // undefined

// 70점을 넘은 학생은 누구인가?
console.log(students.findIndex((student) => student.score > 70)); // 0 (홍길동의 index인 0반환)
console.log(students.findIndex((student) => student.score > 90)); // -1 (해당없음)

// 모든 학생이 60점 이상인가요?
console.log(students.every((student) => student.score >= 60)); // false 이순신이 55점이여서 모두는 아니다
console.log(students.every((student) => student.score >= 50)); // true

// 이반에 이순신 학생이 있나요?
console.log(students.some((student) => student.name == '이순신')); // true
console.log(students.some((student) => student.name == '')); // false



