/*
WAP--> Write a program

Q.WAP to find weather the no entered by user is even or odd.

Q.WAP to swap the values of 2 nos.(Take input from user)
eg a=10 b=20

after swapping
a=20 b=10

Q.WAP to find the greatest between the 3 nos and display the output. (Take input from user)

Q.WAP to find weather the character entered by user is a vowel or not.(solve by using if..else and switch case)

Q.WAP to print even nos from 1-50 using while loop.

Q.WAP to print odd nos from 50-100 using do while loop.

Q.Given a number N, print sum of all even numbers from 1 to N.

Q. WAP to print the following patterns  
a.for n=4
1
22
333
4444

b.for n=4
4444
4444
4444
4444

c.for n=5
    *
   **
  ***
 ****
*****

Q.Revers an Array.

Q.Swap the nos in Array.

Q.WAP to calculate and display the factorial of a no entered by user.

Q.WAP to check weather the no entered by user is prime or not.

Q.Given an integer N, print all the prime numbers that lie in the range 2 to N (both inclusive).

Q.WAP to generate the reverse of a given number N. Print the corresponding reverse number.


*/ 




import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

import javax.sound.midi.SysexMessage;



/////////////////////////////// CODE IS WRITTEN USING JDK 17 /////////////////////////////////

public class Assignment {
    private static Scanner sc = new Scanner(System.in);

    
    public static void main(String [] args){
       

        while(true){

            System.out.println("""
                    
                    1. Check weather number is EVEN or ODD.
                    2. Swap 2 number given as input.
                    3. Find out the greatest number out of the 3 numbers given as input.
                    4. Check weather the alphabet entered is vowel or not.
                    5. Print all even numbers lying between 1 and 50
                    6. Print all odd numbers lying between 50 and 100
                    7. Print the sum of all even numbers lying between 0 to number N given as input.
                    8. Print the required pattern on the basis of the input number.
                    9. Reverse the given input array.
                    10. Swap the numbers of the array given as input.
                    11. Print the factorial of the number n given as input.
                    12. Check whether the given number is prime or not.
                    13. Print all the prime numbers between 1 and Number n given as input.
                    14. Print the given number n in reverse.
                    
                    """);

            System.out.println("Enter the feature no. to test");
            int option = sc.nextInt();

            switch(option){
              case 1 : checkOddEven();
              break;
              case 2 : swapNumbers();
              break;
              case 3 : greatestNumber();
              break;
              case 4 : checkVowel();
              break;
              case 5 : printEvenTill50();
              break;
              case 6 : printOddFrom50To100();
              break;
              case 7 : printEvenSumToN();
              break;
              case 8 : patternPrinting();
              break;
              case 9 : reverseArray();
              break;
              case 10 : swapArrayNumbers();
              break;
              case 11 : printFactorial();
              break;
              case 12 : {
                            System.out.println("Enter the number you want to check");
                            var num = sc.nextInt();
                            var result = checkForPrime(num);

                            if(result){
                                System.out.println("PRIME NO.");
                            }else{
                                System.out.println("NOT A PRIME NO.");
                            }
                }
              break;
              case 13 : printAllPrimesTillRange();
              break;
              case 14 : printNumberReverse();
              break;
            }

        }
    }


    public static void checkOddEven(){
        int number;
        
        System.out.println("Enter the number to check its property");
        number = sc.nextInt();

        if(number%2 == 0){
            System.out.println("Number is EVEN");
        }
        else{
            System.out.println("Number is ODD");;
        }
    }

    public static void swapNumbers(){

        int num1,num2,temp;

        System.out.println("Enter the 2 number whose values you want to swap");
        System.out.println("Enter no. 1");
        num1 = sc.nextInt();
        System.out.println("Enter no. 2");
        num2 = sc.nextInt();

        temp = num1;
        num1 = num2;
        num2 = temp;
       
        System.out.println("The swapped numbers are as displayed : "+ num1 +" "+num2);
    
    }

    public static void greatestNumber(){
        
        System.out.println("Enter the 3 numbers for comparison");
        
        System.out.println("Enter no. 1");
        var num1 = sc.nextInt();

        System.out.println("Enter no. 2");
        var num2 = sc.nextInt();

        System.out.println("Enter no. 3");
        var num3 = sc.nextInt();

        System.out.println("The Greatest number out of the 3 is : " + Math.max(num1, Math.max(num2, num3)));

    }

