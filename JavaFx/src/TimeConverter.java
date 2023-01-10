public class TimeConverter {
    static int TimeToIndex(String time) {
        int startTimeHours = Integer.parseInt(time.substring(0, 2));
        int startTimeMins = Integer.parseInt(time.substring(2, 4));
        return ((4 * (startTimeHours - 7)) + 1) + (startTimeMins / 15);

    }

    static int TimeToRawSpan(String time) {
        int startTimeHours = Integer.parseInt(time.substring(0, 2));
        int startTimeMins = Integer.parseInt(time.substring(2, 4));
        int endTimeHours = Integer.parseInt(time.substring(5, 7));
        int endTimeMins = Integer.parseInt(time.substring(7, 9));
        return ((endTimeHours - startTimeHours) * 4 + (endTimeMins - startTimeMins) / 15);
    }

    static int DaysToIndex(String days) {
        switch (days) {
            case "U":
                return 1;
            case "M":
                return 2;
            case "T":
                return 3;
            case "W":
                return 4;
            case "R":
                return 5;
            default:
                return 0;

        }

    }
}
