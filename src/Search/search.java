package Search;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class search {
    public static int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        List<Integer> answers = new ArrayList<Integer>();
        int[] answer = {};
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        Map<String, Integer> termsMap = Arrays.stream(terms).map(i -> i.split(" "))
                .collect(Collectors.toMap(s -> s[0], s -> Integer.parseInt(s[1])));
        List<String[]> wordList = Arrays.stream(privacies).map(i -> i.split(" ")).collect(Collectors.toList());
        wordList.forEach(a -> System.out.println(a[1] + " : " + a[0]));
        Calendar cal = Calendar.getInstance();
        Date todays = formatter.parse(today);
        int index = 0;
        for (String[] days : wordList) {
            Date date;
            try {
                index++;
                System.out.println("index :" + index);
                System.out.println("days :" + days[0]);
                System.out.println("day :" + days[1]);
                date = formatter.parse(days[0]);
                cal.setTime(date);
                cal.add(Calendar.MONTH, termsMap.get(days[1]));
                cal.add(Calendar.DATE, -1);
                Date wordDate = new Date(cal.getTimeInMillis());
                System.out.println("&&&&&&: " + formatter.format(wordDate));
                System.out.println("@@@@@@: " + Integer.parseInt(formatter.format(wordDate).substring(8)));
                System.out.println("######: " + formatter.format(wordDate).toString().substring(0, 8) + "28");
                if (Integer.parseInt(formatter.format(wordDate).substring(8)) > 28) {
                    wordDate = formatter.parse(formatter.format(wordDate).substring(0, 8) + "28");
                }
                System.out.println("wordDate : " + wordDate);
                if (todays.after(wordDate)) {
                    answers.add(index);
                }
                answer = answers.stream().mapToInt(Integer::intValue).toArray();
                System.out.println("answer : " + Arrays.toString(answer));
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        return answer;
    }

    public static int[] solution2(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        int date = getDate(today);

        for (String s : terms) {
            String[] term = s.split(" ");

            termMap.put(term[0], Integer.parseInt(term[1]));
        }
        System.out.println("term : " + termMap.toString());
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            if (getDate(privacy[0]) + (termMap.get(privacy[1]) * 28) <= date) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(integer -> integer).toArray();
    }

    private static int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }

}
