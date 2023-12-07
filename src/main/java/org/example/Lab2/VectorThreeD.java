package org.example.Lab2;
/*Создать класс для работы с векторами 3D, задаваемыми тройкой координат. При
разработке класса использовать рекомендованные правилами инкапсуляции
спецификаторы доступа.
Самостоятельно подумать и написать по аналогии с заданием 1 конструкторы. Реализовать
методы:
• сложение,
• вычитание,
• скалярное произведение векторов,
• произведение вектора на скаляр,
• сравнение векторов,
• вычисление длины вектора.
Проверить работу класса на примерах (пример придумать самостоятельно)*/
public class VectorThreeD {
    private int x, y, z;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public VectorThreeD(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public VectorThreeD() {
        this(0,0,0);
    }
    public VectorThreeD(VectorThreeD vector) {
        this(vector.getX(),vector.getY(),vector.getZ());
    }
    public static VectorThreeD plus(VectorThreeD a, VectorThreeD b) {
        return new VectorThreeD(a.x + b.x, a.y + b.y, a.z + b.z);
    }
    public static VectorThreeD minus(VectorThreeD a, VectorThreeD b) {
        return new VectorThreeD(a.x - b.x, a.y - b.y, a.z - b.z);
    }
    public static int multiscar(VectorThreeD a, VectorThreeD b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }
    public VectorThreeD scar(int a) {
        return new VectorThreeD(x * a, y * a, z * a);
    }
    public static boolean comp(VectorThreeD a, VectorThreeD b) {
        if(a.equals(b)) return true;
        return false;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VectorThreeD vector = (VectorThreeD) o;
        return x == vector.x && y == vector.y && z == vector.z;
    }
    public double length( ){
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
    }
    @Override
    public String toString() {
        return "VectorThreeD{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}


