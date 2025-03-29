//배열
//4-1
const str = '사과,바나나,당근,김밥,치즈,떡볶이,햄버거,환타,사이다,콜라,고양이,강아지';
function findWord(str, word) {
    if(word === undefined){
        return '결과를 확인할 수 없습니다'
    }
    result = str.split(',').indexOf(word);
    if(result === -1)
        return `${word}는 배열에 존재하지 않습니다.`
    return `${word}는 배열 index ${result}에 있습니다.`
};

console.log(findWord(str, '고양이'));
console.log(findWord(str, '샌드위치'));
console.log(findWord(str));

//4-2   배열(arr)의 요소 중 a와 b 사이에 속하지 않는 요소는
//      삭제해주는 함수 filterRange(arr, a, b)를 작성한다.

function filterRange(arr, a, b) {
    const result = arr.filter((item, index, arr)=> a <= item  && item <= b);
    arr = result
    return result;
}

const arr = [5, 3, 8, 1, 10, 4];
filterRange(arr, 1, 5);
console.log(arr);