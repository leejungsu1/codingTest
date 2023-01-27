package testType;

public class cut {
    public static int solution(String s) {
        int answer = 0;
        int countS = 0;
        int countD = 0;
        String startChar = s.substring(0, 1);
        String nextChar;
        if (!s.toUpperCase().equals(s) && s.length() >= 1 && s.length() <= 10000) {
            for (int i = 0; i < s.length(); i++) {
                System.out.println("sLength : " + s.length());
                System.out.println("i+1 : " + (i + 1));
                nextChar = s.substring(i, i + 1);
                System.out.println("startChar : " + startChar);
                System.out.println("nextChar : " + nextChar);
                if (startChar.equals(nextChar)) {
                    countS++;
                    System.out.println("countS : " + countS);
                } else {
                    countD++;
                    System.out.println("countD : " + countD);
                }
                if (countS == countD) {
                    // s = s.substring(i + 1);
                    if (i + 1 != s.length()) {
                        startChar = s.substring(i + 1, i + 2);
                    }
                    answer++;
                    // System.out.println("s : " + s);
                    System.out.println("1 startChar : " + startChar);
                    System.out.println("1 if answer : " + answer);
                    countD = 0;
                    countS = 0;
                } else if (countD != countS && i + 1 == s.length()) {
                    answer++;
                    System.out.println("s : " + s);
                    System.out.println("2 if answer : " + answer);
                    countD = 0;
                    countS = 0;
                    break;
                }
            }
        }
        System.out.println("answer : " + answer);
        return answer;
    }

}
