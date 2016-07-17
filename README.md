# Twitter Maven Plugin 1.0.1

Twitter Maven Plugin updates the status of a Twitter account.
  
## License

Twitter Maven Plugin is distributed under the terms of BSD 3-Clause License.

    Copyright (c) 2016, Andrea Medeghini
    All rights reserved.
    
    Redistribution and use in source and binary forms, with or without
    modification, are permitted provided that the following conditions are met:
    
    * Redistributions of source code must retain the above copyright notice, this
      list of conditions and the following disclaimer.
    
    * Redistributions in binary form must reproduce the above copyright notice,
      this list of conditions and the following disclaimer in the documentation
      and/or other materials provided with the distribution.
    
    * Neither the name of Twitter Maven Plugin nor the names of its
      contributors may be used to endorse or promote products derived from
      this software without specific prior written permission.
    
    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
    AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
    IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
    DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
    FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
    DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
    SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
    CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
    OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
    OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

## Notice

Twitter Maven Plugin depends on Twitter4j ( http://twitter4j.org ).

    Twitter4j
    Copyright 2007 Yusuke Yamamoto
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
          http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    Distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

## Updating status of a Twitter account

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


 