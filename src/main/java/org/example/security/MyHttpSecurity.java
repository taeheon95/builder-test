package org.example.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyHttpSecurity {
    private List<MyAuthorizeHttpRequest> myAuthorizeHttpRequests = new ArrayList<>();
    private Optional<MyFormLogin> myFormLogin = Optional.empty();
    private Optional<MyRememberMe> myRememberMe = Optional.empty();

    public MyAuthorizeHttpRequest myAuthorizeHttpRequests() {
        MyAuthorizeHttpRequest myAuthorizeHttpRequest = new MyAuthorizeHttpRequest(this);
        myAuthorizeHttpRequests.add(myAuthorizeHttpRequest);
        return myAuthorizeHttpRequest;
    }

    public MyFormLogin myFormLogin() {
        return myFormLogin.orElseGet(() -> {
            myFormLogin = Optional.ofNullable(new MyFormLogin(this));
            return myFormLogin.get();
        });
    }

    public MyRememberMe myRememberMe() {
        return myRememberMe.orElseGet(() -> {
            myRememberMe = Optional.ofNullable(new MyRememberMe(this));
            return myRememberMe.get();
        });
    }

    public void build() {
        System.out.println("http security 가 빌드 시작했습니다.");
        myAuthorizeHttpRequests.forEach(MyAuthorizeHttpRequest::build);
        myFormLogin.ifPresent(MyFormLogin::build);
        myRememberMe.ifPresent(MyRememberMe::build);
        System.out.println("http security 가 빌드 완료됐습니다.");
    }
}
