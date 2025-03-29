// 구조분해 할당 Destructuring Assignment
// - 비구조화할당은 옛날 이름
// - 배열/객체의 요소를 꺼내서 변수에 대입하는 문법

// 🥨1. 배열구조분해할당
const arr = ["가", "나", "다"];
// const a = arr[0];
// const b = arr[1];
// const c = arr[2];

// ⛳인덱스 별로 값 대입
// const [a, b, c] = arr;
// console.log(a, b, c);

// ⛳인덱스 중간 건너뛰기도 가능
// const [a, b] = arr; // 0, 1
// const [a, , b] = arr; // 0, 2
// console.log(a, b); // 가 다

// ⛳존재하지 않는 인덱스의 값를 반환하면 undefined -> 오류 나지 않음!
// const [a, b, c, d = 'ㅋㅋㅋ'] = arr; // 가 나 다 ㅋㅋㅋ -> 기본값 할당
const [a, b, c, d] = arr;
console.log(a, b, c, d); //가 나 다 undefined

// ⛳자리교환
let x = 10;
let y = 20;
[x, y] = [y, x];
console.log(x, y); // 20 10

// ⛳나머지 파라미터
const [m, n, ...rest] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
console.log(m, n, rest); // 1   2   [ 3, 4, 5, 6, 7, 8, 9, 10];

/**
 * ⛳함수 매개변수부 사용
 */
const test1 = ([name, kor, eng, math]) => {
  console.log(
    `${name} 학생의 평균점수는 ${Math.round((kor + eng + math) / 3)}점 입니다.`
  );
};
test1(["홍길동", 95, 85, 77]); // 홍길동 학생의 평균점수는 86점 입니다.
test1(["신사임당", 100, 88, 99]); // 신사임당 학생의 평균점수는 96점 입니다.

/**
 * ⛳함수 리턴값 처리에 사용
 */
const test2 = (a, b) => [a + b, a - b, a * b, a / b, a % b];
const [sum, diff, product, quotient, remainder] = test2(30, 20);
console.log(sum, diff, product, quotient, remainder); //50 10 600 1.5 10

// 🥨2. 객체 구조 분해 할당
// - 속성 값을 변수에 옮겨 담는 문법
// - 속성명 기준으로 요소를 탐색
const obj = {
  id: 123,
  name: "홍길동",
  bool: true,
};
// const id = obj.id;
// const name = obj.name;
// const bool = obj.bool;

// const{id, name, bool} = obj; // 🎈순서는 중요하지 않음!
// const{id, bool, name} = obj;
// console.log(id, name, bool); // 123 홍길동 true

// const{id, bool, name, hobby = '축구'} = obj;
// console.log(id, name, bool, hobby); // 123 홍길동 true 축구

const { id: code } = obj;
// console.log(id); // ReferenceError : id is not defined -> 오류가 남
console.log(code); // 123

// ⛳중첩된 객체 구조분해 할당
const user = {
  id: "123412341234",
  name: {
    firstName: "길동",
    lastName: "홍",
  },
  hobby: ["축구", "풋살", "싸커", "볼링"],
};

const {
  name: { firstName, lastName },
  hobby: [mainHobby, secondHobby],
} = user; // mainHobby, secondHobby -> 변수를 선언한 것은 아님!!
console.log(firstName, lastName); // 길동 홍
console.log(mainHobby, secondHobby); // 축구 풋살

/**
 * 취미 핸들러
 */
const test3 = ({ hobby }) => {
  console.log(hobby);
};

/**
 * 이름 핸들러
 */
const test4 = ({ name: { firstName, lastName } }) => {
  console.log(`안녕하세요~! ${lastName}가의 ${firstName}님~~`);
};
test3(user); // [ '축구', '풋살', '싸커', '볼링' ]
test4(user); // 안녕하세요~! 홍가의 길동님~~

const data = {
  name: "SSG 아카데미",
  url: "https://ssg-academy.co.kr",
  tel: ["070-1234-5678", "070-8888-9999"],
  branches: {
    "강남 지원": { addr: "서울시 강남구 역삼동" },
    "삼성 지원": { addr: "서울시 종로구 탑골동" },
  },
};

const {
    name, 
    url, 
    tel : [tel1, tel2], 
    branches : {
      '강남 지원' : branch1, 
      '삼성 지원' : branch2
    }
  } = data;

console.log(name);
console.log(url);
console.log(tel1);
console.log(tel2);
console.log(branch1);
console.log(branch2);