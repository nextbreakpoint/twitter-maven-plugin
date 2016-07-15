package com.nextbreakpoint.twitter;

import com.nextbreakpoint.Try;
import org.apache.maven.plugin.MojoExecutionException;

public class TestTwitterMojo {
    public static void main(String[] args) {
        Try.of(TestTwitterMojo::run).ifFailure(System.out::println);
    }

    private static Object run() throws MojoExecutionException {
        TwitterMojo mojo = new TwitterMojo();
        mojo.setOauthConsumerKey(System.getProperty("twitter4j.oauth.consumerKey"));
        mojo.setOauthConsumerSecret(System.getProperty("twitter4j.oauth.consumerSecret"));
        mojo.setOauthAccessToken(System.getProperty("twitter4j.oauth.accessToken"));
        mojo.setOauthAccessTokenSecret(System.getProperty("twitter4j.oauth.accessTokenSecret"));
        mojo.setStatus("test");
        mojo.setDebug(true);
        mojo.execute();
        return null;
    }
}
