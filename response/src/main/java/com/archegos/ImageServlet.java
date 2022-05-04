package com.archegos;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置浏览器每3秒自动刷新
        resp.setHeader("refresh","3");
        //在内存中创建一张照片
        BufferedImage image = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);
        //用笔来构建图片
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        //设置背景颜色
        graphics.setColor(Color.white);
        //画刷填充矩形
        graphics.fillRect(0,0,100,50);
        //给图片写数据
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font(null,Font.BOLD,20));
        graphics.drawString(makeNum(),0,20);

        //告诉浏览器 这个请求用图片方式打开
        resp.setContentType("image/jpg");
        //网站存在缓存，不让浏览器缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        //把图片写给浏览器
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
    //生成随机数验证码
    private String makeNum(){
        Random random = new Random();
        String num = random.nextInt(999999) + "";
        StringBuffer stringBuffer = new StringBuffer();
        //测试生成的随即数是不是6位的 不是的话自动补0
        for (int i = 0; i < 6-num.length(); i++) {
            stringBuffer.append("0");
        }
        num = stringBuffer.toString() + num;
        return num;
}




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
