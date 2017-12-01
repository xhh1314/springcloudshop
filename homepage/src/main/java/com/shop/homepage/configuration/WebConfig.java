package com.shop.homepage.configuration;



import com.shop.homepage.web.filter.CSRFTokenInterceptor;
import com.shop.homepage.web.filter.EncodingFilter;
import com.shop.homepage.web.filter.PermissionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//注：这里的配置可以直接写在xml文件中，通过@ImportResource注解即可导入配置类中

@Configuration
//@EnableWebMvc 加上这个注解后很多自动配置的东西都失效了，不知道是不是bug
public class WebConfig  extends WebMvcConfigurerAdapter  {
	
	
	/*//指定视图解析器
	@Bean
	public ViewResolver  viewResolver(){	
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");	
		resolver.setExposeContextBeansAsAttributes(true);//使得可以在JSP页面中通过${ }访问容器中的bean
		return resolver;
	}*/
	//注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		super.addInterceptors(registry);
		registry.addInterceptor(new PermissionInterceptor()).addPathPatterns("/forePermission/*");
		registry.addInterceptor(new EncodingFilter()).addPathPatterns("/**");
		registry.addInterceptor(new CSRFTokenInterceptor()).addPathPatterns("/**");
	}
	
	//注册资源路径
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/staic/**").addResourceLocations("/static/");
		registry.addResourceHandler("/staic/**").addResourceLocations("/templates/static/");
	}

	
	

}
