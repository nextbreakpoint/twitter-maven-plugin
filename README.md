# Twitter Maven Plugin 1.0.1

Twitter Maven Plugin updates the status of a Twitter account.

## How to use

Add plugin to your POM:

    <profile>
        <id>twitter</id>
        <activation>
            <property>
                <name>channel</name>
                <value>twitter</value>
            </property>
        </activation>
        <build>
            <plugins>
                <plugin>
                    <groupId>com.nextbreakpoint</groupId>
                    <artifactId>twitter-maven-plugin</artifactId>
                    <version>1.0.1</version>
                    <configuration>
                        <debug>false</debug>
                        <oauthConsumerKey>${consumerKey}</oauthConsumerKey>
                        <oauthConsumerSecret>${consumerSecret}</oauthConsumerSecret>
                        <oauthAccessToken>${accessToken}</oauthAccessToken>
                        <oauthAccessTokenSecret>${accessTokenSecret}</oauthAccessTokenSecret>
                        <status>Version ${project.version} of ${project.name} has been released! ${project.url}</status>
                    </configuration>
                </plugin>
            </plugins>
        </build>
    </profile>

Define Twitter secrets in settings.xml:

    <settings>
      <profiles>
        ...
        <profile>
          <id>twitter</id>
          <activation>
            <property>
              <name>channel</name>
              <value>twitter</value>
            </property>
          </activation>
          <properties>
            <consumerKey>...</consumerKey>
            <consumerSecret>...</consumerSecret>
            <accessToken>...</accessToken>
            <accessTokenSecret>...</accessTokenSecret>
          </properties>
        </profile>
        ...
      </profiles>
    </settings>

Run the plugin with the command:

    mvn -Dchannel=twitter com.nextbreakpoint:twitter-maven-plugin:updateStatus


 