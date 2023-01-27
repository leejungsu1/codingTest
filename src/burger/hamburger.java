package burger;

import java.util.Arrays;
import java.util.Stack;

public class hamburger {
    public static int solution(int[] ingredient) {
        int answer = 0;
        String[] array = Arrays.stream(ingredient).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.println("0000array :"+array);
        String arr = String.join("", array);
        for(int i = 0; i<arr.length(); i++){
            String[] a = arr.split("1231");
            if(String.join("",a).length() != arr.length() && answer == 0){
                answer = (arr.length()-String.join("",a).length()) / 4;
            }else if(String.join("",a).length() != arr.length() && answer != 0){
                answer += (arr.length()-String.join("",a).length()) / 4;
            }
            arr = String.join("", a);
            System.out.println("&&&&&&arr : "+arr);
        }
        System.out.println("1111array : "+arr);
        System.out.println("22222answer : "+answer);
        return answer;
    }

    public static int solution2(int[] ingredient) {
        int answer = 0; 
        Stack data = new Stack();  
        for (int i : ingredient){ 
            if (i == 1 && data.size()>= 3 && data.lastIndexOf(3) == data.size()-1 && data.lastIndexOf(2) == data.size()-2 && data.lastIndexOf(1) == data.size()-3) // line 8
            {
                answer++; 
                data.pop(); 
                data.pop(); 
                data.pop(); 
            }else {
                data.add(i); 
            }
        }
        return answer; 
    }
}
