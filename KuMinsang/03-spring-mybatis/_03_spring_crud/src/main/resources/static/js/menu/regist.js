console.log('⛄⛄⛄')
document.menuRegistFrm.addEventListener('submit', (e)=>{
   //이름검사
   //가격검사
    const $menuPrice = e.target.menuPrice;
    if($menuPrice.value <= 0){
        alert("가격이 유효하지 않습니다.");
        e.preventDefault(); //폼제출 방지
    }
   //카테고리 검사
   //주문가능 검사
});