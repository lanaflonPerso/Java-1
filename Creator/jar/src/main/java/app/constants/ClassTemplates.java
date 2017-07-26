package app.constants;

/**
 * Created by Hristo Skipernov on 22/07/2017.
 */
public final class ClassTemplates {

    public static final String SERVICE_IMPLEMENTATION_TEMPLATE = "package %3$s.services;\n" +
            "\n" +
            "import %4$s;\n" +
            "import %3$s.repositories.%1$sRepository;\n" +
            "import org.springframework.beans.factory.annotation.Autowired;\n" +
            "import org.springframework.stereotype.Service;\n" +
            "import org.springframework.transaction.annotation.Transactional;\n" +
            "\n" +
            "import java.util.List;\n" +
            "\n" +
            "@Transactional\n" +
            "@Service\n" +
            "public class %1$sServiceImpl implements %1$sService {\n" +
            "\n" +
            "    private final %1$sRepository %2$sRepository;\n" +
            "\n" +
            "    @Autowired\n" +
            "    public %1$sServiceImpl(%1$sRepository %2$sRepository) {\n" +
            "        this.%2$sRepository = %2$sRepository;\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public List<%1$s> findAll() {\n" +
            "        return this.%2$sRepository.findAll();\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public %1$s findById(long id) {\n" +
            "        return this.%2$sRepository.findOne(id);\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public %1$s createOne(%1$s %2$s) {\n" +
            "        return this.%2$sRepository.save(%2$s);\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public List<%1$s> createMany(Iterable<%1$s> %2$ss) {\n" +
            "        return this.%2$sRepository.save(%2$ss);\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public %1$s updateOne(%1$s %2$s) {\n" +
            "        return this.%2$sRepository.save(%2$s);\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public List<%1$s> updateMany(Iterable<%1$s> %2$ss) {\n" +
            "        return this.%2$sRepository.save(%2$ss);\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public void deleteById(long id) {\n" +
            "        this.%2$sRepository.delete(id);\n" +
            "    }\n" +
            "\n" +
            "}";

    public static final String SERVICE_INTERFACE_TEMPLATE = "package %1$s.services;\n" +
            "\n" +
            "import %2$s;\n" +
            "\n" +
            "import java.util.List;\n" +
            "\n" +
            "public interface %3$sService {\n" +
            "\n" +
            "    List<%3$s> findAll();\n" +
            "\n" +
            "    %3$s findById(long id);\n" +
            "\n" +
            "    %3$s createOne(%3$s %4$s);\n" +
            "\n" +
            "    List<%3$s> createMany(Iterable<%3$s> %4$ss);\n" +
            "\n" +
            "    %3$s updateOne(%3$s %4$s);\n" +
            "\n" +
            "    List<%3$s> updateMany(Iterable<%3$s> %4$ss);\n" +
            "\n" +
            "    void deleteById(long id);\n" +
            "}";

    public static final String REPOSITORY_INTERFACE_TEMPLATE = "package %1$s.repositories;\n" +
            "\n" +
            "import %2$s;\n" +
            "import org.springframework.data.jpa.repository.JpaRepository;\n" +
            "import org.springframework.stereotype.Repository;\n" +
            "\n" +
            "@Repository\n" +
            "public interface %3$sRepository extends JpaRepository<%3$s, Long> {\n" +
            "}";

    public static final String APPLICATION_PROPERTIES_TEMPLATE = "#Data Source Properties\n" +
            "spring.datasource.driverClassName = com.mysql.jdbc.Driver\n" +
            "spring.datasource.url =jdbc:mysql://localhost:3306/<DATABASE NAME>?useSSL=false&createDatabaseIfNotExist=true\n" +
            "spring.datasource.username = <USER>\n" +
            "spring.datasource.password = <PASS>\n" +
            "\n" +
            "#JPA Properties\n" +
            "spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect\n" +
            "spring.jpa.properties.hibernate.format_sql = TRUE\n" +
            "spring.jpa.hibernate.ddl-auto = update\n" +
            "\n" +
            "###Logging Levels\n" +
            "# Disable the default loggers\n" +
            "logging.level.org = WARN\n" +
            "logging.level.blog = WARN\n" +
            "\n" +
            "#Show SQL executed with parameter bindings\n" +
            "logging.level.org.hibernate.SQL = DEBUG\n" +
            "logging.level.org.hibernate.type.descriptor = TRACE";

    private ClassTemplates() {}
}