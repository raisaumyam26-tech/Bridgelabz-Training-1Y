import java.util.*;
class FriendsCheck{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int a1=sc.nextInt(),a2=sc.nextInt(),a3=sc.nextInt();
int h1=sc.nextInt(),h2=sc.nextInt(),h3=sc.nextInt();
int youngest=Math.min(a1,Math.min(a2,a3));
int tallest=Math.max(h1,Math.max(h2,h3));
System.out.println("Youngest age: "+youngest);
System.out.println("Tallest height: "+tallest);
}}
