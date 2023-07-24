public class FriendsPairing {
    
    public static int pairFriends(int n){
        if(n==1 || n==2)
            return n;
        return pairFriends(n-1)+(n-1)*pairFriends(n-2);
    }

    public static void main(String[] args) {
        System.out.println(pairFriends(5));
    }
}
