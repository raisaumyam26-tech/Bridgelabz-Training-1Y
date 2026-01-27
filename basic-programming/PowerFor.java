import java.util.*;
class PowerFor{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt(),p=sc.nextInt();
int res=1;
for(int i=1;i<=p;i++) res*=n;
System.out.println(res);
}}
