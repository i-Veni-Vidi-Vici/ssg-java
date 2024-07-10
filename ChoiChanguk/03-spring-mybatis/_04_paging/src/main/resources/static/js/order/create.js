document.orderCreateFrm.onsubmit=(e)=>{
    const $form=e.target;
    const $fieldsets = $form.querySelectorAll('fieldset');
    const $totalOrderPrice=$form.totalOrderPrice;
    let totalOrderPrice = 0;

    // 총결제금액 -> #totalOrderPrice.value 대입
    [...$fieldsets].forEach(($fieldset) => {
        const [ ,$menuCode, $orderAmount, $menuPrice]=$fieldset.children;
        console.log($menuCode, $orderAmount, $menuPrice);
        totalOrderPrice+= $orderAmount.value*$menuPrice.value;
    });
    // 총 결제 금액 확인

    $totalOrderPrice.value=totalOrderPrice;

    confirm(`총 결제 금액 : ${totalOrderPrice}웝입니다, 주문할까요??`) || e.preventDefault();
};

const removeMenu = ($btn) =>{
    const $fieldset = $btn.parentElement;
    $fieldset.remove();
}

const addMenu = () => {
    const $fieldsets = document.querySelectorAll("fieldset");
    // 부여된 최대 menuNo 가져오기
    // 유사배열 -> 진짜배열로 변환하기
    // 1. [...$fieldsets]
    // 2. Array.from($fielsets)
    const maxMenuNo = Array.from($fieldsets).reduce((max, $fieldset) => {
        const menuNo = Number($fieldset.dataset.menuNo)
        return max > menuNo ? max : menuNo;
    }, 0);
    const nextMenuNo = maxMenuNo + 1;
    const html = `
        <fieldset data-menu-no="${nextMenuNo}">
          <legend>메뉴${nextMenuNo}</legend>
          <input type="text" name="orderMenus[${nextMenuNo - 1}].menuCode" placeholder="메뉴코드" value="">
          <input type="text" name="orderMenus[${nextMenuNo - 1}].orderAmount" placeholder="수량" value="">
          <input type="number" class="menu-price" id="menu-price${nextMenuNo}" value="">
          <button type="button" class="btn btn-danger" onclick="removeMenu(this)">제거</button>
          <button onclick="removeMenu(this)">X</button>
        </fieldset>
      `;
    const $menuWrapper = document.querySelector(".menu-wrapper");
    // 새 요소를 추가하기
    //before() // 이전 형제요소로 추가하기 - insertAdjacentHTML ('beforebegin',html)
    //prepend() // 첫번째 자식요소로 추가하기 - insertAdjacentHTML ('afterbegin',html)
    //append() // 마지막 자식요소로 추가하기 - insertAdjacentHTML ('beforeend',html)
    //after() // 다음 형제요소로 추가하기 - insertAdjacentHTML ('afterend',html)
    $menuWrapper.insertAdjacentHTML('beforeend', html);
};