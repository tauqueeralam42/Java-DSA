import java.util.HashMap;

public class ItineraryTickets {

    public static String getStart(HashMap<String,String> tickets){
        HashMap<String,String> rev = new HashMap<>();

        for(String key : tickets.keySet()){
            rev.put(tickets.get(key), key);
        }

        for(String key : tickets.keySet()){
            if(!rev.containsKey(key)){
                return key;
            }
        }

        return null;
    }
    

    public static void main(String[] args) {
        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Delhi", "Goa");
        tickets.put("Goa", "Chennai");
        
        String start = getStart(tickets);
        System.out.print(start);
        for(String key : tickets.keySet()){
            System.out.print("->"+tickets.get(start));
            start = tickets.get(start);
        }

    }
}
