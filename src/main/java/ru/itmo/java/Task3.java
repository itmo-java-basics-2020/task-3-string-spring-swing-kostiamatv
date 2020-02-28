package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if(inputArray == null || inputArray.length == 0){
            return new int[0];
        }
        int last = inputArray[inputArray.length - 1];
        for(int i = inputArray.length - 1; i > 0; i--){
            inputArray[i] = inputArray[i - 1];
        }
        inputArray[0] = last;
        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if(inputArray == null || inputArray.length == 0){
            return 0;
        }
        if(inputArray.length == 1){
            return inputArray[0];
        }
        Arrays.sort(inputArray);
        return Integer.max(inputArray[inputArray.length - 1] * inputArray[inputArray.length - 2],
                inputArray[0] * inputArray[1]);
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if(input == null || input == ""){
            return 0;
        }
        var chararray = input.toLowerCase().toCharArray();
        Arrays.sort(chararray);
        var k =0;
        for(int i=0; i < chararray.length; i++){
            if(chararray[i] == 'b' | chararray[i] =='a'){
                k++;
            }
            if(chararray[i] > 'b'){
                break;
            }
        }
        if(chararray.length == 0){
            return 0;
        }
        return k*100/chararray.length;
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input){
        if(input == ""){
            return true;
        }
        if(input == null){
            return false;
        }
        for(int i = 0; i <= input.length()/2; i++){
            if(input.charAt(i) != input.charAt(input.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input){
        if(input == null || input == ""){
            return "";
        }
        var result= "" + input.charAt(0);
        var cur_num = 1;
        var cur_char = input.charAt(0);
        var i = 1;
        while (i < input.length()){
            if (cur_char == input.charAt(i)){
                cur_num++;
            }
            else {
                result += Integer.toString(cur_num);
                cur_char = input.charAt(i);
                result += cur_char;
                cur_num = 1;
            }
            i++;
        }
        result += Integer.toString(cur_num);
        return result;
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if(one == null || two == null || one == "" || two == ""){
            return false;
        }
        var chars1 = one.toCharArray();
        var chars2 = two.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if(s == null || s == ""){
            return false;
        }
        var array = s.toCharArray();
        Arrays.sort(array);
        for(int i = 1; i < array.length; i++){
            if (array[i] == array[i-1]){
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if(m == null){
            return new int[0][0];
        }
        for(int i = 0; i < m.length; i++){
            for(int j = i + 1; j < m.length; j++){
                m[i][j] += m[j][i];
                m[j][i] = m[i][j] - m[j][i];
                m[i][j] -= m[j][i];
            }
        }
        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if(inputStrings == null || inputStrings.length == 0){
            return "";
        }
        if(separator == null){
            separator = ' ';
        }
        var result = inputStrings[0];
        for(int i = 1; i < inputStrings.length; i ++){
            result += separator + inputStrings[i];
        }
        return result;
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if(inputStrings == null || inputStrings.length == 0 || prefix == null){
            return 0;
        }
        var num = 0;
        for(int i = 0; i < inputStrings.length; i++){
            if(prefix.length() <= inputStrings[i].length()){
                num ++;
                for(int j = 0; j < prefix.length(); j++){
                    if(prefix.charAt(j) != inputStrings[i].charAt(j)){
                        num --;
                        break;
                    }
                }
            }
        }
        return num;
    }
}
