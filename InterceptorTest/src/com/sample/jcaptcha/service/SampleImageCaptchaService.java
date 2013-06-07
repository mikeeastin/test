package com.sample.jcaptcha.service;

import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

/**
 * Singleton class to get ImageCaptchaService instance
 * 
 * @author guangqingzhong
 *
 */
public class SampleImageCaptchaService  {

	private static ImageCaptchaService instance;

	/**
	 * Get default manageable image captcha service
	 * @return ImageCaptchaService
	 */
	public static ImageCaptchaService getInstance() {
		if (instance == null) {
			instance = new DefaultManageableImageCaptchaService();
		}
		return instance;
	}

}
