package platform.codingnomads.co.springdata.example.mybatis.oneandmany.models;

import java.util.Scanner;

public class BrayosInterview {
    public static void main(String[] args) {

        //This array consist of positive and negative numbers
        System.out.println("Please insert your number..");
        Scanner scanner = new Scanner(System.in);
        int numbers = 0;
        int positiveCount = 0;

        for (int i = 0; i < 51; i++) {
            numbers += i;

            if (i > 0){
                positiveCount++;
            }
        }
    }
}
