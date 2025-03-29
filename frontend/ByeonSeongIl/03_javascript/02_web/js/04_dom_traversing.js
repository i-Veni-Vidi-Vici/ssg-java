/**
 * DOM Traversing
 * - DOM Tree 위에서 특정요소를 찾아가는 기술
 * 
 * 1. 자식방향
 * 2. 부모방향
 * 3. 형제방향
 * 
 * Node
 * (태그노드/텍스트노드/주석노드)
 * - 자식 firstChild | lastChild | childNodes
 * - 부모 parentNode
 * - 형제 nextSibling | previousSibling
 * 
 * Element
 * (태그노트)
 * - 자식 firstElementChild | lastElementChild | children
 * - 부모 parentElement
 * - 형제 nextElementSibling | previousElementSibling
 * 
 */


/**
 * 자식방향
 */
const test1 = () => {
  const $src = document.querySelector(".wrapper");
  // const $target = $src.firstElementChild;
  // const $target = $src.lastElementChild;

  const $target = $src.children[2]; // 유사배열 반환
  console.log($target);

  $target.style.color = 'hotpink';
  
};

/**
 * 부모방향
 */
const test2 = () => {
  const $src = document.querySelector("#p2");
  const $target = $src.parentElement;
  console.log($target);
  $target.style.backgroundColor = 'skyblue';
};

/**
 * 형제방향
 */
const test3 = () => {
  const $src = document.querySelector("#p3");
  // const $target = $src.previousElementSibling.previousElementSibling;
  const $target = $src.nextElementSibling;
  console.log($target);
  $target.style.fontSize = "32px";
  $target.style.color = "yellowgreen";
};