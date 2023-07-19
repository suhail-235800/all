package com.stackroute.basics;


import java.util.Scanner;

public class SortAscNumber {

    public static void main(String[] args) {
        new SortAscNumber().getNumbers();
    }

    //get the numbers from user through console
    public void getNumbers() {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int third = scanner.nextInt();
        int fourth = scanner.nextInt();
        System.out.println(numberSorter(first,second,third,fourth));
    }

    //logic to sort the numbers
    public String numberSorter(int firstNumber, int secondNumber, int thirdNumber, int fourthNumber) {
        String result = "Sorted:{";
        int pos1=0,pos4=0,temp1=0,temp2=0,pos2=0,pos3=0;

        if(firstNumber<=secondNumber && firstNumber<=thirdNumber && firstNumber<=fourthNumber){
            pos1=firstNumber;
        }
        else{
            if(secondNumber<=firstNumber && secondNumber<=thirdNumber && secondNumber<=fourthNumber){
                pos1=secondNumber;
            }
            else{
                if(thirdNumber<=firstNumber && thirdNumber<=secondNumber && thirdNumber<=fourthNumber){
                    pos1=thirdNumber;
                }
                else {
                    pos1=fourthNumber;
                }
            }
        }

        if(firstNumber>=secondNumber && firstNumber>=thirdNumber && firstNumber>=fourthNumber){
            pos4=firstNumber;
        }
        else{
            if(secondNumber>=firstNumber && secondNumber>=thirdNumber && secondNumber>=fourthNumber){
                pos4=secondNumber;
            }
            else{
                if(thirdNumber>=firstNumber && thirdNumber>=secondNumber && thirdNumber>=fourthNumber){
                    pos4=thirdNumber;
                }
                else {
                    pos4=fourthNumber;
                }
            }
        }

        temp1=pos1;
        temp2=pos4;

        if(firstNumber!=pos1 && firstNumber!=pos4){
            temp1=firstNumber;
            if(secondNumber!=pos1 && secondNumber!=pos4){
                temp2=secondNumber;
            } else if (thirdNumber!=pos1 && thirdNumber!=pos4) {
                temp2 =thirdNumber;
            } else {
                temp2=fourthNumber;
            }
        } else if (secondNumber!=pos1 && secondNumber!=pos4) {
            temp1=secondNumber;
            if(thirdNumber!=pos1 && thirdNumber!=pos4){
                temp2=thirdNumber;
            } else if (firstNumber!=pos1 && firstNumber!=pos4) {
                temp2=firstNumber;
            } else {
                temp2=fourthNumber;
            }
        } else if (thirdNumber!=pos1 && thirdNumber!=pos4) {
            temp1=thirdNumber;
            if(fourthNumber!=pos1 && fourthNumber!=pos4){
                temp2=fourthNumber;
            } else if (firstNumber!=pos1 && firstNumber!=pos4) {
                temp2=firstNumber;
            } else {
                temp2=secondNumber;
            }
        } else if (fourthNumber!=pos1 && fourthNumber!=pos4) {
            temp1 = fourthNumber;
            if (firstNumber != pos1 && firstNumber != pos4) {
                temp2 = firstNumber;
            } else if (secondNumber != pos1 && secondNumber != pos4) {
                temp2 = secondNumber;
            } else {
                temp2 = thirdNumber;
            }
        }

        if(temp1<=temp2){
            pos2=temp1;
            pos3=temp2;
        }
        else{
            pos2=temp2;
            pos3=temp1;
        }
        result+=pos1+","+pos2+","+pos3+","+pos4+"}";
        return result;
    }
}