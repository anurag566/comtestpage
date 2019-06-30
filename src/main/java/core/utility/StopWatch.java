package core.utility;

import java.util.Date;

public class StopWatch {
    private long startTime;

    public boolean isWatchRunning() {
       return (this.startTime > (new Date().getTime())) ? true : false;
    }

    public void startWatch(int time) {
        this.startTime = (new Date().getTime()) + (time * 1000);
    }
}
