package ru.job4j.generic;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class AbstractStore<T extends Base> implements Store<T> {

    private SimpleArray<T> store;

    public AbstractStore(SimpleArray<T> store) {
        this.store = store;
    }

    @Override
    public void add(T model) {
        this.store.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        return this.store.set(this.findPositionById(id), model);
    }

    @Override
    public boolean delete(String id) {
        return this.store.remove(this.findPositionById(id));
    }

    @Override
    public T findById(String id) {
        int index = this.findPositionById(id);
        return index != -1 ? this.store.get(index) : null;
    }

    public int findPositionById(String id) {
        int rst = -1;
        int position = 0;
        for (T element : this.store) {
            if (element.getId().equals(id)) {
                rst = position;
            }
            position++;
        }
        return rst;
    }
}
