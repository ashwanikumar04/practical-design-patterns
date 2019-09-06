package in.ashwanik.pdp.builder;

import in.ashwanik.pdp.common.githubjobs.GithubJob;
import in.ashwanik.pdp.common.githubjobs.GithubJobClientContract;
import in.ashwanik.pdp.common.http.RequestParam;
import in.ashwanik.pdp.common.http.RestClient;
import okhttp3.OkHttpClient;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GithubJobClientBuilderUnitTest {
    @Test
    public void testBuilder() {
        GithubJobClient client = GithubJobClient.builder()
                .baseUrl("https://jobs.github.com/")
                .clientContract(new TestGithubClientContract())
                .httpClient(new OkHttpClient.Builder().build())
                .build();

        assertThat(client).isNotNull();
    }


    private class TestGithubClientContract implements GithubJobClientContract {


        @Override
        public List<GithubJob> getJobs(RestClient restClient, RequestParam requestParam) {
            return null;
        }
    }
}
