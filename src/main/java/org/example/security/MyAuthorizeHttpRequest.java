package org.example.security;

public class MyAuthorizeHttpRequest implements SecurityFilter{
    private MyHttpSecurity http;
    public MyAuthorizeHttpRequest(MyHttpSecurity http) {
        this.http = http;
    }

    @Override
    public MyHttpSecurity and() {
        return http;
    }

    @Override
    public void build() {
        System.out.println("MyAuthorizeHttpRequest 가 빌드 됐습니다.");
    }

}
