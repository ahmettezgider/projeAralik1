package islem1;

public class Islem {

    private double deger;

    public static Islem mat(int deger){
        return new Islem(deger);
    }

    public static Islem mat(double deger){
        return new Islem(deger);
    }

    private Islem(int deger){
        this.deger = deger;
    }

    private Islem(double deger){
        this.deger = deger;
    }

    public Islem topla(int x){
        deger += x;
        return this;
    }

    public Islem topla(double x){
        deger += x;
        return this;
    }

    public Islem carp(int x){
        deger *= x;
        return this;
    }

    public Islem carp(double x){
        deger *= x;
        return this;
    }

    public Islem bol(int x){
        deger /= x;
        return this;
    }

    public Islem bol(double x){
        deger /= x;
        return this;
    }

    public void yazdir(){
        System.out.println(deger);
    }
}
