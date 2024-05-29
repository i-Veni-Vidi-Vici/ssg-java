/**
 * object 
 * - 속성 / 메소드를 가진 자료형
 * - js 유일한 객체형
 * - object / array / function 특별한 자료형을 지원하고 있음.
 * - 속성은 속성명 / 속성값으로 구분되고, 모든 자료형을 지원
 * - 보통 속성명은 식별자(문자열)를 사용한다.
 * 
 * 나머지 자료형은 다 원시형
 */

/**
 * 객체 생성 
 * 1. literal로 생성{}
 * 2. new 연산자 이용 
 */

const user = {
    name : '홍길동',
    age : 23,
    married : true,
    sns : ['tiktok','instagram','facebook'],
    //속성값의 타입이 function인 경우, '메소드'라고한다. 
    hi : function(){
        //현재 객체의 속성을 참조하는 경우 this르 사용해야한다.
        console.log(`HI~~~~!!!${this.name}`);
    },
    pet : {
        petName : '복실이',
        age : 3,
    },
    100 : '홍길동100',
    "user-car" : '소나타',
    "user favorite food" : '물회'
};// 코드 블럭(if, for ,function)이 아니므로 ;로 종결처리

console.log(user) // 


/**
 * 속성 참조
 * 1. dot notation
 */
console.log(user.name);
console.log(user.age);
console.log(user.name);
console.log(user.married);
console.log(user.sns);
console.log(user.pet);
console.log(user.hi);


// 메소드 호출
user.hi();

//2. bracket notaion
//식별자가 아닌 속성명은 bracket notaino으로만 호출이 가능하다.
console.log(user['name']);
console.log(user['age']);
console.log(user['married']);
console.log(user['sns']);
console.log(user['sns'][0]);
console.log(user['pet']);
user['hi']();

console.log(user[100]);
console.log(user['user-car']);
console.log(user['user favorite food']);

//bracket notation 사용시 주의사항
console.log(user['name']); //user의 name 속성 , 홍길동 user의 name 속성
const name = 'age'; 
console.log(user[name]); //23 user의 name 변수의 대입된 값 속성




/**
 * 모든 속성은 동적으로 추가 / 수정 / 삭제가 가능하다.
 */
// const obj = {};
const obj = new Object();
console.log(obj);


// 속성 추가 
obj['id'] = 123;
obj['name'] = "장구";
obj.id = 123;
obj.name = '친구';
console.log(obj); 


//속성 수정 -> 기존 값에 덮어씌워짐
obj.name = '바보';
console.log(obj);

//속성 값 삭제 
obj.name = null;
console.log(obj);

//속성 삭제 : delete
delete obj.name;
console.log(obj);

/**
 * 객체 단축 속성 등록 
 * - property
 * - method/
 */

const id = 'p-001';
const price = 3000;
// const product = {
//     id : id,
//     price : price
// };

// 속성명 : 변수명 , 속성값 : 변수값 
const product = {
    id,
    price
};

console.log(product);

//메소드 단축등록 - 메소드 : 객체 안에 들어가있는 속성
const car = {
    name : '소나타',
    // run : function(){
    //     console.log(`${this.name} 부르릉`);
    // }    
    run(){
        console.log(`${this.name} 부르릉`);
    }    
};

car.run()

//함수 등록은 해당사항이 없다.
function foo(){}
// for(){}

/**
 * 객체 사용법 
 * - namespace와 같이 사용하는것을 추천한다.
 * - nmaespace : 하위에 있는것들을 구별하는 역할 
 * - 속성 / 메소드를 객체라는 namespace로 구분지어 관리할 수 있다.
 */

const calculator ={
    plus(a,b){return a+ b;},
    minus(a,b){return a-b},
    multi(a,b){return a*b},
    divide(a,b){return a/b},
    remainder(a,b){return a%b}
}

console.log(calculator.plus(10,20));
console.log(calculator.multi(10,20));
console.log(calculator.minus(10,20));
console.log(calculator.divide(10,20));
console.log(calculator.remainder(10,20));

/**
 * 객체 반복 처리
 * - for..in
 * - Object.keys() : 속성 모음
 * - Object.values() : 값 모음
 */

const menu = {
    name : '순대국',
    price : 10000,
    options : ['안매운', '보통','매운']
}

//for in문 (enumerable : true 인 속성들을 순회)
// - 객체의 모든 속성을 조회
// - 배열에 대해서 
for(const key in menu){
    console.log(`key = ${key}, value = ${menu[key]}`);
    
}

//Object.keys() : key값만 배열로 전환
Objects.keys(menu);

//Object.values() : value값만큼 배열로 반환 
console.log(Object.values(menu)); 

//in 연산자
//객체에 속성이 존재하는지 여부반환
const student ={
    name : '홍길동',
    age : 33
}

console.log("name" in student);
console.log("score" in student);

//student 객체에 school 속성이 없으면 , school : 'ssg학교'를 추가하는 코드를 작성해보세요 

"school" in student || (student.school = 'SSG학교')

















