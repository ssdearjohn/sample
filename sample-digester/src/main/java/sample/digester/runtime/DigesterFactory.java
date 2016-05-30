package sample.digester.runtime;

import org.springframework.util.Assert;
import sample.digester.runtime.delegate.Delegate;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

/**
 * DigesterFactory.java
 * Description:it can create the target type of digester annalyse delegate
 * Created by John.Huwenxuan on 2016/4/13.
 */
public class DigesterFactory {

    public static <T> T create(Type ctype, InputStream is) {
        Assert.notNull(ctype, "ctype cannot be NULL!");
        Assert.notNull(is, "xmlfile cannot be NULL!");
        //
        T obj = null;
        try{
            String cTypeName = ctype.getTypeName();
            String tatgetClassName = cTypeName.substring(cTypeName.lastIndexOf(".")).concat("Delegate");
            Class<?> clazz = Class.forName("sample.digester.runtime.delegate".concat(tatgetClassName));
            Delegate<T> delegate = (Delegate<T>)clazz.getDeclaredConstructor().newInstance();
            //
            obj = delegate.digeste(is);
        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InvocationTargetException
                | IllegalAccessException
                | InstantiationException e){
            e.printStackTrace();
        }
        Assert.notNull(obj, "result cannot be NULL!");
        return obj;
    }

}
