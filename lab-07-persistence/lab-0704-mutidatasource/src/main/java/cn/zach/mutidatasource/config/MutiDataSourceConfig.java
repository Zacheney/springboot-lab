package cn.zach.mutidatasource.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author Zach
 * @date 2022/9/26 11:04
 */
@Configuration
@MapperScan(value = "cn.zach.mutidatasource.mapperone" ,sqlSessionFactoryRef = "oneSqlSessionFactory")
@MapperScan(value = "cn.zach.mutidatasource.mappertwo" ,sqlSessionFactoryRef = "twoSqlSessionFactory")
public class MutiDataSourceConfig {

    //创建两个不同的数据源
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.one")
    DataSource oneDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.two")
    DataSource twoDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    //分别注册到两个不同的SqlSessionFactory
    @Bean
    SqlSessionFactory oneSqlSessionFactory(@Qualifier("oneDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean
    SqlSessionFactory twoSqlSessionFactory(@Qualifier("twoDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // 扫描mybatis文件
        //注意这里是个坑，自己重写SqlSessionFactory的时候，就不会去扫描application.yml中配置的xml的文件路径了，所以这里需要手动去扫描
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }



    //分别注册到两个不同的SqlSessionTemplate
    @Bean
    SqlSessionTemplate oneSqlSessionTemplate(@Qualifier("oneSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    SqlSessionTemplate twoSqlSessionTemplate(@Qualifier("twoSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
