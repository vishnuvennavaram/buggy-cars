package utils;

import java.time.Instant;

/**
 * This class contains methods related to Common Utility methods
 */

public class CommonUtils {
    static long epochSecond;

    // to set EpochSecond time so that we will have unique number
    public void setEpochSecond(){
        epochSecond = Instant.now().getEpochSecond();
    }
    public long getEpochSecond(){
        return  epochSecond;
    }
}