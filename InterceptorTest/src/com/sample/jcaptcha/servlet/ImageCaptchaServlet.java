package com.sample.jcaptcha.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octo.captcha.service.image.ImageCaptchaService;
import com.sample.jcaptcha.service.SampleImageCaptchaService;

public class ImageCaptchaServlet extends HttpServlet {
	private static String className = ImageCaptchaServlet.class.getName();

	private static Logger logger = Logger.getLogger(className);


	public static ImageCaptchaService service = SampleImageCaptchaService
			.getInstance();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws ServletException,
			IOException {
		logger.entering(className, "doPost");
		// set content type as jpeg
		httpServletResponse.setHeader("Cache-Control", "no-store");
		httpServletResponse.setHeader("Pragma", "no-cache");
		httpServletResponse.setDateHeader("Expires", 0);
		httpServletResponse.setContentType("image/jpeg");

		// create the image using session ID
		logger.fine("tring to get image captcha service");
		BufferedImage bufferedImage = service
				.getImageChallengeForID(httpServletRequest.getSession(true)
						.getId());

		ServletOutputStream servletOutputStream = httpServletResponse
				.getOutputStream();

		// write the image to the servlet output stream
		logger.fine("tring to output buffered image to servlet output stream");
		ImageIO.write(bufferedImage, "jpg", servletOutputStream);
	
		try {
			servletOutputStream.flush();
		} finally {
			servletOutputStream.close();
		}
		logger.exiting(className, "doPost");
	}

	/**
	 * Validate user's input
	 * 
	 * @param sessionID
	 * @param userCaptchaResponse
	 * @return
	 */
	public static boolean validateResponse(String sessionID,
			String userCaptchaResponse) {
		logger.entering(className, "validateResponse");
		boolean validated = false;
		try {
			logger.fine("Going to validate user's input, user's input="
					+ userCaptchaResponse);
			validated = service.validateResponseForID(sessionID,
					userCaptchaResponse).booleanValue();
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
