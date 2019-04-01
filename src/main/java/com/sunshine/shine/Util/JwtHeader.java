package com.sunshine.shine.Util;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.Header;
import lombok.Data;

@Data
public class JwtHeader implements Header {
    @Override
    public String getAlgorithm() {
        return "HS256";
    }

    @Override
    public String getType() {
        return "JWT";
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public String getKeyId() {
        return null;
    }

    @Override
    public Claim getHeaderClaim(String s) {
        return null;
    }

}
