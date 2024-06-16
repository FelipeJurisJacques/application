package org.application.core.pool;

import org.application.core.Console;
import org.application.core.util.List;
import org.application.core.directrix.Directrix;

public class Pool<T> extends Directrix {
    private List<Factory> pools;

    private class Factory {
        private T value;
        private boolean take;
    }

    public Pool() {
        pools = new List<Factory>();
    }

    public T acquire() {
        for (Factory pool : pools) {
            if (!pool.take) {
                if (pool.value instanceof Reusable) {
                    Reusable value = (Reusable) pool.value;
                    value.reset();
                }
                pool.take = true;
                return pool.value;
            }
        }
        return null;
    }

    public void release(T obj) {
        boolean has = false;
        for (Factory pool : pools) {
            if (obj == pool.value) {
                has = true;
                pool.take = false;
                break;
            }
        }
        if (!has) {
            Factory pool = new Factory();
            pool.take = false;
            pool.value = obj;
            pools.push(pool);
            Console.log(pools.length());
        }
    }
}
