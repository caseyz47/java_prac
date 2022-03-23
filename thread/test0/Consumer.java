public class Consumer implements Runnable{
    private Product item;
    public Consumer(Product item){
        this.item = item;
    }

    public void run(){
        synchronized (item){
            for(int i=1;i<=10;i++){
                item.consumeProduct(item.getBrand(), item.getName());
            }
        }
    }
}
