package org.example.security;

public class MyRememberMe implements SecurityFilter{
    private final MyHttpSecurity http;

    public MyRememberMe(MyHttpSecurity http) {
        this.http = http;
    }

    @Override
    public MyHttpSecurity and() {
        return http;
    }

    @Override
    public void build() {
        System.out.println("rememberMe 가 build 됐습니다.");
    }
}
