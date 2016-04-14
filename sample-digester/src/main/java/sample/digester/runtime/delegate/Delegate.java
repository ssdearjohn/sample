package sample.digester.runtime.delegate;

import java.io.InputStream;

/**
 * Delegate.java
 * Description: digester annalyse delegate interface
 * Created by John.Huwenxuan on 2016/4/13.
 */
public interface Delegate<T> {

    T digeste(InputStream is);

}
