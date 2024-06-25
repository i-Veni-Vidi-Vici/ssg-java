document.orderCreateFrm.onsubmit = (e) => {
    const $frm = e.target;
    const $fieldsets = $frm.querySelectorAll('fieldset');
    const $totalOrderPrice = $frm.totalOrderPrice; // name 값으로 직접 참조가 가능함!! -> ✨얘는 태그 객체
    let totalOrderPrice = 0; // ✨얘는 일반 숫자
    // 총 결제 금액 - #totalOrderPrice.value 대입

    [...$fieldsets].forEach(($fieldset) => {
        const [, $menuCode, $orderAmount, $menuPrice] = $fieldset.children;
        console.log($menuCode, $orderAmount, $menuPrice); // ✨배열 구조 분해 할당을 사용한 것!!
        totalOrderPrice += $orderAmount.value * $menuPrice.value
    });
    $totalOrderPrice.value = totalOrderPrice;
    // 총 결제 금액 확인
    confirm(`총 결제 금액은 ${totalOrderPrice}원 입니다. 주문 하시겠어요?ㅎ_ㅎ`) || e.preventDefault();
    //
};
const removeMenu = ($btn) => {
    const $fieldset = $btn.parentElement;
    $fieldset.remove();
};

const addMenu = () => {
    const $fieldsets = document.querySelectorAll("fieldset");
    // 부여된 최대 menuNo 가져오기
    // 유사 배열을 찐 배열로 변환 [...$fieldsets], Array.from($fieldsets)
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
          <button type="button" class="btn  btn-danger" onclick="removeMenu(this)">X</button>
        </fieldset>
      `;
    const $menuWrapper = document.querySelector(".menu-wrapper");
    // ✨새 요소를 추가하기
    //before() : 이전 형제 요소로 추가하기 - insertAdjacnetHTML('beforebegin', html)
    //prepend() : 첫번째 자식 요소로 추가하기 - insertAdjacnetHTML('afterbegin', html)
    //append() : 마지막 자식 요소로 추가하기 - insertAdjacnetHTML('beforeend', html)
    //after() : 다음 형제 요소로 추가하기 - insertAdjacnetHTML('afterend', html)

    $menuWrapper.insertAdjacentHTML('beforeend', html);
};
