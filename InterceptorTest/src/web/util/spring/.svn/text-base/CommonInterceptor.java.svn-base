package web.util.spring;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Spring MVC拦截器
 *
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {
	
	static Log log = LogFactory.getLog(CommonInterceptor.class);
	
	/**
	 * 在系统启动时执行
	 */
	public void afterPropertiesSet() throws Exception {
		log.debug("=======初始化CommonInterceptor拦截器=========");
		System.out.println("afterPropertiesSet============");
	}
	
	/**
	 * 在Controller方法前进行拦截
	 * 如果返回false
	 * 		从当前拦截器往回执行所有拦截器的afterCompletion方法,再退出拦截器链.
	 * 如果返回true
	 * 		执行下一个拦截器,直到所有拦截器都执行完毕.
	 * 		再运行被拦截的Controller.
	 * 		然后进入拦截器链,从最后一个拦截器往回运行所有拦截器的postHandle方法.
	 * 		接着依旧是从最后一个拦截器往回执行所有拦截器的afterCompletion方法.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		log.debug("=====preHandle====");
		//业务逻辑
		System.out.println("preHandle=========");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.debug("==========postHandle=========");
		 System.out.println("PostHandle=========");
		if(modelAndView != null){
			String viewName = modelAndView.getViewName();
			log.debug("view name : " + viewName);
		}else{
			log.debug("view is null");
		}
	}
	
	/**
	 * 在Controller方法后进行拦截
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有拦截器的afterCompletion方法
	 */
	@Override
	public void afterCompletion(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj,
			Exception exception) throws Exception {
		log.debug("=====afterCompletion====");
		System.out.println("afterCompletion=========");
	}

	
}
