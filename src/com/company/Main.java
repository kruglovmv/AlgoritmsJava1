package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static final int maxSize = 25;

    public static void main(String[] args) {
        System.out.println("Задание №2.1");
        int size = new Random().nextInt(maxSize)+1;
        int[] array = createArray(maxSize);

        long time=System.nanoTime();
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        System.out.println("Время затраченное на копирование массива в новый массив, наноСек: " + (System.nanoTime()-time));
        System.out.println("Исходный массив:");
        time = System.nanoTime();
        System.out.println(Arrays.toString(array));
        time = System.nanoTime()-time;
        System.out.println("Время затраченное на отображение массива, наноСек: " + time);
        System.out.println("Отсортированный масив:");
        time = System.nanoTime();
        Arrays.sort(arrayCopy);
        time = System.nanoTime()-time;
        System.out.println(Arrays.toString(arrayCopy));
        System.out.println("Время затраченное на сортировку массива, наноСек: " + time);
        time = System.nanoTime();
        boolean flag = Arrays.equals(array,arrayCopy);
        time = System.nanoTime()-time;
        System.out.println("Сравнение отсортированного и неотсортированного массивов: "+(flag?"массивы равны":"массивы не равны"));
        System.out.println("Время затраченное на сравнение двух массивов, наноСек: " + time);
        System.out.println("Задание №2.2");
        int number = new Random().nextInt(1000)-500;
        linearSearch(number, array);
        binarySearch(number, arrayCopy);
        System.out.println("Задание №2.3");
        array = createArray(400);
        arrayCopy=Arrays.copyOf(array, array.length);
        time = System.nanoTime();
        Arrays.sort(arrayCopy);
        time = System.nanoTime()-time;
        System.out.println("Время затраченное на сортировку массива из 400х чисел методом sort(), наноСек: " + time);
        System.out.println("Задание №2.4");
        arrayCopy=Arrays.copyOf(array, array.length);
        bubbleSort(arrayCopy);
        System.out.println("Задание №2.5");
        arrayCopy=Arrays.copyOf(array, array.length);
        minMaxSort(arrayCopy);
        System.out.println("Задание №2.6");
        arrayCopy=Arrays.copyOf(array, array.length);
        insertSort(arrayCopy);
    }

    private static void insertSort(int[] array) {
        int index;
        int buffer;
        long time = System.nanoTime();
        for (int i = 1; i <array.length ; i++) {
            buffer = array[i];
            index =i;
            while (index>0&&array[index-1]>=buffer){
                array[index]=array[index-1];
                --index;
            }
            array[index]=buffer;
        }
        time= System.nanoTime()-time;
        System.out.println("Время затраченное на сортировку массива из 400х чисел методом вставки, наноСек: " + time);
    }

    private static void minMaxSort (int [] array){
        int min;
        int buffer;
        long time = System.nanoTime();
        for (int i = 0; i <array.length-1 ; i++) {
            min =i;
            for (int j = i+1; j < array.length; j++) {
              if (array[j]<array[min]) min=j;
            }
            buffer= array[i];
            array[i]=array[min];
            array[min]=buffer;
        }
        time= System.nanoTime()-time;
        System.out.println("Время затраченное на сортировку массива из 400х чисел методом выбора, наноСек: " + time);
    }
    private static void bubbleSort(int [] array){
        int buffer;
        long time = System.nanoTime();
        for (int i = 0; i <array.length-1 ; i++) {
            for (int j = i; j < array.length-1; j++) {
              if(array[j]>array[j+1]){
                  buffer = array[j];
                  array[j]=array[j+1];
                  array[j+1]=buffer;
              }
            }
        }
        time= System.nanoTime()-time;
        System.out.println("Время затраченное на сортировку массива из 400х чисел методом пузырька, наноСек: " + time);
    }

    @NotNull
    private static int[] createArray(int size) {
        int [] array = new int[size];
        for (int j = 0; j < array.length; j++) {
            array[j] = new Random().nextInt(1000)-500;
        }
        return array;
    }

    private static void linearSearch(int number, int [] array){
       System.out.println("Линейный поиск числа в массиве:");
        boolean flag = false;
        long time = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            if(number==array[i]) {
                System.out.printf("Число %d в массиве на %d месте. Найдено за %d наносекунд%n", number, i + 1, System.nanoTime() - time);
                flag =true;
                break;
            }
        }
        if (!flag)
            System.out.printf("Число %d в массиве не найдено. Затрачено %d наносекунд%n", number, System.nanoTime() - time);
    }
    private static void binarySearch(int number, int @NotNull [] array){
        System.out.println("Двоичный поиск числа в отсортированном массиве:");
        int fistIndex = 0;
        int lastIndex = array.length-1;
        boolean flag = false;
        long time = System.nanoTime();
        while (fistIndex<=lastIndex){
            int middleIndex = (fistIndex+lastIndex)/2;
            if(array[middleIndex]==number){
                System.out.printf("Число %d в массиве на %d месте. Найдено за %d наносекунд%n", number, middleIndex, System.nanoTime() - time);
                flag = true;
                break;
            } else if(array[middleIndex]<number) fistIndex = middleIndex+1;
            else if (array[middleIndex]>number) lastIndex = middleIndex-1;
        }
        if (!flag) System.out.printf("Число %d в массиве не найдено. Затрачено %d наносекунд%n", number, System.nanoTime() - time);
    }


}
