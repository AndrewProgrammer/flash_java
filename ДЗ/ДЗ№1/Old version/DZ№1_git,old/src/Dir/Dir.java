package Dir;

import File.File;
import HashGenerate.HashGenerate;

import javax.xml.bind.Element;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lukig on 13.08.2017.
 */
public class Dir implements Element {

    private String hashcode;
    private String content;

    /*private  enum Type {
        blob("blob"),
        tree("tree");


        private String type;
        Type(String type)
        {
            this.type = type;
        }

    }*/


    private List<Dir> dirs;
    private List<File> files;

    public Dir() {
        this.dirs = new ArrayList<>();
        this.files = new ArrayList<>();

        this.content = "";
        this.hashcode = HashGenerate.HashGenerate(content);
    }

    public void AddDir(Dir dir) {
        dirs.add(dir);
        content += "tree" + dir.getHashCode();
        hashcode = HashGenerate.HashGenerate(content);
    }

    public void AddFile(File file) {
        files.add(file);
        content += "blob" + file.getHashCode();
        hashcode = HashGenerate.HashGenerate(content);
    }

    public String getHashCode()
    {
        return  hashcode;
    }

    public String getContent() {
        return content;
    }

    public String getType()
    {
        return "tree";
    }
    public List<Dir> getDirs() {
        return dirs;
    }

    public List<File> getFiles() {
        return files;
    }
    //проверка на совпадение hash code по папкам
    public boolean keepDir(String dirhashcode)
    {
        for(Dir d: dirs){
            if(d.getHashCode().equals(dirhashcode))
            {
                return true;
            }
        }
        for(Dir d: dirs)
        {
            if(d.keepDir(dirhashcode))
            {
                return true;
            }
        }
        return false;
    }
    public Dir getDir(String dirhashcode)
    {
        for(Dir d : dirs)
        {
            if(d.getHashCode().equals(dirhashcode))
            {
                return d;
            }
        }
        for(Dir d : dirs)
        {
            if(d.keepDir(dirhashcode))
            {
                return d.getDir(dirhashcode);
            }
        }
        return null;
    }
    //Must be done
    /*public boolean keepElement(String elementhashcode)
    {
        for(Element d: dirs)
        {
            if(d.getHashCode().equals(elementhashcode))
            {
                return true;
            }
        }
        for(Element d: files)
        {
            if(d.getHashCode().equals(elementhashcode))
            {
                return true;
            }
        }
        for(Dir d: dirs)
        {
            if(d.getHashCode().equals(elementhashcode))
            {
                return true;
            }
        }
    }*/
    //Must be done
    /*public Element getElement(String elementhashcode)
    {
        for(Element d: dirs)
        {
            if(d.getHashCode().equals(elementhashcode))
            {
                return d;
            }
        }
        for (Element d: files)
        {
            if(d.getHashCode().equals(elementhashcode))
            {
                return d;
            }
        }
        for(Dir d : dirs)
        {
            if(d.keepElement(elementhashcode))
            {
                return d.getElement(elementhashcode);
            }
        }
        return null;
    }*/

    public void Add_to_Map(Map map)
    {
        map.put(this.getHashCode(),this.getContent());
        for(Dir d: dirs)
        {
            d.Add_to_Map(map);
        }
        for(File d : files)
        {
            d.Add_to_Map(map);
        }
    }
    public void Element_Ouput()
    {
        System.out.println("dir\t");
        System.out.println(hashcode);
        System.out.println();

        for(Dir d: dirs)
        {
            d.Element_Ouput();
        }
        for(File d : files)
        {
            d.Element_output();
        }
    }

}
