package cn.zach.springsecurity.config;

import cn.zach.springsecurity.entity.Menu;
import cn.zach.springsecurity.entity.Role;
import cn.zach.springsecurity.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zach
 * @date 2022/10/1 20:21
 */
@Component
public class CustFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 返回请求的url所需要的角色
     * @param
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<Menu> menus = menuMapper.getAllMenus();
        for (Menu menu : menus) {
            if (antPathMatcher.match(menu.getPattern(), requestUrl)) {
                String[] roleArr = menu.getRoles().stream().map(Role::getName).toArray(String[]::new);
                return SecurityConfig.createList(roleArr);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    /**
     * 返回所有定义的权限资源，Spring Security在启动时会校验每个ConfigAttribute是否配置正确，如果我们使用动态权限控制那就不需要实现这个方法
     *
     * @return
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /**
     * 表示当前的FilterInvocationSecurityMetadataSource是否支持传递的ConfigAttribute
     *
     * @param
     * @return
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
