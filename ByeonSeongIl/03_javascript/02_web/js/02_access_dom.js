console.log('🐫');

/**
 * document.getElementById(id)
 * - 페이지내 유일한 태그 식별자
 * - 아이디값의 변수로 선언없이 접근 가능하다. (변수명 충돌을 주의해야 한다.)
 * - 태그객체 (DOM객체)에는 관례적으로 $로 시작하는 변수명을 사용한다.
 */
const test1 =()=>{
    const $li1 =document.getElementById("li1");
    console.log($li1, typeof $li1);
    console.dir($li1);

    $li1.innerHTML ='Hello JS'

    const $notExist =document.getElementById("zzz");
    console.log($notExist);
};

/**
 * document.getElementByTagName(tagName)
 * - 조회된 태그객체를 유사배열로 HTMLCOLLection로 반환
 * - 유사배열은 배열의 메서드를 사용할 수 없고, for..in처리시에도 오류가 발생할 수 있다.
 * - 유사배열은 진짜배열로 변환후 배열처럼 사용가능 함
 */
const test2 = ()=>{
    const $list = document.getElementsByTagName("li");
    console.log($list);

    for(let i=0; i<$list.length; i++){
        console.log($list[i]);
        $list[i].style.backgroundColor ='springgreen';
    }

    const $list2 = [...$list]; // 진짜 배열로 변환
    console.log($list2);

    for(let i in $list2){
        console.log(i, $list2[i]);
        $list2[i].style.fontSize ='32px';

    }
}

/**
 * document.getElementsByClassName(className)
 * - 조회된 태그객체를 유사배열로 반환

 */
const test3 = () => {
    const $ul = document.getElementById("container");
    console.log($ul);
    // $ul 하위에서만 .group를 조회
    const $group1 = $ul.getElementsByClassName("group1");
    // 모든 document 하위에서 .group을 조회
    // const $group1 = document.getElementsByClassName("group1");

    console.log($group1);
    
    for(let i in [...$group1]){
        console.log(i);
        $group1[i].style.fontSize ="32px"
    }
  };


  /**
   * querySelector
   * - css선택자와 일치하는 첫번재요소만 반환
   */
  const test4 = ()=>{
    // const $elem = document.querySelector("#li1");
    const $elem = document.querySelector(".group2");
    console.log($elem);

    $elem.innerHTML ="ㄱㄱㄱㄱ"

    const $notExist = document.querySelector("$sssssssss");
    console.log($notExist); // null
  }

  /**
   * querySelectorAll
   * - css선택자와 일치하는 모든요소만 NodeList 유사배열로 반환
   * 
   */
  
  const test5 = () => {
    const _$list = document.querySelectorAll("li");
    console.log(_$list);
  
    const $list = [..._$list];
    const texts = $list.map(($li) => $li.textContent);
    console.log(texts);
    
    const $notExist = document.querySelectorAll("li.abc");
    console.log($notExist); // [] NodeList
  };
  
/**
 * document.getElementsByName(name)
 * - name속성값이 일치하는 태그객체를 담은 NodeList 유사배열을 반환
 */
const test6 = () => {
    const $hobbies = document.getElementsByName("hobby");
    console.log($hobbies);
  
    let checkedHobbies = [];
    [...$hobbies].forEach(($hobby) => {
      console.log($hobby, $hobby.checked);
  
      if($hobby.checked)
        checkedHobbies.push($hobby.value);
    });
  
    alert(`선택하신 취미는 ${checkedHobbies}입니다.`);
  };
  
  /**
   * 
   */
  const test7 = () => {
    const $hobbies = document.querySelectorAll("[name=hobby]:checked");
    console.log($hobbies);
    
    const values = [...$hobbies].map(($hobby) => $hobby.value);
    alert(`선택하신 취미는 ${values}입니다.`);
  };
  
  /**
   * onchange 
   * - checkbox가 체크/체크해제 될때 해당코드를 실행
   * - this를 전달하면, 해당 태그객체가 매개인수로 전달
   */
  const test8 = ($input) => {
    console.log($input.checked);
    
    const $hobbies = document.getElementsByName("hobby");
    [...$hobbies].forEach(($hobby) => $hobby.checked = $input.checked);
  }
  
  /**
   * 
   */
  const test9 = () => {
    // 요소 한개를 반환
    // const $elem = document.querySelector("#name");
    // const $elem = document.getElementById("name");
  
    // 요소가 담긴 유사배열을 반환
    // const $elem = document.getElementsByClassName("user-input")[0];
    const $elem = document.getElementsByName("name")[0];
    console.log($elem);
    
    alert(`입력하신 이름은 ${$elem.value}입니다.`);
    
  };