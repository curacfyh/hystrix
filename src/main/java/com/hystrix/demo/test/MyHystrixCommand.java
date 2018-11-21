package com.hystrix.demo.test;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.Future;

/**
 * @description:
 * @author: 周勇
 * @date: 2018/11/21 11:35
 */
public class MyHystrixCommand extends HystrixCommand<String> {

    private String name;

    protected MyHystrixCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() {
        return "hello";
    }


    public static void main(String[] args) throws Exception {
        MyHystrixCommand command = new MyHystrixCommand("");
        Future<String> future = command.queue();
        System.out.println(future.get());
    }

}
