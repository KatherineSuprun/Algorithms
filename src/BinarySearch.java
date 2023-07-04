import java.util.List;

public class BinarySearch {

         static List<String> stopWords = List.of(
                "hello", "yes", "no", "java", "cyber", "micky", "mouse");
        public static boolean isStopWord (){
           // String candidate;
            for (String word : stopWords) {
                if (word.equals("candidate")) {
                    System.out.println("The world " + word + "found? : ");
                    return true;
                }
            }
            return false;
        }
    }