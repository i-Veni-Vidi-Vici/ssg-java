document.orderCreateFrm.onsubmit = (e) => {
    const $frm = e.target;
    const $fieldsets = $frm.querySelectorAll('fieldset');
    let totalOrderPrice = 0;
    // 총 결제금액 -> #totalOrderPrice.value 대입
    [...$fieldsets].forEach(($fieldset) => {
       const [$menuCode,$orderAmount,$menuPrice] = $fieldset.children;
       console.log($menuCode,$orderAmount,$menuPrice);
       totalOrderPrice += $orderAmount.value * $menuPrice.value;
    });
    $totalOrderPrice.value = totalOrderPrice;
    // 총 결제금액 확인

    e.preventDefault();
}