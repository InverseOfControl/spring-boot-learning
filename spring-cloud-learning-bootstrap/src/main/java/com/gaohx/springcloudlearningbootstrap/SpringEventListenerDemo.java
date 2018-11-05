package com.gaohx.springcloudlearningbootstrap;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class SpringEventListenerDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 添加监听
        //context.addApplicationListener(new MyListener());
        context.register(MyListener.class);
        // 启动上下文
        context.refresh();
        // 发布事件 必须在Spring启动成功之后发布事件
        context.publishEvent(new MyEvent("click"));
    }

    @Component
    public static class MyListener implements ApplicationListener<MyEvent>{

        @Override
        public void onApplicationEvent(MyEvent event) {
            System.out.println(event.getSource());
        }
    }

    public static class MyEvent extends ApplicationEvent{
        /**
         * Create a new ApplicationEvent.
         *
         * @param source the object on which the event initially occurred (never {@code null})
         */
        public MyEvent(Object source) {
            super(source);
        }
    }
}
