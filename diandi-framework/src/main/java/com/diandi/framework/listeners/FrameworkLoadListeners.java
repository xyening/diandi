package com.diandi.framework.listeners;

import com.diandi.framework.configurations.PropertiesConfiguration;
import com.diandi.framework.filters.CrossDomainFilter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;

/**
 * Created by len.li on 2016/4/12.
 * 容器启动监听入口类,在web.xml上配置
 */
public class FrameworkLoadListeners implements ServletContextListener {

    protected final Log logger = LogFactory.getLog(FrameworkLoadListeners.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        logger.info(PropertiesConfiguration.getMsDisconfScanpackage());
        // spring characterEncodingFilter
        ServletContext servletContext = sce.getServletContext();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        servletContext.addFilter("encodingFilter",characterEncodingFilter).addMappingForUrlPatterns(null,false,"/*");

        // 开启跨域请求添加跨域过滤器
        if(PropertiesConfiguration.getMsCrossDomain()){
            logger.info("开启跨域请求.");
            servletContext.addFilter("crossDomainFilter",new CrossDomainFilter(PropertiesConfiguration.getMsCrossAlloworigin(),
                    PropertiesConfiguration.getMsCrossAllowheaders(),PropertiesConfiguration.getMsCrossAllowmethods(),
                    PropertiesConfiguration.getMsCrossMaxage())).addMappingForUrlPatterns(null,false,PropertiesConfiguration.getMsCrossDomainUrl());
        }

        // 启用spring mvc 执行
        logger.info("start spring mvc");
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(false);
        dispatcherServlet.setContextConfigLocation("classpath*:spring/spring-*.xml");
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet(PropertiesConfiguration.getMsApplicationName()
                ,dispatcherServlet);
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
