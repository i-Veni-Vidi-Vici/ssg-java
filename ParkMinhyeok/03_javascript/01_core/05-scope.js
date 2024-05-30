const arr = ['가', '나', '다'];
for (let i in arr) {
  console.log(i, arr[i]);
}

for (const value of arr) {
  console.log(value);
}

let y = 99;
(function () {
  let x = 100;
  let y = 9;
  z = 1;
  console.log(`x + y + z = ${x + y + z}`);
})();
console.log(`y + z = ${y + z}`);
console.log(`x + y + z = ${x + y + z}`);
