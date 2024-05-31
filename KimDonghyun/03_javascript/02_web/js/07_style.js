/**
 * inline style 속성
 */
const test1 = () => {
  const $area = document.querySelector(".area");
  // style객체의 property명은 camel case로 작성
  // $area.style.backgroundColor = "yellowgreen";

  // bracket notation으로 케밥케이스 속성지정 가능
  $area.style['background-color'] = 'tomato';
};


/**
 * className 속성
 * - class기반 css속성 + DOM.className
 * - DOM.className 문자열로 관리되므로 여러개의 class값 관리가 힘들다.
 */
const test2 = () => {
  const $area = document.querySelector(".area"); 
  $area.className += " bg-yellow"; 
  console.dir($area);
};

/**
 * classList 속성
 * - 클래스값을 제어하는 메소드를 제공
 * - ClassList#add(class)
 * - ClassList#remove(class)
 * - ClassList#toggle(class)
 * - ClassList#contains(class):boolean
 * - ClassList#replace(oldClass, newClass)
 */
const test3 = () => {
  const $area = document.querySelector(".area"); 
  // $area.classList.add("bg-yellow");
  $area.classList.toggle("bg-yellow");
};


/**
 * 정렬
 */
const test4 = ($radio) => {
  console.log($radio);
  const $area = document.querySelector(".area"); 
  
  // 다른 정렬클래스 제거
  $area.classList.remove("left", "center", "right");

  // 이번 정렬클래스 추가
  $area.classList.add($radio.value);
};