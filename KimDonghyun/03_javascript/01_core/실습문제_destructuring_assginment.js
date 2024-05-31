// 1.

const printStudentInfo = ([name, gender, ...scores]) => {
  const sum = scores
      .map((n) => Number(n))
      .reduce((sum, score) => sum + score);
  const avg = Math.round((sum / scores.length) * 10) / 10;
  console.log(`${name}(${gender}) - ${avg}점`);
};

(() => {
  const data = "홍길동,남,90,80,70,60|신사임당,여,88,100,50|전봉준,남,55,80,77";
  const temp = data.split("|");
  const students = temp.map((s, i) => s.split(","));
  console.log(students);
  students.forEach(printStudentInfo);
})();


// 2.

(() => {
  const persons = [
      {
          name: '홍길동',
          family: {
              father: '홍석천',
              mother: '홍진경',
              sister: '홍수아',
          },
          age: 35
      },
      {
          name: '신사임당',
          family: {
              father: '신동엽',
              mother: '고두심',
              brother: '신하균',
          },
          age: 25
      },
      {
          name: '이순신',
          family: {
              father: '이경영',
              mother: '이영자',
              brother: '이승환',
              sister: '아이유',
          },
          age: 33
      }
  ];
  persons.forEach(({ 
          name, 
          family: { 
              father, 
              mother, 
              ...siblings 
          } 
      }) => {
      // const { 
      //     name, 
      //     family: { 
      //         father, 
      //         mother, 
      //         ...siblings 
      //     } 
      // } = person;
      console.log(`이름 : ${name}, 아빠 : ${father}, 엄마 : ${mother}, 형제자매 : ${Object.values(siblings)}`);
  });
})();