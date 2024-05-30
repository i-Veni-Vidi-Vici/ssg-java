let b;
console.log(b);
b = 1;
console.log(b);

const key = Symbol('key');
console.log(key, typeof key);

function foo() {
  console.log('fooooooo');
}

foo();
console.log(foo, typeof foo);
