import java.util.Map;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
//import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
//import java.util.stream.Stream;


public class Launcher{

    static int fibo(int n)
    {
        if(n <=1)
        {
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }

  public static void main(String[] args){
    System.out.println("Bienvenue Benvenidos");

    Scanner scanner = new Scanner(System.in);
    boolean state = false;
    while(state != true){
        System.out.print("Type A Command(Type 'quit' to quit)");
        String input = scanner.nextLine(); 

        //quit
        if(input.equalsIgnoreCase("quit")){
            state = true;
            //break
        }

        //fibo
        else if(input.equalsIgnoreCase("fibo")){
            System.out.println("Choose A Number: ");
            int input_nb = scanner.nextInt();
            int resultat_fibo = fibo(input_nb);
            System.out.println(resultat_fibo);
            state = true;
        }
        //freq-----------
        else if (input.equalsIgnoreCase("freq")) {
            System.out.print("Enter the file path: ");
            String givenpath = scanner.nextLine();

            try {
                String content = Files.readString(Path.of(givenpath));
                content = content.toLowerCase();

                //--- motsdiv
                String[] words = content.split("\\W+");

                Map<String, Long> wordFrequency = new HashMap<>();
                for (String word : words) {
                    if (!word.isBlank()) {
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0L) + 1);
                    }
                }
                //--freqmots
                List<String> topWords = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    String mostFrequentWord = null;
                    long maxCount = 0;
                    for (Map.Entry<String, Long> entry : wordFrequency.entrySet()) {
                        if (entry.getValue() > maxCount && !topWords.contains(entry.getKey())) {
                            mostFrequentWord = entry.getKey();
                            maxCount = entry.getValue();
                        }
                    }
    if (mostFrequentWord != null) {
        topWords.add(mostFrequentWord);
    }
}

                System.out.println("3 Most Frequent WOrds: " + String.join(" ", topWords));
            } catch (IOException e) {
                System.out.println("FIle couldn't be read: " + e.getClass().getName() + " - " + e.getMessage());
            }
            state = true;
        } 
        else{
            System.out.println("Unknown command");
            System.out.println("You Typed" + input);
        }
    }
    scanner.close();
    }
}
