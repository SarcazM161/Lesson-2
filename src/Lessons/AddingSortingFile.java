package Lessons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddingSortingFile {
    private List<String> words  ;
    private List<String> lineWords;

    public void start(int i){
        String Path ="F:\\JAVA Школа\\Lessons\\№2\\test.txt";
        readTxtFile(Path);

        switch (i){
            case 1:{
                System.out.println("Количество различных слов в файле:"+readTxtFileLong(Path) );
                break;
            }
            case 2:{
                words.stream().distinct().sorted(Comparator.comparing(String::length).thenComparing(String::compareTo)).forEach(System.out::println);
                break;
            }
            case 3:{
                comparisonOfRepetitions();
                break;
            }
            case 4:{
                for (int j = lineWords.size()-1; j>=0;j-- ){
                    System.out.println(lineWords.get(j));
                }
                break;
            }
            case 5:{
                for(String text : new iterator<String>(lineWords)){
                    System.out.print(text);
                }
                break;
            }
            case 6:{
                Scanner scanner = new Scanner(System.in);
                int line = scanner.nextInt();
                if(line <= 0 ){
                    break;
                } else {
                    System.out.println(lineWords.get(line));
                }
                break;
            }
        }
    }

    public long  readTxtFileLong(String fileName){
        long wordCount = 0L;
        try (Stream<String> line = Files.lines(Paths.get(fileName)))
        {
            wordCount = line.map(x -> x.split("\\s+"))
                    .flatMap(Arrays::stream)
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCount;
    }

    public void  readTxtFile(String fileName) {
        try (Stream<String> line = Files.lines(Paths.get(fileName)))
        {
            lineWords = line.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Stream<String> word = Files.lines(Paths.get(fileName)))
        {
            words = word.map(x -> x.split(" ")).flatMap(Arrays::stream).
                    map(x -> x.replaceAll("\\pP","")).
                    map(String::toLowerCase).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void  comparisonOfRepetitions(){
        HashMap<String, Integer> wordToCount = new HashMap<>();
        for (String word : words)
        {
            if (!wordToCount.containsKey(word))
            {
                wordToCount.put(word, 0);
            }
            wordToCount.put(word, wordToCount.get(word) + 1);
        }
        for (String word : wordToCount.keySet())
        {
            System.out.println(word + " " + wordToCount.get(word));
        }
    }

    public List<String> getWords(){
        return  words;
    }

    public List<String> getLineWords(){
        return  lineWords;
    }

    public void setLineWords(List<String> wordsLine){
        this.lineWords = wordsLine;
    }
}
