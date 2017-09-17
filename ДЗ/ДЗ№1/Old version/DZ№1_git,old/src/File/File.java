package File;

import Element.Element;
import HashGenerate.HashGenerate;

import java.util.Map;

/**
 * Created by lukig on 13.08.2017.
 */
public class  File implements Element{

    private String hashcode;
    private String content;

    public File(String content)
    {
        this.content = content;
        this.hashcode = HashGenerate.HashGenerate(content);
    }

    public String getHashCode()
    {
        return  hashcode;
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return "blob";
    }
    public void Add_to_Map(Map map)
    {
        map.put(this.getHashCode(), this.getContent());
    }
    public void Element_output()
    {
        System.out.println("File" + "\t" + hashcode);
        System.out.println();
    }
}
