console.log('🍒🍹🍒');

document.menuRegistFrm.addEventListener('submit', (e) => {
    // 이름 검사
    // 가격 검사
    const $menuPrice = e.target.menuPrice;
    if ($menuPrice.value <= 0) {
        alert("가격이 유효하지 않습니다.")
        e.preventDefault(); // 폼 제출을 방지한다.
    }
    // 카테고리 검사
    // 주문가능여부 검사
})