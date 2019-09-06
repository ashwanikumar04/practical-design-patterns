package in.ashwanik.pdp.iterator;

import in.ashwanik.pdp.builder.GithubJobClient;
import in.ashwanik.pdp.common.githubjobs.GithubJob;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class GithubJobRepository {

    private GithubJobClient jobClient;

    public GithubJobRepository(GithubJobClient jobClient) {
        this.jobClient = jobClient;
    }


    public Iterable<GithubJob> getJobs() {
        AtomicInteger page = new AtomicInteger();
        page.set(0);
        final Supplier<List<GithubJob>> initialPage = () -> jobClient.getJobs(SearchFilter.builder().page(page.get()).build());
        final UnaryOperator<List<GithubJob>> nextPage =
                currentPage -> {
                    page.set(page.get() + 1);
                    return jobClient.getJobs(SearchFilter.builder().page(page.get()).build());
                };

        return new GithubPagedResult<>(currentPage -> currentPage == null ? initialPage.get() : nextPage.apply(currentPage));
    }
}
