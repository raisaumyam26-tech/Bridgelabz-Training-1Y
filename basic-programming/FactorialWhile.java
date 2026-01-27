import java.util.*;
class FactorialWhile{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
if(n>0){
long f=1;
while(n>0){f*=n;n--;}
System.out.println(f);
}else
System.out.println("Not a natural number");
}}
