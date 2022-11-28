package org.eclipse.opensmartclide.tdreusabilityapi.controller.principal.entity;

public class RequestBodyAnalysis {

    private String gitURL;
    private String token;

    public RequestBodyAnalysis(String gitURL) {
        this.gitURL = gitURL;
    }

    public RequestBodyAnalysis(String gitURL, String token) {
        this.gitURL = gitURL;
        this.token = token;
    }

    public String getGitURL() {
        return gitURL;
    }

    public String getToken() {
        return token;
    }

}
