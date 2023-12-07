package org.example.Lab2;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        VectorThreeD vector1 = new VectorThreeD(1, 2, 3);
        VectorThreeD vector2 = new VectorThreeD(4, 5, 6);

        // Выводим информацию о векторах
        System.out.println("Вектор 1: " + vector1);
        System.out.println("Вектор 2: " + vector2);

        // Выполняем операции над векторами
        VectorThreeD sum = VectorThreeD.plus(vector1, vector2);
        System.out.println("Сумма векторов 1 и 2: " + sum);

        VectorThreeD difference = VectorThreeD.minus(vector1, vector2);
        System.out.println("Разница векторов 1 и 2: " + difference);

        int dotProduct = VectorThreeD.multiscar(vector1, vector2);
        System.out.println("Скалярное произведение векторов 1 и 2: " + dotProduct);

        VectorThreeD scaledVector = vector1.scar(2);
        System.out.println("Умножение вектора 1 на 2: " + scaledVector);

        boolean areEqual = VectorThreeD.comp(vector1, vector2);
        System.out.println("Вектор 1 и вектор 2 равны: " + areEqual);

        double lengthOfVector1 = vector1.length();
        System.out.println("Длина вектора 1: " + lengthOfVector1);
        System.out.println("====================================");
        ComplexClass complex1 = new ComplexClass(2, 3);
        ComplexClass complex2 = new ComplexClass(1, 4);

        // Выводим информацию о комплексных числах
        System.out.println("Комплексное число 1: " + complex1);
        System.out.println("Комплексное число 2: " + complex2);

        // Выполняем операции над комплексными числами
        complex1.plus(complex2);
        System.out.println("Сумма комплексных чисел 1 и 2: " + complex1);

        complex1.minus(complex2);
        System.out.println("Разница комплексных чисел 1 и 2: " + complex1);

        complex1.multiplication(complex2);
        System.out.println("Умножение комплексных чисел 1 и 2: " + complex1);

        complex1.division(complex2);
        System.out.println("Деление комплексных чисел 1 и 2: " + complex1);

        // Выполняем статические операции над комплексными числами
        ComplexClass resultPlus = ComplexClass.plus(complex1, complex2);
        System.out.println("Сумма комплексных чисел 1 и 2 (статически): " + resultPlus);

        ComplexClass resultMinus = ComplexClass.minus(complex1, complex2);
        System.out.println("Разница комплексных чисел 1 и 2 (статически): " + resultMinus);

        ComplexClass resultMultiplication = ComplexClass.multiplication(complex1, complex2);
        System.out.println("Умножение комплексных чисел 1 и 2 (статически): " + resultMultiplication);

        ComplexClass resultDivision = ComplexClass.division(complex1, complex2);
        System.out.println("Деление комплексных чисел 1 и 2 (статически): " + resultDivision);

        // Вычисляем сумму и разность действительных и мнимых частей
        double sumOfNumbers = complex1.snumber(complex1.getRe(), complex1.getIm());
        double differenceOfNumbers = complex1.snumber(complex1.getRe(), -complex1.getIm());
        System.out.println("Сумма действительных и мнимых частей: " + sumOfNumbers);
        System.out.println("Разность действительной и мнимой частей: " + differenceOfNumbers);
        System.out.println("====================================");
        MyDate myDate1 = new MyDate("11.02.2014");
        MyDate myDate2 = new MyDate("11.06.2015");
        System.out.println( "Сложение дат "+ myDate1.addDate(25));
        System.out.println( "Вычитание дат "+ myDate1.minusDate(25));
        System.out.println( "Разница между двумя датами"+ MyDate.beetDay(myDate1,myDate2));
    }
}
