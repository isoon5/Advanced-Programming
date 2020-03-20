public class Optional {



    public  String[] generate(int n, int k, String[] alphabet){
    String[] words = new String[n];
    int i = 0;

    for(i = 0; i < n; i++){
        StringBuilder buff = new StringBuilder();

        for(int j = 0; j < k; j++){
            int generator = (int)(Math.random() * (alphabet.length));
            buff.append(alphabet[generator]);
        }

        words[i] = buff.toString();
    }

    return words;
    }
    public static int commonLetter(String a, String b){
        char[] word1, word2;
        word1 = a.toCharArray();
        word2 = b.toCharArray();
        for(int i = 0; i < a.length(); i++)
            for(int j = 0; j < b.length(); j++){
                if(word1[i] == word2[j]){
                    return 1;
                }

            }
        return 0;
    }
    public static void  neighbor(int matrix[][], String[] words, int n){

        for(int i = 0; i < n; i++)
            for(int j = 0; j <  n; j++){
            matrix[i][j] = commonLetter(words[i],words[j]);
            }

    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        String[] alphabet = new String[args.length - 2];

        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = args[i + 2];
        }


        Optional app = new Optional();
        String[] words = new String[n];
        words = app.generate(n, k, alphabet);
        for (int i = 0; i < n; i++) {
            System.out.println(words[i]);
        }
        int matrix[][] = new int[n][n];
        neighbor(matrix, words, n);
        if(n < 30_000) {
            for (int i = 0; i < n; i++) {
                String line = "";

                for (int j = 0; j < n; j++) {
                    line = line + matrix[i][j] + " ";
                }
                System.out.println(line);
            }
        }

        int minCount = n;
        int maxCount = 0;
        int counter = 0, minIndex = 0 , maxIndex = 0;

        for (int i = 0; i < n; i++) {
            counter = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    counter++;
                }
            }
            if(counter < minCount){
                minCount = counter;
                minIndex = i;
            }
            if(counter > maxCount){
                maxCount = counter;
                maxIndex = i;
            }

        }
        System.out.println("Cuvantul cu cei mai multi vecini este "+words[maxIndex]);
        System.out.println("Cuvantul cu cei mai putini vecini este "+words[minIndex]);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Aplicatia a rulat "+timeElapsed+" nanosecunde");

    }
}

