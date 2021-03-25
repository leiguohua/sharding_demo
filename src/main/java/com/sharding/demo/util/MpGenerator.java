package com.sharding.demo.util;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * 代码生成器
 * @author DELL
 */
public class MpGenerator {
	/**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


    public static void main(String[] args) {
        //配置作者,生成路径，启动输入表名，多个逗号隔开
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //生成路径
        String projectPath = "D:\\tmp\\generator-code";
        gc.setOutputDir(projectPath);
        //作者
        gc.setAuthor("lgh");
        gc.setOpen(false);
        gc.setFileOverride(true);
        // 实体属性 Swagger2 注解
        gc.setSwagger2(true);
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/shard_order_0?characterEncoding=utf8&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
//        dsc.setUrl("jdbc:mysql://rm-bp1758tjha54422ks7o.mysql.rds.aliyuncs.com:3306/dev_trend?characterEncoding=utf8");
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("P@s$w0rdUjoY");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.sharding.demo");
        pc.setController("controller");
        pc.setService("server");
        pc.setServiceImpl("server.impl");
        pc.setMapper("dao");
        pc.setXml("mapper");
        pc.setEntity("model");
        mpg.setPackageInfo(pc);

        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController("templates/controller.java");
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

//        strategy.setSuperEntityClass("com.sharding.demo.entity.BaseModel");
        strategy.setSuperServiceClass("com.sharding.demo.base.IBaseService");
        strategy.setSuperServiceImplClass("com.sharding.demo.base.BaseServiceImpl");
        strategy.setSuperMapperClass("com.sharding.demo.base.BaseMapper");
        strategy.setSuperControllerClass("com.sharding.demo.base.AbstractController");

        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
//        strategy.setSuperEntityColumns("id","create_time","create_by","update_time","update_by","del_flag","remark");
        strategy.setControllerMappingHyphenStyle(true);
        //忽略表前缀
        strategy.setTablePrefix("t_");
        mpg.setTemplate(templateConfig);
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
