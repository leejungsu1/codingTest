package testType;

public class test {
    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        String answerType = "";
        int[] score = { 3, 2, 1, 0, 1, 2, 3 };
        String[] index = { "RT", "CF", "JM", "AN" };
        char word;
        for (int j = 0; j < choices.length; j++) {
            switch (choices[j]) {
                case 1:
                case 2:
                case 3:
                    word = survey[j].charAt(0);
                    answerType = answerType + String.valueOf(word).repeat(score[choices[j] - 1]);
                    System.out.println("j : " + j);
                    System.out.println("word : " + choices[j] + " : " + word);
                    System.out.println("answerType : " + answerType);
                    break;
                case 4:
                    break;
                case 5:
                case 6:
                case 7:
                    word = survey[j].charAt(1);
                    answerType = answerType + String.valueOf(word).repeat(score[choices[j] - 1]);
                    System.out.println("j : " + j);
                    System.out.println("word : " + choices[j] + " : " + word);
                    System.out.println("answerType : " + answerType);
                    break;
            }
        }
        String finWord = answerType.toString();
        System.out.println("finWord : " + finWord);

        for (String i : index) {
            System.out.println("i : " + i);
            if (countChar(finWord, i.charAt(0)) >= countChar(finWord, i.charAt(1))) {
                answer = answer + i.charAt(0);
            } else {
                answer = answer + i.charAt(1);
            }
        }

        System.out.println("answer : " + answer);
        return answer;
    }

    private static long countChar(String str, char ch) {

        return str.chars()
                .filter(c -> c == ch)
                .count();

    }
}
