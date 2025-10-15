package coding;

public class NativeUtil {
    public native MyPoint createPoint(double x, double y, String desc);


    static {
        System.loadLibrary("point");
    }


    public static void main(String[] args) {
        NativeUtil u = new NativeUtil();
        MyPoint p = u.createPoint(3.14, 2.71, "hello from native");
        System.out.println(p);   // 应打印出正确内容
    }
}
