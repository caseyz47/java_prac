import java.util.concurrent.Callable;

public class Producer implements Runnable {
    private Product item;
    public Producer(Product item){
        this.item = item;
    }
    public void run() {
        for(int i=1; i<=10; i++){
                if(i %2==0){
                    item.setProdcut("青岛","啤酒");
                }else{
                    item.setProdcut("陕西","苹果");
                }
        }

    }
}

class test{
    public static void main(String[] args) throws InterruptedException {
        Product items = new Product();
        Producer p = new Producer(items);
        Thread tp = new Thread(p);
        tp.start();
        Consumer c = new Consumer(items);
        Thread tc = new Thread(c);
        tc.start();
    }
}
