public class intro {
    public static void main(String[] args){
        System.out.println("Hello World!\n");
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n = n * 3;
        String binary = "10101";
        int number;
        number = Integer.parseInt(binary, 2);
        n = n + number;
        binary = "FF";
        number = Integer.parseInt(binary, 16);
        n = n + number;
        n = n * 6;
        System.out.printf("The result is %d \n", n);

        int sum = 0;
    while(n != 0){

        int c = n % 10;
        sum = sum + c;
        n = n / 10;

    }
    System.out.printf("Sum of digits: %d\n", sum);
    int aux = 0;
    while(sum > 9){
         aux = sum;
         sum = 0;
        while(aux != 0){

            sum = sum + (aux % 10);
            aux = aux / 10;

        }
    }
    String text = "Willy-nilly, this semester I will learn " + languages[sum];
    System.out.println(text);

    }
}
