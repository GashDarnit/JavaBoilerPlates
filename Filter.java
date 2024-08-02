import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Filter {
    public static void main(String[] args) {
        List<String> stuff = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        initialize(stuff);
        
        System.out.print("Filter: ");
        String string = sc.nextLine();
        
        //System.out.println(filter(string, new ArrayList<>(Arrays.asList("Mira Strauss"))));
        for(String i : filter(string, stuff)) System.out.println(i);
    }
    
    public static void initialize(List<String> stuff) {
        stuff.add("Adam Burrow");
        stuff.add("Mira Strauss");
        stuff.add("Alice Burbridge");
        stuff.add("Cameron Louise");
        stuff.add("Jonathan Sin");
        stuff.add("Paul Choi");
        stuff.add("Kevin Zheng");
        stuff.add("Alice Lawliet");
        stuff.add("Kevin Lee");
        stuff.add("Alice Steward");
        stuff.add("Adam Lee");
    }
    
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