public class PhoneDirectory {
    boolean[] used;
    Queue<Integer> q;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        used = new boolean[maxNumbers];
        q = new LinkedList<Integer>();
        for(int i=0; i<maxNumbers; i++)
            q.offer(i);
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if( q.isEmpty() )
            return -1;
        int ans = q.poll();
        used[ans] = true;
        return ans;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !used[number];
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if( used[number] == false)  return;
        used[number] = false;
        q.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */