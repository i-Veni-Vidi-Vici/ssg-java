/**
 * calculator 라는 객체에 아래와 같은 메소드를 정의하고 메소드 실행을 테스트 한다.
 * sum 메소드 : 객체의 a, b 두 값의 합을 반환multi 메소드 : 객체의 a, b 두 값의 곱을 반
 */

const calculator={
    sum(a,b){
        return a+b;
    },
    minus(a,b)
    {
        return a-b;
    },
    multi(a,b)
    {
        return a*b;
    }
}
console.log("3-1, 리터럴 방식, 합, 곱");
console.log("합 : " +calculator.sum(30,200));
console.log("곱 : "+calculator.multi(10,20));

function Calculator(a,b){
    this.a=a;
    this.b=b;
    this.sum=function(){
        return a+b;
    }
    this.multi=function(){
        return a*b;
    }

};
console.log("3-2, 생성자 방식, 합, 곱");
var calculator1=new Calculator(10,20);
console.log(calculator1.sum());
console.log(calculator1.multi());
