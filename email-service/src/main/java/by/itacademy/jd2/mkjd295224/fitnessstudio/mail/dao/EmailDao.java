package by.itacademy.jd2.mkjd295224.fitnessstudio.mail.dao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;


public interface EmailDao {

    @SqlQuery
    Boolean save(@Bind("email") String email, @Bind("code") String code);

    @SqlQuery("SELECT count(*)>0 FROM emails WHERE email = :email AND code = :code")
    Boolean existsByEmailAndCode(@Bind("email") String email, @Bind("code") String code);
}
