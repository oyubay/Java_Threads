public class Racer implements Runnable{ /* TODO
This class is exactly as the Racer from Task 1*/
    Car c;
    int distance = 1000; // this is a racer that is going to run 1000 miles.
    public Racer(Car c){
        this.c = c;
    }

    @Override
    public  void run(){
        while (c.odometer<distance)
            if (c.miles==0){
                System.out.println(c+"...Charging");
                c.charge();
                try {
                    Thread.sleep((int) c.miles);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            } else {
                c.move(1);
            }
        System.out.println("Finish:"+c);

    }
}
