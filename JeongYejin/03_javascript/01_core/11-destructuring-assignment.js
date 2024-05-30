/**
 * 구조분해할당 Destructuring Assignment
 * - (전)비구조화할당
 * - 배열/객체의 요소를 꺼내서 변수에 대입하는 문법
 */

/**
 * 1. 배열구조분해할당
 */

const arr = ['가', '나', '다'];
// const a = arr[0];
// const b = arr[1];
// const c = arr[2];

// const [a, b, c] = arr;
// console.log(a, b, c);
// console.log(a);
// console.log(b);
// console.log(c);


// 인덱스별로 값대입
// const [a, b] = arr; // 0, 1
// const [a, , b] = arr; // 0, 2
// console.log(a, b);

// const [a, b, c, d] = arr; // 해당인덱스의 값이 존재하지 않으면, undefined를 반환
const [a, b, c, d = 'zzz'] = arr; // 주어진 값이 없다면 기본값을 사용한다
console.log(a, b, c, d);

// 자료교환

let x = 10;
let y = 20;
[x, y] = [y, x];
console.log(x, y);

// 나머지 파라미터
const [m, n, ...rest] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
console.log(m, n, rest);

// 전개연산자와 구별하는 법
// 공간(변수)으로 처리되는지 값으로서 처리되는지

/**
 * 함수 매개변수부 사용
 */
const test1 = ([name, kor, eng, math]) => {
    console.log(name, kor, eng, math);
    console.log(`${name}학생의 평균점수는 ${Math.round((kor + eng + math) / 3)}점입니다.`);
    
};

test1(['홍길동', 95, 85, 77]);
test1(['신사임당', 100, 88, 99]);

/**
 * 함수 리턴값 처리에 사용
 */
const test2 = (a, b) => [a+b, a-b, a*b, a/b, a%b];
const [sum, diff, product, quotient, remainder] = test2(30, 20);
console.log(sum, diff, product, quotient, remainder);

/**
 * 2. 객체구조분해할당
 * - 속성값을 변수에 옮겨담는 문법. 
 * - 속성명기준으로 요소를 탐
 */

const obj = {
    id : 123,
    name : '홍길동',
    bool : true
};

// const id = obj.id;
// const name = obj.name;
// const bool = obj.bool;

// const {id, name, bool} = obj;
// const {id, bool, name, hobby = '축구'} = obj;
// console.log(id, name, bool, hobby);

const {id : code} = obj;
// console.log(id); // ReferenceError: id is not defined
console.log(code);

// 중첩된 객체 구조분해할당
const user = {
    id : '12345123434',
    name : {
        firstName: '길동',
        lastName: '홍'
    },
    hobby : ['축구', '풋살', '싸커']
};

const {name : {firstName, lastName}, hobby: [mainHobby, secondHobby]} = user;
// 변수 선언이 아니다
console.log(firstName, lastName);
console.log(mainHobby, secondHobby);

/**
 * 취미 핸들러
 */
const test3 = () => {
    
}
/**
 * 이름 핸들러
 */
const test4 = ({name: {firstName, lastName}}) => {
    console.log(`안녕하세요~ ${lastName}가의 ${firstName}님~`);
}

test3(user);
test4(user);

const data = {
    name : 'SSG 아카데미',
    url : 'https://ssg-academy.co.kr',
    tel : ['070-1234-5678', '070-8888-9999'],
    branches : {
      '강남 지원' : { addr : '서울시 강남구 역삼동' },
      '삼성 지원' : { addr : '서울시 종로구 탑골동' }
    }
  }

const {name, url} = data;

// const [tel1, tel2] = tel;
// const {branches : {branch1, branch2}} = branches; (X)

const {tel : [tel1, tel2], branches : {'강남 지원' : branch1, '삼성 지원': branch2}} = data;

console.log(name);
console.log(url);
console.log(tel1);
console.log(tel2);
console.log(branch1);
console.log(branch2);





