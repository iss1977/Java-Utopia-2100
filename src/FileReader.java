import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.nio.charset.StandardCharsets;


public class FileReader {

    private static byte[] allBytes; // why if I move it into "readFileContentToArray()" it doesn't work?

//    private static String[] namesArray = new String[0]; // Initialisierung ist nötig, um wordsArray.add() aufrufen zu können. Wenn Anzahl der elemente ist zero, array wird überschrieben.


    // read the file "dict.txt" to an array of String with unique words, all in lowercase.
    static String[] readFileContentToArray(String fileName, char separator){

        Path inputFile     = Paths.get(fileName);

        // display the dictionary file
        System.out.println("Reading dictionary :"+inputFile.toAbsolutePath().toString());

        try {
            long start = System.currentTimeMillis();

            allBytes = Files.readAllBytes(inputFile);

            long end = System.currentTimeMillis();
            System.out.println("File read in " + (end - start) + " ms");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // convert bytes[] to string :
        String s = new String(allBytes, StandardCharsets.UTF_8);

        String[] arrWords = createNamesArray(s);

        return arrWords;
    }

    // initiates the static Array arrWords. only used in the readFileContentToArray() method.
    private  static String[] createNamesArray(String s){
        ArrayList<String> temp_arr = new ArrayList<>();

        //do a loop through the string "s" to get the words
        String currentWord="";
        for (int i = 0; i <= s.length()-1; i++) {
            char c=s.charAt(i);

            if ((c>=65&&c<=90)||(c>=97&&c<=122)||(c==32)){  // nur Buchstaben A-Z und a-z werden berücksichtigt.
                // we found a usable character. add it to the current word.

                currentWord= currentWord.concat(Character.toString(c));
            } else {
                //we found an unusable character, close the current word and reinit.
                if (c==',') { // close name
                    temp_arr.add(currentWord); // add the word to our temp array
                    currentWord = ""; // ready to create a new word
                }
            }
        }
        // return the array of words - conversion is ugly ...
        String[] array2Send = new String[temp_arr.size()];
        array2Send = temp_arr.toArray(array2Send);
        return array2Send;
    }

    // gibt ein random wort zurück :
    // verwendung:
    //      getWord(char minCharacter, char maxCharacter) - gibt ein zufälliges wort zurück mit einen Anzahl an Buchstaben zwischen  minCharacter und  maxCharacter
    //      getWord(char minCharacter) - gibt ein  zufälliges wort zurück mit einen minimalen  Anzahl an Buchstaben von minCharacter
    //      getWord() - gibt ein  zufälliges wort zurück
    //          solte kein Treffer vorhanden sein, wird ein empty String zurückgegeben.

    private  static void getWord(int minCharNumber, int maxCharNumber){
//        // wenn  wordsArray noch keine Elemente hat, muss es erst initialisiet werden
//        if(namesArray.length==0)   namesArray=readFileContentToArray();
//        ArrayList<String> filterWordsArray= new ArrayList<String>();
//        for (String word: namesArray){
//            if (word.length()>=minCharNumber && word.length()<=maxCharNumber) filterWordsArray.add(word);
//        }
//        int randomWordIndex = (int) Math.floor(Math.random() * filterWordsArray.size() );
//        return ((filterWordsArray.size() > 0) ?  filterWordsArray.get(randomWordIndex) : "");

    }
    private  static void  getWord(int minCharNumber){
//        return  getWord(minCharNumber,40);
    }
    private  static void  getWord(){
//        return getWord(1,40);
    }


} //end class FileReader

