/**
 * data attribute
 * - data-로 시작하는 사용자 정의 attribute를 통해 tag레벨에서 데이터를 관리할 수 있다. 
 * - 연결되는 단어를 -로 연결해서 작성한다. 
 * 
 * dataset property
 * - DOM객체 하위에서 data attribute를 dataset property관리할 수 있다. 
 * - DOMStringMap타입으로 관리된다. 
 * - 키값은 data를 제외한 나머지 단어를 카멜케이싱으로 관리한다. 
 */
(() => {
  const $boards = document.querySelectorAll(".boards li");

  [...$boards].forEach(($li) => {
    // 읽기
    console.dir($li.dataset);
    console.log($li.dataset.boardId, $li.dataset.categoryId);
    // 쓰기 
    $li.dataset.boardAuthor = '홍길동';
  });
})();

/**
 * boardId = 789인 태그를 찾아 categoryId = 10번으로 변경하세요.
 */
const test1 = () => {
  const $boards = document.querySelectorAll(".boards li");

  const $li = [...$boards].find(($li) => $li.dataset.boardId === "789");
  console.log($li);
  $li.dataset.categoryId = 10;
};