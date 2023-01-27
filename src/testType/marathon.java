package testType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class marathon {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        participant = Arrays.stream(participant).sorted().toArray(String[]::new);
        completion = Arrays.stream(completion).sorted().toArray(String[]::new);
        List<String> participantList = new LinkedList<>(Arrays.asList(participant));
        List<String> completionList = new LinkedList<>(Arrays.asList(completion));

        completionList.forEach(c -> participantList.remove(c));

        answer = participantList.get(0);
        System.out.println("answer : " + answer);
        return answer;
    }

    public static String solution2(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant)
            hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion)
            hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0) {
                answer = key;
                break;
            }
        }
        System.out.println("answer : " + answer);
        return answer;
    }
}
