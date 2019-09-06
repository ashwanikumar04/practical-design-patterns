package in.ashwanik.pdp.common.githubjobs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GithubJob extends BaseObject{
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("company_url")
    @Expose
    private String companyUrl;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("how_to_apply")
    @Expose
    private String howToApply;
    @SerializedName("company_logo")
    @Expose
    private String companyLogo;
}
