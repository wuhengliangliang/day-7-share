package liangliang.bigdata.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


/**
 *Create by 彭亮
 */
@Configuration  //成为配置类
@EnableJpaRepositories(basePackages = "liangliang.bigdata.repository") //扫描仓库类
@EnableTransactionManagement
public class JPAConfig {
    //建立一个数据源
    @Bean  //配置
    //配置源属性前缀,//建立好数据源需要一些属性
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
    //实体类的管理工厂
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        //实例化实体类的管理工厂
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        //是否生成sql,这里是否，我们需要把所有的控制权掌握在自己的手里
        jpaVendorAdapter.setGenerateDdl(false);

        //设置数据源
        entityManagerFactory.setDataSource(dataSource());
        //设置刚刚sql管理
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        //设置我们所需要寻找的实体类的包名
        entityManagerFactory.setPackagesToScan("liangliang.bigdata.entity");

        return entityManagerFactory;
    }
    //需要实例化一个事物管理的类
    @Bean
    //让spring帮我们注入之前的映射管理类
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }


}
