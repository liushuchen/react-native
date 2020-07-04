package com.httd.api.db;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.httd.api.base.BaseController;

/**
 * 代码模板生成
 * 
 * @author w_liusc
 *
 */
public class Generator {
	public static void main(String[] args) {
		String packageName = "home";
		String tableNames = "t_home_recommend";
		System.out.println("开始生成模板");
		generate(packageName, tableNames);
		System.out.println("模板已生成,请刷新目录");
	}

	protected static void generate( String packageName, String tableNames) {
		// 全局配置
		GlobalConfig config = new GlobalConfig();
		config.setActiveRecord(false)
				.setEnableCache(false)
				.setAuthor("w_liusc")
				.setOutputDir("/Volumes/LSC/recat-native/httd-api/src/main/java")
				.setOpen(false);

		// 数据源配置
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig.setDbType(DbType.MYSQL)
				.setUrl("jdbc:mysql://152.136.108.24:3341/httd-api")
				.setUsername("httd")
				.setPassword("edluja96TI953Ptz")
				.setDriverName("com.mysql.cj.jdbc.Driver")
				.setTypeConvert(new MySqlTypeConvert());

		// 配置策略
		StrategyConfig strategyConfig = new StrategyConfig();
		strategyConfig.setCapitalMode(true)
				.setEntityLombokModel(true)
				.setTablePrefix(new String[] { "t_" })
				.setNaming(NamingStrategy.underline_to_camel)
				.setInclude(tableNames)
				.setSuperControllerClass(BaseController.class);

		// 包配置
		PackageConfig packageInfo = new PackageConfig();
		packageInfo.setParent("com.httd.api")// 自定义包路径
				.setController("business."+packageName + ".controller")
				.setService("business."+packageName + ".service")
				.setServiceImpl("business."+packageName + ".service.impl")
				.setEntity("mapper.po")
				.setMapper("mapper")
				.setXml("mapper");
		// 执行配置
		new AutoGenerator().setGlobalConfig(config)
				.setDataSource(dataSourceConfig)
				.setStrategy(strategyConfig)
				.setPackageInfo(packageInfo)
				.execute();
	}
}