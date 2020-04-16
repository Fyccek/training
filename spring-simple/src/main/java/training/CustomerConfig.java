package training;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.mysql.cj.jdbc.MysqlDataSource;

@ComponentScan
@Configuration
@PropertySource("classpath:application.properties")
public class CustomerConfig {
	
    @Bean
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/training?useUnicode=true");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        return dataSource;
    }
}