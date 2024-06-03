/**
 * 각 태그별로 이벤트에 대한 기본처리가 있다. 
 * - a태그를 클릭하면, href속성값 주소로 페이지를 이동시킨다. 
 * - checkbox/radio클릭시, 체크/체크해제 처리한다.  
 * - form태그에 submit이벤트 발생시, action속성 주소로 사용자 입력값을 전송한다. 
 */

const $naverLink = document.querySelector("#naver-link");
// $naverLink.onclick = (e) => {
//   console.log('#naver-link click');
//   // e.preventDefault();
//   return false;
// };

$naverLink.addEventListener('click', (e) => {
  console.log('#naver-link click');
  e.preventDefault(); 
  // return false; //  addEventListener로 등록한 경우는 사용할 수 없다. 
});

const $isAdmin = document.querySelector("#isAdmin");
$isAdmin.onclick = (e) => {
  console.log('#isAdmin click');
  e.preventDefault();
};

const $p1 = document.querySelector("#p1");
$p1.onmousedown = (e) => e.preventDefault();


/**
 * copy(ctrl+c, 컨텍스터메뉴선택) -> copy event -> 클립보드에 복사
 */
const $p2 = document.querySelector("#p2");
$p2.oncopy = (e) => {
  alert('저작권 보호를 위해 복사를 방지합니다.');
  e.preventDefault();
};




















