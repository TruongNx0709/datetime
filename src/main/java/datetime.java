

public class datetime {
    public static void main(String[] args) {
        long timestamp = getNumberOfSecondFromDayMonthYear(23, 8, 2021);
        System.out.println("Timestamp  : " + timestamp);
    }

    // kiểm tra năm nhuận
    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
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

    public static long getNumberOfSecondFromDayMonthYear(int day, int month, int year) {
        long second = 0;
        for (int i = 1; i <= month - 1; i++) {
            //System.out.println(getDayofmonth(i,year));
            second += (getDayofmonth(i, year)) * 86400;
        }
        for (int i = 1970; i <= year - 1; i++) {
            if (isLeapYear(i)) {
                second += 366 * 86400;
            } else
                second += 365 * 86400;
        }
        second += day * 86400;
        return second - 1;
    }
}

