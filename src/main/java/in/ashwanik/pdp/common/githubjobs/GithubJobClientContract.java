package in.ashwanik.pdp.common.githubjobs;

import in.ashwanik.pdp.common.http.RequestParam;
import in.ashwanik.pdp.common.http.RestClient;

import java.util.List;

public interface GithubJobClientContract {
    List<GithubJob> getJobs(RestClient restClient, RequestParam requestParam);
}
