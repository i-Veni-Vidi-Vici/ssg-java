/**
 * HTML Attribute 
 * - tag에 inline에 작성된 속성
 * - 속성Node에서 관리되면 getAttribute/setAttribute로 관리한다.
 * 
 * DOM Property
 * - 요소Node에서 관리하는 속성
 * - 사용자입력에 실시간 대응
 * 
 */
 
/**
 * attribute 
 */
const test1 = () => {
  const $username = document.querySelector("#username");
  console.log($username.getAttribute("value"));
  $username.setAttribute("value", "ㅋㅋㅋㅋㅋ");
}

/**
 * property
 */
const test2 = () => {
  const $username = document.querySelector("#username");
  console.log($username.value);
}

/**
 * attribute
 * - checked 작성시 "checked" 또는 "" 반환
 * - checked 미작성시 null이 반환
 */
const test3 = () => {
  const $email = document.querySelector("#email");
  console.log($email.getAttribute("checked")); // checked
}

/**
 * property
 */
const test4 = () => {
  const $email = document.querySelector("#email");
  console.log($email.checked); // true/false
}