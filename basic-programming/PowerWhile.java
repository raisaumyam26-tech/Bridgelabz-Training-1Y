import java.util.*;
class PowerWhile{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt(),p=sc.nextInt(),res=1,c=0;
while(c<p){res*=n;c++;}
System.out.println(res);
}}
