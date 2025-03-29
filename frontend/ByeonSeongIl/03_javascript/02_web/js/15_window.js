/**
 * window 전역객체 
 * - browser에서 웹페이지 실행시에 최상위객체 
 * - 모든 js객체, DOM, BOM, 여러 api들을 가진 객체 
 * - window, this(전역), globalThis등의 키워드로 접근 가능
 * 
 * window하위객체
 * - DOM document
 * - BOM Browser Object Model(navigator, location, history, screen, ...)
 * - Javascript(Object, Array, Function, Date, String, ...)
 * - 그 외 API(Timer API, console, alert, ...)
 */
console.log(window);
console.log(this);
console.log(globalThis);

/**
 * open(url, name, spec)
 * - 새창의 url
 * - 새창의 name(새 창 window객체의 name속성 등록)
 * - spec 새창의 크기/offset 지정, 문자열
 */
document.querySelector("#btn1").onclick = () => {
  // const naver = open("http://naver.com", 'naver');
  // const naver = open("http://naver.com", 'naver', 'width=1080px, height=800px');
  const naver = open("01_hellojs.html", 'naver', 'width=1080px, height=800px');
  console.log(naver);
  
  setTimeout(() => {
    // naver.alert('Wooooooooooooooooooooooooooooooooowwwww');
    // naver.close();
  }, 3000);
};

/**
 * confirm("text") 
 * - true/false를 반환하는 사용자 입력값 함수
 */
document.querySelector("#btn2").onclick = () => {
  const bool = confirm('정말 삭제하시겠습니까?');
  console.log(bool);

  // 분기처리 
  if(bool) {
    // 삭제처리
  }
  else {
    // 삭제취소처리 
  }
  
};

/**
 * prompt("text", "기본값")
 * - 사용자로 부터 한줄짜리 텍스트입력을 받는 함수 
 * - 사용자입력값 / null이 반환
 */
document.querySelector("#btn3").onclick = () => {
  const name = prompt('당신의 이름은 무엇입니까?', "홍길동");
  console.log(name);

  if(name) {
    alert(`${name}님, 반갑습니다.`); 
  }
  else {
    alert("아무 이름이나 입력하세요.");
    
  }
  
};