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
 * change 값변경 이벤트. 텍스트 input태그계열에서는 blur이벤트가 발생시 change이벤트도 함께 발생
 * input 사용자입력 이벤트. 사용자 입력이 감지된 순간에 발생 이벤트
 */
$nickname.onchange = (e) => {
  console.log('change', e.target.value);
};

$nickname.oninput = (e) => {
  console.log('input', e.target.value);
};

const $score = document.querySelector("#score");
$score.oninput = (e) => {
  console.log('input', e.target.value);
  e.target.nextElementSibling.innerHTML = e.target.value;
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


/**
 * form관련 이벤트
 * - 폼제출 버튼 클릭 -> submit이벤트 발생 -> submit핸들러 호출 -> 실제 전송
 * - submit핸들러 안에서 사용자에 입력값에 대한 유효성검사 
 *  - 정상입력된 경우, 실제 제출
 *  - 하나라도 유효하지 않은 값이 있다면, 제출방지 
 *    - return false;
 *    - event.preventDefault()
 * 
 */
console.log(document.forms); // HTMLCollection
console.log(document.forms[0]);
console.log(document.forms.userRegisterFrm);

document.forms.userRegisterFrm.onsubmit = (e) => {
  console.log("submit 핸들러 호출!");
  const $frm = e.target;

  console.log($frm.elements); // 모든 자식요소 

  const $username = $frm.username;
  const $password = $frm.password;
  const $passwordConfirmation = $frm.querySelector("#password-confirmation");

  console.log($username, $password, $passwordConfirmation);
  
  // username 검사
  if(!/^[A-Za-z]{4,8}$/.test($username.value)){
    alert('유효한 아이디를 작성해주세요.');
    e.preventDefault();
    return; // 조기리턴
  }

  // 비밀번호 검사 
  if(!/^[A-Za-z0-9!@#$%]{4,8}$/.test($password.value)) {
    alert('유효한 비밀번호를 작성해주세요.');
    e.preventDefault();
    return; // 조기리턴    
  }
  // 비밀번호 일치여부 검사 
  if($password.value !== $passwordConfirmation.value) {
    alert('두 비밀번호가 일치하지 않습니다.');
    e.preventDefault();
    $password.select();
    return; // 조기리턴    
  }
  
  
  console.log('모든 값이 유효합니다...');
}

