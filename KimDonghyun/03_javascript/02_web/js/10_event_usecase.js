const $nickname = document.querySelector("#nickname");

$nickname.onfocus = (e) => {
  console.log('focus', e);
};
$nickname.onblur = (e) => {
  console.log('blur', e);

  // 유효성검사
  console.log(e.target.value);
  if(!e.target.value) {
    alert('닉네임을 반드시 작성하세요');
  }
};

/**
 * key관련 이벤트
 * - keydown
 * - keypress
 * - keyup
 */
const $memo = document.querySelector("#memo");
$memo.addEventListener('keyup', (e) => {
  console.log('keyup', e);
  const {code, key, keyCode, ctrlKey} = e;
  console.log(code, key, keyCode);
  if(key === 'Enter' && ctrlKey ) {
    alert(e.target.value);
  }
  // keyup이벤트시에 이벤트발생객체의 value값 가져오기
  document.querySelector("#target").innerHTML = e.target.value;
});