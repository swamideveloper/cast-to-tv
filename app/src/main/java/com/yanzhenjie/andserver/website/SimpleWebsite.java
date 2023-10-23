package com.yanzhenjie.andserver.website;

import com.yanzhenjie.andserver.view.View;

import java.io.File;
import java.io.IOException;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.protocol.HttpContext;

public abstract class SimpleWebsite implements WebSite {
    
    public abstract View handle(HttpRequest httpRequest) throws HttpException, IOException;

    
    public String addStartSlash(String str) {
        String str2 = File.separator;
        if (str.startsWith(str2)) {
            return str;
        }
        return str2 + str;
    }

    
    public String addEndSlash(String str) {
        String str2 = File.separator;
        if (str.endsWith(str2)) {
            return str;
        }
        return str + str2;
    }

    
    public String trimStartSlash(String str) {
        while (str.startsWith(File.separator)) {
            str = str.substring(1);
        }
        return str;
    }

    
    public String trimEndSlash(String str) {
        while (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    @Override
    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        View handle = handle(httpRequest, httpResponse);
        httpResponse.setStatusCode(handle.getHttpCode());
        httpResponse.setEntity(handle.getHttpEntity());
        httpResponse.setHeaders(handle.getHeaders());
    }

    
    public View handle(HttpRequest httpRequest, HttpResponse httpResponse) throws HttpException, IOException {
        return handle(httpRequest);
    }
}
