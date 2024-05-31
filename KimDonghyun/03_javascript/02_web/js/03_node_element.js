/**
 * 모든 태그객체는 Node와 Element를 상속한다. 
 * 
 * Node
 *  - document하위의 모든 요소는 Node이다. (Node를 상속한다.)
 *
 *  - 문서Node
 *  - 요소Node
 *  - 텍스트Node
 *  - 주석Node
 *  - 속성Node
 * 
 * 
 * Element
 *  - Node중에서 요소(태그)Node만 Element를 상속한다. 
 *  - 요소Node는 Node가 제공하는 속성/메소드를 사용할 수 있다.
 *  - 요소Node는 Element가 제공하는 속성/메소드를 사용할 수 있다.
 * 
 */

/**
 * div#sample 상속구조
 *  - div > HTMLDivElement > HTMLElement > Element > Node > EventTarget > Object
 * 
 * TextNode 상속구조
 *  - "텍스트" > Text > CharacterData > Node > EventTarget > Object 
 * 
 * CommentNode 상속구조
 *  - 주석 > Text > CharacterData > Node > EventTarget > Object 
 */


/**
 * document.createElement(tagName)
 * document.createTextNode(text)
 * 
 * Node#appendChild(자식노드)
 */
const test1 = () => {
  const $h2 = document.createElement("h2"); // <h2></h2>
  const text = document.createTextNode("Hello world 🍖"); // "Hello world 🍖"

  $h2.appendChild(text); // <h2>Hello world 🍖</h2>
  
  console.log($h2);
  
  const $target = document.querySelector("#target");
  $target.appendChild($h2); // <div id="target"><h2>Hello world 🍖</h2></div>

};

/**
 * 자식 텍스트노드가 없는 태그 생성하기
 */
const test2 = () => {
  const $img = document.createElement("img"); // <img />
  $img.src = "../../sample/image/hyunta.jpg"; // <img src="..."/>
  $img.alt = "현타견사진"; // <img src="..." alt="..."/>
  // $img.style = "width: 300px;"
  $img.style.width = "300px";
  console.log($img);

  const $target = document.querySelector("#target");
  $target.appendChild($img);
};

const $mark = document.createElement("mark");
const text = document.createTextNode("🍕");
$mark.appendChild(text);
const $inner = document.querySelector(".inner");

/**
 * Element#before 이전 형제요소로 삽입
 */
const test3 = () => $inner.before($mark);
/**
 * Element#prepend 첫번째 자식요소로 삽입
 */
const test4 = () => $inner.prepend($mark);

/**
 * Element#append 마지막 자식요소로 삽입
 */
const test5 = () => $inner.append($mark);

/**
 * Element#after 다음 형제요소로 삽입
 */
const test6 = () => $inner.after($mark);


/**
 * Element#remove() 스스로를 삭제
 */
const test7 = () => {
  const $foo = document.querySelector("#foo");
  $foo.remove();
};

/**
 * Node#removeChild(childNode) 부모요소 기준으로 자식요소를 삭제 (자식요소를 인자로 전달)
 */
const test8 = () => {
  const $ul = document.querySelector(".wrap");
  // const $foo = document.querySelector("#foo");
  // $ul.removeChild($foo);
  console.dir($ul);
  
  // 모든 자식요소
  // Node#firstChild 첫번째 자식 노드
  while($ul.firstChild) {
    console.log($ul.firstChild);
    $ul.removeChild($ul.firstChild);
  }  
};

/**
 * Node#cloneNode(isDeepCopy)
 * - 깊은복사 : 하위 모든 노드를 깊은 복사
 * - 얖은복사 : (기본값) 하위 노드에 대해서는 복사하지 않음.
 */
const test9 = () => {
  const $container = document.querySelector(".container");
  // const $container2 = $container.cloneNode(false); // ul태그만
  const $container2 = $container.cloneNode(true); // ul태그 하위 자식요소까지 복제
  $container.after($container2);
};

/**
 * Node#replaceChild(newChild, oldChild)
 */
const test10 = () => {
  const $container = document.querySelector(".container");
  const $li = $container.firstElementChild; // 첫번째 자식태그객체
  console.log($container, $li);
  
  const $newLi = document.createElement("li");
  $newLi.append("🍔"); // append(text)

  $container.replaceChild($newLi, $li);
};