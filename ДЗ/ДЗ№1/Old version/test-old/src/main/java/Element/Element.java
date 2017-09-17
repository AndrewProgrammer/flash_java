package Element;

import java.util.Map;

public interface Element {
    String getContent();
    String getHashCode();
    String getType();
    void Add_to_Map(Map map);
}
