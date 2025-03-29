/**
 * 동기적 synchronous 짝을 맞춘다. (함수 호출-리턴과 그 다음 실행코드 짝을 맞춘다.)
 * 비동기적 asynchronous 짝을 맞추지 않는다. 
 * 
 * - js runtime은 싱글쓰레드로 작동하다. 
 * - 시간이 오래 소요되거나 종료시점을 알수 없는 함수(timer api, dom처리, event핸들링, 네트워크 요청)들은 백그라운드로 미뤄뒀다가 이후에  실행한다.
 */
const foo = () => 100;

const value = foo();
console.log(value);

let value2;
// setTimeout함수를 실행하면, millis초 이후 실행될 함수를 백그라운드에 등록하고, 바로 하단의 코드를 실행
setTimeout(() => {
  value2 = 200;
  console.log('local', value2);
}, 3000);
console.log('global', value2);

/**
 * JS Runtime 환경
 * - call stack 함수(메소드) 실행공간 LIFO
 * - heap 모든 객체 생성되는 공간
 * 
 * - Web API's 비동기처리 함수들 적재
 * - Callback Queue 비동기처리 함수가 실행될 타이밍에 이 공간으로 전달. FIFO
 * - Event Loop Call Stack이 비어있는 경우, Callback Queue의 첫번째 함수를 callstack 밀어넣는다.
 */
document.querySelector("#btn1").addEventListener('click', () => {
  const script = document.createElement('script');
  script.src = 'js/test.js';
  script.onload = () => {
    console.log('script load 완료!');
    bar();
  };
  document.body.append(script); // 비동기처리
  // bar(); // Uncaught ReferenceError: bar is not defined
});