    public static void checkVowel(){
        System.out.println("Enter the cheracter to check its nature");
        var charac = sc.next().toLowerCase();
        
        System.out.println("Validation using switch case");
        switch (charac.charAt(0)) {
            
            case 'a','e','i','o','u' : System.out.println("VOWEL");    
            break;
            
            default : System.out.println("ANAGRAM");
            break;    
        }

        System.out.println("Using if else");
        if(Character.toString(charac.charAt(0)).matches("(a|e|i|o|u)")){
            System.out.println("VOWEL");
        }else{
            System.out.println("ANAGRAM");
        }
        
    }

    public static void printEvenTill50(){

        IntStream.rangeClosed(0, 50).filter(num -> num%2 == 0)
                              .forEach(System.out::println);
                            
    }

    public static void printOddFrom50To100(){
        
        IntStream.rangeClosed(50,100).filter(num -> num%2 != 0)
                                     .forEach(System.out::println);

    }

    public static void printEvenSumToN(){

        System.out.println("Enter the number limit n");
        var n = sc.nextInt();

        var result = IntStream.rangeClosed(0, n).filter(num -> num%2 == 0)
                                   .sum();

        System.out.println("The sum of all even nos. upto N is : " + result);
    }

    public static void patternPrinting(){
        
        System.out.println("Enter the no.");
        var n = sc.nextInt();

        System.out.println("PATTERN 1.");
        IntStream.rangeClosed(1, n).forEach(num -> {
                        IntStream.range(0, num).forEach(value -> System.out.print(num));
                        System.out.println();
                    });

        System.out.println("PATTERN 2.");
        IntStream.rangeClosed(1, n).forEach(num ->{
            IntStream.range(0, n).forEach(value -> System.out.print(n));
            System.out.println();

        });


        System.out.println("PATTERN 3.");
        IntStream.rangeClosed(0,n-1).forEach(num -> {
            
            for(int j = 2*(n-num) ; j >= 0 ; j--){
              System.out.print(" ");
          }

          for(int k = 0 ; k <= num ; k++ ){
              System.out.print("* ");
          }

        System.out.println();
            
        });


    }

    public static void reverseArray(){
        var count = 0;
        String [] arr;
        int [] num;
        
        System.out.println("Enter array numbers comma , seperated");
        var input = sc.next();
        arr = input.split(",");
        num = new int[arr.length];
        

        for(String str : arr){
            num[count] = Integer.parseInt(str);
            count++; 
        }

        int f = 0,l = num.length-1,temp;
        
        while(f<=l){
            
            temp = num[f];
            num[f] = num[l];
            num[l] = temp; 

            f++;
            l--;
        }

        for(int number : num){
            System.out.print(number + " ");
        }
        System.out.println();

    }

    private static void swapArrayNumbers() {
        var count = 0;
        String [] arr;
        int [] num;
        int temp;
        
        System.out.println("Enter array numbers comma , seperated");
        var input = sc.next();
        arr = input.split(",");
        num = new int[arr.length];
        

        for(String str : arr){
            num[count] = Integer.parseInt(str);
            count++; 
        }

        
        for(int i = 0 ; i < num.length - 1 ; i = i + 2 ){
            temp = num[i];
            num[i] = num[i+1];
            num[i+1] = temp;
        }
    
      
        System.out.println("The swapped elements are : ");
        for(int i : num)
            System.out.print(" " + i + " ");

    }

    public static void printFactorial(){
        
        System.out.println("Enter the number for which you want to find out the factorial");
        var num = sc.nextInt();

        var result = IntStream.rangeClosed(1, num).reduce((a , b) -> b * a).getAsInt();

        System.out.println("The factorial of the number is : " + result);

    }

    public static boolean checkForPrime(int num){

        if (num <= 1){
            return false;
        }
        
        else if (num == 2){
            return true;
        }
       
        else if (num % 2 == 0){
            return false;
        }
 
      
        for (int i = 3; i <= Math.sqrt(num); i = i + 2)
        {
            if (num % i == 0){
               return false;
            }
                
        }
        
       return true;

    }

    public static void printAllPrimesTillRange() {
        
        System.out.println("Enter the range");
        var range = sc.nextInt();

        IntStream.rangeClosed(2, range)
                 .filter(Assignment::checkForPrime)
                 .forEach(System.out::println);


    }

    public static void printNumberReverse() {
        
        System.out.println("Enter the number to be reversed");
        var num = sc.nextInt();
        var reversedNum = 0;
        
        while (num > 0) {
            reversedNum = reversedNum * 10 + num % 10;
            num = num / 10;
        }
        
        System.out.println("The reversed number is : " + reversedNum);

    }





    
}
