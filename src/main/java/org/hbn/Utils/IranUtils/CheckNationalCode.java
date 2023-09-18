package org.hbn.Utils.IranUtils;

import org.hbn.Utils.Exceptions.Exceptions;

public class CheckNationalCode {

    int controlDigit=0;
    int sum = 0;
    Float mod_result = 0.0f;


    public Boolean checkNationalCode(String nationalCode) throws Exceptions.InvalidNationalCode {
        if (nationalCode.trim().length() != 10) {
            throw new Exceptions.InvalidNationalCode("Employee national code is invalid");
        } else {
            try {
                controlDigit = Integer.parseInt(nationalCode.substring(9));
                System.out.println("this is control digit : " + controlDigit);

                for (int i = 0; i < 9; i++) {
                    sum += Integer.parseInt(nationalCode.substring(i, i + 1)) * (10 - i);
                }
                mod_result = (float) sum % 11;
                System.out.println("moderesult is  " + mod_result);

                if (mod_result < 2 && controlDigit == mod_result) return true;
                else return (11 - mod_result) == controlDigit;
            } catch (Exception e) {
                e.getCause();
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return true;
    }
}