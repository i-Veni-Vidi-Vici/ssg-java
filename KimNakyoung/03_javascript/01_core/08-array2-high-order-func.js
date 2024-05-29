/**
 * 고차함수 high-order function
 * - 함수를 인자를 받거나 리턴하는 함수
 */
// 이거 중요합니다 !

/**
 * sort(compareFunction) : 정렬된 기존배열 반환
 * - compareFunction : 두 요소를 비교후 정수를 반환
 */

const arr = [1,10,2,20,3];

// arr.sort(); // 기본 compare함수는 문자단위 비교 (사전등재순 지금 글자여서 10 보다 2가 더 늦은거)

arr.sort((a,b) => b - a); // 숫자내림차순 왜 마이너스지
//뒤에 있는 값이 클 때 변경이 일어나기 때문에, 큰 값은 뒤로 가게 되고 작은 값은 앞으로 오게 돼서 내림차순 정렬이 됩니다.

console.log(arr);

/**
 * forEach(loopFunction) : 각 요소별로 처리할 함수를 전달
 * - for문 대신 반복처리 가능한 함수
 */
const vegitables = ['오이','감자','당근','양파'];

vegitables.forEach((item,index,arr) => {
    console.log(item,index,arr);
});

/**
 * map(mappingFunction) : 새 요소로 구성된 배열반환
 * - mappingFunction의 반환갓이 새 배열의 요소가 된다.
 */

const squared = [1,2,3].map((item,index,arr) => {
    console.log(item,index,arr);
    return item * item;
});
console.log(squared);

['안녕','잘가','반가웠어']

// ['<p>안녕</p>', <p>잘가<p>', '<p>반가웠어</p>']

const pTags = ['안녕','잘가','반가웠어'].map((item) => `<p>${item}</p>`)
console.log(pTags);

/**
 * filter(filterFunction) : 필터링된 새 배열 반환
 * - filterFuction 각 요소별로 true/false를 반환, true인 요소만 새 배열에 포함
 */
const evenNums = [1,2,3,4,5,6,7,8,9,10].filter((item,index,arr) => item % 2 == 0)
console.log(evenNums);// [ 2, 4, 6, 8, 10 ]

// 여태까지 모두 이뮤터블 방식 원본 그대로 두고 사본으로 변경함 

/**
 * reduce ( aggFuction,initValue) : resultValue 배열요소에 대한 연산후 결과값을 하나로 반환하는 한수
 */
const sum = [1,2,3,4,5,6,7,8,9,10].reduce((value,item,index,arr) => {
    console.log(value,item,index);
    return value + item;
    
});

console.log(sum);

const evens = [1,2,3,4,5,6,7,8,9,10].reduce((evens,item) => {
    if(item %2 == 0)
    evens.push(item);
    return evens;
}, []); 
console.log(evens);

/**
 * find(cbFunction): 특정조건을 만족하는 첫번째 요소를 반환
 * 
 * findIndex(cbFunction) : 특정조건을 만족하는 첫번째 요소의 인덱스 반환
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
    }
];
// 신사임당 학생이 존재하는가?
console.log(students.find((student) => student.name === '신사임당')); //{ name: '신사임당', score: 77 }
console.log(students.find((student) => student.name === '세종대왕')); //undefined
 

// 70점을 넘은 학생이 누구인가하는가? -> 한명만 찾고싶다면 이거 쓰기
console.log(students.findIndex((student) => student.score > 70)); // 0 왜냐면 찾으면 더이상 뒤까지 안보기땨문애 0번지
console.log(students.findIndex((student) => student.score > 90)); // -1 인덱스 따질 때 값이 없다면 ? -1

// 해당되는 모든 걸 보고 싶다면 필터써야됨! 여기서 핉어가 머임? 난 모름 일단 **

// 모든 학생이 60점 이상인가요?
console.log(students.every((student) => student.score >= 60)); // false
console.log(students.every((student) => student.score >= 50)); // ture

// 이 반에 이순신 학생이 있나요?
console.log(students.some((student) => student.name === '이순신')); // ture
console.log(students.some((student) => student.name === '논개')); // false








