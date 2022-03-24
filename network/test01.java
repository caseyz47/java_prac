import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class Test01 {
    public static void main(String[] args) throws UnknownHostException {
        // InetAddress trial
        InetAddress ia1 = InetAddress.getByName("localhost");
        InetAddress ia2 = InetAddress.getByName("10.27.111.201");
        InetAddress ia3 = InetAddress.getByName("www.baidu.com");
        System.out.println(ia1);
        System.out.println(ia2);
        System.out.println(ia3);
        System.out.println(ia3.getHostAddress() + ia3.getHostName());

        // InetSocketAddress trial
        InetSocketAddress isa = new InetSocketAddress("10.27.111.201", 8080);
        System.out.println(isa.getHostName());
        System.out.println(isa.getPort());
        InetAddress ia = isa.getAddress();
        System.out.println(ia.getHostName() + ia.getHostAddress());
    }
}
