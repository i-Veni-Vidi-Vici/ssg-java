/**
 * 구조분해할당
 * - 배열/객체의 요소를 꺼내서 변수에 대입하는 문법
 */

/**
 * 1. 배열구조분해할당
 */
const arr = ['가', '나', '다'];

// const [a, b, c] = arr;
// console.log(a, b, c);

// const [a, , b] = arr;
// console.log(a, b);

// const [a, b, c, d] = arr;
// console.log(a, b, c, d); // 가 나 다 undefined

// 자리교환
let x = 10;
let y = 20;
[x, y] = [y, x];
console.log(x, y);

// 나머지 파라미터
const [m, n, ...rest] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
console.log(m, n, rest);

/**
 * 함수 매개변수부 사용
 */

// const test1 = ([name, kor, eng, math]) => {
//   console.log(name, kor, eng, math);
// };
// test1(['홍길동', 95, 85, 77]);

// const test2 = (a, b) => [a + b, a - b, a * b, a / b, a % b];
// const [sum, diff, product, quoient, remainder] = test2(30, 20);
// console.log(sum);

// const obj = {
//   id: 123,
//   name: '홍길동',
//   bool: true,
// };

// const { id, name, bool } = obj;
// console.log(id);
// const { id: code } = obj;
// console.log(code);

// 중첩된 객체 구조분해할당
// const user = {
//   id: '123412341',
//   name: {
//     firstName: '길동',
//     lastNAme: '홍',
//   },
//   hobby: ['축구', '풋살', '사커'],
// };

// const {
//   name: { firstName, lastNAme },
//   hobby: [mainHobby, secondHobby],
// } = user;

// console.log(firstName, lastNAme);
// console.log(mainHobby, secondHobby);

// /**
//  * 취미 핸들러
//  */
// const test3 = ({ hobby }) => {
//   console.log(hobby);
// };

// /**
//  * 이름 핸들러
//  */
// const test4 = ({ name: { firstName, lastNAme } }) => {
//   console.log(`hi ${lastNAme} ${firstName}`);
// };

// test3(user);
// test4(user);

const academy = {
  name: 'SSG 아카데미',
  url: 'https://ssg-academy.co.kr',
  tel: ['070-1234-5678', '070-8888-9999'],
  branches: {
    '강남 지원': { addr: '서울시 강남구 역삼동' },
    '삼성 지원': { addr: '서울시 종로구 탑골동' },
  },
};
const {
  name,
  url,
  tel: [tel1, tel2],
} = academy;
console.log(name, url, tel1, tel2);
const {
  branches: { '강남 지원': branch1, '삼성 지원': branch2 },
} = academy;

console.log(branch1);
console.log(branch2);
