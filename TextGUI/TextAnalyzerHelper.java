/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practical14;
import java.util.regex.*;
/**
 *
 * @author krushna
 */
public class TextAnalyzerHelper {

     /**
     * @param args the command line arguments
     */
    private String text;
    private int spaceCount ;
    private int wordCount;
    private int tabCount;
    private int linesCount;
    private int stringLength;
    
    private String specificWord;
    private int specificWordCount;;
    
    private String[] uniqueCharText=new String[1000];
    private String result="";
    private int uniqueCharTextCount;
    private int charTextCount;
    
    public TextAnalyzerHelper(String text) {
        this.text = text;
        analyze();
    }
    
    public int getStringLength() {
        return stringLength;
    }

    public int getSpaceCount() {
        return spaceCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getTabCount() {
        return tabCount;
    }

    public int getLinesCount() {
        return linesCount;
    }
    
    public int getSpecificWordCount() {
        return specificWordCount;
    }

    public String[] getUniqueCharText() {
        return uniqueCharText;
    }
    public int getCharTextCount() {
        return charTextCount;
    }
    
    
    private int getCharOrWordCount(String text){
        return 0;
    }
    
    public void analyze(){
        if (text == null || text.isEmpty()) {
            stringLength = 0;
            spaceCount = 0;
            wordCount = 0;
            tabCount = 0;
            linesCount = 0;
            specificWordCount=0;
            return;
        }
        
        stringLength=text.length();
        wordCount=text.split("[\\s\\t\\n]+").length;
        tabCount=text.split("\t",-1).length-1;
        linesCount=stringLength>0?text.split("\n",-1).length:0;
        spaceCount=text.split("\s",-1).length-1;
        
        for(int i=0;i<text.length();i++){
            String ch = Character.toString(text.charAt(i));
            if(result.indexOf(ch)==-1 && ch !=" " && ch !=null){
                result+=ch;
                uniqueCharText[uniqueCharTextCount]=ch;
                uniqueCharTextCount++;
            }
        }
        
    }
    public void setSpecificWordCount(String s){
        for (String word : text.split("[\\s\\t\\n]+")) {
            if (word.equals(s)) { 
                specificWordCount++;
            }
        }         
    }
    public void setSpecificCharCount(String s){
        for (int i = 0; i < text.length(); i++) {
            if(Character.toString(text.charAt(i)).equals(s)){
                charTextCount++;
            }
        }
    }
    
        
    
    public static void main(String[] args) {
        //String s= "\naAbBcCdD\nHello ad world Jarvis";
        String s="Hello world, \nHello\tJava!\nHello";
        TextAnalyzerHelper obj = new TextAnalyzerHelper(s);
        int spaceCount =0;
        
        int stringLength=s.length();
//        for(int i=0;i<s.length();i++){
//            if(s.charAt(i)==' '){
//                spaceCount++;
//            }
//        }
        spaceCount=s.split("\s",-1).length-1;
        int wordCount=s.split("[\\s\\t\\n]+",-1).length;
        int tabCount=s.split("\t",-1).length-1;
        int linesCount=stringLength>0?s.split("\n",-1).length:0;
        
        System.out.println(s);
        System.out.println("length of string = "+stringLength);
        System.out.println("no. of spaces = "+spaceCount);
        System.out.println("no. of words = "+wordCount);
        System.out.println("no. of tabs = "+tabCount);
        System.out.println("no. of lines = "+linesCount);
        
        String[] words = s.split("[\\s\\t\\n]+");
        int specificWordCount=0;
        for (String word : words) {
            if (word.equals("Hello")) { 
                specificWordCount++;
            }
        } 
//        Pattern pattern = Pattern.compile("\\b" + "Hello" + "\\b");
//        Matcher matcher = pattern.matcher(s);
//        while (matcher.find()) {
//            specificWordCount++;
//        } 
        System.out.println("no. of Hello words = "+specificWordCount);
        
        String[] uniqueCharText=new String[s.length()];
        String result="";
        int uniqueCharTextCount=0;
        for(int i=0;i<s.length();i++){
            String ch = Character.toString(s.charAt(i));
            if(result.contains(ch)==false){
                result+=ch;
                uniqueCharText[uniqueCharTextCount]=ch;
                uniqueCharTextCount++;
            }
        }
        System.out.println("Unique letters = ");
        for(String txt:uniqueCharText){
            System.out.print(txt);
        }
    }
    
    
}
