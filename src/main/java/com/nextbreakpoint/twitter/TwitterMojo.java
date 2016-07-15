package com.nextbreakpoint.twitter;
 
import com.nextbreakpoint.Try;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Mojo(name = "updateStatus")
public class TwitterMojo extends AbstractMojo {
    @Parameter(property = "status")
    private String status;

    @Parameter(property = "debug")
    private Boolean debug;

    @Parameter(property = "oauthConsumerKey")
    private String oauthConsumerKey;

    @Parameter(property = "oauthConsumerSecret")
    private String oauthConsumerSecret;

    @Parameter(property = "oauthAccessToken")
    private String oauthAccessToken;

    @Parameter(property = "oauthAccessTokenSecret")
    private String oauthAccessTokenSecret;

    public String getStatus() {
        return status;
    }

    public void setStatus(String _status) {
        this.status = _status;
    }

    public Boolean isDebug() {
        return debug;
    }

    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    public String getOauthConsumerKey() {
        return oauthConsumerKey;
    }

    public void setOauthConsumerKey(String oauthConsumerKey) {
        this.oauthConsumerKey = oauthConsumerKey;
    }

    public String getOauthConsumerSecret() {
        return oauthConsumerSecret;
    }

    public void setOauthConsumerSecret(String oauthConsumerSecret) {
        this.oauthConsumerSecret = oauthConsumerSecret;
    }

    public String getOauthAccessToken() {
        return oauthAccessToken;
    }

    public void setOauthAccessToken(String oauthAccessToken) {
        this.oauthAccessToken = oauthAccessToken;
    }

    public String getOauthAccessTokenSecret() {
        return oauthAccessTokenSecret;
    }

    public void setOauthAccessTokenSecret(String oauthAccessTokenSecret) {
        this.oauthAccessTokenSecret = oauthAccessTokenSecret;
    }

    public void execute() throws MojoExecutionException {
        Try.of(() -> twitterFactory().updateStatus(getStatus()))
            .onFailure(error -> getLog().error("Can't update the status", error))
            .ifPresent(status -> getLog().info("Successfully updated the status to [" + status.getText() + "]."));
    }

    private Twitter twitterFactory() {
        return new TwitterFactory(getConfigurationBuilder().build()).getInstance();
    }

    private ConfigurationBuilder getConfigurationBuilder() {
        return new ConfigurationBuilder()
            .setDebugEnabled(isDebug())
            .setOAuthConsumerKey(getOauthConsumerKey())
            .setOAuthConsumerSecret(getOauthConsumerSecret())
            .setOAuthAccessToken(getOauthAccessToken())
            .setOAuthAccessTokenSecret(getOauthAccessTokenSecret());
    }
}