package by.itacademy.jd2.mkjd295224.fitnessstudio.mail.config;

import by.itacademy.jd2.mkjd295224.fitnessstudio.mail.dao.EmailDao;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.spring5.JdbiFactoryBean;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class JdbiConfiguration {

    //    @Bean
//    public Jdbi jdbi(DataSource dataSource, List<JdbiPlugin> jdbiPlugins, List<RowMapper<?>> rowMappers) {
//        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(dataSource);
//        Jdbi jdbi = Jdbi.create(proxy);
//        jdbiPlugins.forEach(jdbi::installPlugin);
//        rowMappers.forEach(jdbi::registerRowMapper);
//        return jdbi;
//    }

    @Bean
    public JdbiFactoryBean jdbi(DataSource dataSource) {
        return new JdbiFactoryBean(dataSource);
    }

    @Bean
    public List<JdbiPlugin> jdbiPlugins() {
        return List.of(new SqlObjectPlugin());
    }

    @Bean
    public EmailDao emailDao(Jdbi jdbi) {
        return jdbi.onDemand(EmailDao.class);
    }
}
