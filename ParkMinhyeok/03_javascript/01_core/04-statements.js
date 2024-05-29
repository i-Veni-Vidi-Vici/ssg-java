const arr = ['가', '나', '다'];
for (let i in arr) {
  console.log(i, arr[i]);
}

for (const value of arr) {
  console.log(value);
}
