package in.ashwanik.pdp.behavioral.iterator;

import in.ashwanik.pdp.creational.builder.GithubJobClient;
import in.ashwanik.pdp.common.githubjobs.GithubJob;
import okhttp3.OkHttpClient;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PagingIteratorUnitTest {
    @Test
    public void testGetJobs() {
        GithubJobClient client = GithubJobClient.builder()
                .baseUrl("https://jobs.github.com/")
                .clientContract(new DefaultGithubJobClientContract())
                .httpClient(new OkHttpClient.Builder().build())
                .build();
        List<GithubJob> jobs = new ArrayList<>();
        GithubJobRepository repository = new GithubJobRepository(client);
        for (GithubJob job : repository.getJobs()) {
            jobs.add(job);
        }

        assertThat(jobs.size()).isGreaterThan(0);
    }
}

