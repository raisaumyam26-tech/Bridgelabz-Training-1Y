import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {

        int i = 0;
        System.out.println("value : " + i);

        i++;
        System.out.println("value a : " + i++);
        System.out.println("value b : " + i);

        ++i;
        System.out.println("value c : " + i++);
        System.out.println("value d : " + i++);

        int z = i + i++ + ++i + i + ++i + i++;
        System.out.println(z);
        System.out.println(i);

        for(int j = 0; j < 10; j++){
            System.out.println("j:" + j);
        }

        int k = 10;
        while(k > 0){
            System.out.println("k:" + k);
            k--;
        }

        int l = 10;
        do{
            System.out.println("l:" + l);
            l--;
        } while(l > 0);

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.close();
    }
}
