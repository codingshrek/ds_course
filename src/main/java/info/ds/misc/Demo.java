package info.ds.misc;

public class Demo {

    int a ;
    int b = getA();

    public Demo() {
        this.a = 10;
    }

    public int getA(){
        return this.a;
    }

    public static void main(String[] args) {
        Demo d  =  new Demo();
        System.out.println(d.a);
        System.out.println(d.b);
    }
}
