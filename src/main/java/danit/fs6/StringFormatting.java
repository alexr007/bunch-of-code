package danit.fs6;

import java.util.Scanner;

public class StringFormatting {
    public static boolean isDelimiter(char c){
        return c==','|| c==';'|| c=='.' || c=='?' || c=='!';
    }

    public static boolean isSpace(char c) {
        return c==' ';
    }

    public static boolean isLetter(char c) {
        return Character.isLetterOrDigit(c);
    }

    public static char lastChar(StringBuilder sb) {
        return sb.charAt(sb.length()-1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner("Donec pharetra,arcu id eleifend .");
        String src = in.nextLine();
        StringBuilder sb = new StringBuilder();

        for (int index = 0; index < src.length(); index++) {
            char c=src.charAt(index);
            if (index>0 && isLetter(c) && isDelimiter(lastChar(sb))) {
                sb.append(" ");
                sb.append(c);
            } else
            if (isLetter(c)
                    || isDelimiter(c) && isLetter(lastChar(sb))
                    || index+1<src.length() && isSpace(c) && isLetter(src.charAt(index+1))) {
                sb.append(c);
            }
        }
        System.out.format("%s\n", sb);
        System.out.format("\nsrc:\t%s\nresult:\t%s\n", src, sb);
    }

    public static void main_marina(String[] args) {
        Scanner in = new Scanner("Donec pharetra,arcu id eleifend .");
        String delimiters = ".,?!:;";
        String src = in.nextLine();

        //Для формирования результата без перекопирования строки при каждой конкатенации
        StringBuilder result = new StringBuilder();

        //Признак, что предыдущий символ был разделителем
        boolean prevCharIsDelimiter = false;
        //По символам строки
        for (int i = 0; i < src.length(); i++) {
            //Сохранить текущий символ в локальную перменную,
            //чтобы каждый раз не вызывать метод получения по индексу
            char ch = src.charAt(i);

            //Если символ является разделителем, то отметить этот факт в prevCharIsDelimiter
            if (ch != ' ')
                if (delimiters.indexOf(ch) != -1) {
                    prevCharIsDelimiter = true;

                    //Если символ НЕ разделитель
                } else {
                    //Если символ НЕ пробел и предыдущий символ разделитель, то добавить пробел.
                    if (ch != ' ' && prevCharIsDelimiter) {
                        result.append(' ');
                    }
                    //Снять признак "разделитель" для следующей итерации цикла
                    prevCharIsDelimiter = false;

                }

            //Добавить текущий символ в выходную строку
            result.append(ch);
        }

        System.out.format("\nsrc:\t%s\nresult:\t%s\n", src, result);
    }
}
