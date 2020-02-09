package com.xycode.springLecture.demos.factory;

import com.xycode.springLecture.demos.serviceImpl.AppServiceImpl;
import com.xycode.springLecture.demos.service.Service;

/**
 * ClassName: ServiceFactory
 *
 * @Author: xycode
 * @Date: 2020/2/7
 * @Description: this is description of the ServiceFactory class
 **/
public class ServiceFactory {
    public static Service getAppService(){
        return new AppServiceImpl();
    }

    public static Service getAppServiceWithArgs(){
        return new AppServiceImpl("alpha");
    }
}
