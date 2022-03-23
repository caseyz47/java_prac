import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Product {
    private String brand;
    private String name;
    boolean hasProdct = false;
    Lock lock = new ReentrantLock();//create 2 different waiting queue for conusmer and producer
    Condition produceConsition = lock.newCondition();
    Condition consumerConsition = lock.newCondition();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setProdcut(String brand, String name){
        try{
            lock.lock();
            if(hasProdct){
                try {
                    produceConsition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            }
            this.setBrand(brand);
            this.setName(name);
            System.out.println("i am producer, i made "+this.getBrand()+this.getName());
            hasProdct = true;//这个必须有，否则再来一个生产者会使生产者再次进入
//        notify();
            consumerConsition.signal();
        }finally {
            lock.unlock();
        }
    }

    public synchronized void consumeProduct(String bran, String name){
        try{
            lock.lock();
            if(!hasProdct) {
                try {
//                wait();
                    consumerConsition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("i am consumer, i buy "+this.getBrand()+this.getName());
            hasProdct = false;
//        notify();
            produceConsition.signal();
        }finally {
            lock.unlock();
        }
    }
}
