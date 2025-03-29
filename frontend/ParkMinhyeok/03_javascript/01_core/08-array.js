const arr = [1, 2, 3];

const arr2 = new Array(1, 2, 3);

const arr3 = Array.of(1, 2, 3);

for (let i in arr) {
  console.log(arr[i]);
}

for (let i of arr) {
  console.log(i);
}

arr.map((i) => console.log(i));
arr.forEach((v, i) => console.log(v, i));

/**
 * unshift(E) 요소를 0번지에 추가
 * shift():E 0번지 요소를 제거후 반환
 * push(E) 요소를 맨 마지막에 추가
 * pop():E 맨 마지막 요소를 제거후 반환
 */

const chars1 = [1, 2, 3];
const chars2 = [4, 5, 6];

const chars = chars1.concat(chars2);
const newChars = [...chars1, ...chars2];
console.log(chars);
console.log(newChars);
