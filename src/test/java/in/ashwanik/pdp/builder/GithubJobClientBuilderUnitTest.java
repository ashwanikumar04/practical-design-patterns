package in.ashwanik.pdp.builder;

import in.ashwanik.pdp.common.GithubJobClientContract;
import okhttp3.OkHttpClient;
import org.junit.Test;

public class GithubJobClientBuilderUnitTest {
    @Test
    public void testBuilder() {
        GithubJobClient client = GithubJobClient.builder()
                .jobSearchUrl("https://jobs.github.com/positions.json")
                .jobUrl("https://jobs.github.com/positions/{0}.json")
                .clientContract(new TestGithubClientContract())
                .httpClient(new OkHttpClient.Builder().build())
                .build();
    }


    private class TestGithubClientContract extends GithubJobClientContract {

    }

}
