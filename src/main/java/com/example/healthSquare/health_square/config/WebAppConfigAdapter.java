package com.example.healthSquare.health_square.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/*created by Hector Developers
06-08-2019
*/

public class WebAppConfigAdapter extends WebMvcConfigurerAdapter {

    @Autowired
    InterceptorConfig interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

        System.out.println("this method will get invoked by container while deployment");
        System.out.println("value of interceptor is " + interceptor);
        //adding custom interceptor
        interceptorRegistry.addInterceptor(interceptor);
    }
}