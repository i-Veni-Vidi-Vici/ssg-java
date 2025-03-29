console.log('🥩');

/**
 * document.getElementById(id)
 */
const test1 = () =>{
   const li1= document.getElementById("li1");
    console.log(li1,typeof li1);
    
    li1.innerHTML = 'Hello1 js';

    const notExist = document.getElementById("zz");
    console.log(notExist);
    
};

/**
 * document.getElementsByTagName(tagName)
 * - 조회된 태그객체를 유사배열로 반환 
 */
const test2 = () => {
    const list = document.getElementsByTagName("li");
    console.log(list);
    
    for(let i = 0 ; i <list.length; i++){
        console.log(list[i]);
        list[i].style.backgroundColor='springgreen';
        // 내부에서 css코드를 작성할 때는 camelCase로 접근 
    }
}

/**
 * documnet.getElementByClassName(className)
 * - 조회된 태그 객체를 유사배열로 반환 
 */

const test3 = () =>{
    const group1 = document.getElementsByClassName("group1");
    console.log(group1);
    for(let i = 0; group.length; i++){
        console.log(group1[i]);
        group1[i].style.textDecoration ='underLine';
    }
}