package com.recipe.today;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
@MapperScan(basePackages="com.recipe.today.domain.repository")
public class TodayRecipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodayRecipeApplication.class, args);
	}

	@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        // コンフィグファイルの読み込み
        sessionFactory.setConfigLocation(new ClassPathResource("/mybatis-config.xml"));

        return sessionFactory.getObject();
    }

}
