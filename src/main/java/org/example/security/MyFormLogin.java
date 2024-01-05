package org.example.security;

public class MyFormLogin implements SecurityFilter{
    private final MyHttpSecurity http;
    public MyFormLogin(MyHttpSecurity http) {
        this.http = http;
    }

    @Override
    public MyHttpSecurity and() {
        return http;
    }

    @Override
    public void build() {
        System.out.println("form login 이 빌드 됐습니다.");
    }
}
