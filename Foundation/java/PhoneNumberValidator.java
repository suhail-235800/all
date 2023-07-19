package com.stackroute.basics;

import java.util.Scanner;

public class PhoneNumberValidator {
    //Create Scanner object as instance variable
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //call the functions in the required sequence
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
        String phoneNumber = phoneNumberValidator.getInput();
        phoneNumberValidator.closeScanner();
        phoneNumberValidator.displayResult(phoneNumberValidator.validatePhoneNumber(phoneNumber));
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public void displayResult(int result) {
        //displays the result
        if(result==1){
            System.out.println("valid");
        } else if (result==0) {
            System.out.println("invalid");
        }
        else{
            System.out.println("empty string");
        }
    }

    public int validatePhoneNumber(String input) {
        int count=0,flag=0;
        if(input==null || input.isEmpty()){
            return -1;
        }
        for(int i=0;i<input.length();i++){
            if(Character.isDigit(input.charAt(i)) || input.charAt(i)=='-'){
                if(Character.isDigit(input.charAt(i))){
                    count++;
                }
            }
            else {
                flag=1;
                break;
            }
        }
        if(flag==0 && count == 10){
            return 1;
        }
        else {
            return 0;
        }
    }
    public void closeScanner(){
        //close the Scanner object
        scanner.close();
    }
}
