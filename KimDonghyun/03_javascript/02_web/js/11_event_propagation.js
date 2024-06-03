/**
 * Event 전파 
 * 
 * Event 발생 단계 
 * 1. 캡쳐링 단계 : 발생한 이벤트는 DOM Tree부터 해당 객체를 찾는다.
 * 2. 타겟 단계 : 이벤트 발생객체를 찾았을때, 해당 이벤트핸들러 호출
 * 3. 버블링 단계 : 발생한 이벤트는 DOM Tree를 타고 최상위 조상요소까지 전파된다.
 *  - 이벤트핸들링 타겟객체가 아닌 부모태그에서 집중적으로 처리 가능하다.
 */
const $box1 = document.querySelector("#box1");
const $box2 = document.querySelector("#box2");
const $box3 = document.querySelector("#box3");

// $box1.addEventListener('click', (e) => {
//   console.log("#box1 click");
// });
// $box2.addEventListener('click', (e) => {
//   console.log("#box2 click");
// });
$box3.addEventListener('click', (e) => {
  console.log("#box3 click");
  // 이벤트 전파(bubbling) 방지 
  e.stopPropagation();
});

/**
 * 이벤트 처리 위임
 * - 이벤트 버블링을 이용해서, 자식요소 각각이 아닌 부모요소에서 핸들링 할수 있다.
 */
document.body.addEventListener('click', (e) => {
  console.log('body click', e);
  
  // matches 선택자와 일치하면 true반환
  if(e.target.matches("#box1")) {
    console.log('#box1 click');
  }
  else if (e.target.matches("#box2")) {
    console.log('#box2 click');
  }
  else if (e.target.matches("#box3")) {
    console.log('#box3 click');
  }
});


// 캡쳐링용 이벤트핸들러 등록 (3번째 option true지정)
$box1.addEventListener('click', (e) => {
  console.log("capturing #box1 click");
}, true);
$box2.addEventListener('click', (e) => {
  console.log("capturing #box2 click");
}, true);
$box3.addEventListener('click', (e) => {
  console.log("capturing #box3 click");
}, true);