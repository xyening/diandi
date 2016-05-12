package com.diandi.security.core;

import org.springframework.beans.factory.BeanClassLoaderAware;

/**
 * Created by lenli on 16/4/23.
 */
public class App {

    public static void main(String[] args) throws Exception{
//        HttpSecurity  httpSecurity = new HttpSecurity();
//        httpSecurity.antMatcher()

        BeanClassLoaderAware beanClassLoaderAware = new BeanClassLoaderAware() {
            public void setBeanClassLoader(ClassLoader classLoader) {
            }
        };
    }
}
