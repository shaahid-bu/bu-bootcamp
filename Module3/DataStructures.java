package Module3;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.HashMap;

public class DataStructures {

    public static void main(String[] args) {
        ArrayList<String> servers = ArrayList_method(new String[]{"Web-01", "Web-02", "db-01"});
        System.out.println(servers);
        HashSet<String> unique_servers = HashSet_method(new String[]{"Web-01", "Web-02", "db-01", "Web-01"});
        System.out.println(unique_servers);
        Stack<String> history = Stack_method(new String[]{"/home", "/product", "/cart"});
        System.out.println(history);
        System.out.println(history.peek());
        System.out.println(history.pop());
        System.out.println(history.isEmpty());
        
    }

    //playing with ArrayList
    public static ArrayList<String> ArrayList_method(String[] serverlist) {
        ArrayList<String> servers = new ArrayList<>();
        for (String server: serverlist) {
            servers.add(server);
        } 
        return servers;
    }

    //playng with HashSet
    public static HashSet<String> HashSet_method(String[] serverlist) {
        HashSet<String> unique_server  = new HashSet<>();
        unique_server = new HashSet<>(List.of(serverlist));
        return unique_server;
    }
    //playing with Stack
    public static Stack<String> Stack_method(String[] serverlist) {
        Stack<String> server_stack = new Stack<>();
        for (String server: serverlist) {
            server_stack.push(server);  
        }
        return server_stack;
    }
    //playing with HashMap
    public static HashMap<String, Integer> HashMap_method(String[] serverlist) {
        HashMap<String, Integer> server_map = new HashMap<>();
        for (String server: serverlist) {
            server_map.put(server, server.length());
        }

        String[] events = {"login", "login", "logout", "login", "error", "logout"}; 
        HashMap<String, Integer> counts = new HashMap<>(); 
        for (String event : events) { 
            counts.put(event, counts.getOrDefault(event, 0) + 1); 
        } 
        boolean hasError = counts.containsKey("error");
        System.out.println("Has error: " + hasError);
        System.out.println(counts); 

        return server_map;
    }
}