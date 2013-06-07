// Copyright (c) 1998-2013 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2013-XX-XX, Mike.Mai, creation
// ============================================================================

package org.mike.app.controller;

/**
 * @author Mike.Mai
 *
 */
   import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

   /**
    * 防止Captcha机器人登陆
    * @author liuwang
    *
    */
   @Controller
   @RequestMapping("/kaptcha/*")
   public class CaptchaController {

       @Autowired
       private final Producer captchaProducer = null;

       @RequestMapping
       public ModelAndView getKaptchaImage(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
           final HttpSession session = request.getSession();
           final String code = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
           System.out.println("****************** 验证码是: " + code + "******************");

           response.setDateHeader("Expires", 0);

           // Set standard HTTP/1.1 no-cache headers.
           response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

           // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
           response.addHeader("Cache-Control", "post-check=0, pre-check=0");

           // Set standard HTTP/1.0 no-cache header.
           response.setHeader("Pragma", "no-cache");

           // return a jpeg
           response.setContentType("image/jpeg");

           // create the text for the image
           final String capText = captchaProducer.createText();

           // store the text in the session
           session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

           // create the image with the text
           final BufferedImage bi = captchaProducer.createImage(capText);
           final ServletOutputStream out = response.getOutputStream();

           // write the data out
           ImageIO.write(bi, "jpg", out);
           try {
               out.flush();
           } finally {
               out.close();
           }
           return null;
       }

   }

