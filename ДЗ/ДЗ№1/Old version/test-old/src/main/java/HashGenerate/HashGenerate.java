package HashGenerate;

import org.apache.commons.codec.digest.DigestUtils;

public class HashGenerate {

    HashGenerate()
    {
        String hashValue = "";
        DigestUtils.sha1Hex(hashValue);
    }

    public static String HashGenerate(String key) {
        return key = DigestUtils.sha1Hex(key);
    }
}