import java.util.*;
class GradeCalculator{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
double p=sc.nextDouble(),c=sc.nextDouble(),m=sc.nextDouble();
double avg=(p+c+m)/3;
String grade="",remark="";
if(avg>=80){grade="A";remark="Level 4, above agency-Normalized standards";}
else if(avg>=70){grade="B";remark="Level 3, at agency-normalized standards";}
else if(avg>=60){grade="C";remark="Level 2, below, but approaching agency-normalized standards";}
else if(avg>=50){grade="D";remark="Well, below agency-normalized standards";}
else if(avg>=40){grade="E";remark="Level 1-, Too below agency-Normalized standards";}
else{grade="R";remark="Remedial standards";}
System.out.println("Average: "+avg+" Grade: "+grade+" Remarks: "+remark);
}}
