package com.example.demo.service;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/10/15/015 10:52
 * @Version 1.0
 */
public interface PayService {
    /**
     * 模拟调用图片上传
     * @return
     * @throws InterruptedException
     */
    String upLoadPic() throws InterruptedException;

    /**
     *
     * 模拟调用支付系统
     * @return
     * @throws InterruptedException
     */
    void payMoney(double totalFee) throws InterruptedException;
    /**
     * 模拟订单处理
     * @return
     * @throws InterruptedException
     */
    double dealOrder(String userName) throws InterruptedException;
    /**
     * 模拟调用 中控服务器拿token等验证信息
     * @return
     * @throws InterruptedException
     */
    String getToken(String userName, String password) throws InterruptedException;
}
