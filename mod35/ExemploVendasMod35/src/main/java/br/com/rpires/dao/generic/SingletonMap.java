package br.com.rpires.dao.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rodrigo.pires
 *
 * Classe Singleton que garante que o <code>map</code> será único em toda a vita da aplicação.
 *
 */
public class SingletonMap {

    private static SingletonMap singletonMap;

    protected Map<Class, Map<?, ?>> map;

    private SingletonMap() {
        map = new HashMap<>();
    }

    public static SingletonMap getInstance() {
        if (singletonMap == null) {
            singletonMap = new SingletonMap();
        }
        return singletonMap;
    }

    public Map<Class, Map<?, ?>> getMap() {
        return this.map;
    }
}
