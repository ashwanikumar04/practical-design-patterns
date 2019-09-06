package in.ashwanik.pdp.decorator;

import in.ashwanik.pdp.builder.GithubJobClient;
import in.ashwanik.pdp.common.githubjobs.GithubJob;
import in.ashwanik.pdp.iterator.DefaultGithubJobClientContract;
import in.ashwanik.pdp.iterator.GithubJobRepository;
import okhttp3.OkHttpClient;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestCacheJobClient {
    @Test
    public void testCacheGetJobs() {
        GithubJobClient client = GithubJobClient.builder()
                .baseUrl("https://jobs.github.com/")
                .clientContract(new CacheGithubJobClientContract(new DefaultGithubJobClientContract()))
                .httpClient(new OkHttpClient.Builder().build())
                .build();
        List<GithubJob> jobs = new ArrayList<>();
        GithubJobRepository repository = new GithubJobRepository(client);
        long startTime = System.currentTimeMillis();
        for (GithubJob job : repository.getJobs()) {
            jobs.add(job);
        }
        long difference = System.currentTimeMillis() - startTime;
        assertThat(jobs.size()).isGreaterThan(0);
        startTime = System.currentTimeMillis();
        for (GithubJob job : repository.getJobs()) {
            jobs.add(job);
        }
        long cachedDifference = System.currentTimeMillis() - startTime;
        assertThat(cachedDifference).isLessThan(difference);
    }
}
