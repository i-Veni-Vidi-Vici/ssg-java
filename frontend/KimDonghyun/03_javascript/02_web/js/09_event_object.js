/**
 * 이벤트객체 
 * - 이벤트 발생시, 이벤트관련 다양한 정보를 가진객체가 동적으로 생성한다. 
 * - 핸들러의 첫번째 인수로 전달된다. 
 * - attribute방식에서는 event이름으로 직접 전달해야 한다. 
 * 
 * 이벤트발생객체 
 * - 이벤트객체의 target속성은 이벤트가 발생한 태그객체이다. 
 * - 이벤트핸들러의 this숨은 참조는 이벤트발생객체이다. (화살표함수는 다르다.)
 * - 화살표함수안의 this는 실제이벤트 발생객체가 아니라, window등 다른 객체이다.
 *   (화살표는 자체적인 this가 없고, 부모스코프의 this를 가져다 쓴다.)  
 * 
 * 
 * - window객체 : 브라우져상의 최상위객체(node상에서의 global이라 생각하면 된다.)
 */

const $btn = document.querySelector("#btn");

console.log(this); // 전역에서 호출한 this는 window최상위 객체이다.

$btn.onclick = function(e){
  console.log('click', e);

  // event.target 이벤트 발생 태그객체 
  console.log(e.target, this);
  // e.target.value = 'clicked';
  this.value = 'clicked!!!!';
};

const $area = document.querySelector(".area");
$area.addEventListener('click', (ev) => {
  console.log('click', ev); 
  const {clientX, clientY} = ev;

  const $coords = document.querySelector("#coords");
  $coords.innerHTML = `(${clientX}, ${clientY})를 클릭했습니다. `;

  console.log(ev.target, this);
  // this.style (X)
  ev.target.style.backgroundColor = 'yellow';
});

/**
 * attribute방식에서 이벤트 객체 가져오기
 * - inline에 호출코드에서 이벤트객체를 전달해야 하는데, 이때 이름은 event 고정!
 * - attribute로 작성한 내용은 on이벤트 메소드의 몸통으로 전달된다. 
 * - on이벤트 메소드의 이벤트객체 매개변수명이 event이므로, 이를 그대로 사용해야 하는 것이다.
 */
const test1 = (e) => {
  console.log('click', e); 
};
const $btnAttr = document.querySelector("#btn-attr");
console.log($btnAttr.onclick);
/*
ƒ onclick(event) {
test1(event); console.log(1234);
}
*/

