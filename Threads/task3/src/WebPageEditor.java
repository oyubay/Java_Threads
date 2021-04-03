/* TODO 
Imports. Fill them up as you need them.*/

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WebPageEditor {
    public  String temp; // holds the last webpage saved.
    public  WebPage wp; // the webpage you are working on
    public  String filename; // the filename to save this webpage

    public WebPageEditor(String filename){
        wp = new WebPage();
        this.filename = filename;
/* TODO
Initialize wp to an empty webpage, and filename to the value passed. */
    }

    public void start(){
//
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor(); /* TODO
Using Executors, instantiate a new SingleThreadedScheduledExecutor */
        /* TODO
Schedule at a fixed rate a runnable that executes checkSave. if checkSave is true it will print "Saved", This has to be schdule to start in 10 seconds and repeat every 10 seconds.  */
        service.scheduleAtFixedRate(()->{
            if (checkSave())
                System.out.println("...Saved");
        },10L,10L, TimeUnit.SECONDS);

        // use a scanner to read every line the user writes
        Scanner kbd  = new Scanner(System.in);
        boolean finish = false;
        while(!finish){
            String text = kbd.nextLine();
            if(text.equals("quit"))
                finish=true;
            else if (text.startsWith("t:"))
                wp.addTitle(text.substring(2));
            else
                wp.addParagraph(text);
/* TODO
If the user types "quit" the loop ends. If the input starts with t: you add a title to the webpage. If not, you add a paragraph.*/
        }
        service.shutdownNow();/* TODO
Shutdown the threads NOW*/; // when the loop finishes, threads are stopped
    }

    public  boolean checkSave(){
        if(this.wp.toString().equals(this.temp))
            return false;
        else{
            wp.save(filename);
            temp = wp.toString();
            return true;
        }
        /* TODO 
If the text of the wp (String representation) is equal to the last String reperesentation (stored in tmp) returns false. Otherwise, it saves the webpage to the given filenam, tmp updates to the most current string representation of this webpage, and the funtion returns true.*/
    }
}
