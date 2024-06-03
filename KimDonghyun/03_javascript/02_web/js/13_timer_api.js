const $btn1 = document.querySelector("#btn1");
$btn1.addEventListener('click', (e) => {
  // window.setTimeout(callbackFunction, millis[, arguments]);
  setTimeout(() => {
    console.log('🍖🍖🍖');
  }, 3000);

  setTimeout((food) => {
    console.log(food);
  }, 3000, '🍕🍕🍕');

});

const $btn2 = document.querySelector("#btn2");
let intervalId;
$btn2.addEventListener('click', (e) => {
  // setInterval(callbackFunction, millis)
  // millis이후에 millis마다 callbackFunction 호출
  intervalId = setInterval(() => {
    console.log('🍳');
  }, 1000);
  console.log(`인터벌 ${intervalId}번이 생성되었습니다.`);
});

(() => {
  setInterval(() => {
    const now = new Date();
    document.querySelector("#clock").innerHTML = 
      `${now.getHours()}:${now.getMinutes()}:${now.getSeconds()}`;
  }, 1000);
})();