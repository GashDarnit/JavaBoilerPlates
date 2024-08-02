import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Filter {
    public static List<String> filter(String search, List<String> names) {
        List<String> list = new ArrayList<>();
        for(String i : names) 
            if(compare(search.toLowerCase(), i.toLowerCase())) list.add(i);
        return list;
    }
    
    public static boolean compare(String search, String name) {
        char[] queue = search.toCharArray();
        boolean start = false;
        boolean match = false;
        int index = 0;
        for (char i : name.toCharArray()) {
            if(i == queue[0]) start = true;
            
            if(start && i != queue[index]) {
                start = false;
                index = 0;
            }
            if(start) index++;
            if(index == queue.length) {
                match = true;
                break;
            }
        }
        return match;
    }
}