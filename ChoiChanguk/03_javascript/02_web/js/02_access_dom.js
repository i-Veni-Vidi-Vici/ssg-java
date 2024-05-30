console.log("02 access 입니다");
/**
 * document.getElementById(id)
 */
const test1=()=>{
    const li1=document.getElementById("li1");
    console.log(li1,typeof li1);
    console.dir(li1)
    li1.innerHTMl='hello1 JS';

    const notExist=document.getElementById("zzzzz");
    console.log(notExist);
};

/**
 * document.getElmentsByTagName(tagName)
 * - 조회된 태그 객체를 배열로 반환
 */
const test2=()=>{
    const list=document.getElementsByTagName("li");
    console.log(list);

    for (let i=0 ;i< list.length; i++) {
        console.log(list[i]);
        list[i].style.backgroundColor='springgreen';
    }
};


/**
 * document.getElementsByClassName(ClassName)
 */
const test3=()=>{
const group1 = document.getElementsByClassName("group1");
for(let i=0;i<group1.length;i++)
    {
        group1[i].style.textDecoration = "underline";
    }
}
