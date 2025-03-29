/**
 * if
 */
if(true){

}else{

}


/**
 * switch
 */
const value = 1;
switch(value){
    case 1: console.log(1); break;
    case 2: console.log(2); break;
}

/**
 * for
 */
for(let i = 0; i< 10; i++){
    console.log(i)
}

/**
 * while j
 *
 */

let j = 0;
while(true){
    console.log(j);
    j++;
    if(j > 10) break;
}

/**
 * for..in : 배열에 대해 사용 시 인덱스가 변수가 대입된다.
 * - 객체의 enumerable : true인 속성에 대해서 반복처리 
 */
const arr=['가','나','다'];

for(let i in arr){
    console.log(i, arr[i]);
}

/**
 * for.of
 * - 배열에 대해 사용시 요소가 변수에 대입된다.
 * - iterable 구현 객체에 대한 반복문
 */

for(const value of arr){
    console.log(value);
}