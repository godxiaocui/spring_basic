package com.czh.aop.calculator;

/**
 * @author godxiaocui
 * @date 2024/8/417:04
 */
public class testDynamicProxy {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new CalculatorLogImpl());
        Calculator proxy = (Calculator) factory.getProxy();
        proxy.div(1,1);
    }
}
