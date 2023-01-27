package REPORT_MINE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class report {
    public static int[] Solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        List<String> idList = new ArrayList<>(List.of(id_list));
        Set<String> id_set = new HashSet<>(idList);
        try {
            if(id_set.size() == idList.size() && id_list.length>=2 && id_list.length<= 1000 && report.length>=1 && report.length<=200000 && k>=1 && k<=200){
                report = Arrays.stream(report).distinct().toArray(String[]::new);
                HashMap<String, ArrayList<String>> userId = new HashMap<String, ArrayList<String>>();
                HashMap<String, Integer> blockUser = new HashMap<String, Integer>();
                for(String id : id_list){
                    System.out.println("000000dddd :"+id.equals(id.toLowerCase()));
                    if(id.length()>=1 && id.length()<=10 && id.equals(id.toLowerCase())){
                        
                        userId.put(id, new ArrayList<>());
                        blockUser.put(id, 0);
                    }
                }
                for(String user : report){
                    System.out.println("hfafhalf : "+user);
                    if(user.length()>=3 && user.length()<=21 && user.equals(user.toLowerCase())){
                        String[] userList = user.split(" ");
                        userList[1] = userList[1].trim();
                        System.out.println("ffffff :"+userList[1]);
                        System.out.println("ddddd : "+!userList[0].equals(userList[1]));
                        if(userList[0].equals(userList[1])){
                            userId.get(userList[0]).add(userList[1]);
                            System.out.println("1111userId :"+userId);
                            blockUser.put(userList[1],blockUser.get(userList[1])+1);
                            System.out.println("2222blockUser :"+blockUser);
                        }
                    }
                }
                System.out.println("3333userId :"+userId.toString());
                System.out.println("4444blockUser :"+blockUser.toString());
                ArrayList<String> blockId = new ArrayList<>();
            
                for(String id : id_list){
                    if(blockUser.size() == 1 && blockUser.get(id) == 0){
                        blockId.add("none");
                    }
                    else if(blockUser.get(id)>=k){
                        blockId.add(id);
                    }
                }
                System.out.println("5555blockId :"+blockId.toString());
    
                for(String id : id_list){
                    userId.get(id).retainAll(blockId);
                }
                System.out.println("6666userId :"+userId);
    
                for(int i = 0; i < id_list.length; i++){
                    answer[i] = userId.get(id_list[i]).size();
                    System.out.println("7777answer :"+answer[i]);
    
                }
                return answer;
            
            
        }
    } catch (NullPointerException e) {
        for(int i=0; i<id_list.length; i++){
            answer[i] = 0;
            System.out.println("8888answer :"+answer[i]);
        }
        return answer;
    }
        return answer;
    }

    public static int[] Solution2(String[] id_list, String[] report, int k) {
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        System.out.println("******** count :"+count.toString());
        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            System.out.println("++++++ reportList :"+reportList);
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }
}
