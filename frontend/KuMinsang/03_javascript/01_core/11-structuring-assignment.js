/**
 * 구조분해할당 Destructuring Assignment
 * - 비구조할당은 옛날 이름
 * - 배열/객체의 요소를 꺼내서 변수에 대입하는 문법
 */

/**
 * 1. 배열구조분해할당
 */
const arr = ['가', '나', '다'];
//기존의 코드
// const a = arr[0];
// const b = arr[1];
// const c = arr[2];
// console.log(a,b,c);

//구조분해 할당 시작
// const [a,b,c] = arr;
// console.log(a, b, c);

//인덱스별로 값 대입
// const [a, b] = arr;
// console.log(a, b); a=가, b=나

// const [a, ,b] = arr;
// console.log(a , b);    //a = 가, b = 다

// const [a, b, c, d] = arr;
// console.log(a, b, c, d); //가 나 다 undefined //d의 값이 없으므로 undefined
const [a, b, c, d = 'wow'] = arr;
console.log(a, b, c, d);    //가 나 다 wow

//자리교환
let x = 10;
let y = 20;

[x,y] = [y,x];
console.log(x,y);   //20 10

//나머지
const [m, n, ...rest] = [1,2,3,4,5,6,7,8,9,10];
console.log('m = ' + m);
console.log('n = ' + n);
console.log('rest = ' + rest);

/**
 * 함수매개변수부 사용
 */
const test1 = ([name, kor, eng, math]) =>{
    console.log(name, kor, eng, math);
    console.log(`${name}학생의 평균점수는 ${Math.round( (kor+eng+math) / 3)}점 입니다.`);
};

test1(['홍길동', 95, 85, 77]);
test1(['신사임당', 100, 88, 99]);

/**
 * 함수 리턴값 처리에 사용
 */
const test2 = (a,b) => [a + b, a - b, a * b, a / b, a % b];
const result = test2(30,20);
console.log(result);

const [sum, diff, product, quotient, remainder] = test2(30, 20);
console.log(sum, diff, product, quotient, remainder);

//=====================================================================
/**
 * 2. 객체 구조 분해 할당
 * - 속성 값을 변수에 옮겨 담는 문법
 * - 속성명 기준으로 요소를 탐색
 */
const obj = {
    id : 123,
    name : '홍길동',
    bool : true
};

//풀어 쓰기
// const id = obj.id;
// const name = obj.name;
// const bool = obj.bool;

// console.log(id, name, bool);

//객체구조 분해할당 문법
// const {id, name, bool, hobby} = obj;
// console.log(id, name, bool, hobby); //123 홍길동 true undefined

// const {id, name, bool, hobby='축구'} = obj;
// console.log(id, name, bool, hobby); //123 홍길동 true 축구

//원래는 객체의 이름과 분해한 이름이 같아야 하지만 이름으 바꿔서 할당하는 방법이 있다
// const { id : code} = obj;
// console.log(code);

//중첩된 객체 구조분해할당
const user = {
    id : '1234561234',
    name :{
        firstName : '길동',
        lastName : '홍'
    },
    hobby : ['축구', '풋살', '싸커']
}
const {name : {lastName, firstName}, hobby : [mainHobby, secondHobby]} = user;
console.log(firstName, lastName);
console.log(mainHobby, secondHobby);

/**
 * 취미핸들러
 */
const test3 = ({hobby}) =>{
    console.log(hobby);
}

/**
 * 이름핸들러
 */
const test4 = ({name : {firstName, lastName}}) => {
    console.log(`안녕하세요~ ${lastName}가의 ${firstName}님`);
}

const user2 = {
    hobby : ['합비합비합비', '해피해피해피']
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
};

const {name, url, tel : [tel1, tel2], branches : {'강남 지원' : branch1, '삼성 지원' : branch2}} = data
// const {name, url, tel : [tel1, tel2], branches} = data

console.log(name);
console.log(url);
console.log(tel1);
console.log(tel2);
// console.log(branches);
console.log(branch1);
console.log(branch2);

