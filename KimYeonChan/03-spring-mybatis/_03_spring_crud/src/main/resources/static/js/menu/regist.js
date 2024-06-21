console.log('log!!!');

document.menuRegistFrm.addEventListener('click', (e) => {
    // 이름 검사
    // 가격 검사
    const $menuPrice = e.target.menuPrice;
    if ($.menuPrice <= 0) {
        alert('가격이 유효하지 않습니다.');
        e.preventDefault();
    }
    // 카테고리 검사
    // 주문가능여부 검사
});