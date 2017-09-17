package Element;

import java.util.Map;

/**
 * Created by lukig on 13.08.2017.
 */
public interface Element {
    String getContent();
    String getHashCode();
    String getType();
    void Add_to_Map(Map map);
}
