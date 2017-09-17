package HashGenerate;
import org.apache.commons.codec.digest.DigestUtils;


/**
 * Created by lukig on 11.08.2017.
 */
public class HashGenerate {

    HashGenerate()
    {
        String hashValue = "";
        DigestUtils.sha1Hex(hashValue);
    }

    public static String HashGenerate(String key) {
        return key = DigestUtils.sha1Hex(key);
    }
    //Приоритет ошибки №3
    //Метод который будет в качестве аргумента передавать в
    //в вызов функции sha1Hex ссылку на переменную content либо children
    //При подходящем типом данных без него нельзя выполнить 3 задание
}