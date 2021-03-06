package in.ashwanik.pdp.structural.decorator;

import in.ashwanik.pdp.common.githubjobs.GithubJob;
import in.ashwanik.pdp.common.githubjobs.GithubJobClientContract;
import in.ashwanik.pdp.common.http.RequestParam;
import in.ashwanik.pdp.common.http.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheGithubJobClientContract implements GithubJobClientContract {

    private final GithubJobClientContract contract;
    private Map<String, List<GithubJob>> cache;

    public CacheGithubJobClientContract(GithubJobClientContract contract) {
        this.contract = contract;
        cache = new HashMap<>();
    }

    @Override
    public List<GithubJob> getJobs(RestClient restClient,
                                   RequestParam requestParam) {
        cache.computeIfAbsent(requestParam.getUrl(), k -> contract.getJobs(restClient, requestParam));
        return cache.get(requestParam.getUrl());
    }
}
