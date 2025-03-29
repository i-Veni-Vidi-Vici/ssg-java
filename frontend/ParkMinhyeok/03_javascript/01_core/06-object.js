const obj = {
  name: 'park',
  age: 20,
  newAge: 30,
};

// 속성 삭제
delete obj.age;
console.log(obj);

console.log(obj['name']);

// for..in
for (const key in obj) {
  console.log(obj[key]);
}
