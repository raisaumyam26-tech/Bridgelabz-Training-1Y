import java.util.*;
class BMI{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
double w=sc.nextDouble(),h=sc.nextDouble()/100;
double bmi=w/(h*h);
String status="";
if(bmi<=18.4) status="Underweight";
else if(bmi<=24.9) status="Normal";
else if(bmi<=39.9) status="Overweight";
else status="Obese";
System.out.println("BMI: "+bmi+" Status: "+status);
}}
