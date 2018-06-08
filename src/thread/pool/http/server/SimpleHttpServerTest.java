package thread.pool.http.server;


/**
 * Created by haw on 18-6-6.
 */
public class SimpleHttpServerTest {
    public static void main(String[] args) throws Exception{
//        SimpleHttpServer simpleHttpServer = new SimpleHttpServer();
        String path = Class.class.getClass().getResource("/").getPath();
        path = path.substring(0,path.length()-1);
//        String path = System.getProperty("user.dir");
        System.out.println("path: "+path);
        SimpleHttpServer.setBasePath(path);
        SimpleHttpServer.start();
    }
}
