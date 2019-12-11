import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodeGenerator {

  /**
   * <p>
   * 读取控制台内容
   * </p>
   */
  public static String scanner(String tip) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入" + tip + "：");
    if (scanner.hasNext()) {
      String ipt = scanner.next();
      if (StringUtils.isNotBlank(ipt)) {
        return ipt;
      }
    }
    throw new MybatisPlusException("请输入正确的" + tip + "！");
  }

  public static void main(String[] args) {
    // 代码生成器
    AutoGenerator mpg = new AutoGenerator();

    // 全局配置
    GlobalConfig gc = new GlobalConfig();
    String projectPath = System.getProperty("user.dir");
    System.out.println("projectPath = " + projectPath);
    gc.setOutputDir(
        "/Users/ericshen/Code/personal/hello-spring-security-oauth2/hello-spring-security-oauth2-server"
            + "/src/main/java");
    System.out.println("gc.getOutputDir() = " + gc.getOutputDir());
    gc.setAuthor("Eric Shen");
    gc.setOpen(false);
    gc.setFileOverride(true);
    gc.setActiveRecord(true);
    gc.setEnableCache(false);
    gc.setBaseResultMap(true);
    gc.setBaseColumnList(true);
    // gc.setSwagger2(true); 实体属性 Swagger2 注解
    gc.setEntityName("%s");
    gc.setMapperName("%sDao");
    gc.setXmlName("%sMapper");
    gc.setServiceName("%sService");
    gc.setServiceImplName("%sServiceImpl");
    gc.setControllerName("%sController");

    mpg.setGlobalConfig(gc);

    // 数据源配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setDbType(DbType.MYSQL);
    dsc.setUrl(
        "jdbc:mysql://127.0.0.1:3306/oauth2?useUnicode=true&characterEncoding=utf-8&useSSL=false");
    // dsc.setSchemaName("public");
    dsc.setDriverName("com.mysql.jdbc.Driver");
    dsc.setUsername("root");
    dsc.setPassword("123456");
    dsc.setTypeConvert(new MySqlTypeConvert() {
      // 自定义数据库表字段类型转换【可选】
      @Override
      public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
        System.out.println("转换类型：" + fieldType);
        if (fieldType.toLowerCase().contains("datetime")) {
          return DbColumnType.DATE;
        }
        return super.processTypeConvert(globalConfig, fieldType);
      }
    });

    mpg.setDataSource(dsc);

    // 包配置
    PackageConfig pc = new PackageConfig();
    // pc.setModuleName(scanner("模块名"));
    pc.setParent("com.eric.spring.security.oauth2.server");
    pc.setController("controller");
    pc.setMapper("dao");
    pc.setService("service");
    pc.setServiceImpl("service.impl");
    pc.setXml("mapper");
    mpg.setPackageInfo(pc);

    // 自定义配置
    InjectionConfig cfg = new InjectionConfig() {
      @Override
      public void initMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
        this.setMap(map);
      }
    };

    // // 如果模板引擎是 freemarker
    // // String templatePath = "/templates/mapper.xml.ftl";
    // // 如果模板引擎是 velocity
    // String templatePath = "/templates/mapper.xml.vm";
    //
    // // 自定义输出配置
    // List<FileOutConfig> focList = new ArrayList<>();
    // // 自定义配置会被优先输出
    // focList.add(new FileOutConfig(templatePath) {
    //   @Override
    //   public String outputFile(TableInfo tableInfo) {
    //     // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
    //     return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
    //         + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
    //   }
    // });
    //
    //     cfg.setFileCreate(new IFileCreate() {
    //         @Override
    //         public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
    //             // 判断自定义文件夹是否需要创建
    //             checkDir("调用默认方法创建的目录");
    //             return false;
    //         }
    //     });
    //
    // cfg.setFileOutConfigList(focList);
    mpg.setCfg(cfg);

    // 配置模板
    // TemplateConfig templateConfig = new TemplateConfig();

    // 配置自定义输出模板
    //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
    // templateConfig.setEntity("templates/entity2.java");
    // templateConfig.setService();
    // templateConfig.setController();

    // templateConfig.setController("/templates/Controller.java.vm");
    // templateConfig.setEntity("/templates/Entity.java.vm");
    // templateConfig.setMapper("/templates/Mapper.java.vm");
    // templateConfig.setXml("/templates/Mapper.xml.vm");
    // templateConfig.setService("/templates/Service.java.vm");
    // templateConfig.setServiceImpl("/templates/ServiceImpl.java.vm");
    // mpg.setTemplate(templateConfig);

    // 策略配置
    StrategyConfig strategy = new StrategyConfig();
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    strategy.setEntityLombokModel(true);
    strategy.setEntityColumnConstant(true);
    strategy.setEntityBooleanColumnRemoveIsPrefix(true);
    strategy.setRestControllerStyle(true);
    // strategy.setTablePrefix(scanner("表前缀名，下划线之前") + "_");
    strategy.setInclude(scanner("表全名，多个英文逗号分割").split(","));
    strategy.setControllerMappingHyphenStyle(true);
    mpg.setStrategy(strategy);

    mpg.setTemplateEngine(new VelocityTemplateEngine());
    mpg.execute();
  }

}