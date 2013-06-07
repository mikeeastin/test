package com.sample.jcaptcha.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octo.captcha.service.image.ImageCaptchaService;
import com.sample.jcaptcha.service.SampleImageCaptchaService;

public class CaptchaValidationServlet extends HttpServlet {
	private static String className = CaptchaValidationServlet.class.getName();

	private static Logger logger = Logger.getLogger(className);

	private static final String USER_INPUT_NAME = "captcha_input";

	public static ImageCaptchaService service = SampleImageCaptchaService
			.getInstance();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userCaptchaResponse = request.getParameter(USER_INPUT_NAME);
		logger.info("user input=" + userCaptchaResponse);
		boolean isValid = validateResponse(request, userCaptchaResponse);
		if (isValid) {
			logger.info("user input validation succeed!");
			this.getServletConfig().getServletContext().getRequestDispatcher(
					"/success.jsp").forward(request, response);
		} else {
			request.setAttribute("ERROR", "抱歉，验证码输入错误，请重新输入!");
			this.getServletConfig().getServletContext().getRequestDispatcher(
					"/index.jsp").forward(request, response);
		}
	}

	private  boolean validateResponse(HttpServletRequest request,
			String userCaptchaResponse) {
		logger.entering(className, "validateResponse");
		boolean validated = false;
		try {
			logger.fine("Going to validate user's input, user's input="
					+ userCaptchaResponse);
			validated = service.validateResponseForID(
					request.getSession(true).getId(), userCaptchaResponse)
					.booleanValue();
		

			logger.fine("End of validating, result=" + validated);
		} catch (Exception e) {
			logger
					.severe("[Error]: Exception occurred when validating user's input, message="
							+ e.getMessage());
			e.printStackTrace();
		}
		logger.exiting(className, "validateResponse");
		return validated;
	}
	
	
}
