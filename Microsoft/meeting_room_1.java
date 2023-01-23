import java.util.Arrays;

public class meeting_room_1 {
     static boolean canAttendMeetings(int[][] intervals) {

        // sort on start point - lambda usage
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0])
                return false;
        }

        return true;
        
    
    }
    
    public static void main(String[] args) {

        // Start times
        int s[] = { 7,2};

        // Finish times
        int f[] = { 10,4 };

        // Defining an arraylist of meet type
       
        meeting_room_1 obj = new meeting_room_1();

        int[][] result = new int[s.length][2];

        for (int i = 0; i < s.length; i++) {

            result[i][0] = s[i];
            result[i][1] = f[i];
        }

       System.out.println(obj.canAttendMeetings(result));
    }
}
