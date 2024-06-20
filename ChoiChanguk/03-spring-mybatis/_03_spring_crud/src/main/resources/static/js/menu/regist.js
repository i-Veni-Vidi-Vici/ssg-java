console.log("여기는 js파일입니다");

// name값으로 document로 하는 건 form만 된다
document.menuRegistFrm.addEventListener('submit',(e)=>{
    // 이름 검사
    // 가격 검사
    let $menuPrice;
    $menuPrice = e.target.menuPrice;
    if($menuPrice.value<=0)
    {
        alert("가격이 유요하지 않습니다");
        e.preventDefault;
    }
    // 카테고리 검사
    // 주문가능여부 검사
});