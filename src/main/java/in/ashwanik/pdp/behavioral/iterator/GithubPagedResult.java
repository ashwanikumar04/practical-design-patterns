package in.ashwanik.pdp.behavioral.iterator;

import in.ashwanik.pdp.common.githubjobs.BaseObject;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class GithubPagedResult<P extends List<T>, T extends BaseObject> implements Iterable<T>, Iterator<T> {
    private P pageCollection;
    private int index;
    private Function<P, P> nextPage;

    public GithubPagedResult(final UnaryOperator<P> nextPage) {
        this.nextPage = nextPage;
    }

    @Override
    public boolean hasNext() {
        if (index != -1 && (pageCollection == null || index >= pageCollection.size())) {
            pageCollection = nextPage.apply(pageCollection);
            if (pageCollection != null) {
                index = 0;
            } else {
                index = -1;
            }
        }

        return index != -1 && pageCollection != null && index < pageCollection.size();
    }

    @Override
    public T next() {
        return pageCollection.get(index++);
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return this;
    }
}
