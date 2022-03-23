public class Product {
    private String brand;
    private String name;
    boolean hasProdct = false;

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
    public synchronized void setProdcut(String brand, String name){
        if(hasProdct){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setBrand(brand);
        this.setName(name);
        System.out.println("i am producer, i made "+this.getBrand()+this.getName());
        hasProdct = true;//这个必须有，否则再来一个生产者会使生产者再次进入
        notify();
    }

    public synchronized void consumeProduct(String bran, String name){
        if(!hasProdct) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("i am consumer, i buy "+this.getBrand()+this.getName());
        hasProdct = false;
        notify();
    }
}
