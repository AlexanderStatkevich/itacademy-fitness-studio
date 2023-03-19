package by.itacademy.jd2.mkjd295224.fitnessstudio.mail.dao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;


public interface EmailDao {

    @SqlUpdate("INSERT INTO emails (email, code) VALUES (:email, :code)")
    void save(@Bind("email") String email, @Bind("code") String code);

    @SqlQuery("SELECT count(*)>0 FROM emails WHERE email = :email AND code = :code")
    Boolean existsByEmailAndCode(@Bind("email") String email, @Bind("code") String code);
}
