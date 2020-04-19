package lib;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class getConfig {

    //获取配置文件中的value
public static String getValueByKey(String key) throws IOException {

    String configList[]={"data.properties","url.properties"};

    String result=null;
    for (int i = 0; i < configList.length; i++) {
        String s = configList[i];
        Properties pro=new Properties();
        InputStream input=new BufferedInputStream(new FileInputStream(s));
        try {
            pro.load(input);
            result=pro.getProperty(key);
            if (result!=null){
                return result;
            }
            input.close();
        } catch (IOException e) {
            input.close();
            e.printStackTrace();
        }

    }
    return result;
}











}
