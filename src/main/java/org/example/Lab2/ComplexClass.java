package org.example.Lab2;
/*Задание 1. Создать класс Complex, описывающий комплексное число и
хранящий действительную и мнимую части в виде вещественных чисел. При
разработке класса использовать рекомендованные правилами инкапсуляции
спецификаторы доступа.
Реализовать конструкторы, необходимые для удобной работы с классом : 1.
конструктор без параметров: действительная и мнимая части равны нулю;
2. конструктор, принимающий одно число в качестве параметра:
действительную часть. Мнимая часть равна нулю;
3. конструктор, принимающий два числа в качестве параметра:
действительную и мнимую части;
4. конструктор, принимающий ссылку на класс «комплексное число» в
качестве параметра и устанавливающий действительную и мнимую части
текущего объекта равными действительной и мнимой частям объекта,
полученного в качестве параметра.
Использовать вызовы одного конструктора из другого. Написать по два метода
для каждой операции: сложения, вычитания, умножения, сравнения. В качестве
примера рассмотрим операцию сложения. Один метод должен складывать
содержимое текущего объекта с содержимым объекта, переданного в качестве
параметра:
public void plus(Complex other){ re += other.re; im+= other.im; }
Здесь: Complex – имя класса, описывающего комплексное число, re –
действительная часть, im – мнимая часть.
Другой метод – статический – должен складывать два «внешних» комплексных
числа, переданных в качестве параметров:
public static Complex plus( Complex c1, Complex c2){ //используем конструктор
No3: return new Complex( c1.re+c2.re, c1.im+c2.im); }
Этот метод работает как известные нам арифметические операторы +, -, *, /.
Они тоже принимают в качестве параметров два числа и создают третье. Далее
самостоятельно напишите по два метода для каждой оставшейся операции: •
вычитания • умножения • сравнения Написать метод возвращающий
сопряженное число. Используя класс Complex выполнить следующие примеры:
Даны числа: z1 = 3 - i и z2 = -2+ i*3
*/
public class ComplexClass {
    private double re;
    private double im;
    public ComplexClass() {
        this(0,0);
    }
    public ComplexClass(double re) {
        this(0,re);
    }
    public ComplexClass(double re, double im) {
        this.re = re;
        this.im = im;
    }
    public ComplexClass(ComplexClass complex) {
        this(complex.getIm(),complex.getRe());
    }
    public double getRe() {
        return re;
    }
    public void setRe(double re) {
        this.re = re;
    }
    public double getIm() {
        return im;
    }
    public void setIm(double im) {
        this.im = im;
    }
    public void plus(ComplexClass other){
        re += other.re;
        im+= other.im;
    }
    public void minus(ComplexClass other){
        re -= other.re;
        im -= other.im;
    }
    public void multiplication(ComplexClass other){
        re *= other.re;
        im *= other.im;
    }
    public void division(ComplexClass other){
        re /= other.re;
        im/= other.im;
    }
    public static ComplexClass plus(ComplexClass c1, ComplexClass c2){
        return new ComplexClass( c1.re+c2.re, c1.im+c2.im);
    }
    public static ComplexClass minus(ComplexClass c1, ComplexClass c2){
        return new ComplexClass( c1.re-c2.re, c1.im-c2.im);
    }
    public static ComplexClass multiplication(ComplexClass c1, ComplexClass c2){
        return new ComplexClass( c1.re*c2.re, c1.im*c2.im);
    }
    public static ComplexClass division(ComplexClass c1, ComplexClass c2){
        return new ComplexClass( c1.re/c2.re, c1.im/c2.im);
    }
    public double snumber(double re,double im){
        return this.re-this.im;
    }
    @Override
    public String toString() {
        return "ComplexClass{" +
                "re=" + re +
                ", im=" + im +
                '}';
    }
}


