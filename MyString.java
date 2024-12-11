/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int N = str.length();
        int counter = 0;
        for ( int i = 0 ; i < N ; i++){
            if ( str.charAt(i) == ch){
                counter++;
            }
        }
        if ( counter != 0) return counter;
        else return 0;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        int checker = 0;
        if ( str1.lrngth() == 0) return true;
        if ( (str1.length() == 0) || ( str2.length() == 0) ) return false;
        for ( int i = 0 ; i < str1.length() ; i++){
            char c = str1.charAt(i);
            if ( ( countChar(str1, c) <= countChar(str2, c) )) {
                checker++;
            }
        }
        if ( checker == str1.length()) return  true; 
        return false;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString (String str) {
        String result = ""+ str.charAt(0);
        for ( int i = 1 ; i < str.length() ; i++){
            result += " " + str.charAt(i);
        }
        return result;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        char[] letters = new char[26];
        int i = 0;
        String randomString= "";
        for (  char c = 'a' ; c <= 'z' ; c++ ){ //setting an array of the english alphabet
            letters[i] = c;
            i++;
        }
        for ( int j = 0 ; j < n ; j++){
            int random = (int)(Math.random() * 26);
            randomString += letters[random];
        }
        return randomString;
    }


    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        char[] arr1 = new char [ str1.length() ];
        char[] arr2 = new char [ str2.length() ];
        for ( int i = 0 ; i < arr1.length ; i++ ){
         arr1[i] = str1.charAt(i);
        }
        for ( int i = 0 ; i < arr2.length ; i++ ){
         arr2[i] = str2.charAt(i);
        }
        String result = "";
        for ( int i = 0 ; i < arr2.length ; i++){
             char c = arr1[i];
             for ( int j = 0 ; j < arr1.length ; j++){
                 char c2 = arr1[j];
                 if ( c == c2 ) {
                     arr1[j] = ' ';
                     break;
             }
          }
         }
         for ( int x = 0 ; x < arr1.length ; x++){
             if ( arr1[x] != ' ' ) result += arr1[x]; //buiding the new string
         }
         return result;
     }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
