package edu.hw2.Task4;

public class Task4 {
    private Task4() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    private static Integer getLastDotIndex(String line) {
        return line.lastIndexOf('.');
    }

    private static Integer getPenultimateDotIndex(String line) {
        return line.substring(0, getLastDotIndex(line)).lastIndexOf('.');
    }

    private static String getClassName(String causingInfo) {
        return causingInfo.substring(getPenultimateDotIndex(causingInfo) + 1, getLastDotIndex(causingInfo));
    }

    private static String getMethodName(String causingInfo) {
        return causingInfo.substring(getLastDotIndex(causingInfo) + 1);
    }

    public static CallingInfo callingInfo() {
        String causingInfo = (new Throwable()).getStackTrace()[1].toString();
        // removing location
        causingInfo = causingInfo.substring(0, causingInfo.indexOf('('));
        return new CallingInfo(getClassName(causingInfo), getMethodName(causingInfo));
    }
}
