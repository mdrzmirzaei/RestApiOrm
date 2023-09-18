package org.hbn.Utils.Exceptions;


public class Exceptions {
    @SuppressWarnings("InvalidEmployeeName")
    public static class InvalidEmployeeName extends Exception {
        public InvalidEmployeeName(String msg) {
            super(msg);
        }
    }

    @SuppressWarnings("InvalidNationalCode")
    public static class InvalidNationalCode extends Exception {
        public InvalidNationalCode(String msg) {
            super(msg);
        }
    }

}
