import REPORT_MINE.*;
import Search.search;
import burger.*;

public class App {
    public static void main(String[] args) throws Exception {
        // String[] id_list = /* {"ryon","con"} */{"muzi","frodo","apeach","neo"};
        // String[] report = /* {"ryon con", "ryon con", "ryon con", "ryon con", "con
        // con"} */{"muzi frodo","apeach frodo","frodo neo", "muzi neo", "apeach muzi"};
        // int k = /* 3 */2;
        // REPORT_MINE.report.Solution(id_list, report, k);
        // REPORT_MINE.report.Solution2(id_list, report, k);

        // int[] ingredient = /* {2,1,1,2,3,1,2,3,1}*/{1,3,2,1,2,1,3,1,2};
        // burger.hamburger.solution(ingredient);

        // String today = "2022.05.19";
        // String[] terms = { "A 6", "B 12", "C 3" };
        // String[] privacies = { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C",
        // "2022.02.20 C" };
        // Search.search.solution2(today, terms, privacies);

        // String[] survey = { "AN", "CF", "MJ", "RT", "NA" };
        // int[] choices = { 5, 3, 2, 7, 5 };
        // testType.test.solution(survey, choices);

        // String s = "aaabbaccccabba";
        // testType.cut.solution(s);

        String[] participant = { "mislav", "stanko", "mislav", "ana" };
        String[] completion = { "mislav", "stanko", "ana" };
        testType.marathon.solution2(participant, completion);

    }

}
