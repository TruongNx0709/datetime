

public class datetime {
    public static final long SENCONDS_OF_DAY = 86400;
    public static void main(String[] args) {
        long timestamp = getNumberOfSecondFromDayMonthYear(23, 8, 2021,8,16,30);
        System.out.println("Timestamp  : " + timestamp);
        int[] date = getDayMonthYearfromTimestamp(timestamp);
        System.out.println(date[0]);
        System.out.println(date[1]);
        System.out.println(date[2]);
        System.out.println(date[3]);
        System.out.println(date[4]);
        System.out.println(date[5]);
    }

    // kiểm tra năm nhuận
    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }
    public static long getSecondsFromYear(int year) {
        if (isLeapYear(year)) {
            return 366 * SENCONDS_OF_DAY;
        }
        return 365 * SENCONDS_OF_DAY;
    }

    public static int getDayofmonth(int month, int year) {
        int day = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return day = 31;
        }
        if (month == 9 || month == 6 || month == 4 || month == 11) {
            return day = 30;
        }
        if (month == 2 && isLeapYear(year)) {
            return day = 29;
        } else if (month == 2 && !isLeapYear(year)) {
            return day = 28;
        }
        return day;
    }
    public static long getSecondsFromMonth(int month, int year) {
        return (long) getDayofmonth(month, year) * SENCONDS_OF_DAY;
    }

    public static long getNumberOfSecondFromDayMonthYear(int day, int month, int year, int hour , int minus , int second) {
        long seconds = 0;
        for (int i = 1; i <= month - 1; i++) {
            //System.out.println(getDayofmonth(i,year));
            seconds += getSecondsFromMonth(i,year);
        }
        for (int i = 1970; i <= year - 1; i++) {
            seconds += getSecondsFromYear(i);
        }
        seconds += day * SENCONDS_OF_DAY;
        seconds += hour * 360;
        seconds += minus*60;
        seconds += second;
        return seconds;
    }
    public static int[] getDayMonthYearfromTimestamp(long timestamp){
        int day = 1;
        int month = 1;
        int year = 1970;
        int hour = 1;
        int minus = 1;
        int second = 1;
        long seconds = timestamp + 1;
        while (timestamp >= getSecondsFromYear(year)) {
            timestamp -= getSecondsFromYear(year);
            year++;
        }
        while (timestamp >= getSecondsFromMonth(month, year)) {
            timestamp -= getSecondsFromMonth(month, year);
            month++;
        }
        while (timestamp > 0) {
            timestamp -= SENCONDS_OF_DAY;
            day++;
        }
        while (timestamp > 0) {
            timestamp -= 360;
            hour++;
        }
        while (timestamp > 0) {
            timestamp -= 60;
            minus++;
        }
        while (timestamp > 0) {
            timestamp -= 0;
            second++;
        }
        return new int[]{day, month, year, hour,minus,second};
    }
}

