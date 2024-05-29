/**
 * 고차함수 high-order function
 * - 함수를 인자를 받거나 리턴하는 함수
 */

/**
 * sort(compareFunction): 정렬된 기존배열 반환
 * - compareFunction : 두 요소를 비교 후 정수를 반환
 */

const arr = [2, 1, 10, 20, 3];

//arr.sort(); //기본 compare함수는 문자단위 비교 (사전등재순)
// arr.sort((a ,b) =>{
//     return a-b;
// })
arr.sort((a,b)=>b-a);
console.log(arr);

/**
 * foreach(loopFunction) : 각 요소별로 처리할 함수를 전달
 * - for문 대신 반복처리 가능한 함수
 */

const vegitables = ['오이', '감자', '당근', '양파'];
vegitables.forEach((item, index, arr)=>{
    console.log(item, index, arr);
});

/**
 * map(mappingFunction): 새 요소로 구성된 배열반환
 * - mappingFunction의 반환 값이 새 배열의 요소가 된다.
 */

const squared = [1,2,3].map((item, index, arr)=> {
    console.log(item, index, arr);
    return item * item;
})
console.log(squared);

// ['안녕', '잘가', '반가웠어']
// ['<p>안녕</p>', '<p>잘가</p>', '<p>반가웠어</p>']

const hello = ['안녕', '잘가', '반가웠어'].map((item, index, arr) =>{
    return `<p>${item}</p>`;
});
console.log(hello);

/**
 * filter(filterFunction): 필터링된 새 배열 반환
 * - filterFunction 각 요소별로 true/false를 반환. true인 요소만 새 배열에 포함
 */
const evenNms = [1,2,3,4,5,6,7,8,9,10].filter((item, index, arr) => item %2 ==0)
console.log(evenNms);

/**
 * reduce (aggFunction, initValue): 각 배열요소(item)에 대한 연산 후 결과 값(value)을 하나로 반환하는 함수
 * 특정 값 하나를 찾거나 요소 전체의 연산 결과를 반화하는데 특화 되어 있음
*/
console.log('----------reduce -------------');
const sum = [1,2,3,4,5,6,7,8,9,10].reduce((value, item, index, arr)=> {
    // console.log(value, item, index, arr);
    return value + item;
});

console.log(sum);

const evens = [1,2,3,4,5,6,7,8,9,10].reduce((evens, item) => {
    // console.log(evens, item);
    if(item % 2 == 0)
        evens.push(item);
    return evens;
}, []);
console.log(evens);

/**
 * findIndex(cbFunction) : 특정 조건을 만족하는 첫번째 요소를 반환
 */
const students = [
    {
        name : '홍길동',
        score : 87
    },
    {
        name : '신사임당',
        score : 55
    },
    {
        name : '이순신',
        score : 90
    },
];
// 이름이 신사임당인 학생이 누구인가?
console.log(students.find((student => student.name ==='신사임당'))); 
console.log(students.find((student => student.name ==='세종대왕'))); 

// 70점을 넘은 학생이 누구인가?
console.log('70점을 넘은 학생');
console.log(students.find((student) => student.score > 70));    //첫번째 요소를 반환함

// 인덱스를 반환
console.log('70점을 넘은 학생은 누구인가');
console.log(students.findIndex((student) => student.score > 70));    //첫번째 요소를 반환함
console.log(students.findIndex((student) => student.score > 88));    //첫번째 요소를 반환함

//모든 학생의 정보
console.log(students.every((student) => student.score >= 60));    //false
console.log(students.every((student) => student.score >= 50));    //true

// 이 반에 이순신이 있는가
console.log(students.some((students)=> students.name == '이순신')); //true
console.log(students.some((students)=> students.name == '박철순')); //false
