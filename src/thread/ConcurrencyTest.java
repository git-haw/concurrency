package thread;

/**
 * Created by haw on 18-6-4.
 */
public class ConcurrencyTest {
    private static final long count = 10000001;

    public static void main(String[] args) throws InterruptedException{
        serial();
        concurrency();
    }

    private static void concurrency() throws InterruptedException{
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (int i = 0; i < count; i++) {
                    a+=5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        thread.join();
        long time = System.currentTimeMillis()-start;
        System.out.println("concurrency:"+time+"ms,b="+b);
    }

    private static void serial(){
        long start = System.currentTimeMillis();
        int a = 0;
        for (int i = 0; i < count; i++) {
            a+=5;
        }
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis()-start;
        System.out.println("serial:"+time+"ms,b="+b+",a="+a);
    }
}
