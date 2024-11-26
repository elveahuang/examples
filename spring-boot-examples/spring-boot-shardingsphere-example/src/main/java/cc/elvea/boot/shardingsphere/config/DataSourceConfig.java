package cc.elvea.boot.shardingsphere.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.algorithm.core.config.AlgorithmConfiguration;
import org.apache.shardingsphere.infra.config.mode.ModeConfiguration;
import org.apache.shardingsphere.mode.repository.standalone.StandalonePersistRepositoryConfiguration;
import org.apache.shardingsphere.readwritesplitting.config.ReadwriteSplittingRuleConfiguration;
import org.apache.shardingsphere.readwritesplitting.config.rule.ReadwriteSplittingDataSourceGroupRuleConfiguration;
import org.apache.shardingsphere.single.config.SingleRuleConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

@Slf4j
@Configuration(proxyBeanMethods = false)
public class DataSourceConfig {

    @Bean
    @Primary
    public DataSource dataSource(
            @Autowired(required = false) @Qualifier("masterDataSource") DataSource masterDataSource,
            @Autowired(required = false) @Qualifier("slaveDataSource") DataSource slaveDataSource
    ) throws SQLException {
        ModeConfiguration modeConfig = new ModeConfiguration("Standalone", new StandalonePersistRepositoryConfiguration("JDBC", new Properties()));

        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("master", masterDataSource);
        dataSourceMap.put("slave", slaveDataSource);

        ReadwriteSplittingDataSourceGroupRuleConfiguration dataSourceConfiguration =
                new ReadwriteSplittingDataSourceGroupRuleConfiguration("main", "master", List.of("slave"), "lb");

        Map<String, AlgorithmConfiguration> loadBalancers = new HashMap<>();
        loadBalancers.put("lb", new AlgorithmConfiguration("ROUND_ROBIN", new Properties()));

        ReadwriteSplittingRuleConfiguration ruleConfiguration =
                new ReadwriteSplittingRuleConfiguration(Collections.singleton(dataSourceConfiguration), loadBalancers);

        SingleRuleConfiguration ruleConfig = new SingleRuleConfiguration(Collections.singleton("*.*"), "master");

        Properties properties = new Properties();
        properties.setProperty("sql-show", "true");

        return ShardingSphereDataSourceFactory
                .createDataSource(modeConfig, dataSourceMap, List.of(ruleConfiguration, ruleConfig), properties);
    }

    /**
     * ========================================================================================================================
     * 主库数据源配置
     * ========================================================================================================================
     */

    @Bean(name = "masterDataSourceProperties")
    @ConfigurationProperties("spring.datasource.master")
    public DataSourceProperties masterDataSourceProperties() {
        log.info("Creating MasterDataSourceProperties...");
        return new DataSourceProperties();
    }

    @Bean(name = "masterDataSource")
    @ConfigurationProperties("spring.datasource.master.hikari")
    public HikariDataSource masterDataSource(@Qualifier("masterDataSourceProperties") DataSourceProperties properties) {
        log.info("Creating MasterDataSource...");
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    /**
     * ========================================================================================================================
     * 从库数据源配置
     * ========================================================================================================================
     */

    @Bean(name = "slaveDataSourceProperties")
    @ConfigurationProperties("spring.datasource.slave")
    public DataSourceProperties slaveDataSourceProperties() {
        log.info("Creating slaveDataSourceProperties...");
        return new DataSourceProperties();
    }

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties("spring.datasource.slave.hikari")
    public HikariDataSource slaveDataSource(@Qualifier("slaveDataSourceProperties") DataSourceProperties properties) {
        log.info("Creating slaveDataSource...");
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

}
