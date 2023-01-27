function solution(ingredient) {
  const answer = 0;
  var burger = "1231";
  let arr = ingredient.join("");
  console.log("arr :", arr);
  console.log("arr Type : ", typeof arr);
  for (var i = 0; i < ingredient.length; i++) {
    if (arr.subStr(i, 4) == burger) {
      arr = arr.subStr(i + 3);
      answer += 1;
    }
  }

  console.log("answer : ", answer);
  return answer;
}
const ingredient = [2, 1, 1, 2, 3, 1, 2, 3, 1];
solution(ingredient);
