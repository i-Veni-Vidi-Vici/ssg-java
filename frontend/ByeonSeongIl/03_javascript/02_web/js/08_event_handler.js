/**
 * 이벤트
 * - 웹페이지상에 일어나는 모든 것은 이벤트
 * - 특정태그에 발생한 이벤트를 처리하기 이벤트핸들러를 작성할수 있다.
 * - 특정태그에 이벤트가 발생하면, 연결된 이벤트핸들러가 있는 경우 자동으로 호출한다. 
 * - 연결된 이벤트가 없다면, 해당이벤트 소실된다. 
 * - 이때 이벤트 핸들러의 첫번째 매개인자로 이벤트 관련 정보를 가진 이벤트객체가 전달된다.
 * 
 * 이벤트 핸들러 작성방법
 * 1. attribute 작성 (inline)
 * 2. property 작성
 * 3. addEventListener 작성
 * 
 * 
 */


/**
 * attribute 방식
 */
const test1 = () => {
  console.log('click 🥝');
};
const test2 = () => {
  console.log('mouseover 🍓');
};
const test3 = (event, food) => {
  console.log('mouseout ', food);
  console.log(event);
};
const $btnAttribute = document.querySelector("#btn-attribute");
$btnAttribute.onclick = null; // 핸들러 삭제

/**
 * property 방식
 * - 하나의 이벤트에 하나의 핸들러 작성가능
 */
const $btnProperty = document.querySelector('#btn-property');
$btnProperty.onclick = () => {
  console.log('click 🚗');
};
$btnProperty.onmouseover = () => {
  console.log('mouseover 🚎');
};
$btnProperty.onclick = () => {
  console.log('click 🚜');
};
$btnProperty.onclick = null;

/**
 * addEventListener 방식
 * - 하나의 이벤트에 여러개의 핸들러 작성가능(등록된 순서대로 실행)
 */
const $btnAddEventListener = document.querySelector('#btn-add-event-listener');
const clickHandler1 = () => {
  console.log('click1');
};
$btnAddEventListener.addEventListener('click', clickHandler1);
$btnAddEventListener.addEventListener('click', () => {
  console.log('click2');
}); // 익명함수로 등록시 삭제가 불가능하다.

$btnAddEventListener.removeEventListener('click', clickHandler1);