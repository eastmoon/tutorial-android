package example.dynamiclayout;

/**
 * Created by Chen on 2016/2/16.
 */
public class RuntimeTimeRecord {
    // Static variable
    public static int MAX_BUTTON_SIZE = 1000;
    // Static variable for class instance.
    private static RuntimeTimeRecord instance = null;

    // Static method for management instance.
    public static RuntimeTimeRecord getInstance() {
        if( instance == null )
            instance = new RuntimeTimeRecord();
        return instance;
    }

    // Private Constructor
    private RuntimeTimeRecord() {
        this.m_startTime = 0;
        this.m_endTime = 0;
    }

    // Private member variable
    private long m_startTime;
    private long m_endTime;

    // Public attribute
    public void setStartTime (long a_value){
        this.m_startTime = a_value;
    }

    public void setEndTime (long a_value){
        this.m_endTime = a_value;
    }

    public long getTimeDifference() {
        long diff = this.m_endTime - this.m_startTime;

        // if time difference less than 0, then return 0.
        // otherwise, return time difference.
        if( diff < 0 )
            diff = 0;

        return diff;
    }
}
