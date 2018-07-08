package utils.enums;


/**
 * @author trafalgar
 */

public enum MONTH {
    Jan(1), Feb(2), Mar(3), Apr(4), May(5), Jun(6), Jul(7), Aug(8), Sep(9), Oct(10), Nov(11), Dec(12);


    private int monthIndex;

    MONTH(int monthIndex) {
        this.monthIndex=monthIndex;
    }


    public int getMonthIndex() {
        return monthIndex;
    }
};

