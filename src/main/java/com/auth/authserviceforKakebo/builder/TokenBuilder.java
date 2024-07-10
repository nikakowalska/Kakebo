package com.auth.authserviceforKakebo.builder;

import java.time.Instant;

public class TokenBuilder {
    private String id;
    private String userName;
    private String activeTokenTime;
    private String tokenSeparator;

    public static TokenBuilder builder(String tokenSeparator) {
        return new TokenBuilder(tokenSeparator);
    }

    public TokenBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public TokenBuilder withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public TokenBuilder withActiveTokenTime(Long activeTokenTime) {
        this.activeTokenTime = Instant.now().plusSeconds(activeTokenTime).toString();
        return this;
    }

    public String build() {
        return "id=" + id +
                "userName=" + userName + tokenSeparator +
                "validTime=" + activeTokenTime + tokenSeparator;

    }
}
