/* TODO
Imports will be filling up as you need them. */

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class WebPage {
    public List<String> dom; // this actually has the html document model.

    public WebPage(){
        dom = new LinkedList<String>() /* TODO
//Initialize this to some kind of List */;
    }

    public void addTitle(String title){
        dom.add("<h1>"+title+"</h1>");
        /* TODO 
Add a title to the DOM*/
    }
    public void addParagraph(String par){
        dom.add("<p>"+par +"</p>") ;
    }

    /* TODO 
implement addParagraph that receives a String and puts it in the dom 
surrounded by <p> and </p>*/
    public String toString(){
        String html = "<html>\n<head>\n</head>\n<body>";
        for (int i=0; i< dom.size(); i++){
            html+= dom.get(i);
        }
        /* TODO
Loop through the elemments of the dom and append them to html */
        return html+"</body>\n</html>";
    }

    public void save(String filename){
        try(FileWriter out = new FileWriter(new File(filename))){
            out.write(this.toString());
        }catch(IOException e) {
            e.printStackTrace();
        }

        /* TODO 
Save a string representation of this webpage to the filename provided.*/
    }
}
