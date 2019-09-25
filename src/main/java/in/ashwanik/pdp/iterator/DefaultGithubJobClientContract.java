package in.ashwanik.pdp.iterator;

import in.ashwanik.pdp.common.githubjobs.BaseObject;
import in.ashwanik.pdp.common.githubjobs.GithubJob;
import in.ashwanik.pdp.common.githubjobs.GithubJobClientContract;
import in.ashwanik.pdp.common.http.RequestParam;
import in.ashwanik.pdp.common.http.RestClient;
import in.ashwanik.pdp.common.http.RestResponse;

import java.util.Arrays;
import java.util.List;

public class DefaultGithubJobClientContract implements GithubJobClientContract {

    @Override
    public List<GithubJob> getJobs(RestClient restClient,
                                   RequestParam requestParam) {
        RestResponse<GithubJob[], BaseObject> data = restClient.get(GithubJob[].class, BaseObject.class, requestParam);
        return Arrays.asList(data.getSuccess());
    }
}
