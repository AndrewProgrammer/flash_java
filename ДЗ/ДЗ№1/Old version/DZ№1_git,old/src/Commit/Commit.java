package Commit;

import Element.Element;
import HashGenerate.HashGenerate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by lukig on 13.08.2017.
 */
public class Commit implements Element {

    private String hashcode;
    private String parent;
    private String tree;
    private String message;
    private Date date;

    public Commit(String treehashcode, String parenthashcode, String message)
    {
        this.tree = treehashcode;
        this.parent = parenthashcode;
        String content = "tree" + treehashcode;
        content += "\nparent " + parenthashcode;
        this.hashcode = HashGenerate.HashGenerate(content);
        this.message = message;
        this.date = new Date();
    }
    public Commit(String treehashcode,String message)
    {
        this.tree = treehashcode;
        this.parent = null;

        String content = "tree" + treehashcode;
        this.hashcode = HashGenerate.HashGenerate(content);
        this.message = message;
        this.date = new Date();
    }
    public String getContent()
    {
        String temp = "tree" + tree;
        if(parent != null)
        {
            temp += "\nparent" + parent;
        }
        temp += "\n" + message;
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM..yyyy hh:mm:ss a");
        temp += "\n" + ft.format(this.date);
        return temp;
    }
    public String getHashCode(){
        return hashcode;
    }
    public String getType()
    {
        return "commit";
    }
    public void Add_to_Map(Map map)
    {
        map.put(this.getHashCode(), this.getContent());
    }
}
