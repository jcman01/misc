package naftalin;

import java.util.Collection;

interface MyCollection<E> {
    public boolean contains(E o);

    public boolean containsAll(Collection<? extends E> c);
}
